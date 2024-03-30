   CREATE TABLE tasks (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     description VARCHAR(255) NOT NULL,
     status VARCHAR(20) NOT NULL,
     creation_date TIMESTAMP NOT NULL
   );