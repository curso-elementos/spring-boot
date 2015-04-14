/*
CREATE TABLE PELICULA(
ID_PELICULA INTEGER PRIMARY KEY AUTO_INCREMENT,
TITULO VARCHAR(120),
SINOPSIS VARCHAR(500) 
);


CREATE TABLE CLIENTE (ID_CLIENTE INTEGER PRIMARY KEY AUTO_INCREMENT, NOMBRE VARCHAR(120), SUELDO FLOAT);
CREATE TABLE DIRECCION (ID_DIRECCION INTEGER PRIMARY KEY AUTO_INCREMENT,ID_CLIENTE INTEGER, COLONIA VARCHAR(300), CALLE VARCHAR(300),
FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE));
*/
CREATE TABLE usuario(ID_USUARIO INTEGER PRIMARY KEY AUTO_INCREMENT,
              NOMBRE VARCHAR(160), EDAD INTEGER, SUELDO FLOAT);



/*

create table avion (id_avion integer primary key auto_increment,
    asientos integer );

create table vuelo (id_vuelo integer primary key auto_increment,
                     id_avion integer, origen varchar(180),
                     destino varchar(180), fecha date,
            foreign key(id_avion) references avion(id_avion));
*/

select * from usuario;
