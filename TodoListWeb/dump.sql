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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

/*Data for the table `tasks` */

insert  into `tasks`(`id`,`user_id`,`name`,`description`,`priority`,`due_date`,`created`,`status`) values (25,4,'Task 1','Task Description 1','h','2013-11-27 00:00:00','2013-11-24','s'),(27,4,'Task 3','Task Description 3','l','2013-11-24 00:00:00','2013-11-24','f'),(28,4,'Task 2','Task 2 Description','m','2013-11-28 00:00:00','2013-11-24','p'),(29,2,'Java Final','Prepare exam','h','2013-12-04 00:00:00','2013-11-24','s'),(30,2,'Web Services','Assignment 6 due','m','2013-11-27 00:00:00','2013-11-24','p'),(31,2,'Software Security Assignment','Lab 6','l','2013-11-22 00:00:00','2013-11-24','f'),(32,1,'Jee Project','Presentation','h','2013-11-24 00:00:00','2013-11-24','s'),(33,1,'COMP231 Project','Story','m','2013-11-26 00:00:00','2013-11-24','p'),(34,1,'Android Assignment','Assignment 6','l','2013-11-24 00:00:00','2013-11-24','f'),(35,3,'Android Assignment','Assignment 6','h','2013-11-30 00:00:00','2013-11-24','s'),(36,3,'English','Report','m','2013-11-28 00:00:00','2013-11-24','p'),(37,3,'Web Services','Assignment','l','2013-11-24 00:00:00','2013-11-24','f');

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

insert  into `users`(`id`,`username`,`email`,`password`) values (1,'gmansilla','mansillag@gmail.com','476e251cc54b60534f68d0f614fcc67950151353'),(2,'rverma','rubyverma2080@gmail.com','476e251cc54b60534f68d0f614fcc67950151353'),(3,'sraju','sonnykr@gmail.com','476e251cc54b60534f68d0f614fcc67950151353'),(4,'user','user@gmail.com','476e251cc54b60534f68d0f614fcc67950151353');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
