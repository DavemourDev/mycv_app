# java_servlet
testing

-- Para crear la base de datos que usa la aplicación, ejecutar el siguiente script:


create database if not exists `dummy`
	character set utf8
  collate utf8_spanish_ci;

create table if not exists `user`(
	`email` varchar(100) not null primary key,
  `password` varchar(255) not null
);


-- El usuario sería root sin contraseña.
-- Si queréis usar otros datos o tablas, cambiad las constantes de la clase Database
