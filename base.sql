drop database if exists biblio;
create database biblio;
use biblio;

create table autor
(
    id int not null auto_increment primary key,
    nombre varchar(20) not null,
    apellido varchar(20) not null
);

create table categoria
(
    id int not null auto_increment primary key,
    nombre varchar(30) not null
);

create table libro
(
    id int not null auto_increment primary key,
    nombre varchar(100) not null,
    editorial varchar(100) not null,
    autor int not null,
    categoria int not null,
    foreign key (autor) references autor(id),
    foreign key (categoria) references categoria(id)
);

create table usuario
(
    username varchar(20) primary key,
    password varchar(20) not null
);

create table rol
(
    id int not null auto_increment primary key,
    descripcion varchar(10) not null
);

create table roles_usuario
(
   usuario varchar(20) not null,
   rol int not null,
   foreign key (usuario) references usuario(username),
   foreign key (rol) references rol(id)
);

create table inventario
(
    id int not null auto_increment primary key,
    libro int not null,
    prestado bool not null,
    foreign key (libro) references libro(id)
);

insert into autor values(null, "Autor1", "Apellido1");
insert into categoria values(null,"Fantasia");
insert into libro values(null, "Libro1", "Editorial", 1, 1);
insert into usuario values("usuario", "123");
insert into rol values (null, "LEER");
insert into rol values (null, "CREAR");
insert into rol values (null, "ELIMINAR");
insert into rol values (null, "EDITAR");
insert into roles_usuario values("usuario", 1);
insert into roles_usuario values("usuario", 2);
insert into roles_usuario values("usuario", 3);
insert into roles_usuario values("usuario", 4);

insert into inventario values(null,1,0);
