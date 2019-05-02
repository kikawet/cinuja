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
            frmcmt: "#frmcmt",
            idtitulo: "#tittle",
            idtexto: "#texto",
            ERtitulo: /^.{3,20}$/i,
            ERtexto: /^.{3,256}$/i,
            errores: "#errores",
            element: "p"
        };
    }
    init() {
        $(this.config.frmcmt).on('submit', event => {
            if (!this.validaComentario()) {
                event.preventDefault();
            }
        });
    }

    validaComentario() {
        let titulo = $(this.config.idtitulo).val().trim();
        let texto = $(this.config.idtexto).val().trim();
        let errores = "";
        
        if (!this.config.ERtitulo.test(titulo)) {
            errores += "<" + this.config.element + ">" + "El titulo no tiene una longitud entre 3 y 20" + "</" + this.config.element + ">";
        }
        
        if (!this.config.ERtexto.test(texto)) {
            errores += "<" + this.config.element + ">" + "El titulo no tiene una longitud entre 3 y 256" + "</" + this.config.element + ">";
        }
        
        $(this.config.errores).addClass('alert alert-danger').html(errores);

        return errores === "";
    }

}