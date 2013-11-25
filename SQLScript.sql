/*
SQLyog Community v11.21 (64 bit)
MySQL - 5.6.12-log : Database - todolist
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`todolist` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `todolist`;

/*Table structure for table `tasks` */

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(140) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `priority` char(1) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `created` date DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `tasks` */

insert  into `tasks`(`id`,`user_id`,`name`,`description`,`priority`,`due_date`,`created`,`status`) values (12,1,'Jee Project','Presentation','m','2013-11-25 00:00:00','2013-11-24','f'),(13,1,'Android Assignment','Lab 6','h','2013-11-26 00:00:00','2013-11-24','s'),(14,1,'COMP231 Project','Story','l','2013-11-14 00:00:00','2013-11-24','p'),(15,3,'Software Security Assignment','Assignment','m','2013-11-28 00:00:00','2013-11-24','f'),(16,3,'Web Services','Finish Week 13 Lab','h','2013-11-28 00:00:00','2013-11-24','p'),(17,3,'English','Report','l','2013-11-27 00:00:00','2013-11-24','s'),(18,2,'Java Final','Prepare JPA','h','2013-12-03 00:00:00','2013-11-24','s'),(19,2,'Android Assignment','Lab 6 due','m','2013-11-28 00:00:00','2013-11-24','p'),(20,2,'Web Services','Assignment 3 due','l','2013-12-11 00:00:00','2013-11-24','f'),(21,4,'Task 1','Task Description 1','h','2013-11-26 00:00:00','2013-11-24','s'),(22,4,'Task 2','Task Description 2','m','2013-11-29 00:00:00','2013-11-24','p'),(23,4,'Task 3','Task description 3','l','2013-11-24 00:00:00','2013-11-24','f'),(24,4,'Task 4','Task description 4','m','2013-12-02 00:00:00','2013-11-24','p');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`email`,`password`) values (1,'gmansilla','mansillag@gmail.com','password'),(2,'rverma','rubyverma2080@gmail.com','password'),(3,'sraju','sonnykr@gmail.com','password'),(4,'user','user@gmail.com','password');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
