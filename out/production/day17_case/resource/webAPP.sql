CREATE TABLE `user` (
    `id`  int(11) NOT NULL AUTO_INCREMENT ,
    `name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
    `gender`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
    `age`  int(11) NULL DEFAULT NULL ,
    `address`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
    `qq`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
    `email`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
    `password`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
    PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4
ROW_FORMAT=COMPACT
;


INSERT INTO user (id, name, gender, age, address, qq, email, password) VALUES (12, '郝建', '男', 18, '陕西', '26216145', '2207392787@qq.com', null);
INSERT INTO user (id, name, gender, age, address, qq, email, password) VALUES (9, '小伟', '男', 18, '北京', '26216145', '2207392763@qq.com', null);
INSERT INTO user (id, name, gender, age, address, qq, email, password) VALUES (16, '周雨彤', '男', 18, '北京', '26216145', '2207392763@qq.com', null);
INSERT INTO user (id, name, gender, age, address, qq, email, password) VALUES (17, '郝强', '女', 18, '北京', '26216145', '2207392763@qq.com', null);
INSERT INTO user (id, name, gender, age, address, qq, email, password) VALUES (1, 'admin', '男', 18, '上海', '4613641', 'dftgyhu@qqcom', '123456');
INSERT INTO user (id, name, gender, age, address, qq, email, password) VALUES (14, '周雨彤', '女', 18, '上海', '26216145', '2207392763@qq.com', null);
INSERT INTO user (id, name, gender, age, address, qq, email, password) VALUES (15, '郝勇', '男', 18, '上海', '26216145', '2207392763@qq.com', null);