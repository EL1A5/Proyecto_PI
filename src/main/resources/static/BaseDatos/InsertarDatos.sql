
USE `db_proyectointegradorgroup5` ;

insert into users(username, password, enable) values('user','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);

insert into users(username, password, enable) values('admin','$2a$10$C/kXzIeCg7CIUMpgDL5P/OjHhS3XTZsCYd5aqYdTwdjMIgfleBQoG',1);
insert into users(username, password, enable) values('gerente','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);
insert into users(username, password, enable) values('cajero','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);

insert into roles(user_id, rolname) values(5, 'ROLE_USER');

insert into roles(user_id, rolname) values(6, 'ROLE_USER');
insert into roles(user_id, rolname) values(6, 'ROLE_ADMIN');
insert into roles(user_id, rolname) values(6, 'ROLE_GERENTE');
insert into roles(user_id, rolname) values(6, 'ROLE_CAJERO');

insert into roles(user_id, rolname) values(7, 'ROLE_GERENTE');
insert into roles(user_id, rolname) values(7, 'ROLE_USER');

insert into roles(user_id, rolname) values(8, 'ROLE_CAJERO');

SELECT u.username, u.password, u.enable FROM users u WHERE u.username = 'user';

SELECT r.user_id, r.rolname FROM roles r inner join users u 
on r.user_id=u.id where u.username='user';

insert into visitante (nombre,apellidos,dni,fechareg,activo) values('ELIAS','PROVINCIA',12345678,'2020-05-05',1);
insert into visita (idvisitante,idresidente,horaentrada,horasalida) values(2,1,'2020-05-05 15:07:01','2020-05-06 17:07:01');

insert into mascota values(null,null,"FUFI","CHIHUAHUA","1997-05-08",1);
Insert into mascota values(null,null,"ODI","PERRO AMARILLO","1997-05-08",1);
Insert into mascota values(null,null,"GARFIELD","GATO NARANJA","1997-05-08",1);
Insert into mascota values(null,null,"BETO","DOBERMAN","1997-05-08",1);


insert into residente values
(null,"Bryan Alexander","Bernuy Bravo",71434952,"user1@gmail.com",1,"Inquilino",980598055,"1997-05-03","2020-05-05",1);
insert into residente values
(null,"Marco Alberto","Vicenzi Gianetto",09621521,"user2@gmail.com",2,"Propietario",990456789,"1999-04-03","2020-05-05",1);
insert into residente values
(null,"Mariela Morena","Beltran Renitti",09621545,"user3@gmail.com",4,"Inquilino",975456852,"1998-04-03","2020-07-05",1);
insert into residente values
(null,"Julio Miguel","Benedetti Saldaña",05555444,"user4@gmail.com",3,"Propietario",982632145,"1997-05-08","2022-05-05",3);

select*from residente;