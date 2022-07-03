
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_proyectointegradorgroup5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_proyectointegradorgroup5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_proyectointegradorgroup5` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_proyectointegradorgroup5` ;

-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`residente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`residente` (
  `idresidente` INT NOT NULL AUTO_INCREMENT,
  `iddepartamento` INT NULL DEFAULT NULL,
  `nombre` VARCHAR(35) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `dni` INT NULL DEFAULT NULL,
  `correo` VARCHAR(45) NOT NULL,

  `telefono` INT NOT NULL ,
   `fechaNac` DATE NULL DEFAULT NULL,
  `fechaReg` DATETIME NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idresidente`),

    FOREIGN KEY (`iddepartamento`)
    REFERENCES `db_proyectointegradorgroup5`.`departamento` (`iddepartamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`propietario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`propietario` (
  `idpropietario` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(35) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `dni` INT NULL DEFAULT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL ,
  `fechaNac` DATE NULL DEFAULT NULL,
  `fechaReg` DATETIME DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idpropietario`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`departamento` (
 `iddepartamento` INT NOT NULL AUTO_INCREMENT,
  `idpropietario` INT NULL  NOT NULL,
  `numdepartamento` char(3) NULL DEFAULT NULL,
  `habitaciones` INT NULL DEFAULT NULL,
  `area` double NULL DEFAULT NULL,
  `banos` INT NULL DEFAULT NULL,
  `fechareg` DATETIME NULL DEFAULT NULL,
  `estado` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`iddepartamento`),
  FOREIGN KEY (`idpropietario`)
    REFERENCES `db_proyectointegradorgroup5`.`propietario` (`idpropietario`))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`boleta` (
  `idboleta` INT NOT NULL AUTO_INCREMENT,
  `idservicio` INT NULL DEFAULT NULL,
  `idpropietario` INT NULL DEFAULT NULL,
  `anio` char(4)  NULL DEFAULT NULL,
  `fechaVenc` DATE NULL DEFAULT NULL,
  `estado` varchar(15) not NULL DEFAULT 'Pendiente',
  PRIMARY KEY (`idboleta`),
  INDEX `idservicio` (`idservicio` ASC) ,
  CONSTRAINT `boleta_ibfk_1`
    FOREIGN KEY (`idservicio`)
    REFERENCES `db_proyectointegradorgroup5`.`servicio` (`idservicio`),
  CONSTRAINT `boleta_ibfk_2`
    FOREIGN KEY (`idpropietario`)
    REFERENCES `db_proyectointegradorgroup5`.`propietario` (`idpropietario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`servicio`
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`servicio` (
  `idservicio` INT NOT NULL AUTO_INCREMENT,
  `nombreserv` VARCHAR(35) NOT NULL,
  `precioserv` DOUBLE NOT NULL,
  `estado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idservicio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`users` (
  `id` INT NOT NULL ,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `enable` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`insidencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`incidencia` (
  `idincidencia` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NULL DEFAULT NULL,
  `idresidente` INT NULL DEFAULT NULL,
  `iddepartamento` INT NULL DEFAULT NULL,
   `tipo` VARCHAR(80) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` INT NOT NULL,
  `observacion` varchar(50)  NULL,
  `fechareg` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`idincidencia`),
    CONSTRAINT `insidencia_ibfk_3`
    FOREIGN KEY (`iddepartamento`)
    REFERENCES `db_proyectointegradorgroup5`.`departamento` (`iddepartamento`),
     CONSTRAINT `insidencia_ibfk_4`
    FOREIGN KEY (`iduser`)
    REFERENCES `db_proyectointegradorgroup5`.`users` (`id`),
     CONSTRAINT `insidencia_ibfk_5`
    FOREIGN KEY (`idresidente`)
    REFERENCES `db_proyectointegradorgroup5`.`residente` (`idresidente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`mascota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`mascota` (
  `idmascota` INT NOT NULL AUTO_INCREMENT,
   `idresidente` INT NOT NULL,
  `nombre` VARCHAR(35) NULL DEFAULT NULL,
   `edad` varchar(10) not null,
  `tipo` VARCHAR(40) not  null ,
  `raza` VARCHAR(40) not NULL,
  `vacunacion` VARCHAR(25) not NULL,
  `fechareg` DATETIME NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`idmascota`),
  CONSTRAINT `residente_fk_2`
    FOREIGN KEY (`idresidente`)
    REFERENCES `db_proyectointegradorgroup5`.`residente` (`idresidente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `rolname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_rol_unique` (`user_id` ASC, `rolname` ASC) VISIBLE,
  CONSTRAINT `rk_rol_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_proyectointegradorgroup5`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`visitante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`visitante` (
  `idvisitante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(35) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
   `fechanac` date not NULL,
  `dni` INT NOT NULL,
   `correo` VARCHAR(45) NOT NULL,
    `telefono` VARCHAR(45) NOT NULL,
  `fechareg` DATETIME NULL DEFAULT NULL,
  `activo` TINYINT(1) NULL DEFAULT NULL,
   `idusuario` INT NOT NULL,
  PRIMARY KEY (`idvisitante`),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `db_proyectointegradorgroup5`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`visita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`visita` (
  `idvisita` INT NOT NULL AUTO_INCREMENT,
  `idvisitante` INT NULL DEFAULT NULL,
  `idresidente` INT NULL DEFAULT NULL,
  `iddepartamento` int  not null,
  `horaentrada` DATETIME NULL DEFAULT NULL,
  `horasalida` DATETIME NULL,
  `observacion` varchar(50)  NULL,
  `estado` varchar(7) not NULL,
   `idusuario` INT not null,
  PRIMARY KEY (`idvisita`),
  CONSTRAINT `visita_ibfk_1`
    FOREIGN KEY (`idresidente`)
    REFERENCES `db_proyectointegradorgroup5`.`residente` (`idresidente`),
  CONSTRAINT `visita_ibfk_2`
    FOREIGN KEY (`idvisitante`)
    REFERENCES `db_proyectointegradorgroup5`.`visitante` (`idvisitante`),
     CONSTRAINT `visita_ibfk_4`
    FOREIGN KEY (`idusuario`)
    REFERENCES `db_proyectointegradorgroup5`.`users` (`id`),
     CONSTRAINT `visita_ibfk_7`
    FOREIGN KEY (`iddepartamento`)
    REFERENCES `db_proyectointegradorgroup5`.`departamento` (`iddepartamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;











-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`pago` (
  `idpago` INT  not NULL,
   `idboleta` INT  not NULL,
  `iduser` INT not null,
  `idresidente` INT not NULL,
  `fechapago` DATETIME  not NULL,
  PRIMARY KEY (`idpago`),
  INDEX `fk2_idx` (`iduser` ASC) ,
  INDEX `fk3_idx` (`idresidente` ASC) ,
  CONSTRAINT `fk2`
    FOREIGN KEY (`iduser`)
    REFERENCES `db_proyectointegradorgroup5`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk3`
    FOREIGN KEY (`idresidente`)
    REFERENCES `db_proyectointegradorgroup5`.`residente` (`idresidente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk4`
    FOREIGN KEY (`idboleta`)
    REFERENCES `db_proyectointegradorgroup5`.`boleta` (`idboleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_proyectointegradorgroup5`.`historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyectointegradorgroup5`.`incidencia` (
  `idincidencia` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NULL DEFAULT NULL,
  `idresidente` INT NULL DEFAULT NULL,
  `iddepartamento` INT NULL DEFAULT NULL,
   `tipo` VARCHAR(80) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` INT NOT NULL,
  `observacion` varchar(50)  NULL,
  `fechareg` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`idincidencia`),
    CONSTRAINT `insidencia_ibfk_3`
    FOREIGN KEY (`iddepartamento`)
    REFERENCES `db_proyectointegradorgroup5`.`departamento` (`iddepartamento`),
     CONSTRAINT `insidencia_ibfk_4`
    FOREIGN KEY (`iduser`)
    REFERENCES `db_proyectointegradorgroup5`.`users` (`id`),
     CONSTRAINT `insidencia_ibfk_5`
    FOREIGN KEY (`idresidente`)
    REFERENCES `db_proyectointegradorgroup5`.`residente` (`idresidente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

ALTER TABLE propietario
ADD UNIQUE (dni);

ALTER TABLE residente
ADD UNIQUE (dni);
