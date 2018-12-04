CREATE DATABASE IF NOT EXISTS `sports_facility`;

USE `sports_facility`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `pesel_number` varchar(11) NOT NULL,
  `phone_number` int(11) DEFAULT 0,
  `address` varchar(255) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `employee_id` int(11) NOT NULL,
  
  PRIMARY KEY (`username`),
  
  CONSTRAINT `users_ibfk_1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `employee` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  
  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
  
  CONSTRAINT `authorities_ibfk_1`
  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
);


DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone_number` int(11) DEFAULT 0,
  `address` varchar(255) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `purchase_date` date NOT NULL,
  
  PRIMARY KEY (`id`),
  
  CONSTRAINT `purchase_ibfk_1`
  FOREIGN KEY (`client_id`) 
  REFERENCES `client` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `purchase_ibfk_2`
  FOREIGN KEY (`service_id`) 
  REFERENCES `service` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `purchase_ibfk_3`
  FOREIGN KEY (`employee_id`) 
  REFERENCES `employee` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `enter_log`;

CREATE TABLE `enter_log` (
  `client_id` int(11) NOT NULL,
  `enter_time` datetime NOT NULL,
  
  PRIMARY KEY (`client_id`, `enter_time`),
  
  CONSTRAINT `enter_log_ibfk_1`
  FOREIGN KEY (`client_id`) 
  REFERENCES `client` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `exit_log`;

CREATE TABLE `exit_log` (
  `client_id` int(11) NOT NULL,
  `exit_time` datetime NOT NULL,
  
  PRIMARY KEY (`client_id`, `exit_time`),
  
  CONSTRAINT `exit_log_ibfk_1`
  FOREIGN KEY (`client_id`) 
  REFERENCES `client` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) NOT NULL,
  `original_name` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `path` varchar(45) NOT NULL,
  
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `static_text`;

CREATE TABLE `static_text` (
  `name` varchar(45) NOT NULL,
  `lang_code` varchar(3) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  
  PRIMARY KEY (`name`, `lang_code`),
  
  CONSTRAINT `static_text_ibfk_1`
  FOREIGN KEY (`lang_code`) 
  REFERENCES `lang` (`code`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `lang`;

CREATE TABLE `lang` (
  `code` varchar(3) NOT NULL UNIQUE,
  `lang` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`code`)
);


DROP TABLE IF EXISTS `setting`;

CREATE TABLE `setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `lang_code` varchar(3) NOT NULL,
  
  PRIMARY KEY (`id`),
  
  CONSTRAINT `setting_ibfk_1`
  FOREIGN KEY (`lang_code`) 
  REFERENCES `lang` (`code`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `setting_ibfk_2`
  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `change_log`;

CREATE TABLE `change_log` (
  `date` date NOT NULL UNIQUE,
  `changes` varchar(255) NOT NULL,
  
  PRIMARY KEY (`date`)
);


SET FOREIGN_KEY_CHECKS = 1;