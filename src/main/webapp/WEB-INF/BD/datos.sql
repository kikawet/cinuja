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
INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Quentin Tarantino','15.02.2017', 'https://www.cooperativa.cl/noticias/site/artic/20161104/imag/foto_0000000120161104090517.png');
INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Steven Spielberg','14.02.2017','https://media.metrolatam.com/2019/02/20/capturadepantalla20190219alas210214-35b457738219a1b024fbd90a66cb8914-600x400.jpg');
INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Pixar','06.10.2000','https://www.taquillaespana.es/wp-content/uploads/2018/06/Pixar-en-Espa%C3%B1a-740x445.jpg');
INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Bryan Singer','16.10.2000','https://ichef.bbci.co.uk/news/660/cpsprodpb/1126/production/_105509340_hi051882259.jpg');
INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Christopher Nolan','17.10.2001','https://pixel.nymag.com/imgs/daily/vulture/2018/09/11/15-Nolan.w330.h330.jpg');
INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Steve McQueen','12.2.1997','https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Steve_McQueen.png/220px-Steve_McQueen.png');
INSERT INTO DIRECTOR (NOMBRE,F_NAC,FOTO) VALUES ('Taika Waititi','7.8.2017','https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Taika_Waititi_by_Gage_Skidmore.jpg/240px-Taika_Waititi_by_Gage_Skidmore.jpg');


INSERT INTO PELICULA (NOMBRE,FECHA,URL,DESCRIPCION,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Uno de los nuestros','01.01.1990','uno-de-los-nuestros','Un hombre de Brooklyn busca la fama y la fortuna en el crimen organizado',47,10,10,'http://es.web.img2.acsta.net/medias/nmedia/18/67/70/14/20077949.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Martin Scorsese'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Pulp Fiction','01.01.1997','pulp-fiction',46,10,10,'https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/09/pulp-fiction_0.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Quentin Tarantino'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Salvar al soldado Ryan','01.01.1998','salvar-al-soldado-bryan',0,1,2,'https://twistedsifter.files.wordpress.com/2015/10/53-saving-private-ryan.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Steven Spielberg'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Ratatouille','01.01.2007','ratatouille',43,10,6,'https://educayaprende.com/wp-content/uploads/2014/05/ratatouille-cover-caratula-dvd-disney-pixar.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Pixar'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Bohemian Rhapsody','01.01.2018','bohemian-rhapsody',43,10,11,'https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Bryan Singer'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Batman: The Dark Knight','17.10.2001','batman',45,10,0,'http://4.bp.blogspot.com/-nKSHSdwKeKc/UA2G4zIPHfI/AAAAAAAAOQI/8C-iUweMezE/s1600/elcaballerooscuroleyendarenace.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Christopher Nolan'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('12 años de esclavitud','12.2.1997','doce-anos',44,10,8,'https://images-na.ssl-images-amazon.com/images/I/61QFAKXbb5L._SY679_.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Steve McQueen'));
INSERT INTO PELICULA (NOMBRE,FECHA,URL,SUMAVOTOS,NVOTOS,GENERO,FOTO,DIRECTOR) VALUES ('Thor: Ragnarok','7.8.2017','thor',42,10,0,'http://www.cineycine.com/archivos/2017/10/thor-ragnarok-poster.jpg',
                                                                                (SELECT ID FROM DIRECTOR AS d WHERE d.NOMBRE = 'Taika Waititi'));

INSERT INTO COMENTARIO (TITULO,TEXTO,FECHA,PELICULA,USUARIO) VALUES ('Maravillosa','La mejor pelicula de mi vida.',CURRENT_TIMESTAMP,
                                                                                (SELECT ID FROM PELICULA AS p WHERE p.URL = 'uno-de-los-nuestros'),'gordito');
INSERT INTO COMENTARIO (TITULO,TEXTO,FECHA,PELICULA,USUARIO) VALUES ('No está mal','Es bastante entretenida pero prefiero ver Salvame.',CURRENT_TIMESTAMP,
                                                                                (SELECT ID FROM PELICULA AS p WHERE p.URL = 'uno-de-los-nuestros'),'boa');
INSERT INTO COMENTARIO (TITULO,TEXTO,FECHA,PELICULA,USUARIO) VALUES ('Aburrida','Yo me aburrí. Preferiría morirme en este momento.',CURRENT_TIMESTAMP,
                                                                                (SELECT ID FROM PELICULA AS p WHERE p.URL = 'uno-de-los-nuestros'),'web');