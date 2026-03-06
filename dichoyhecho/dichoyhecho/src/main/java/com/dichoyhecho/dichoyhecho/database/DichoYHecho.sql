create database dichoyhecho_in5bv;
use dichoyhecho_in5bv;

create table usuario(
	id_usuario int auto_increment not null primary key,
    nombre_usuario varchar(60) not null,
    apellido_usuario varchar(60) not null,
    handle_usuario varchar(60) not null,
    contrasena varchar(60) not null,
    email_usuario varchar(60) not null,
    edad_usuario int not null,
    rol_usuario enum(
    'POLICIA_NACIONAL_CIVIL',
	'POLICIA_MUNICIPAL',
	'POLICIA_MUNICIPAL_DE_TRANSITO',
	'BOMBERO_MUNICIPAL',
	'BOMBERO_VOLUNTARIO',
	'AGENTE_CONRED',
	'EJERCITO_DE_GUATEMALA',
	'PERSONAL_DE_SALUD_PUBLICA',
	'GESTOR_DE_TRANSMETRO',
	'PERSONAL_DE_ORNATO',
	'PERSONALIDAD_DE_MUNICIPALIDAD',
	'JUEZ_DE_ASUNTOS_MUNICIPALES',
	'VECINO'
    )
);

insert into usuario (nombre_usuario, apellido_usuario, handle_usuario, contrasena, edad_usuario, rol_usuario, email_usuario) values ("Jaime", "Martinez", "roxy", "contraseña", 67, "Vecino", "jmartinez202567@kinal.edu.gt");

create table comentario (
    id_comentario bigint auto_increment primary key,
    contenido text not null,
    imagen_url longblob,
    video_url longblob,
    id_usuario int not null,
    fecha_comentario timestamp default current_timestamp,
    constraint fk_usuario_comentario foreign key (id_usuario) references usuario(id_usuario) on delete cascade
);

create table areas_verdes(
id_area int auto_increment not null primary key,
nombre_area varchar(60) not null,
tipo_area varchar(30) not null,
ubicacion_area varchar(50) not null,
estado_area varchar(30) not null
);

create table administrador(
	id_administrador int primary key auto_increment,
    nombre varchar(64),
    apellido varchar(64),
    edad int,
    direccion varchar(120),
    identificador varchar(24) unique,
    correo varchar(74),
    contrasena varchar(13) unique
);

create table problemas(
	id_problema int primary key auto_increment,
    tipo varchar(128),
    direccion varchar(120),
    categoria enum('NIVEL_BAJO','NIVEL_MODERADO','NIVEL_ALTO','NIVEL_CRITICO'),
    estado enum('REPORTADO','EN_INSPECCION_TECNICAa','PENDIENTE_DE_APROBACION','EN_REVISION','PROGRAMADO','EN_PROCESO','RESUELTO','RECHAZADO'),
    notificacion boolean
);

Create table locales(
id_locales int auto_increment not null primary key,
nombre varchar(100) not null,
descripcion text,
telefono varchar(12) not null,
correo varchar(50) not null,
id_categoria text not null,
direccion_asociada varchar(100) not null
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


INSERT INTO locales (nombre, descripcion, telefono, correo, id_categoria, direccion_asociada)
VALUES 
('Super 24 Zona 1',
 'Tienda de conveniencia abierta 24 horas',
 '22345678',
 'zona1@super24.com',
 'Tienda de conveniencia',
 '6a avenida 10-50 Zona 1, Ciudad de Guatemala'),

('Farmacias Cruz Verde Roosevelt',
 'Farmacia con servicio a domicilio y medicamentos especializados',
 '24445566',
 'roosevelt@cruzverde.com.gt',
 'Farmacia',
 'Calzada Roosevelt 15-20 Zona 11, Ciudad de Guatemala'),

('CEMACO Peri Roosevelt',
 'Tienda por departamentos, hogar y ferretería',
 '24112233',
 'peri@cemaco.com',
 'Tienda por departamentos',
 'Anillo Periférico 25-30 Zona 7, Ciudad de Guatemala'),

('Clínica Médica Central',
 'Servicios médicos generales y laboratorio clínico',
 '23334455',
 'info@clinicacentral.com',
 'Clínica',
 '12 calle 5-40 Zona 9, Ciudad de Guatemala'),

('Librería La Cultura',
 'Venta de libros escolares y universitarios',
 '22556677',
 'ventas@lacultura.com',
 'Librería',
 '18 calle 8-15 Zona 1, Ciudad de Guatemala');

insert into problemas(tipo,direccion,categoria,estado,notificacion) values ("Congestionamiento vehicular","Calzada Roosevel",3,4,true);

select * from problemas;
select * from administrador;
select * from usuario;