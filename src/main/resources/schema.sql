
DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  passportNumber VARCHAR(250) NOT NULL

);


DROP TABLE IF EXISTS PAR;

CREATE TABLE PAR (
  ROWID VARCHAR(250) NOT NULL,
  PAR_GROUP VARCHAR(250) NOT NULL,
  PAR_NAME VARCHAR(250) NOT NULL,
  PAR_ENABLED TINYINT(1) NOT NULL,
  PAR_VERSION VARCHAR(250) NOT NULL,
  PAR_ACCESS INT NOT NULL,
  PAR_VALUE VARCHAR(250) NOT NULL
);


