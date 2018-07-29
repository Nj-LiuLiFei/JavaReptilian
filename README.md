JavaReptilian
====
Java爬虫（对京东图书分类、分类明细、商品列表），
---   
    CREATE DATABASE `java_reptilian`

    CREATE TABLE `booksort` ( 
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `sort_name` varchar(50) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=925 DEFAULT CHARSET=utf8

    CREATE TABLE `booksortdetails` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `book_sort_id` int(11) DEFAULT NULL,
      `booksortdetailname` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `book_sort_id` (`book_sort_id`),
      CONSTRAINT `booksortdetails_ibfk_1` FOREIGN KEY (`book_sort_id`) REFERENCES `booksort` (`id`) ON DELETE NO ACTION
    ) ENGINE=InnoDB AUTO_INCREMENT=8845 DEFAULT CHARSET=utf8


    CREATE TABLE `book` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `jd_id` varchar(100) DEFAULT NULL,
      `ad_id` varchar(100) DEFAULT NULL,
      `book_name` varchar(300) DEFAULT NULL,
      `book_promo_words` varchar(300) DEFAULT NULL,
      `book_price` varchar(10) DEFAULT NULL,
      `book_press` varchar(300) DEFAULT NULL,
      `book_p_date` varchar(50) DEFAULT NULL,
      `book_author` varchar(300) DEFAULT NULL,
      `book_cover` varchar(300) DEFAULT NULL,
      `cr_time` datetime NOT NULL,
      `up_time` datetime NOT NULL,
      `book_sort_id` int(11) DEFAULT NULL,
      `booksortdetails_id` int(11) DEFAULT NULL,
      `jd_href` varchar(300) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `book_sort_id` (`book_sort_id`),
      KEY `booksortdetails_id` (`booksortdetails_id`),
      CONSTRAINT `book_ibfk_1` FOREIGN KEY (`book_sort_id`) REFERENCES `booksort` (`id`) ON DELETE NO ACTION,
      CONSTRAINT `book_ibfk_2` FOREIGN KEY (`booksortdetails_id`) REFERENCES `booksortdetails` (`id`) ON DELETE NO ACTION
    ) ENGINE=InnoDB AUTO_INCREMENT=17586 DEFAULT CHARSET=utf8
