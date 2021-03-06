
/**
 * Author:  lopez
 * Created: 31-mar-2019
 */

DROP TABLE Comentario;
DROP TABLE Usuario;
DROP TABLE Pelicula;
DROP TABLE Director;

CREATE TABLE Director(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre VARCHAR(20) NOT NULL UNIQUE,
    f_nac DATE NOT NULL UNIQUE,
    foto VARCHAR(300),
    apellidos VARCHAR(40),
    biografia LONG VARCHAR,
    PRIMARY KEY(id)
);

CREATE TABLE Pelicula(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre VARCHAR(50) NOT NULL UNIQUE,
    fecha DATE NOT NULL UNIQUE,
    foto VARCHAR(300),-- una url no se
    url VARCHAR(30) NOT NULL UNIQUE,
    sumaVotos BIGINT,
    nVotos BIGINT,
    genero INTEGER,
    descripcion LONG VARCHAR,
    restriccion BOOLEAN,
    director INTEGER REFERENCES Director(id),
    PRIMARY KEY(id)
);

CREATE TABLE Usuario(
    nick VARCHAR(20) NOT NULL,
    nombre VARCHAR(20),
    apellidos VARCHAR(40),
    foto VARCHAR(300),
    contrasena VARCHAR(20),
    rol VARCHAR(3) CHECK( rol IN ('non','adm')) NOT NULL,
    PRIMARY KEY(nick)
);

CREATE TABLE Comentario(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    fecha TIMESTAMP NOT NULL UNIQUE,
    titulo VARCHAR(20),
    texto LONG VARCHAR,
    valoracion FLOAT(5),
    usuario VARCHAR(20) REFERENCES Usuario(nick),
    pelicula INTEGER REFERENCES Pelicula(id),
    PRIMARY KEY(id)
);

CREATE INDEX pel_url ON Pelicula(url);
