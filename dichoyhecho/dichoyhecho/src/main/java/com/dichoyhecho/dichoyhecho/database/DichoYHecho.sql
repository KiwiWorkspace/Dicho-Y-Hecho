create database dichoyhecho_in5bv;
use dichoyhecho_in5bv;

create table user(
    id_user int auto_increment not null primary key,
    first_name varchar(60) not null,
    last_name varchar(60) not null,
    user_handle varchar(60) not null,
    profile_img longblob,
    password varchar(60) not null,
    user_email varchar(60) not null,
    user_age int not null,
    user_role enum(
        'NATIONAL_CIVIL_POLICE',
        'MUNICIPAL_POLICE',
        'MUNICIPAL_TRAFFIC_POLICE',
        'MUNICIPAL_FIRE_DEPARTMENT',
        'VOLUNTEER_FIRE_DEPARTMENT',
        'CONRED_AGENT',
        'GUATEMALAN_ARMY',
        'PUBLIC_HEALTH_PERSONNEL',
        'TRANSMETRO_MANAGER',
        'PUBLIC_MAINTENANCE_PERSONNEL',
        'MUNICIPAL_AUTHORITY',
        'MUNICIPAL_AFFAIRS_JUDGE',
        'CITIZEN'
    )
);

insert into user (first_name, last_name, user_handle, password, user_age, user_role, user_email) 
values ("Jaime", "Martinez", "roxy", "password", 67, "CITIZEN", "jmartinez202567@kinal.edu.gt");

create table comment (
    id_comment bigint auto_increment primary key,
    content text not null,
    image_url longblob,
    video_url longblob,
    id_user int not null,
    id_zone int not null,
    comment_date timestamp default current_timestamp,
    constraint fk_user_comment foreign key (id_user) references user(id_user) on delete cascade
);

create table green_areas(
    id_area int auto_increment not null primary key,
    area_name varchar(60) not null,
    area_type varchar(30) not null,
    area_location varchar(50) not null,
    area_status varchar(30) not null
);

create table administrator(
    id_administrator int primary key auto_increment,
    first_name varchar(64),
    last_name varchar(64),
    age int,
    address varchar(120),
    identifier varchar(24) unique,
    email varchar(74),
    password varchar(255) unique
);

create table issues(
    id_issue int primary key auto_increment,
    type varchar(128),
    address varchar(120),
    category enum('LOW_LEVEL','MODERATE_LEVEL','HIGH_LEVEL','CRITICAL_LEVEL'),
    status enum('REPORTED','UNDER_TECHNICAL_INSPECTION','PENDING_APPROVAL','UNDER_REVIEW','SCHEDULED','IN_PROGRESS','RESOLVED','REJECTED'),
    notification boolean
);

create table businesses(
    id_business int auto_increment not null primary key,
    name varchar(100) not null,
    description text,
    phone varchar(12) not null,
    email varchar(50) not null,
    category text not null,
    associated_address varchar(100) not null,
    status enum('PENDING', 'APPROVED', 'REJECTED') not null default 'PENDING',
    rejection_reason varchar(255)
);

insert into green_areas (area_name, area_type, area_location, area_status) values
('Parque Naciones Unidas', 'National Park', 'Villa Nueva / Amatitlán', 'Excellent'),
('Parque Ecológico Deportivo Cayalá', 'Ecological Reserve', 'Zone 16', 'Good'),
('Parque Erick Barrondo', 'Sports Park', 'Zone 7', 'Regular'),
('Parque Jungla Urbana', 'Ecological Park', 'Zone 15', 'Good'),
('Cerrito del Carmen', 'Historic Park', 'Zone 1', 'Excellent'),
('Parque Ecológico Kanajuyú', 'Natural Reserve', 'Zone 16', 'Good'),
('Parque Regional El Zapote', 'Ecological Park', 'Zone 2', 'Good'),
('Parque Colón', 'Recreational Plaza', 'Zone 1', 'Regular'),
('Hipódromo del Norte', 'Urban Forest', 'Zone 2', 'Good'),
('Jardín Botánico CECON', 'Botanical Garden', 'Zone 10', 'Excellent'),
('Parque Minerva', 'Recreational Park', 'Zone 2', 'Good'),
('Barranco de Gerona', 'Ecological Corridor', 'Zone 1', 'In Recovery'),
('Parque La Asunción', 'Ecological Park', 'Zone 5', 'Good'),
('Parque de la Paz', 'Sports Park', 'Zone 21', 'New');

insert into businesses (name, description, phone, email, category, associated_address)
values 
('Super 24 Zona 1',
 '24-hour convenience store',
 '22345678',
 'zona1@super24.com',
 'Convenience Store',
 '6th avenue 10-50 Zone 1, Guatemala City'),

('Farmacias Cruz Verde Roosevelt',
 'Pharmacy with home delivery and specialized medicine',
 '24445566',
 'roosevelt@cruzverde.com.gt',
 'Pharmacy',
 'Roosevelt Avenue 15-20 Zone 11, Guatemala City'),

('CEMACO Peri Roosevelt',
 'Department store, home and hardware',
 '24112233',
 'peri@cemaco.com',
 'Department Store',
 'Periférico Ring Road 25-30 Zone 7, Guatemala City'),

('Clínica Médica Central',
 'General medical services and clinical laboratory',
 '23334455',
 'info@clinicacentral.com',
 'Clinic',
 '12th street 5-40 Zone 9, Guatemala City'),

('Librería La Cultura',
 'School and university books store',
 '22556677',
 'ventas@lacultura.com',
 'Bookstore',
 '18th street 8-15 Zone 1, Guatemala City');

insert into issues(type,address,category,status,notification) 
values ("Traffic congestion","Roosevelt Avenue",3,4,true);

select * from issues;
select * from administrator;
select * from user;