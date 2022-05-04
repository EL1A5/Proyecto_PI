
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

insert into propietario values
(null,"Bryan Alexander","Bernuy Bravo",71434952,"user1@gmail.com",980598055,"1997-05-03","2020-05-05",1);
insert into propietario  values
(null,"Marco Alberto","Vicenzi Gianetto",09621521,"user2@gmail.com",990456789,"1999-04-03","2020-05-05",1);
insert into propietario  values
(null,"Mariela Morena","Beltran Renitti",09621545,"user3@gmail.com",975456852,"1998-04-03","2020-07-05",1);
insert into propietario  values
(null,"Julio Miguel","Benedetti Saldaña",05555444,"user4@gmail.com",982632145,"1997-05-08","2022-05-05",1);
insert into propietario  values
(null,"Migue Angel","Quiroga Muñoz",41256635,"user5@gmail.com",963563255,"1982-04-02","2022-03-03",1);
insert into propietario  values
(null,"Migue Angel","Quiroga Muñoz",41256635,"user5@gmail.com",963563255,"1982-04-02","2022-03-03",0);


-- INSERT DEPARTAMENTO
insert into departamento values
(null,1,101,3,120,2,"2020-05-12",1);
insert into departamento values
(null,2,102,2,90,2,"2021-10-11",1);
insert into departamento values
(null,3,201,1,100,1,"2020-01-25",1);
insert into departamento values
(null,4,202,2,100,1,"2022-02-28",1);
insert into departamento values
(null,5,301,3,240,3,"2021-06-13",1);

insert into mascota values(null,"FUFI","1 año","PERRO ","PITBULL","Vacunacion-InCompleta","1997-05-08",1);
insert into mascota values(null,"BETOBEN","1 año","PERRO ","PITBULL","Vacunacion-Completa","1997-05-08",1);
insert into mascota values(null,"MAIKI","2 años","GATO ","PERSA","Vacunacion-InCompleta","1997-05-08",1);
insert into mascota values(null,"RAMIRO","4 años","GATO ","SIAMES","Vacunacion-Completa","1997-05-08",1);
insert into mascota values(null,"MAIKI","2 años","GATO ","SFINGE","Vacunacion-InCompleta","1997-05-08",1);
insert into mascota values(null,"RAMIRO","4 años","GATO ","ESCOSES","Vacunacion-Completa","1997-05-08",1);

SELECT * FROM mascota;

insert into residente values
(null,1,"Bryan Alexander","Bernuy Bravo",71434952,"user1@gmail.com",1,980598055,"1997-05-03","2020-05-05",1);
insert into residente values
(null,2,"Marco Alberto","Vicenzi Gianetto",09621521,"user2@gmail.com",2,990456789,"1999-04-03","2020-05-05",1);
insert into residente values
(null,3,"Mariela Morena","Beltran Renitti",09621545,"user3@gmail.com",3,975456852,"1998-04-03","2020-07-05",1);
insert into residente values
(null,4,"Julio Miguel","Benedetti Saldaña",05555444,"user4@gmail.com",4,982632145,"1997-05-08","2022-05-05",3);

select*from departamento ;