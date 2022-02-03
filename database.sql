create database biblio;
use biblio;
create table autor
(
    id       varchar(20) primary key,
    nombre   varchar(20) not null,
    apellido varchar(20) not null
);

create table categoria
(
    id     varchar(20) primary key,
    nombre varchar(100) not null
);

create table libro
(
    id        varchar(20) primary key,
    nombre    varchar(50) not null,
    editorial varchar(50),
    autor     varchar(20) not null,
    categoria varchar(20) not null,
    foreign key (autor) references autor (id),
    foreign key (categoria) references categoria (id)
);
create table revista
(
    id        varchar(20) primary key,
    nombre    varchar(50) not null,
    edicion   varchar(50),
    autor     varchar(20) not null,
    categoria varchar(20) not null,
    foreign key (autor) references autor (id),
    foreign key (categoria) references categoria (id)
);
create table comic
(
    id        varchar(20) primary key,
    nombre    varchar(50) not null,
    numero    int,
    volumen   int,
    autor     varchar(20) not null,
    categoria varchar(20) not null,
    foreign key (autor) references autor (id),
    foreign key (categoria) references categoria (id)
);

insert into autor values("autor1", "autor", "uno");
insert into categoria values("fan", "fantasia");
insert into libro values("ladc-1", "las aventuras de chowder", "Ecuatoriana", "autor1", "fan");
