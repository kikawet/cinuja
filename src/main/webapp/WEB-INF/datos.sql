/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lopez
 * Created: 31-mar-2019
 */

INSERT INTO DIRECTOR (nombre,f_nac) VALUES ('super director',CURRENT_DATE);

INSERT INTO PELICULA (nombre,fecha,foto,url,genero) VALUES ('PELICULITA2','03.04.2019','foto','url',0);
INSERT INTO USUARIO (nick,rol) VALUES ('tomas','non');

INSERT INTO COMENTARIO (PELICULA, USUARIO, FECHA, TITULO, TEXTO) VALUES ((
SELECT id
FROM pelicula
WHERE pelicula.nombre = 'PELICULITA'
),'tomas',CURRENT_DATE,'yo k se','jk');

Select c.TITULO from comentario as c , pelicula as p where c.pelicula = p.id AND p.url = 'url';

SELECT *
FROM PELICULA;