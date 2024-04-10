/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.37 : Database - system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`system` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `system`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `username` char(20) NOT NULL,
  `Cno` char(10) NOT NULL,
  `Cname` char(20) NOT NULL,
  PRIMARY KEY (`username`,`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `course` */

insert  into `course`(`username`,`Cno`,`Cname`) values ('3','3','3'),('admin','1234','思政'),('admin','A01','Java程序设计'),('admin','A02','HTML'),('admin','A03','数学'),('user02','A01','C语言');

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `Cno` char(10) NOT NULL,
  `Cname` char(20) NOT NULL,
  `C_record` char(20) NOT NULL,
  `C_score` float NOT NULL,
  `C_date` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `grade` */

insert  into `grade`(`Cno`,`Cname`,`C_record`,`C_score`,`C_date`) values ('A01','C语言','月考',67,2022),('A01','Java程序设计','第一次月考',56,2021),('A01','Java程序设计','第三次月考',46,2021),('A01','C语言','二次月考',89,2021),('A02','数学','周测',89,2021),('A01','Java程序设计','考试7',23,2021),('A01','Java程序设计','月考',78,2021);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `Username` char(20) NOT NULL,
  `Password` char(20) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `users` */

insert  into `users`(`Username`,`Password`) values ('admin','12345aaa'),('admin1','123456'),('admin12','asd'),('admin5','123'),('asd','123'),('asdf','123456'),('user01','123456'),('user02','123456'),('user03','123456'),('user04','123456'),('user05','12345678'),('user06','asd');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
