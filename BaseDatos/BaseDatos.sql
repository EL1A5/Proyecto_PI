create database db_proyectointegradorgroup5;
use db_proyectointegradorgroup5;


CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `rolname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_rol_unique` (`user_id`,`rolname`),
  CONSTRAINT `rk_rol_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


create table residente(
idresidente int not null auto_increment primary key,
nombre varchar(35) not null,
apellidos varchar(45) not null,
dni int,
mascotas tinyint(1),
estado varchar(15),
fechaReg date,
activo tinyint(1)
);

create table mascota(
idmascota int auto_increment primary key,
idresidente int ,
nombre varchar(35),
tipo varchar(40),
fechareg date,
activo tinyint(1),
foreign key(idresidente)references residente(idresidente)
);


create table departamento(
iddepartamento int not null auto_increment primary key,
idresidente int ,
numpiso int ,
habitaciones int,
cocinas int,
banos int,
fechareg date,
estado varchar(30),
activo tinyint(1),
foreign key(idresidente) references residente(idresidente)
);

create table visitante(
idvisitante int not null auto_increment primary key,
nombre varchar(35) not null,
apellidos varchar(45) not null,
dni int not null,
fechareg date,
activo tinyint(1)
);

create table visita(
idvisita int not null auto_increment primary key,
idvisitante int,
idresidente int ,
fechareg date,
foreign key(idresidente) references residente(idresidente),
foreign key(idvisitante) references visitante(idvisitante)
);

create table servicio(
idservicio int not null auto_increment primary key,
iddepartamento int,
nombreserv varchar(35) not null,
precioserv double not null,
fechareg date,
foreign key(iddepartamento) references departamento(iddepartamento)

);

create table boleta(
idpagoservicio int auto_increment primary key,
idservicio int,
idresidente int,
preciototal double,
fechareg date,
estado tinyint(1),
foreign key(idservicio) references servicio(idservicio),
foreign key(idresidente) references residente(idresidente)
);


CREATE table insidencia(
idincidencia int auto_increment primary key,
iduser int,
idresidente int,
tipo varchar(35) not null,
descripcion varchar(80) not null,
estado tinyint(1) not null,
fechareg date,
fechaatencion date,
foreign key(iduser) references users(id),
foreign key(idresidente) references residente(idresidente)
);


insert into users(username, password, enable) values('user','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);

insert into users(username, password, enable) values('admin','$2a$10$C/kXzIeCg7CIUMpgDL5P/OjHhS3XTZsCYd5aqYdTwdjMIgfleBQoG',1);
-----
insert into roles(user_id, rolname) values(1, 'ROLE_USER');

insert into roles(user_id, rolname) values(2, 'ROLE_USER');

insert into roles(user_id, rolname) values(2, 'ROLE_ADMIN');


SELECT u.username, u.password, u.enable FROM users u WHERE u.username = 'user';

SELECT r.user_id, r.rolname FROM roles r inner join users u 
on r.user_id=u.id where u.username='admin';


insert into residente values
(null,"Bryan Alexander","Bernuy Bravo",71434952,1,"Inquilino","2020-05-05",1);
insert into residente values
(null,"Marco Alberto","Vicenzi Gianetto",09621521,1,"Propietario","2020-05-05",1);
insert into residente values
(null,"Mariela Morena","Beltran Renitti",09621545,4,"Inquilino","2020-07-05",1);
insert into residente values
(null,"Julio Miguel","Benedetti Saldaña",05555444,3,"Propietario","2022-05-05",3);

select * from residente;
