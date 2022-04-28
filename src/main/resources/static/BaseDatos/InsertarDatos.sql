
USE `db_proyectointegradorgroup5` ;


insert into users(id,username, password, enable) values(1,'admin','$2a$10$C/kXzIeCg7CIUMpgDL5P/OjHhS3XTZsCYd5aqYdTwdjMIgfleBQoG',1);
insert into users(id,username, password, enable) values(2,'user','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);
insert into users(id,username, password, enable) values(3,'gerente','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);
insert into users(id,username, password, enable) values(4,'cajero','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);


insert into roles(user_id, rolname) values(1, 'ROLE_USER');
insert into roles(user_id, rolname) values(1, 'ROLE_ADMIN');
insert into roles(user_id, rolname) values(1, 'ROLE_GERENTE');
insert into roles(user_id, rolname) values(1, 'ROLE_CAJERO');
insert into roles(user_id, rolname) values(2, 'ROLE_USER');
insert into roles(user_id, rolname) values(3, 'ROLE_GERENTE');
insert into roles(user_id, rolname) values(3, 'ROLE_USER');
insert into roles(user_id, rolname) values(4, 'ROLE_CAJERO');




SELECT r.user_id, r.rolname FROM roles r inner join users u 
on r.user_id=u.id where u.username='admin';



insert into residente values
(null,"Bryan Alexander","Bernuy Bravo",71434952,"user1@gmail.com",1,"Inquilino",980598055,"1997-05-03","2020-05-05",1);
insert into residente values
(null,"Marco Alberto","Vicenzi Gianetto",09621521,"user2@gmail.com",1,"Propietario",990456789,"1999-04-03","2020-05-05",1);
insert into residente values
(null,"Mariela Morena","Beltran Renitti",09621545,"user3@gmail.com",4,"Inquilino",975456852,"1998-04-03","2020-07-05",1);
insert into residente values
(null,"Julio Miguel","Benedetti Saldaña",05555444,"user4@gmail.com",3,"Propietario",982632145,"1997-05-08","2022-05-05",3);

select*from residente;