/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(() => {
    let ctrl = new ControlComentario();
    ctrl.init();
});

class ControlComentario {

    constructor() {
        this.config = {
            templateComentario: '#comentario',
            btn: '[name=show]',
            templateForm: '#form'
        };
    }

    init() {
        $(this.config.btn).each((pos, elem) => {
            $(elem).on('click', () => {
                $(this.config.templateForm + $(elem).attr('id')).toggle();
                $(this.config.templateComentario + $(elem).attr('id')).toggle();
            });
        });

    }

}
