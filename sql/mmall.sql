-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mmall
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `mmall`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mmall` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mmall`;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `productId` (`product_id`),
  KEY `userId` (`user_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=326 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int NOT NULL COMMENT '订单主键',
  `product_id` int NOT NULL COMMENT '商品主键',
  `quantity` int NOT NULL COMMENT '数量',
  `cost` float NOT NULL COMMENT '消费',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___66E1BD8E2F10007B` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '用户主键',
  `login_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_address` varchar(255) DEFAULT NULL COMMENT '用户地址',
  `cost` float DEFAULT NULL COMMENT '总金额',
  `serialnumber` varchar(255) DEFAULT NULL COMMENT '订单号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `price` float NOT NULL COMMENT '价格',
  `stock` int NOT NULL COMMENT '库存',
  `categorylevelone_id` int DEFAULT NULL COMMENT '分类1',
  `categoryleveltwo_id` int DEFAULT NULL COMMENT '分类2',
  `categorylevelthree_id` int DEFAULT NULL COMMENT '分类3',
  `file_name` varchar(200) DEFAULT NULL COMMENT '文件名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___94F6E55132E0915F` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=777 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (733,'香奈儿','好闻的香水！！！',152,1,548,654,655,'baby_1.jpg'),(734,'洗面奶','',153,75,548,654,655,'baby_2.jpg'),(735,'啫喱水','',152,948,548,654,655,'baby_3.jpg'),(736,'香水','',152,984,548,654,655,'baby_4.jpg'),(737,'香水','',152,111,548,654,655,'baby_5.jpg'),(738,'润肤露','',45,99,548,654,655,'baby_6.jpg'),(739,'洁面装','',156,33,548,654,655,'bk_2.jpg'),(740,'电饭锅','',158,87,628,656,659,'bk_1.jpg'),(741,'婴儿喂奶装','',569,100,632,637,653,'bk_3.jpg'),(742,'坚果套餐','',158,1000,660,661,662,'bk_4.jpg'),(743,'超甜蜜崭','',589,995,660,661,663,'bk_5.jpg'),(744,'华为2566','',589,1000,670,671,672,'de1.jpg'),(745,'荣耀3C','',589,92,670,671,672,'de2.jpg'),(746,'小米手环','',963,98,670,674,675,'de3.jpg'),(747,'华为2265','',896,1000,670,671,673,'de4.jpg'),(748,'越南坚果','',520,1,660,661,662,'de5.jpg'),(749,'进口马桶','',5866,93,628,657,NULL,'food_1.jpg'),(750,'联想Y系列','',569,894,670,690,691,'food_2.jpg'),(751,'脑白金1号','',589,998,676,677,680,'food_3.jpg'),(752,'莫里斯按','',589,998,660,661,662,'food_4.jpg'),(753,'三鹿好奶粉','',859,100,660,661,662,'food_5.jpg'),(754,'儿童牛奶','',5896,100,676,679,NULL,'food_6.jpg'),(755,'软沙发','',8596,7,628,696,NULL,'food_b1.jpg'),(756,'收纳盒','',5966,103,628,696,NULL,'food_b2.jpg'),(757,'洗衣液','',58,1000,628,696,NULL,'food_r.jpg'),(758,'红短沙发','',596,113,628,696,NULL,'fre_1.jpg'),(759,'新西兰奶粉','',5896,100,676,679,NULL,'fre_2.jpg'),(760,'婴儿车','',11000,100,681,682,687,'fre_3.jpg'),(761,'夏款婴儿车','',963,99,681,682,688,'fre_4.jpg'),(762,'抗压旅行箱','',569,998,681,683,685,'fre_5.jpg'),(763,'透明手提箱','',8596,1000,681,683,684,'fre_6.jpg'),(764,'婴儿果粉','',5896,999,660,661,662,'milk_1.jpg'),(765,'椰子粉','',5963,1000,660,661,662,'milk_2.jpg'),(766,'坚果蛋糕','',200,94,660,661,663,'milk_3.jpg'),(767,'编制手提箱','',5896,1000,681,682,688,'milk_4.jpg'),(768,'纸箱','',5896,3,681,682,687,'milk_5.jpg'),(769,'健胃液','',152,1000,676,679,NULL,'milk_6.jpg'),(770,'联想NTC','',8596,100,670,671,673,'milk_7.jpg'),(771,'香水1',NULL,100,100,548,654,655,'milk_8.jpg'),(772,'香水2',NULL,100,100,548,654,655,'pro1.jpg'),(773,'香水3',NULL,100,95,548,654,655,'pro2.jpg'),(774,'香水4',NULL,100,100,548,654,655,'pro3.jpg'),(775,'香水5',NULL,100,100,548,654,655,'pro4.jpg'),(776,'香水6',NULL,1,1,548,654,655,'pro5.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `parent_id` int NOT NULL COMMENT '父级目录id',
  `type` int DEFAULT NULL COMMENT '级别(1:一级 2：二级 3：三级)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___9EC2A4E236B12243` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (548,'化妆品',0,1),(628,'家用商品',0,1),(654,'面部护理',548,2),(655,'少女派',654,3),(656,'餐具',628,2),(657,'卫具',628,2),(658,'叉子',656,3),(659,'锅',656,3),(660,'进口食品',0,1),(661,'零食/糖果/巧克力',660,2),(662,'坚果',661,3),(663,'蜜饯',661,3),(669,'孕期教育',546,3),(670,'电子商品',0,1),(671,'手机',670,2),(672,'华为手机',671,3),(673,'联想手机',671,3),(674,'手环',670,2),(675,'小米手环',674,3),(676,'保健食品',0,1),(677,'老年保健品',676,2),(678,'中年营养品',676,2),(679,'儿童保健品',676,2),(680,'脑白金',677,3),(681,'箱包',0,1),(682,'旅行箱',681,2),(683,'手提箱',681,2),(684,'大型',683,3),(685,'小型',683,3),(686,'中型',683,3),(687,'大型',682,3),(688,'中型',682,3),(689,'小型',682,3),(690,'电脑',670,2),(691,'联想电脑',690,3),(692,'刀叉',656,3),(693,'碗筷',656,3),(696,'客厅专用',628,2);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(255) NOT NULL COMMENT '登录名',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `gender` int NOT NULL DEFAULT '1' COMMENT '性别(1:男 0：女)',
  `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `file_name` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C96109CC3A81B327` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (58,'test','张三','b3472e734711122a5c892c3a93705ed11d1513d59b107d57',1,'123@test.com','13312345678',NULL,'2021-11-18 12:55:37','2021-11-18 12:55:37'),(59,'test2','张三','f1bc53d58d67b98a3d41a247a94f5b11de5aa2bc61596723',1,'123@test.com','13312345678',NULL,'2021-11-18 13:00:07','2021-11-18 13:00:07');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int DEFAULT NULL COMMENT '用户主键',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `isdefault` int DEFAULT '0' COMMENT '是否是默认地址（1:是 0否）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
INSERT INTO `user_address` VALUES (49,56,'IT园','公司',0,'2020-05-21 15:55:24','2020-07-29 11:22:13'),(50,56,'软件园','公司',0,'2020-05-22 15:11:07','2020-07-25 09:14:19'),(57,56,'测试','测试',0,'2021-11-17 18:04:49','2021-11-17 18:04:49'),(59,59,'软件园','公司',1,'2021-11-18 13:01:19','2021-11-18 13:01:19');
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-22 17:43:09
