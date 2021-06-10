DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(15) NOT NULL UNIQUE,
    `email` VARCHAR(254) NOT NULL UNIQUE,
    `password` VARCHAR(15) NOT NULL,
    `gender` VARCHAR(6) NOT NULL,
    `role` VARCHAR(13) NOT NULL,
    `picture_url` VARCHAR(2083),
    `description` VARCHAR(250),
    `metadata` VARCHAR(512),
    `status` TINYINT(1) NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL
);

DROP TABLE IF EXISTS `quizzes`;
CREATE TABLE `quizzes` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(80) NOT NULL,
    `user_id` INT UNSIGNED NOT NULL,
    `description` VARCHAR(250) NOT NULL,
    `expected_duration` INT UNSIGNED NOT NULL,
    `picture_url` VARCHAR(2083),
    `tags` VARCHAR(100),
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    INDEX `fk_quizzes_users_idx` (`user_id`),
    CONSTRAINT `fk_quizzes_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `quiz_id` INT UNSIGNED NOT NULL,
    `text` VARCHAR(300) NOT NULL,
    `picture_url` VARCHAR(2083),
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    INDEX `fk_questions_quizzes_idx` (`quiz_id`),
    CONSTRAINT `fk_questions_quizzes` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `question_id` INT UNSIGNED NOT NULL,
    `text` VARCHAR(150) NOT NULL,
    `picture_url` VARCHAR(2083),
    `score` INT NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    INDEX `fk_answers_questions_idx` (`question_id`),
    CONSTRAINT `fk_answers_questions` FOREIGN KEY (`question_id`)
        REFERENCES `questions` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
);