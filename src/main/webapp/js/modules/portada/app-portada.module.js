/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class PortadaController {
    constructor($http) {
        //Visualizar
        this.generos = [];
        this.usuario = {};
        this.peliculas = [];
        this.$http = $http;
        this.serviceURL = 'webservice';

        this.descargarDatos();

        //Formulario
        this.pelicula = {};
        
        //Ordenar
        this.orden = [
            {
                msg: 'Titulo',
                value: 'titulo'
            },
            {
                msg: 'Nota',
                value: 'nota'
            }
        ];
        
        this.ordenacion = 0;
    }
    
    ordenar(){
        this.ordenacion = (this.ordenacion + 1)% this.orden.length;
    }

    descargarDatos() {
        //generos
        this.$http.get(this.serviceURL + '/pelicula/generos')
                .then(response => {
                    this.generos = response.data;
                })
                .catch(() => {
                    console.log("Error al cargar los generos");
                });

        //sesion
        this.$http.get(this.serviceURL + '/API/sesion')
                .then(response => {
                    if (response.data.length === 0)
                        this.usuario = {};
                    else
                        this.$http.get(this.serviceURL + '/usuario/' + response.data)
                                .then(Response => {
                                    this.usuario = Response.data;
                                })
                                .catch(() => {
                                    console.log("Error al el usuario");
                                });
                })
                .catch(() => {
                    console.log("Error al cargar el usuario en sesión");
                });

        //peliculas
        this.$http.get(this.serviceURL + '/pelicula')
                .then(response => {
                    this.peliculas = response.data;
                })
                .catch(() => {
                    console.log("Error al leer peliculas");
                });
    }

    getPeliculas(genero) {
        this.$http.get(this.serviceURL + '/pelicula/gen/' + genero)
                .then(response => {
                    this.peliculas = response.data;
                })
                .catch(() => {
                    console.log("Error al cargar los generos");
                });
    }

}

PortadaController.$inject = ['$http'];

const appPortadaComponent = {
    templateUrl: './js/modules/portada/app-portada.template.html',
    controller: PortadaController
};


export const AppPortadaModule = angular
        .module('portada.app', [])
        .filter('fecha', ['$filter', function ($filter) {
                return (date, format) => {
                    return $filter('date')(date.replace('[UTC]', ''), format);
                };
            }])
        .component('appPortada', appPortadaComponent)
        .name;