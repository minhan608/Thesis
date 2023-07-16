CREATE TABLE role (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES role(id)
);


CREATE TABLE task (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  status ENUM('Done', 'In Progress', 'TODO', 'Pending') NOT NULL,
  type ENUM('In-going', 'Out-going') NOT NULL,
  comment TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE teacher (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE exam (
  id INT NOT NULL AUTO_INCREMENT,
  teacher_id INT NOT NULL,
  subject_name VARCHAR(100) NOT NULL,
  exam_date DATE NOT NULL,
  semester VARCHAR(50) NOT NULL,
  status ENUM('Done', 'In Progress', 'TODO', 'Pending') NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);


CREATE TABLE time_off (
  id INT NOT NULL AUTO_INCREMENT,
  teacher_id INT NOT NULL,
  date_off DATE NOT NULL,
  status ENUM('Done', 'In Progress', 'TODO', 'Pending') NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);

CREATE TABLE subject_result (
  id INT NOT NULL AUTO_INCREMENT,
  subject_name VARCHAR(100) NOT NULL,
  lecturer VARCHAR(100) NOT NULL,
  semester VARCHAR(50) NOT NULL,
  year_time VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE student_result (
  id INT NOT NULL AUTO_INCREMENT,
  subject_id INT NOT NULL,
  pass_count INT NOT NULL,
  fail_count INT NOT NULL,
  prohibited_count INT NOT NULL,
  absent_count INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (subject_id) REFERENCES subject_result(id)
);

CREATE TABLE student_record (
  id INT NOT NULL AUTO_INCREMENT,
  student_id VARCHAR(100) NOT NULL,
  student_name VARCHAR(100) NOT NULL,
  semester VARCHAR(50) NOT NULL,
  year_time VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);



