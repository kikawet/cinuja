/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lopez
 * Created: 31-mar-2019
 */

DELETE FROM COMENTARIO;
DELETE FROM USUARIO;
DELETE FROM PELICULA;
DELETE FROM DIRECTOR;

INSERT INTO USUARIO (NICK,CONTRASENA,NOMBRE,ROL,FOTO) VALUES ('pescues','flo','flo','adm','https://ct.yimg.com/cy/4571/37462755413_c2dae6_128sq.jpg');
INSERT INTO USUARIO (NICK,CONTRASENA,NOMBRE,ROL,FOTO) VALUES ('gordito','donuts','José Tomas','non','https://ct.yimg.com/cy/1904/44016886825_e02d29_128sq.jpg');
INSERT INTO USUARIO (NICK,CONTRASENA,NOMBRE,ROL,FOTO) VALUES ('boa','ponme_un_10_balsas','Pescues','non','https://66.media.tumblr.com/avatar_ea54a1bd0195_128.pnj');
INSERT INTO USUARIO (NICK,CONTRASENA,NOMBRE,ROL,FOTO) VALUES ('web','daw','Rodrigo','non','http://pm1.narvii.com/6265/5bba4fd8638ebdea1100eb9b06940944a8913fc0_128.jpg');

INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Martin Scorsese','02.04.2018','http://d3iln1l77n73l7.cloudfront.net/couch_images/attachments/000/057/537/original/Martin_Scorsese.jpg?2014');
INSERT INTO DIRECTOR (NOMBRE,F_NAC) VALUES ('Quentin Tarantino','15.02.2017');
INSERT INTO DIRECTOR (NOMBRE,F_NAC) VALUES ('Steven Spielberg','14.02.2017');
INSERT INTO DIRECTOR (NOMBRE,F_NAC) VALUES ('Pixar','06.10.2000');
INSERT INTO DIRECTOR (NOMBRE,F_NAC) VALUES ('Bryan Singer','16.10.2000');

INSERT INTO PELICULA (NOMBRE,FECHA,URL,DESCRIPCION,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Uno de los nuestros','01.01.1990','uno-de-los-nuestros','Un hombre de Brooklyn busca la fama y la fortuna en el crimen organizado',0,1,10,'http://es.web.img2.acsta.net/medias/nmedia/18/67/70/14/20077949.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Martin Scorsese'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Pulp Fiction','01.01.1997','pulp-fiction',0,1,10,'https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/09/pulp-fiction_0.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Quentin Tarantino'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Salvar al soldado Ryan','01.01.1998','salvar-al-soldado-bryan',0,1,2,'https://twistedsifter.files.wordpress.com/2015/10/53-saving-private-ryan.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Steven Spielberg'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Ratatouille','01.01.2007','ratatouille',0,1,6,'https://educayaprende.com/wp-content/uploads/2014/05/ratatouille-cover-caratula-dvd-disney-pixar.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Pixar'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Bohemian Rhapsody','01.01.2018','bohemian-rhapsody',0,1,11,'https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Bryan Singer'));

INSERT INTO COMENTARIO (TITULO,TEXTO,FECHA,PELICULA,USUARIO) VALUES ('Maravillosa','La mejor pelicula de mi vida.',CURRENT_TIMESTAMP,
                                                                                (SELECT ID FROM PELICULA AS p WHERE p.URL = 'uno-de-los-nuestros'),'gordito');
INSERT INTO COMENTARIO (TITULO,TEXTO,FECHA,PELICULA,USUARIO) VALUES ('No está mal','Es bastante entretenida pero prefiero ver Salvame.',CURRENT_TIMESTAMP,
                                                                                (SELECT ID FROM PELICULA AS p WHERE p.URL = 'uno-de-los-nuestros'),'boa');
INSERT INTO COMENTARIO (TITULO,TEXTO,FECHA,PELICULA,USUARIO) VALUES ('Aburrida','Yo me aburrí. Preferiría morirme en este momento.',CURRENT_TIMESTAMP,
                                                                                (SELECT ID FROM PELICULA AS p WHERE p.URL = 'uno-de-los-nuestros'),'web');

