CREATE DATABASE IF NOT EXISTS `sports_facility`;

USE `sports_facility`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `pesel_number` varchar(11) NOT NULL,
  `phone_number` int(11) DEFAULT 0,
  `address` varchar(255) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  CONSTRAINT `employees_ibfk_1`
  FOREIGN KEY (`username`) 
  REFERENCES `users` (`username`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  
  PRIMARY KEY (`username`)
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


DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone_number` int(11) DEFAULT 0,
  `address` varchar(255) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `services`;

CREATE TABLE `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` int(11) DEFAULT 0,
  
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `purchases`;

CREATE TABLE `purchases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `purchase_date` date NOT NULL,
  
  PRIMARY KEY (`id`),
  
  CONSTRAINT `purchases_ibfk_1`
  FOREIGN KEY (`customer_id`) 
  REFERENCES `customers` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `purchases_ibfk_2`
  FOREIGN KEY (`employee_id`) 
  REFERENCES `employees` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `purchases_services`;

CREATE TABLE `purchases_services` (
  `purchase_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  
  PRIMARY KEY (`purchase_id`, `service_id`),
  
  CONSTRAINT `purchases_services_ibfk_1`
  FOREIGN KEY (`purchase_id`) 
  REFERENCES `purchases` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `purchases_services_ibfk_2`
  FOREIGN KEY (`service_id`) 
  REFERENCES `services` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `enter_logs`;

CREATE TABLE `enter_logs` (
  `customer_id` int(11) NOT NULL,
  `enter_time` datetime NOT NULL,
  
  PRIMARY KEY (`customer_id`, `enter_time`),
  
  CONSTRAINT `enter_logs_ibfk_1`
  FOREIGN KEY (`customer_id`) 
  REFERENCES `customers` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `exit_logs`;

CREATE TABLE `exit_logs` (
  `customer_id` int(11) NOT NULL,
  `exit_time` datetime NOT NULL,
  
  PRIMARY KEY (`customer_id`, `exit_time`),
  
  CONSTRAINT `exit_logs_ibfk_1`
  FOREIGN KEY (`customer_id`) 
  REFERENCES `customers` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) NOT NULL,
  `original_name` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT 0,
  `path` varchar(245) NOT NULL,
  `content_type` varchar(150) NOT NULL,
  
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `static_texts`;

CREATE TABLE `static_texts` (
  `name` varchar(45) NOT NULL,
  `lang_code` varchar(3) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  
  PRIMARY KEY (`name`, `lang_code`),
  
  CONSTRAINT `static_texts_ibfk_1`
  FOREIGN KEY (`lang_code`) 
  REFERENCES `languages` (`code`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `languages`;

CREATE TABLE `languages` (
  `code` varchar(3) NOT NULL UNIQUE,
  `lang` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`code`)
);


DROP TABLE IF EXISTS `settings`;

CREATE TABLE `settings` (
  `username` varchar(50) NOT NULL,
  `setting` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  
  PRIMARY KEY (`username`, `setting`),
  
  CONSTRAINT `settings_ibfk_1`
  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `change_logs`;

CREATE TABLE `change_logs` (
  `date` date NOT NULL UNIQUE,
  `changes` varchar(255) NOT NULL,
  
  PRIMARY KEY (`date`)
);


SET FOREIGN_KEY_CHECKS = 1;