
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `dataBase_colegio_TH`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dataBase_colegio_TH`.`Profesor` (
  `idProfesor` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProfesor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dataBase_colegio_TH`.`Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dataBase_colegio_TH`.`Materia` (
  `idMateria` INT NOT NULL AUTO_INCREMENT,
  `nombreMateria` VARCHAR(45) NOT NULL,
  `intensidad_Horaria` INT NOT NULL DEFAULT 1,
  `Peso_Academico` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idMateria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dataBase_colegio_TH`.`Grado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dataBase_colegio_TH`.`Grado` (
  `idGrado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGrado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dataBase_colegio_TH`.`AÃ±o_Escolar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dataBase_colegio_TH`.`AÃ±o_Escolar` (
  `aÃ±o` INT NOT NULL,
  PRIMARY KEY (`aÃ±o`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dataBase_colegio_TH`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dataBase_colegio_TH`.`Curso` (
  `Materia_idMateria` INT NOT NULL,
  `cod_grado` INT NOT NULL,
  `AÃ±o_Escolar_aÃ±o` INT NOT NULL,
  PRIMARY KEY (`Materia_idMateria`, `cod_grado`, `AÃ±o_Escolar_aÃ±o`),
  INDEX `fk_Materia_has_Grado_Grado1_idx` (`cod_grado` ASC),
  INDEX `fk_Materia_has_Grado_Materia_idx` (`Materia_idMateria` ASC),
  INDEX `fk_Curso_AÃ±o_Escolar1_idx` (`AÃ±o_Escolar_aÃ±o` ASC),
  CONSTRAINT `fk_Materia_has_Grado_Materia`
    FOREIGN KEY (`Materia_idMateria`)
    REFERENCES `dataBase_colegio_TH`.`Materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Materia_has_Grado_Grado1`
    FOREIGN KEY (`cod_grado`)
    REFERENCES `dataBase_colegio_TH`.`Grado` (`idGrado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Curso_AÃ±o_Escolar1`
    FOREIGN KEY (`AÃ±o_Escolar_aÃ±o`)
    REFERENCES `dataBase_colegio_TH`.`AÃ±o_Escolar` (`aÃ±o`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dataBase_colegio_TH`.`Cursos_dicta_profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dataBase_colegio_TH`.`Cursos_dicta_profesor` (
  `Profesor_idProfesor` INT NOT NULL,
  `Curso_Materia_idMateria` INT NOT NULL,
  `Curso_Grado_idGrado` INT NOT NULL,
  `Curso_AÃ±o_Escolar_aÃ±o` INT NOT NULL,
  PRIMARY KEY (`Profesor_idProfesor`, `Curso_Materia_idMateria`, `Curso_Grado_idGrado`, `Curso_AÃ±o_Escolar_aÃ±o`),
  INDEX `fk_Profesor_has_Curso_Curso1_idx` (`Curso_Materia_idMateria` ASC, `Curso_Grado_idGrado` ASC, `Curso_AÃ±o_Escolar_aÃ±o` ASC),
  INDEX `fk_Profesor_has_Curso_Profesor1_idx` (`Profesor_idProfesor` ASC),
  CONSTRAINT `fk_Profesor_has_Curso_Profesor1`
    FOREIGN KEY (`Profesor_idProfesor`)
    REFERENCES `dataBase_colegio_TH`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesor_has_Curso_Curso1`
    FOREIGN KEY (`Curso_Materia_idMateria` , `Curso_Grado_idGrado` , `Curso_AÃ±o_Escolar_aÃ±o`)
    REFERENCES `dataBase_colegio_TH`.`Curso` (`Materia_idMateria` , `cod_grado` , `AÃ±o_Escolar_aÃ±o`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dataBase_colegio_TH`.`Disponibilidad_Horaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dataBase_colegio_TH`.`Disponibilidad_Horaria` (
  `Profesor_idProfesor` INT NOT NULL,
  `AÃ±o_Escolar_aÃ±o` INT NOT NULL,
  `dia` VARCHAR(10) NOT NULL,
  `hora` INT NOT NULL,
  PRIMARY KEY (`Profesor_idProfesor`, `AÃ±o_Escolar_aÃ±o`),
  INDEX `fk_Disponibilidad_Horaria_AÃ±o_Escolar1_idx` (`AÃ±o_Escolar_aÃ±o` ASC),
  CONSTRAINT `fk_Disponibilidad_Horaria_Profesor1`
    FOREIGN KEY (`Profesor_idProfesor`)
    REFERENCES `dataBase_colegio_TH`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Disponibilidad_Horaria_AÃ±o_Escolar1`
    FOREIGN KEY (`AÃ±o_Escolar_aÃ±o`)
    REFERENCES `dataBase_colegio_TH`.`AÃ±o_Escolar` (`aÃ±o`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
