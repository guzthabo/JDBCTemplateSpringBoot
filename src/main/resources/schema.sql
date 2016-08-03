CREATE TABLE usuario
(
    id int(11) NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
    nombre varchar(30) NOT NULL,
    apellido varchar(30) NULL,
    PRIMARY KEY (id)
);