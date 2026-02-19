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
nombre_area varchar(60) not null,
tipo_area varchar(30) not null,
ubicacion_area varchar(50) not null,
estado_area varchar(30) not null
);
INSERT INTO areas_verdes (nombre_area, tipo_area, ubicacion_area, estado_area) VALUES
('Parque Naciones Unidas', 'Parque Nacional', 'Villa Nueva / Amatitlán', 'Excelente'),
('Parque Ecológico Deportivo Cayalá', 'Reserva Ecológica', 'Zona 16', 'Bueno'),
('Parque Erick Barrondo', 'Parque Polideportivo', 'Zona 7', 'Regular'),
('Parque Jungla Urbana', 'Parque Ecológico', 'Zona 15', 'Bueno'),
('Cerrito del Carmen', 'Parque Histórico', 'Zona 1', 'Excelente'),
('Parque Ecológico Kanajuyú', 'Reserva Natural', 'Zona 16', 'Bueno'),
('Parque Regional El Zapote', 'Parque Ecológico', 'Zona 2', 'Bueno'),
('Parque Colón', 'Plaza Recreativa', 'Zona 1', 'Regular'),
('Hipódromo del Norte', 'Bosque Urbano', 'Zona 2', 'Bueno'),
('Jardín Botánico CECON', 'Jardín Botánico', 'Zona 10', 'Excelente'),
('Parque Minerva', 'Parque Recreativo', 'Zona 2', 'Bueno'),
('Barranco de Gerona', 'Corredor Ecológico', 'Zona 1', 'En Recuperación'),
('Parque La Asunción', 'Parque Ecológico', 'Zona 5', 'Bueno'),
('Parque de la Paz', 'Parque Deportivo', 'Zona 21', 'Nuevo');

create table administrador(
	id_admin int primary key not null auto_increment,
    nombre varchar(64),
    apellido varchar(64),
    edad int,
    direccion varchar(150),
    contraseña varchar(8) unique
);