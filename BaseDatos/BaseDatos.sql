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


insert into users(username, password, enable) values('user','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);

insert into users(username, password, enable) values('admin','$2a$10$C/kXzIeCg7CIUMpgDL5P/OjHhS3XTZsCYd5aqYdTwdjMIgfleBQoG',1);
-----
insert into roles(user_id, rolname) values(1, 'ROLE_USER');

insert into roles(user_id, rolname) values(2, 'ROLE_USER');

insert into roles(user_id, rolname) values(2, 'ROLE_ADMIN');


SELECT u.username, u.password, u.enable FROM users u WHERE u.username = 'user';

SELECT r.user_id, r.rolname FROM roles r inner join users u 
on r.user_id=u.id where u.username='admin';

