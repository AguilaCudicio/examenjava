mysql -u root -p

create database dbusers;

CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';

FLUSH PRIVILEGES;

use dbusers;
create table User(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name TEXT, surname TEXT, email TEXT, password TEXT);

#A partir de acá se cargan datos de ejemplo a la table User

INSERT INTO `User` (`id`,`name`,`surname`,`email`,`password`) VALUES (NULL, "Janet", "Valdez","gia@gmail.com", 'password1234');
INSERT INTO `User` (`id`,`name`,`surname`,`email`,`password`) VALUES (NULL, "Marcelo", "Valdez","marc@gmail.com", 'pass678');
INSERT INTO `User` (`id`,`name`,`surname`,`email`,`password`) VALUES (NULL, "Juan", "Gianni","juan@gmail.com", 'contrasenia346');
INSERT INTO `User` (`id`,`name`,`surname`,`email`,`password`) VALUES (NULL, "Maria", "Cudicio","mariacud@gmail.com", 'mariacontras');

exit
