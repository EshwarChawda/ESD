use esdDemo4;

INSERT INTO faculty_details (email_id, faculty_code, name, password)
VALUES
    ('john.doe@example.com', 'F001', 'John Doe', 'password'),
    ('jane.smith@example.com', 'F002', 'Jane Smith', 'password');

INSERT INTO courses (course_code, course_name, credits, max_students, max_ta, specialization, faculty_id)
VALUES
    ('CS101', 'Introduction to Programming', 4, 50, 5, 0, 1),
    ('CS102', 'Data Structures', 3, 40, 3, 0, 2),
    ('CS103', 'Database Systems', 3, 45, 4, 1, 1);

INSERT INTO student (student_id, gender, login, password, name, student_roll_no)
VALUES
    (1, 'M', 'S001', 'password', 'Alice Johnson', '001'),
    (2, 'F', 'S002', 'password', 'Bob Lee', '002'),
    (3, 'M', 'S003', 'password', 'Cathy Zhang', '003'),
    (4, 'F', 'S004', 'password', 'David Brown', '004');

INSERT INTO course_student (course_id, student_id)
VALUES
    (1, 1), -- Alice Johnson enrolled in CS101
    (1, 2), -- Bob Lee enrolled in CS101
    (2, 3), -- Cathy Zhang enrolled in CS102
    (3, 4); -- David Brown enrolled in CS103

INSERT INTO course_ta (course_id, ta_id)
VALUES
    (1, 3), -- Cathy Zhang is TA for CS101
    (2, 4); -- David Brown is TA for CS102