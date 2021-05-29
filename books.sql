/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
DROP TABLE IF EXISTS books;
CREATE TABLE `books` (
  `book_id` varchar(100) NOT NULL COMMENT 'primary key',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  `book_title` varchar(255) NOT NULL COMMENT 'book title',
  `book_price` varchar(255) NOT NULL COMMENT 'book price',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;