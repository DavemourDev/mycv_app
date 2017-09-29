--EJECUTA ESTE SCRIPT EN TU SERVIDOR ANTES DE INICIAR LA APLICACIÓN
drop database if exists `cv_db`;
create database if not exists `cv_db`
    character set 'utf8'
    collate 'utf8_spanish_ci';

use `cv_db`;

drop user if exists 'mycv_user'@'localhost';
create user if not exists 'mycv_user'@'localhost' identified by '12345';
grant select on cv_db.* to 'mycv_user'@'localhost';
grant insert on cv_db.* to 'mycv_user'@'localhost';
grant update on cv_db.* to 'mycv_user'@'localhost';
grant delete on cv_db.* to 'mycv_user'@'localhost';

drop table if exists `user`;
create table if not exists `user` (
    `id` int not null auto_increment primary key,
    `email` varchar(255) not null unique,
    `password` varchar(255) not null,
    `registerdate` timestamp default current_timestamp
);

drop table if exists `sector`;
create table if not exists `sector`(
    `id` int not null auto_increment primary key,
    `name_es` varchar(255) not null,
    `name_ca` varchar(255) not null,
    `name_en` varchar(255) not null
);

drop table if exists `language_level`;
create table if not exists `language_level`(
    `id` int not null auto_increment primary key,
    `name_es` varchar(50) not null,
    `name_ca` varchar(50) not null,
    `name_en` varchar(50) not null
);

drop table if exists `language_global_level`;
create table if not exists `language_global_level`(
    `id` int not null auto_increment primary key,
    `name` char(3) not null
);

drop table if exists `language`;
create table if not exists `language`(
    `id` int not null auto_increment primary key,
    `name_es` varchar(255) not null,
    `name_ca` varchar(255) not null,
    `name_en` varchar(255) not null,
    `cod_iso_1` char(2) not null,
    `cod_iso_2` char(3) not null,
    `flag` text
);

drop table if exists `country`;
create table if not exists `country`(
	`id` int not null auto_increment primary key,
    `name_es` varchar(100) not null,
    `name_ca` varchar(100) not null,
    `name_en` varchar(100) not null
);

drop table if exists `education_level`;
create table if not exists `education_level`(
    `id` int not null auto_increment primary key,
    `name_es` varchar(255) not null,
    `name_ca` varchar(255) not null,
    `name_en` varchar(255) not null
);

drop table if exists `gender`;
create table if not exists `gender`(
    `id` int not null auto_increment primary key,
    `name_es` varchar(25) not null,
    `name_ca` varchar(25) not null,
    `name_en` varchar(25) not null
);

drop table if exists `telephone`;
create table if not exists `telephone`(
    `user_id` int not null,
    `number` varchar(13) not null,
    `description` varchar(100),
	foreign key (`user_id`) references `user`(`id`)
);

drop table if exists `email`;
create table if not exists `email`(
    `user_id` int not null,
    `email` varchar(255) not null,
    `description` varchar(100),
	foreign key (`user_id`) references `user`(`id`)
);

drop table if exists `personal`;
create table if not exists `personal` (
    `id` int not null primary key, -- La ID de este objeto va ligada a la del usuario, con lo cual no es auto incremental y actúa como clave foránea.
    `name` varchar(255) not null,
    `lastname` varchar(255) not null,
    `gender_id` int not null,
    `birthdate` varchar(20) not null,
    `country_id` int not null,
    `province` varchar(100),
    `city` varchar(100),
    `telephone1` varchar(20) default '',
    `telephone2` varchar(20) default '',
    `picture` text,
    foreign key (`id`) references `user`(`id`),
    foreign key (`gender_id`) references `gender`(`id`),
    foreign key (`country_id`) references `country`(`id`)
);

drop table if exists `picture`;
create table if not exists `picture` (
    `id` int not null auto_increment primary key,
    `user_id` int not null,
    `description` varchar(255) not null,
    `image` blob not null, 
    foreign key (`user_id`) references `user`(`id`)
);

drop table if exists `experience`;
create table if not exists `experience` (
    `id` int not null auto_increment primary key,
    `user_id` int not null,
    `job` varchar(255) not null,
    `enterprise` varchar(255) not null,
    `sector_id` int not null,
    `startdate` date not null,
    `enddate` date,
    `hours` int,
    `description` text default '',
    `country_id` int not null,
    `tags` varchar(500), 
    `city` varchar(100) not null,
    foreign key (`user_id`) references `user`(`id`),
    foreign key (`sector_id`) references `sector`(`id`),
    foreign key (`country_id`) references `country`(`id`)
);

drop table if exists `education`;
create table if not exists `education` (
    `id` int not null auto_increment primary key,
    `user_id` int not null,
    `titlename` varchar(255) not null,
    `center`  varchar(255)  not null,
    `education_level_id` int not null,
    `sector_id` int not null,
    `startdate` date not null,
    `enddate` date,
    `description` text default '',
    `hours` int,
    `country_id` int not null,
    `tags` varchar(500),
    `city` varchar(100) not null,
    foreign key (`user_id`) references `user`(`id`),
    foreign key (`sector_id`) references `sector`(`id`),
    foreign key (`country_id`) references `country`(`id`),
    foreign key (`education_level_id`) references `education_level`(`id`)
-- completar
);

-- Cada item de idioma de un usuario es un registro de esta tabla. No confundir con la tabla language 
drop table if exists `languageskill`;
create table if not exists `languageskill`(
    `id` int not null auto_increment primary key,
    `user_id` int not null,
    `language_id` int not null,
    `speech` int not null,
    `comprehension` int not null,
    `writing` int not null,
    `language_global_level_id` int not null, -- En teoría referencia a language_global_level, pero de momento actúa como los tres campos anteriores
    `description` text default '', -- Sugerencia: Puede ser un buen sitio para incluir información relevante sobre titulación de idiomas, etc.
    foreign key (`user_id`) references `user`(`id`)
		on delete cascade 
        on update cascade
);

-- Cada item de otra info de un usuario es un registro de esta tabla. Pueden incluirse carnets y otros datos relevantes aquí. 
drop table if exists `otherinfo`;
create table if not exists `otherinfo`(
    `id` int not null auto_increment primary key,
    `user_id` int not null,
    `title` varchar(100) not null,
    `description` varchar(255) not null,
    `tags` varchar(500), -- Van en otra tabla
    foreign key (`user_id`) references `user`(`id`)

);

-- T a b l a s   p a r a   l a s   t a g s

drop table if exists `experience_tag`;
create table if not exists `experience_tag`(
    `id` int not null auto_increment primary key,
    `experience_id` int not null,
    `tagtext` varchar(50) not null,
    foreign key (`experience_id`) references `experience`(`id`)
        on delete cascade
        on update cascade

);

drop table if exists `education_tag`;
create table if not exists `education_tag`(
    `id` int not null auto_increment primary key,
    `education_id` int not null,
    `tagtext` varchar(50) not null,
    foreign key (`education_id`) references `education`(`id`)
        on delete cascade
        on update cascade
);

drop table if exists `otherinfo_tag`;
create table if not exists `otherinfo_tag`(
    `id` int not null auto_increment primary key,
    `otherinfo_id` int not null,
    `tagtext` varchar(50) not null,
    foreign key (`otherinfo_id`) references `otherinfo`(`id`)
        on delete cascade
        on update cascade

);

-- Cada perfil de usuario va aquí. Por el momento no hay límite de perfiles de usuario, pero debería limitarse.
drop table if exists `profile`;
create table if not exists `profile`(
    `id` int not null auto_increment primary key,
    `user_id` int not null,
    `name` varchar(100) not null,
    `personal_order` int default 1, 
    `experience_order` int default 1,
    `education_order` int default 1,
    `language_order` int default 1,
    `other_order` int default 1,
    `picture_display` int default 1,
    foreign key (`user_id`) references `user`(`id`)
        on delete cascade on update cascade
);



drop table if exists `profile_tags_exp`;
create table if not exists `profile_tags_exp`(
    profile_id int not null,
    tagtext varchar(50) not null,
    foreign key (`profile_id`) references `profile`(`id`)
        on delete cascade
        on update cascade
);

drop table if exists `profile_tags_education`;
create table if not exists `profile_tags_education`(
    profile_id int not null,
    tagtext varchar(50) not null,
    foreign key (`profile_id`) references `profile`(`id`)
        on delete cascade
        on update cascade
);

drop table if exists `profile_tags_otherinfo`;
create table if not exists `profile_tags_otherinfo`(
    profile_id int not null,
    tagtext varchar(50) not null,
    foreign key (`profile_id`) references `profile`(`id`)
        on delete cascade
        on update cascade
);

drop table if exists `profile_exclude_experience`;
create table if not exists `profile_exclude_experience`(
    `profile_id` int not null,
    `experience_id` int not null,
    foreign key (`profile_id`) references `profile`(`id`)
        on delete cascade
        on update cascade,
    foreign key (`experience_id`) references `experience`(`id`)
        on delete cascade
        on update cascade
);

drop table if exists `profile_exclude_education`;
create table if not exists `profile_exclude_education`(
    `profile_id` int not null,
    `education_id` int not null,
    foreign key (`profile_id`) references `profile`(`id`)
        on delete cascade
        on update cascade,
    foreign key (`education_id`) references `education`(`id`)
        on delete cascade
        on update cascade
);

drop table if exists `profile_exclude_otherinfo`;
create table if not exists `profile_exclude_otherinfo`(
    `profile_id` int not null,
    `other_id` int not null,
    foreign key (`profile_id`) references `profile`(`id`)
        on delete cascade
        on update cascade,
    foreign key (`other_id`) references `otherinfo`(`id`)
        on delete cascade
        on update cascade
);

drop view if exists `all_otherinfo_tags`;
create view if not exists `all_otherinfo_tags` as 
	SELECT distinct o.id id, u.id user_id, tagtext
	from user u 
            JOIN otherinfo oi ON u.id=oi.user_id
            JOIN otherinfo_tag o ON oi.id=o.otherinfo_id;
 
drop view if exists `all_education_tags`;
create view if not exists `all_education_tags` as 
	SELECT distinct et.id id, u.id user_id, tagtext
	from user u 
            join education e on e.user_id = u.id
            join education_tag et on e.id=et.education_id;

drop view if exists `all_experience_tags`;
create view if not exists `all_experience_tags` as 
	SELECT distinct et.id id, u.id user_id, tagtext
	from user u 
            join experience e on e.user_id = u.id
            join experience_tag et on e.id=et.experience_id;

insert into `gender`(`name_es`, `name_ca`, `name_en`) values
('hombre', 'home', 'male'),
('mujer', 'dona', 'female'),
('otro', 'altre', 'other')
;

insert into `country`(`name_es`, `name_ca`, `name_en`) values
('España', 'Espanya', 'Spain'),
('Francia', 'França', 'France'),
('Portugal', 'Portugal', 'Portugal')
;

insert into `sector`(`name_es`, `name_ca`, `name_en`) values
('hostelería y restauración', 'hosteleria i restauració', 'hospitality & restaurant business'),
('química', 'química', 'chemistry'),
('administración de empresas', 'administració d''empreses', 'business administration'),
('informática y telecomunicaciones', 'informàtica i telecomunicacions', 'computer science'),
('administración pública','administració pública','public administration'),
('administración pública','administració pública','public administration'),
('calidad, producción y I+D','qualitat, producció i I+D','quality & production'),
('comercial y ventas','comercial i vendes','commercial activity'),
('compras, logística y almacén','compres, logística i magatzem','logistic'),
('diseño y artes gráficas','disseny i arts gràfiques','design & graphic arts'),
('educación y formación','educació i formació','education & training'),
('ingenieros y técnicos','enginyeria i tècnica','engineering & technicy'),
('inmobiliario y construcción','inmobiliària i construcció','estate agency & building sector'),
('legal','legal','law'),
('marketing y comunicación','màrqueting i comunicació','marketing & communication'),
('otros','altres','other'),
('profesiones, artes y oficios','altres','other'),
('recursos humanos','recursos humans','human resources'),
('sanidad y salud','sanitat i salut','health service'),
('sector farmacéutico','sector farmacèutic','pharmacy'),
('ventas al detalle','vendes al detall','sales')
;

insert into `language` (`name_es`, `name_ca`, `name_en`, `cod_iso_1`, `cod_iso_2`) values
('Español', 'Espanyol','Spanish','es', 'spa'),
('Catalán', 'Català ','Catalan','ca', 'cat'),
('Inglés', 'Anglés','English','en', 'eng'),
('Francés', 'Francés','French','fr', 'fre'),
('Alemán', 'Alemany','Deutsch','de', 'ger'),
('Italiano', 'Italià ','Italian','it', 'ita'),
('Portugués', 'Portugués','Portuguese','pt', 'por'),
('Albanés', 'Albanès','Albanian','sq', 'alb'),
('�?rabe', 'Àrab','Arabic','ar', 'ara'),
('Checo','Txec','Czech', 'cs', 'cze'),
('Chino', 'Xinés','Chinese','zh', 'chi'),
('Coreano', 'Coreà ','Korean','ko', 'kor'),
('Croata', 'Croata', 'Croatian', 'hr', 'hrv'),
('Danés', 'Danès','Danish','da', 'dan'),
('Eslovaco', 'Eslovac','Slovak','sk', 'slo'),
('Esloveno', 'Eslovè', 'Slovene', 'sl', 'slv'),
('Euskera', 'Euskera','Basque','eu', 'eus'),
('Finlandés', 'Finlandés','Finnish','fi', 'fin'),
('Gallego', 'Gallec', 'Galician', 'gl', 'glg'),
('Griego', 'Grec','Greeek','el', 'gre'),
('Húngaro', 'Húngar', 'Hungarian','hu', 'hun'),
('Holandés', 'Holandès','Dutch','nl', 'dut'),
('Japonés', 'Japonés','Japanese','ja', 'jpn'),
('Noruego', 'Noruec', 'Norwegian', 'no', 'nor'),
('Polaco', 'Polac','Polish','pl', 'pol'),
('Rumano', 'Rumanés','Romanian','ro', 'rum'),
('Ruso', 'Rus','Russian','ru', 'rus'),
('Serbio', 'Serbi','Serbian','sr', 'srp'),
('Sueco', 'Suec','Swedish','sv', 'swe'),
('Turco', 'Turc','Turkish', 'tr', 'tur'),
('Otro', 'Altre','Other','xx', 'xxx')
;

insert into `language_level` (`name_es`, `name_ca`, `name_en`) values
('Básico', 'Bàsic', 'Basic'),
('Bajo', 'Baix', 'Low'),
('Medio', 'Mitjà ' ,'Medium'),
('Alto', 'Alt','High'),
('Nativo', 'Natiu', 'Native')
;

insert into `language_global_level` (`name`) values
('A1'),
('A2'),
('B1'),
('B2'),
('C1'),
('C2')
;

insert into `education_level` (`name_es`, `name_ca`, `name_en`) values
('Sin calificación', 'Sense qualificació', 'Unqualified'),
('Educación Primaria', 'Educació Primària', 'Elementary Education'),
('Educación Secundaria Obligatoria', 'Educació Secundària Obligatòria', 'High School'),
('Bachillerato', 'Batxillerat', 'High School Diploma'),
('Formación profesional de grado medio', 'Formació professional de grau mitjà', 'Lower Level Vocational Training'),
('Educación superior', 'Educació superior', 'Post-secondary Education'),
('Formación profesional de grado superior', 'Formació professional de grau superior', 'Advanced Vocational Training'),
('Grado universitario', 'Grau universitari', 'Bachelor''s Degree'),
('Máster universitario', 'Màster universitari', 'Master''s Degree'),
('Doctorado universitario', 'Doctorat universitari', 'Doctorate')
;
