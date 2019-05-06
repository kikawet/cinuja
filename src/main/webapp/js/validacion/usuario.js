/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(() => {
    let ctrl = new ValidaCtrl();
    ctrl.init(); //attach view-event handlers    
});

class ValidaCtrl {
    constructor() {
        this.config = {
            idForm: '#frmreg',
            form: [
                {
                    id: '#idNick',
                    regex: /^(\S{1,10})$/
                },
                {
                    id: '#idNombre',
                    regex: /^.{3,20}$/i
                },
                {
                    id: '#idApellidos',
                    regex: /^.{4,20}$/i
                },
                {
                    id: '#idCtrs1',
                    regex: /^.{6,}$/i
                },
            ],
            ctrs1: '#idCtrs1',
            ctrs2: '#idCtrs2',
            terminos: '#idTrm',
            element: 'p',
            validClass: 'is-valid',
            invalidClass: 'is-invalid'
        };
    }
    init() {
        let errores = $('#idErrors').html().trim();
        if (errores.length !== 0)
            this.marcarErrores(JSON.parse(errores));

        $(this.config.idForm).on('submit', event => {
            if (!this.validaFormulario()) {
                event.preventDefault();
            }
        });
    }

    validaFormulario() {
        let ctrs1 = $(this.config.ctrs1).val().trim();
        let ctrs2 = $(this.config.ctrs2).val().trim();
        let terminos = $(this.config.terminos).is(':checked');
        let errores = false;

        this.config.form.forEach((val) => {
            if (val['regex'].test($(val['id']).val().trim()))
                this.setValid(val['id']);
            else {
                errores = true;
                this.setInvalid(val['id']);
            }
        });

        if (ctrs1 !== ctrs2 || ctrs2.length === 0) {
            errores = true;
            this.setInvalid(this.config.ctrs2);
        } else {
            this.setValid(this.config.ctrs2)
        }

        if (!terminos) {
            errores = true;
            $(this.config.terminos).addClass(this.config.invalidClass);
        } else {
            $(this.config.terminos).removeClass(this.config.invalidClass);
        }

        return !errores;
    }

    setValid(id) {
        $(id).addClass(this.config.validClass);
        $(id).removeClass(this.config.invalidClass);
    }

    setInvalid(id) {
        $(id).addClass(this.config.invalidClass);
        $(id).removeClass(this.config.validClass);
    }

    addElement(txt) {
        return '<' + this.config.element + '>' + txt + '</' + this.config.element + '>';
    }

    addTodos(cssClass) {
        this.config.form.forEach((val) => {
            $(val['id']).addClass(cssClass);
        });

        $(this.config.ctrs2).addClass(cssClass);
    }

    marcarErrores(errores) {

        this.addTodos(this.config.validClass);

        for (let val of errores) {
            this.setInvalid('[name=' + val['name'] + ']');
        }
        ;

    }

}
