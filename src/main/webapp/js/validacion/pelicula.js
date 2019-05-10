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
        this.serviceURL = 'webservice';
        this.config = {
            idForm: '#frmPeli',
            form: [
                {
                    id: '#titulo',
                    regex: /^.{2,30}$/i,
                    error: '#errorTitulo',
                    msg: 'El titulo debe tener entre 2 y 30 caracteres'
                },
                {
                    id: '#url',
                    regex: /^[a-z]+(-[a-z]+)*/,
                    error: '#errorUrl',
                    msg: 'La URL debe estar en minusculas y separadas por -'
                },
                {
                    id: '#foto',
                    regex: /^(https?|ftp|file):[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]/,
                    error: '#errorFoto',
                    msg: 'La url debe ser válida'
                }
            ],
            validClass: 'is-valid',
            invalidClass: 'is-invalid'
        };
    }
    init() {
        this.limpiarTodos();

        $(this.config.idForm).on('submit', event => {
            if (!this.validaFormulario()) {
                event.preventDefault();
            }
        });
    }

    validaFormulario() {

        this.addTodos(this.config.validClass);

        let errores = false;

        this.config.form.forEach((val) => {
            if (val['regex'].test($(val['id']).val().trim()))
                this.setValid(val['id']);
            else {
                errores = true;
                this.setInvalid(val['id']);
                $(val['error']).text(val['msg']);
            }
        });



        return !errores;
    }

    compruebaURL(url) {
        //nada funciona
        this.estado;
        return fetch(this.serviceURL + '/pelicula/url/' + url)
                .then((response) => {
                    return response.ok;
                }
                );
        console.log(this.estado);
        return this.estado;
    }

    setValid(id) {
        $(id).addClass(this.config.validClass);
        $(id).removeClass(this.config.invalidClass);
    }

    setInvalid(id) {
        $(id).addClass(this.config.invalidClass);
        $(id).removeClass(this.config.validClass);
    }

    addTodos(cssClass) {
        this.config.form.forEach((val) => {
            $(val['id']).addClass(cssClass);
        });
    }

    limpiarTodos() {
        this.config.form.forEach((val) => {
            $(val['id']).removeClass(this.config.validClass + ' ' + this.config.invalidClass);
        });
    }

    marcarErrores(errores) {

        this.addTodos(this.config.validClass);

        for (let val of errores) {
            this.setInvalid('[name=' + val['name'] + ']');
        }
        ;

    }

}
