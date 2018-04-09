-- MySQL Script generated by MySQL Workbench
-- Sun Apr  8 21:10:26 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema data_base
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema data_base
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `data_base` DEFAULT CHARACTER SET utf8 COLLATE utf8_icelandic_ci ;
USE `data_base` ;

-- -----------------------------------------------------
-- Table `data_base`.`faculties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `data_base`.`faculties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `data_base`.`specialties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `data_base`.`specialties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_faculty_idx` (`faculty_id` ASC),
  CONSTRAINT `faculty_id`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `data_base`.`faculties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `data_base`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `data_base`.`students` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `specialty_id` INT NOT NULL,
  `group` INT NOT NULL,
  `is_budget` ENUM('true', 'false') NULL DEFAULT 'false',
  `average_score` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_specialty_idx` (`specialty_id` ASC),
  CONSTRAINT `student_specialty_id`
    FOREIGN KEY (`specialty_id`)
    REFERENCES `data_base`.`specialties` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `data_base`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `data_base`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `data_base`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `data_base`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_role_id` INT NOT NULL,
  `student_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_student_idx` (`student_id` ASC),
  INDEX `user_role_idx` (`user_role_id` ASC),
  CONSTRAINT `student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `data_base`.`students` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_role_id`
    FOREIGN KEY (`user_role_id`)
    REFERENCES `data_base`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `data_base`.`practices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `data_base`.`practices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(45) NOT NULL,
  `start_date_practice` DATE NOT NULL,
  `finish_date_practice` DATE NOT NULL,
  `specialty_id` INT NULL,
  `min_average_score` DOUBLE NULL,
  `total_quantity` INT NOT NULL,
  `user_head_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_head_idx` (`user_head_id` ASC),
  INDEX `specialty_id_idx` (`specialty_id` ASC),
  CONSTRAINT `practice_specialty_id`
    FOREIGN KEY (`specialty_id`)
    REFERENCES `data_base`.`specialties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_head_id`
    FOREIGN KEY (`user_head_id`)
    REFERENCES `data_base`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `data_base`.`practice_has_students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `data_base`.`practice_has_students` (
  `id` INT NOT NULL,
  `practice_idpractice` INT NOT NULL,
  `students_idstudent` INT NOT NULL,
  INDEX `fk_practice_has_students_students1_idx` (`students_idstudent` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_practice_has_students_practice1_idx` (`practice_idpractice` ASC),
  CONSTRAINT `fk_practice_has_students_practice1`
    FOREIGN KEY (`practice_idpractice`)
    REFERENCES `data_base`.`practices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_practice_has_students_students1`
    FOREIGN KEY (`students_idstudent`)
    REFERENCES `data_base`.`students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `data_base`.`faculties`
-- -----------------------------------------------------
START TRANSACTION;
USE `data_base`;
INSERT INTO `data_base`.`faculties` (`id`, `name`) VALUES (1, 'KSIS');
INSERT INTO `data_base`.`faculties` (`id`, `name`) VALUES (2, 'FITU');
INSERT INTO `data_base`.`faculties` (`id`, `name`) VALUES (3, 'FRE');

COMMIT;


-- -----------------------------------------------------
-- Data for table `data_base`.`specialties`
-- -----------------------------------------------------
START TRANSACTION;
USE `data_base`;
INSERT INTO `data_base`.`specialties` (`id`, `name`, `faculty_id`) VALUES (1, 'ESB', 1);
INSERT INTO `data_base`.`specialties` (`id`, `name`, `faculty_id`) VALUES (2, 'ECM', 1);
INSERT INTO `data_base`.`specialties` (`id`, `name`, `faculty_id`) VALUES (3, 'IPT', 1);
INSERT INTO `data_base`.`specialties` (`id`, `name`, `faculty_id`) VALUES (4, 'QIS', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `data_base`.`students`
-- -----------------------------------------------------
START TRANSACTION;
USE `data_base`;
INSERT INTO `data_base`.`students` (`id`, `surname`, `name`, `specialty_id`, `group`, `is_budget`, `average_score`) VALUES (1, 'Zhuk', 'Ivan', 1, 12345, 'true', 8.5);
INSERT INTO `data_base`.`students` (`id`, `surname`, `name`, `specialty_id`, `group`, `is_budget`, `average_score`) VALUES (2, 'Gaiduk', 'Ilya', 1, 12346, 'false', 7.6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `data_base`.`user_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `data_base`;
INSERT INTO `data_base`.`user_role` (`id`, `name`) VALUES (1, 'admin');
INSERT INTO `data_base`.`user_role` (`id`, `name`) VALUES (2, 'head_of_pricticc');
INSERT INTO `data_base`.`user_role` (`id`, `name`) VALUES (3, 'student');

COMMIT;


-- -----------------------------------------------------
-- Data for table `data_base`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `data_base`;
INSERT INTO `data_base`.`users` (`id`, `login`, `password`, `user_role_id`, `student_id`) VALUES (1, 'admin', 'admin', 1, NULL);
INSERT INTO `data_base`.`users` (`id`, `login`, `password`, `user_role_id`, `student_id`) VALUES (6, 'ivan123', '123456', 3, 1);

COMMIT;

