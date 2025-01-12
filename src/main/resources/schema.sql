CREATE TABLE `registration` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `status` SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `user` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `type` SMALLINT UNSIGNED NOT NULL,
  `status` SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `address_verification` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `verification_request_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `id_verification` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `verification_request_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `biometric_verification` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `verification_request_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `verification_request` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `verification_type` SMALLINT UNSIGNED NOT NULL,
  `status` SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));
