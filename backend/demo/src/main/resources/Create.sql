CREATE TABLE `courses` (
                           `course_id` bigint NOT NULL AUTO_INCREMENT,
                           `course_code` varchar(255) DEFAULT NULL,
                           `course_name` varchar(255) DEFAULT NULL,
                           `credits` int DEFAULT NULL,
                           `max_students` int DEFAULT NULL,
                           `max_ta` int DEFAULT NULL,
                           `specialization` tinyint DEFAULT NULL,
                           `faculty_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`course_id`),
                           KEY `FK5f87joxylakoiyc8ygfhig4up` (`faculty_id`),
                           CONSTRAINT `FK5f87joxylakoiyc8ygfhig4up` FOREIGN KEY (`faculty_id`) REFERENCES `faculty_details` (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `course_student` (
                                  `course_id` bigint NOT NULL,
                                  `student_id` bigint NOT NULL,
                                  PRIMARY KEY (`course_id`,`student_id`),
                                  KEY `FK4xxxkt1m6afc9vxp3ryb0xfhi` (`student_id`),
                                  CONSTRAINT `FK4xxxkt1m6afc9vxp3ryb0xfhi` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
                                  CONSTRAINT `FKlmsbddqkv96q4nijkrxuof3ug` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `course_ta` (
                             `course_id` bigint NOT NULL,
                             `ta_id` bigint NOT NULL,
                             PRIMARY KEY (`course_id`,`ta_id`),
                             KEY `FK1cnxe5uauv29myy92qu0mssh6` (`ta_id`),
                             CONSTRAINT `FK1cnxe5uauv29myy92qu0mssh6` FOREIGN KEY (`ta_id`) REFERENCES `student` (`student_id`),
                             CONSTRAINT `FK3m8bl4ii2vmrcia1fkov9t0pm` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `faculty_details` (
                                   `faculty_id` bigint NOT NULL AUTO_INCREMENT,
                                   `email_id` varchar(255) DEFAULT NULL,
                                   `faculty_code` varchar(255) DEFAULT NULL,
                                   `name` varchar(255) DEFAULT NULL,
                                   `password` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`faculty_id`),
                                   UNIQUE KEY `UK_1lkik6n87xpl83bnjmaa7jo8j` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `student` (
                           `student_id` bigint NOT NULL AUTO_INCREMENT,
                           `gender` char(1) DEFAULT NULL,
                           `login` varchar(255) DEFAULT NULL,
                           `password` varchar(255) DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `student_roll_no` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci