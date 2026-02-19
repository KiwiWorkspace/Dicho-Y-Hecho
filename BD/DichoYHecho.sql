create database dichoyhecho_in5bv;
use dichoyhecho_in5bv;
create table usuario(
	id_usuario int auto_increment not null primary key,
    nombre_usuario varchar(60) not null,
    apellido_usuario varchar(60) not null,
    handle_usuario varchar(60) not null,
    contrasena varchar(60) not null,
    edad_usuario int not null
);

create table areas_verdes(
id_area int auto_increment not null primary key,
nombre_area varchar(30) not null,
tipo_area varchar(30) not null,
ubicacion_area varchar(50) not null,
estado_area varchar(30) not null,
tipo_therian varchar(15) not null
);
