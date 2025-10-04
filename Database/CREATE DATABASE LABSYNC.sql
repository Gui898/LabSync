CREATE DATABASE LABSYNC;
USE LABSYNC;

CREATE TABLE users (
  id_user BIGINT PRIMARY KEY auto_increment,
  nameUser VARCHAR(255) NOT NULL UNIQUE,
  surname VARCHAR(50),
  email VARCHAR(255) NOT NULL UNIQUE,
  academicEmail VARCHAR(255) UNIQUE,
  passwordUser VARCHAR(50) NOT NULL,
  readerOrAuthor BOOLEAN NOT NULL,
  aboutMe TEXT
);

CREATE TABLE project (
  id_project BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  category VARCHAR(100) NOT NULL,
  used_instruments TEXT,
  text_project LONGTEXT NOT NULL,
  used_tech TEXT,
  is_post BOOLEAN NOT NULL,
  id_user BIGINT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE posts (
  id_post BIGINT AUTO_INCREMENT PRIMARY KEY,
  likes BIGINT,
  id_user BIGINT NOT NULL,
  id_project BIGINT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES users(id_user),
  FOREIGN KEY (id_project) REFERENCES project(id_project)
);

CREATE TABLE favorite (
  id_user BIGINT NOT NULL,
  id_project BIGINT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES users(id_user),
  FOREIGN KEY (id_project) REFERENCES project(id_project)
);

CREATE TABLE commentPost(
	id_comment BIGINT AUTO_INCREMENT,
    message VARCHAR(300) NOT NULL,
    id_post BIGINT NOT NULL,
    PRIMARY KEY(id_comment),
    FOREIGN KEY(id_post) REFERENCES posts(id_post)
);