-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: medicals
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `medicals`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `medicals` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `medicals`;

--
-- Table structure for table `reimburse`
--

DROP TABLE IF EXISTS `reimburse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reimburse` (
  `rei_no` varchar(100) DEFAULT NULL COMMENT '报销单号',
  `id_card` varchar(30) DEFAULT NULL COMMENT '身份证',
  `chro_no` varchar(100) DEFAULT NULL COMMENT '农合编号',
  `rei_alre` decimal(10,0) DEFAULT NULL COMMENT '已报销金额',
  `rei_now` decimal(10,0) DEFAULT NULL COMMENT '本次报销金额',
  `rei_rema` varchar(100) DEFAULT NULL COMMENT '可报销金额',
  `crea_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `disease_name` varchar(30) DEFAULT NULL COMMENT '疾病名称',
  `cost` decimal(10,0) DEFAULT NULL COMMENT '医疗总费',
  `invoice` varchar(36) DEFAULT NULL COMMENT '发票号',
  `trea_time` datetime DEFAULT NULL COMMENT '就诊时间',
  `creator` varchar(30) DEFAULT NULL COMMENT '创建者',
  `status` varchar(2) DEFAULT NULL COMMENT '报销状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报销';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reimburse`
--

LOCK TABLES `reimburse` WRITE;
/*!40000 ALTER TABLE `reimburse` DISABLE KEYS */;
INSERT INTO `reimburse` VALUES ('1591494303516','4505241845210248','312',69,0,'1231','2020-06-07 09:45:05','2020-06-07 10:56:23','01',302,'15215','2020-06-07 00:00:00','超级管理员','1');
/*!40000 ALTER TABLE `reimburse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s201`
--

DROP TABLE IF EXISTS `s201`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s201` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(10) DEFAULT NULL COMMENT '编码',
  `itemname` varchar(50) DEFAULT NULL COMMENT '名称',
  `pitemcode` varchar(10) DEFAULT NULL COMMENT '皮特码',
  `type` varchar(6) DEFAULT NULL COMMENT '类型：02：隶属关系；06：机构级别；04：机构级别；01：机构所属经济类型；03卫生机构；',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s201`
--

LOCK TABLES `s201` WRITE;
/*!40000 ALTER TABLE `s201` DISABLE KEYS */;
INSERT INTO `s201` VALUES (1,'50','县',NULL,'02'),(2,'62','镇',NULL,'02'),(3,'63','乡',NULL,'02'),(4,'1','村卫生室',NULL,'06'),(5,'2','乡镇卫生院',NULL,'06'),(6,'3','县级医疗机构',NULL,'06'),(7,'1','综合定点',NULL,'04'),(8,'2','门诊定点',NULL,'04'),(9,'3','住院定点',NULL,'04'),(10,'10','内资',NULL,'01'),(11,'11','国有全资',NULL,'01'),(12,'12','集体全资',NULL,'01'),(13,'A','医院',NULL,'03'),(14,'C','卫生院',NULL,'03'),(15,'A100','综合医院','A','0301'),(16,'C220','乡镇卫生院','C','0301'),(17,'C210','乡镇中心卫生院','C','0301');
/*!40000 ALTER TABLE `s201` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2003 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',0,1,'#','','M','0','','fa fa-gear','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统管理目录'),(2,'业务功能',0,2,'#','menuItem','M','0','','fa fa-book','admin','2018-03-16 11:33:00','超级管理员','2020-06-13 16:58:58','系统监控目录'),(3,'统计报表',0,3,'#','menuItem','M','0','','fa fa-bars','admin','2018-03-16 11:33:00','慢性病','2020-06-04 15:51:04','系统工具目录'),(100,'用户管理',1,1,'/system/user','','C','0','system:user:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','用户管理菜单'),(101,'角色管理',1,2,'/system/role','','C','0','system:role:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','角色管理菜单'),(102,'菜单管理',1,3,'/system/menu','','C','0','system:menu:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','菜单管理菜单'),(103,'行政区域管理',1,4,'/medical/area','menuItem','C','0','/medical/area','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 10:03:45','部门管理菜单'),(104,'农合机构管理',1,5,'/medical/institution','menuItem','C','0','medical:institution:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 10:07:25','岗位管理菜单'),(105,'慢性病分类管理',1,6,'/medical/chronicdis','menuItem','C','0','medical:chronicdis:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 10:22:37','字典管理菜单'),(106,'医疗机构管理',1,7,'/medical/medical','menuItem','C','0','medical:medical:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 10:23:21','参数设置菜单'),(107,'慢性政策设置',1,8,'/medical/policy','menuItem','C','0','medical:policy:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 10:25:16','通知公告菜单'),(109,'参合家庭档案管理',2,1,'/medical/family','menuItem','C','0','medical:family:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 10:50:04','在线用户菜单'),(110,'参合农民档案管理',2,2,'/medical/person','menuItem','C','0','medical:person:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 11:40:57','定时任务菜单'),(111,'参合缴费登记记录',2,4,'/medical/payment','menuItem','C','0','medical:payment:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-05 21:25:45','数据监控菜单'),(112,'慢性病证管理',2,5,'/medical/chronicinfo','menuItem','C','0','medical:chronicinfo:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-06 21:26:08','服务监控菜单'),(113,'按病种统计慢性病报销情况',3,1,'/medical/reimburse/reimburseDisease','menuItem','C','0','remiburse:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-07 11:15:15','表单构建菜单'),(114,'按行政区域统计慢性病报销情况',3,2,'/medical/reimburse/reimburseArea','menuItem','C','0','reimburseArea:view','#','admin','2018-03-16 11:33:00','超级管理员','2020-06-07 11:16:54','代码生成菜单'),(1000,'用户查询',100,1,'#','','F','0','system:user:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1001,'用户新增',100,2,'#','','F','0','system:user:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1002,'用户修改',100,3,'#','','F','0','system:user:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1003,'用户删除',100,4,'#','','F','0','system:user:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1004,'用户导出',100,5,'#','','F','0','system:user:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1005,'用户导入',100,6,'#','','F','0','system:user:import','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1006,'重置密码',100,7,'#','','F','0','system:user:resetPwd','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1007,'角色查询',101,1,'#','','F','0','system:role:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1008,'角色新增',101,2,'#','','F','0','system:role:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1009,'角色修改',101,3,'#','','F','0','system:role:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1010,'角色删除',101,4,'#','','F','0','system:role:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1011,'角色导出',101,5,'#','','F','0','system:role:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1012,'菜单查询',102,1,'#','','F','0','system:menu:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1013,'菜单新增',102,2,'#','','F','0','system:menu:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1014,'菜单修改',102,3,'#','','F','0','system:menu:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1015,'菜单删除',102,4,'#','','F','0','system:menu:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1039,'操作查询',500,1,'#','','F','0','monitor:operlog:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1040,'操作删除',500,2,'#','','F','0','monitor:operlog:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1041,'详细信息',500,3,'#','','F','0','monitor:operlog:detail','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1042,'日志导出',500,4,'#','','F','0','monitor:operlog:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1043,'登录查询',501,1,'#','','F','0','monitor:logininfor:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1044,'登录删除',501,2,'#','','F','0','monitor:logininfor:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1045,'日志导出',501,3,'#','','F','0','monitor:logininfor:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(2000,'慢性病报销',2,6,'/medical/reimburse','menuItem','C','0','medical:reimburse:view','fa fa-bank','','2020-06-04 15:50:44','超级管理员','2020-06-07 09:01:40',''),(2001,'参合登记',2,3,'/medical/family/person','menuItem','C','0','/medical/family/person','fa fa-beer','','2020-06-05 21:48:49','超级管理员','2020-06-05 21:51:18',''),(2002,'参合缴费设置',1,8,'/medical/payperiod','menuItem','C','0','/medical/payperiod','fa fa-battery-2','','2020-06-06 16:46:54','',NULL,'');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='角色信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','admin',1,'1','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','管理员'),(2,'县合管办领导','common',2,'2','0','0','admin','2018-03-16 11:33:00','ry','2020-06-04 17:43:06','用户-县合管办领导'),(100,'a','ceshi',3,'1','0','2','','2020-06-03 22:34:24','',NULL,'测试'),(101,'县农合办工作人员','agriculture',3,'1','0','0','超级管理员','2020-06-04 17:44:02','',NULL,'可以审核各乡镇的慢病报销记录'),(102,'乡镇农合办人员','township',4,'1','0','0','超级管理员','2020-06-04 17:45:40','',NULL,'只能对本镇内的数据进行管理，包括家庭档案管理、参合缴费登记、慢病证管理、慢病报销、 慢病报销记录查询、统计以及导出');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (2,2),(2,109),(2,110),(2,111),(2,112),(2,1047),(2,1048),(2,1049),(2,1050),(2,1051),(2,1052),(2,1053),(2,1054),(2,1055),(2,1056),(2,2000),(100,1),(100,100),(100,101),(100,102),(100,103),(100,104),(100,105),(100,106),(100,107),(100,108),(100,500),(100,501),(100,1000),(100,1001),(100,1002),(100,1003),(100,1004),(100,1005),(100,1006),(100,1007),(100,1008),(100,1009),(100,1010),(100,1011),(100,1012),(100,1013),(100,1014),(100,1015),(100,1016),(100,1017),(100,1018),(100,1019),(100,1020),(100,1021),(100,1022),(100,1023),(100,1024),(100,1025),(100,1026),(100,1027),(100,1028),(100,1029),(100,1030),(100,1031),(100,1032),(100,1033),(100,1034),(100,1035),(100,1036),(100,1037),(100,1038),(100,1039),(100,1040),(100,1041),(100,1042),(100,1043),(100,1044),(100,1045),(100,1046),(101,2),(101,109),(101,110),(101,111),(101,112),(101,1047),(101,1048),(101,1049),(101,1050),(101,1051),(101,1052),(101,1053),(101,1054),(101,1055),(101,1056),(101,2000),(102,2),(102,3),(102,109),(102,110),(102,111),(102,112),(102,113),(102,114),(102,115),(102,1047),(102,1048),(102,1049),(102,1050),(102,1051),(102,1052),(102,1053),(102,1054),(102,1055),(102,1056),(102,1057),(102,1058),(102,1059),(102,1060),(102,1061),(102,2000);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) DEFAULT '' COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户 01注册用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,103,'admin','超级管理员','00','123@163.com','15888888888','1','','123456','111111','0','0','127.0.0.1','2020-06-04 16:00:55','admin','2020-06-04 16:00:55','超级管理员','2020-06-04 17:45:59','管理员'),(2,105,'county','县合官办领导','00','ry@qq.com','15666666666','1','','123456','222222','0','0','127.0.0.1','2020-06-04 16:00:55','admin','2020-06-04 16:00:55','超级管理员','2020-06-04 17:46:06','县合管办领导可以查\r\n看全县所有业务数据'),(102,NULL,'agriculture','县农合办工作人员','00','1234567890@qq.com','15977985557','1','','123456','','0','0','',NULL,'','2020-06-04 16:00:55','超级管理员','2020-06-04 17:46:09','县农合办工作人员可以审核各乡镇的慢病报销记录'),(103,NULL,'township','乡镇农合办人员','00','1223@163.com','15977985566','1','','123456','','0','0','',NULL,'','2020-06-04 16:01:46','超级管理员','2020-06-04 17:45:53','乡镇农合办人员\r\n只能对本镇内的数据进行管理，包括家庭档案管理、参合缴费登记、慢病证管理、慢病报销、\r\n慢病报销记录查询、统计以及导出');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(2,2),(101,2),(102,101),(103,102);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_area`
--

DROP TABLE IF EXISTS `t_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_area` (
  `areacode` varchar(30) NOT NULL DEFAULT '' COMMENT '区域编码',
  `areaname` varchar(50) DEFAULT NULL COMMENT '区域名称',
  `grade` char(3) DEFAULT NULL COMMENT '级别',
  PRIMARY KEY (`areacode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行政区域信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_area`
--

LOCK TABLES `t_area` WRITE;
/*!40000 ALTER TABLE `t_area` DISABLE KEYS */;
INSERT INTO `t_area` VALUES ('450421','苍梧县','1'),('45042101','龙圩镇','2'),('4504210101','恩义村','3'),('450421010101','多一组','4'),('450421010102','多二组','4'),('450421010103','瓦窑组','4'),('450421010104','猪腰组','4'),('450421010105','头塘组','4'),('4504210102','林水村','3'),('450421010201','林一组','4'),('450421010202','林二组','4'),('450421010203','林三组','4');
/*!40000 ALTER TABLE `t_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_chronicdis`
--

DROP TABLE IF EXISTS `t_chronicdis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_chronicdis` (
  `illcode` varchar(30) NOT NULL COMMENT '疾病编码',
  `pycode` varchar(15) DEFAULT NULL COMMENT '拼音码',
  `illname` varchar(100) DEFAULT NULL COMMENT '疾病名称',
  `wbcode` varchar(15) DEFAULT NULL COMMENT 'wb码',
  `rate` double(10,2) DEFAULT NULL COMMENT '得病率',
  PRIMARY KEY (`illcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='慢性病';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chronicdis`
--

LOCK TABLES `t_chronicdis` WRITE;
/*!40000 ALTER TABLE `t_chronicdis` DISABLE KEYS */;
INSERT INTO `t_chronicdis` VALUES ('A09  F5','jsbz',' 精神病症','dsaf',0.30),('F29 01',' jsb',' 精神病',' jsb',0.50),('G20 02','pjssb','帕金森氏病','pjssb',0.70),('I10 05',' gxys',' 高血压Ⅲ',' gxysdas',0.60),('K74.151','gyh','肝硬化','gyh',0.80);
/*!40000 ALTER TABLE `t_chronicdis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_chronicinfo`
--

DROP TABLE IF EXISTS `t_chronicinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_chronicinfo` (
  `id` varchar(50) NOT NULL COMMENT '农合编号',
  `starttime` varchar(50) DEFAULT NULL COMMENT '开始时间',
  `endtime` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `status` varchar(50) DEFAULT NULL COMMENT '状态',
  `creattime` date DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `perscode` varchar(50) DEFAULT NULL COMMENT '档案编号',
  `illcode` varchar(50) DEFAULT NULL COMMENT '疾病编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='慢性病证信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chronicinfo`
--

LOCK TABLES `t_chronicinfo` WRITE;
/*!40000 ALTER TABLE `t_chronicinfo` DISABLE KEYS */;
INSERT INTO `t_chronicinfo` VALUES ('1591494164483','2020-01-02','2020-08-06','0','2020-06-17','超级管理员','0451591343643639','01'),('45042101010100010120200527004532','2020-05-09','2020-06-21','0','2020-05-27','管理员','450421010101000101','F29 01'),('45042101010100010220200527004748','2020-05-03','2020-06-28','0','2020-05-27','管理员','450421010101000102','F29 01');
/*!40000 ALTER TABLE `t_chronicinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_family`
--

DROP TABLE IF EXISTS `t_family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_family` (
  `famicode` varchar(30) NOT NULL DEFAULT '' COMMENT '家庭编号',
  `county_number` varchar(30) DEFAULT NULL COMMENT '县编号',
  `township_number` varchar(30) DEFAULT NULL COMMENT '乡镇编号',
  `village_number` varchar(30) DEFAULT NULL COMMENT '村编号',
  `house_attributes` varchar(30) DEFAULT NULL COMMENT '户属性',
  `house_name` varchar(6) DEFAULT NULL COMMENT '户主名字',
  `family_popu` int(11) DEFAULT NULL COMMENT '家庭人口数',
  `agriNum` int(11) DEFAULT NULL COMMENT '农业人口数',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `creattime` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(30) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`famicode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭档案';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_family`
--

LOCK TABLES `t_family` WRITE;
/*!40000 ALTER TABLE `t_family` DISABLE KEYS */;
INSERT INTO `t_family` VALUES ('1591328020889','123','32','324','241','法赫德',4,4,'广西梧州市万秀区梧州学院','2020-06-11 00:00:00','1'),('4501591349654553','432','34','423','34','码元',8,43,'43','2020-06-17 00:00:00','1');
/*!40000 ALTER TABLE `t_family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_institution`
--

DROP TABLE IF EXISTS `t_institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_institution` (
  `areacode` varchar(30) NOT NULL COMMENT '所属行政区域',
  `agencode` varchar(30) DEFAULT '' COMMENT '经办机构编号',
  `agenname` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `grade` int(11) DEFAULT NULL COMMENT '级别',
  PRIMARY KEY (`areacode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='农合机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_institution`
--

LOCK TABLES `t_institution` WRITE;
/*!40000 ALTER TABLE `t_institution` DISABLE KEYS */;
INSERT INTO `t_institution` VALUES ('450421','667022793','苍梧县新农合管理中心',1),('45042101','667022793','龙圩镇合管办',2);
/*!40000 ALTER TABLE `t_institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_medical`
--

DROP TABLE IF EXISTS `t_medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_medical` (
  `jgbm` varchar(30) NOT NULL DEFAULT '' COMMENT '机构编码',
  `zzjgbm` varchar(30) DEFAULT NULL COMMENT '组织机构编号',
  `jgmc` varchar(100) NOT NULL COMMENT '机构名称',
  `dqbm` varchar(30) DEFAULT NULL COMMENT '地区代码',
  `areacode` varchar(30) DEFAULT NULL COMMENT '行政区编码',
  `lsgx` varchar(6) DEFAULT NULL COMMENT '隶属关系',
  `jgjb` varchar(6) DEFAULT NULL COMMENT '机构级别',
  `sbddlx` varchar(6) DEFAULT NULL COMMENT '申报定点类型',
  `pzddlx` varchar(6) DEFAULT NULL COMMENT '批准定点类型',
  `ssjjlx` varchar(6) DEFAULT NULL COMMENT '机构所属经济',
  `wsjgdl` varchar(6) DEFAULT NULL COMMENT '卫生机构大类别',
  `wsjgxl` varchar(6) DEFAULT NULL COMMENT '卫生机构小类别',
  `zgdw` varchar(100) DEFAULT NULL COMMENT '主管单位',
  `kysj` varchar(10) DEFAULT NULL COMMENT '成立时间',
  `frdb` varchar(30) DEFAULT NULL COMMENT '法人',
  `zczj` decimal(10,0) DEFAULT NULL COMMENT '注册资金',
  PRIMARY KEY (`jgbm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医疗';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_medical`
--

LOCK TABLES `t_medical` WRITE;
/*!40000 ALTER TABLE `t_medical` DISABLE KEYS */;
INSERT INTO `t_medical` VALUES ('DD450421001','DD450421001','苍梧县人民医院','450421','450421','50','3','1','1','10','A','A100','苍梧县卫生局','2000-10-01','周志刚',1000),('DD450421002','DD450421002','龙圩镇中心卫生院','450421','45042101','62','2','1','1','11','C','C220','苍梧县卫生局','2000-10-01','胡洁玉',50);
/*!40000 ALTER TABLE `t_medical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_payment`
--

DROP TABLE IF EXISTS `t_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_payment` (
  `payNo` int(11) NOT NULL AUTO_INCREMENT COMMENT '参合证号',
  `perscode` varchar(255) DEFAULT NULL COMMENT '档案编号',
  `payCost` decimal(10,0) DEFAULT NULL COMMENT '缴费金额',
  `runyear` int(11) DEFAULT NULL COMMENT '缴费年度',
  `payTime` date DEFAULT NULL COMMENT '缴费时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '操作员',
  `famicode` varchar(30) DEFAULT NULL COMMENT '家庭编号',
  PRIMARY KEY (`payNo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='付款';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_payment`
--

LOCK TABLES `t_payment` WRITE;
/*!40000 ALTER TABLE `t_payment` DISABLE KEYS */;
INSERT INTO `t_payment` VALUES (4,'450421010101000102',200,2020,'2020-05-26','管理员','4504210101010001'),(6,'450421010101000101',200,2020,'2020-05-26','管理员','4504210101010001'),(7,'0451591343643639',200,2020,'2020-06-06','超级管理员','1591328020889'),(8,'4051591347140783',200,2020,'2020-06-06','超级管理员','1591328020889'),(9,'0451591343643639',200,2020,'2020-06-14','超级管理员','1591328020889'),(10,'4051591347140783',200,2020,'2020-06-14','超级管理员','1591328020889'),(11,'0451591343643639',200,2020,'2020-06-14','超级管理员','1591328020889'),(12,'4051591347140783',200,2020,'2020-06-14','超级管理员','1591328020889');
/*!40000 ALTER TABLE `t_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_payperiod`
--

DROP TABLE IF EXISTS `t_payperiod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_payperiod` (
  `runyear` int(11) NOT NULL COMMENT '年度',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '费用',
  `startime` varchar(30) DEFAULT NULL COMMENT '开始时间',
  `endtime` varchar(30) DEFAULT NULL COMMENT '结束时间',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`runyear`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='期限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_payperiod`
--

LOCK TABLES `t_payperiod` WRITE;
/*!40000 ALTER TABLE `t_payperiod` DISABLE KEYS */;
INSERT INTO `t_payperiod` VALUES (2020,200.00,'2020-04-25','2020-08-11',0);
/*!40000 ALTER TABLE `t_payperiod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_person`
--

DROP TABLE IF EXISTS `t_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_person` (
  `perscode` varchar(30) NOT NULL DEFAULT '' COMMENT '档案编号',
  `famicode` varchar(30) DEFAULT NULL COMMENT '家庭编号',
  `rural_card` varchar(50) DEFAULT NULL COMMENT '农合证号',
  `medi_card` varchar(36) DEFAULT NULL COMMENT '医疗证号',
  `house_num` varchar(6) DEFAULT NULL COMMENT '户内编号',
  `persname` varchar(30) DEFAULT NULL COMMENT '名字',
  `relation` varchar(6) DEFAULT NULL COMMENT '与户主关系',
  `card_id` varchar(45) DEFAULT NULL COMMENT '身份证',
  `sex` varchar(3) DEFAULT NULL COMMENT '性别',
  `state_health` smallint(6) DEFAULT NULL COMMENT '健康状况',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `is_rural` bit(1) DEFAULT NULL COMMENT '是否农村户口',
  `occupation` varchar(30) DEFAULT NULL COMMENT '职业类型',
  `telephone` varchar(11) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`perscode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_person`
--

LOCK TABLES `t_person` WRITE;
/*!40000 ALTER TABLE `t_person` DISABLE KEYS */;
INSERT INTO `t_person` VALUES ('0451591343643639','1591328020889','312','421','4','法赫德','0','4505241845210248','0',0,'2020-06-03 00:00:00',_binary '\0','打工','412'),('4051591347140783','1591328020889','342','43','234','性季风','1','450414231','0',0,'2020-06-10 00:00:00',_binary '\0','打工','100863'),('4051591353257137','4501591349654553','4548412','055484215','02','码元','0','4502165923267','0',2,'2020-06-10 00:00:00',_binary '','3','1549745'),('4051591353837817','4501591349654553','432','23','24','34','3','4508031994545848','0',1,'2020-06-02 00:00:00',_binary '\0','肯佬族','432');
/*!40000 ALTER TABLE `t_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_policy`
--

DROP TABLE IF EXISTS `t_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_policy` (
  `runyear` varchar(4) NOT NULL DEFAULT '' COMMENT '年度',
  `maxline` decimal(10,2) DEFAULT NULL COMMENT '封顶线',
  `status` varchar(3) DEFAULT NULL COMMENT '状态',
  `remark` varchar(150) DEFAULT NULL COMMENT '比例',
  PRIMARY KEY (`runyear`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政策';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_policy`
--

LOCK TABLES `t_policy` WRITE;
/*!40000 ALTER TABLE `t_policy` DISABLE KEYS */;
INSERT INTO `t_policy` VALUES ('2018',1200.00,'1','0.3'),('2019',1200.00,'1','0.51'),('2020',1300.00,'0','0.23'),('2021',19000.00,'0','0.56');
/*!40000 ALTER TABLE `t_policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_recordfree`
--

DROP TABLE IF EXISTS `t_recordfree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_recordfree` (
  `perscode` varchar(255) NOT NULL COMMENT '档案编号',
  `freetotal` int(11) DEFAULT NULL COMMENT '免费',
  PRIMARY KEY (`perscode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_recordfree`
--

LOCK TABLES `t_recordfree` WRITE;
/*!40000 ALTER TABLE `t_recordfree` DISABLE KEYS */;
INSERT INTO `t_recordfree` VALUES ('450421010101000101',400),('450421010101000102',750);
/*!40000 ALTER TABLE `t_recordfree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_reducttreat`
--

DROP TABLE IF EXISTS `t_reducttreat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reducttreat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chronicInfoId` varchar(50) DEFAULT NULL COMMENT '慢性病证',
  `treattime` varchar(100) DEFAULT NULL COMMENT '治疗时间',
  `money` int(255) DEFAULT NULL COMMENT '费用',
  `hosId` varchar(50) DEFAULT NULL COMMENT '医院发票号',
  `reductstatus` int(255) DEFAULT NULL COMMENT '0为已提交申请，1为审核确定汇款，2为审核取消汇款，没有删除一项',
  `freemoney` int(255) DEFAULT NULL COMMENT '缴费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='还原处理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_reducttreat`
--

LOCK TABLES `t_reducttreat` WRITE;
/*!40000 ALTER TABLE `t_reducttreat` DISABLE KEYS */;
INSERT INTO `t_reducttreat` VALUES (1,'45042101010100010120200527004532','2020-05-17',800,'23452346',1,400),(3,'45042101010100010220200527004748','2020-05-10',800,'23452346',1,400);
/*!40000 ALTER TABLE `t_reducttreat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-14  9:39:06
