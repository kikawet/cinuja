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
            frm: '#frmreg',
            nick: '#idNick',
            ERNick: /^(\S{1,10})$/,
            nombre: '#idNombre',
            ERNombre: /^.{3,20}$/i,
            apellidos: '#idApellidos',
            ERApellidos: /^.{4,20}$/i,
            ctrs1: '#idCtrs1',
            ERCtrs: /^.{6,}$/i,
            ctrs2: '#idCtrs2',
            terminos: '#idTrm',
            errores: '#idErrores',
            element: 'p',
            validClass: 'is-valid',
            invalidClass: 'is-invalid'
        };
    }
    init() {
        $(this.config.frm).on('submit', event => {
//            if (!this.validaFormulario()) {
//                event.preventDefault();
//            }
        });
    }

    validaFormulario() {
        let nick = $(this.config.nick).val().trim();
        let nombre = $(this.config.nombre).val().trim();
        let apellidos = $(this.config.apellidos).val().trim();
        let ctrs1 = $(this.config.ctrs1).val().trim();
        let ctrs2 = $(this.config.ctrs2).val().trim();
        let terminos = $(this.config.terminos).is(':checked');
        let errores = "";

        if (!this.config.ERNombre.test(nombre)) {
            errores += this.addElement("El nombre debe tener una longitud de entre 3 y 20 caracteres");
            $(this.config.nombre).addClass(this.config.invalidClass);
            $(this.config.nombre).removeClass(this.config.validClass);
        } else {
            $(this.config.nombre).addClass(this.config.validClass);
            $(this.config.nombre).removeClass(this.config.invalidClass);
        }

        if (!this.config.ERApellidos.test(apellidos)) {
            errores += this.addElement("Los apellidos deben tener una longitud de entre 4 y 20 caracteres");
            $(this.config.apellidos).addClass(this.config.invalidClass);
            $(this.config.apellidos).removeClass(this.config.validClass);
        } else {
            $(this.config.apellidos).addClass(this.config.validClass);
            $(this.config.apellidos).removeClass(this.config.invalidClass);
        }

        if (!this.config.ERNick.test(nick)) {
            errores += this.addElement("El nick debe tener entre 1 y 10 caracteres sin espacios en blanco");
            $(this.config.nick).addClass(this.config.invalidClass);
            $(this.config.nick).removeClass(this.config.validClass);
        } else {
            $(this.config.nick).addClass(this.config.validClass);
            $(this.config.nick).removeClass(this.config.invalidClass);
        }

        if (ctrs1 !== ctrs2) {
            errores += this.addElement("Las contraseñas deben ser la mista");
            $(this.config.ctrs1).addClass(this.config.invalidClass);
            $(this.config.ctrs1).removeClass(this.config.validClass);
            $(this.config.ctrs2).addClass(this.config.invalidClass);
            $(this.config.ctrs2).removeClass(this.config.validClass);
        } else {
            $(this.config.ctrs1).addClass(this.config.validClass);
            $(this.config.ctrs1).removeClass(this.config.invalidClass);
            $(this.config.ctrs2).addClass(this.config.validClass);
            $(this.config.ctrs2).removeClass(this.config.invalidClass);
        }

        if (!this.config.ERCtrs.test(ctrs1)) {
            errores += this.addElement("La contraseña debe de tener al menos 6 caracteres");
            $(this.config.ctrs1).addClass(this.config.invalidClass);
            $(this.config.ctrs1).removeClass(this.config.validClass);
            $(this.config.ctrs2).addClass(this.config.invalidClass);
            $(this.config.ctrs2).removeClass(this.config.validClass);
        } else {
            $(this.config.ctrs1).addClass(this.config.validClass);
            $(this.config.ctrs1).removeClass(this.config.invalidClass);
            $(this.config.ctrs2).addClass(this.config.validClass);
            $(this.config.ctrs2).removeClass(this.config.invalidClass);
        }

        if (!terminos) {
            errores += this.addElement("Debes aceptar los terminos y condiciones");
            $(this.config.nombre).addClass(this.config.invalidClass);
            $(this.config.nombre).removeClass(this.config.validClass);
        } else {
            $(this.config.nombre).addClass(this.config.validClass);
            $(this.config.nombre).removeClass(this.config.invalidClass);
        }

        $(this.config.errores).addClass('alert alert-danger').html(errores);

        return errores === "";
    }

    addElement(txt) {
        return '<' + this.config.element + '>' + txt + '</' + this.config.element + '>';
    }

}
