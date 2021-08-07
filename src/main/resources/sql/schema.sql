
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enabled` int NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(60) NOT NULL,
  `role_id` int DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `verification_code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `first_names` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `name` varchar(60) DEFAULT NULL,
                               `race` varchar(255) DEFAULT NULL,
                               `sex` char(1) NOT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `UK_fvmlv6jddrc1tr7k1wwhi6ayd` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `races` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `general_race` varchar(60) DEFAULT NULL,
                         `sub_race` varchar(60) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UK_13vef2yiikal57tjj15dgp4bm` (`sub_race`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `last_names` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(60) DEFAULT NULL,
                              `race` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `UK_kmx7bv2jkqedg68voyxp2vul8` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `classes` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(60) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `UK_pgs3gcxax70h9jugbt24ugwcg` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `backgrounds` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `name` varchar(60) DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `UK_powqmmgqw803e22f9ypax3mrn` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `npcs` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `abilities` longtext,
                        `appearance` longtext,
                        `bond` varchar(255) DEFAULT NULL,
                        `flaw_or_secret` varchar(255) DEFAULT NULL,
                        `history` longtext,
                        `ideal` varchar(255) DEFAULT NULL,
                        `interaction` longtext,
                        `mannerism` longtext,
                        `name` varchar(50) DEFAULT NULL,
                        `occupation` varchar(50) DEFAULT NULL,
                        `race` varchar(50) NOT NULL,
                        `sex` varchar(1) NOT NULL,
                        `talent` longtext,
                        `useful_knowledge` longtext,
                        `user_id` bigint DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FK8bih5gjwwupiralekg7t187m6` (`user_id`),
                        CONSTRAINT `FK8bih5gjwwupiralekg7t187m6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS `players` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `bond` varchar(255) DEFAULT NULL,
                           `charisma_ability` int NOT NULL,
                           `condition_ability` int NOT NULL,
                           `dexterity_ability` int NOT NULL,
                           `equipment` longtext,
                           `features_and_traits` longtext,
                           `flaw` varchar(255) DEFAULT NULL,
                           `history` longtext,
                           `hp` int NOT NULL,
                           `hp_dice` varchar(4) DEFAULT NULL,
                           `ideal` varchar(255) DEFAULT NULL,
                           `intelligence_ability` int NOT NULL,
                           `name` varchar(50) DEFAULT NULL,
                           `proficiencies_and_languages` longtext,
                           `sex` varchar(1) NOT NULL,
                           `skills` longtext,
                           `strength_ability` int NOT NULL,
                           `wisdom_ability` int NOT NULL,
                           `background_id` bigint DEFAULT NULL,
                           `character_class_id` bigint DEFAULT NULL,
                           `race_id` bigint DEFAULT NULL,
                           `user_id` bigint DEFAULT NULL,
                           `personality_traits` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FKib4f8f03xdlynowtunidtf5i8` (`background_id`),
                           KEY `FKacerj197wqdp3xm6lsy1vuuj7` (`character_class_id`),
                           KEY `FKqinih0fh3c42gsamvg1cgh8un` (`race_id`),
                           KEY `FK3rfv9832bif6rea5edetib8it` (`user_id`),
                           CONSTRAINT `FK3rfv9832bif6rea5edetib8it` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
                           CONSTRAINT `FKacerj197wqdp3xm6lsy1vuuj7` FOREIGN KEY (`character_class_id`) REFERENCES `classes` (`id`),
                           CONSTRAINT `FKib4f8f03xdlynowtunidtf5i8` FOREIGN KEY (`background_id`) REFERENCES `backgrounds` (`id`),
                           CONSTRAINT `FKqinih0fh3c42gsamvg1cgh8un` FOREIGN KEY (`race_id`) REFERENCES `races` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;