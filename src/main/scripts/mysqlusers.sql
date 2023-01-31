DROP DATABASE IF EXISTS bookdb;
DROP USER IF EXISTS `bookadmin`@`%`;
DROP USER IF EXISTS `bookuser`@`%`;
CREATE DATABASE IF NOT EXISTS bookdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS `bookadmin`@`%` IDENTIFIED BY 'password';
CREATE USER IF NOT EXISTS `bookuser`@`%` IDENTIFIED BY 'password';

GRANT ALL ON `bookdb`.* TO `bookadmin`@`%`;
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `bookdb`.* TO `bookuser`@`%`;
FLUSH PRIVILEGES;