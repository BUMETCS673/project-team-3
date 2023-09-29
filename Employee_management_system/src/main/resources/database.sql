Create schema employee;
CREATE TABLE employee_info (
                               employee_id INT AUTO_INCREMENT PRIMARY KEY,
                               name VARCHAR(20) NOT NULL,
                               email VARCHAR(100) NOT NULL,
                               phone_number VARCHAR(20),
                               job_title CHAR(100) NOT NULL,
                               AnnualSalary DECIMAL(8, 2) NOT NULL
);

CREATE TABLE user_credential (
                               username VARCHAR(20) NOT NULL,
                               password VARCHAR(25) NOT NULL,
                               user_id VARCHAR(100) NOT NULL
);
CREATE TABLE vacation_request (
                               employee_id INT AUTO_INCREMENT PRIMARY KEY,
                               start_date VARCHAR(20) NOT NULL,
                               end_date VARCHAR(25) NOT NULL,
                               reason VARCHAR(300),
                               status VARCHAR(20),
                               FOREIGN KEY (employee_id) references employee_info(employee_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO employee_info(employee_id,name,email,phone_number,job_title,AnnualSalary)
VALUES (100,'Steven','steven.king@sqltutorial.org','515.123.4567','employee',24000.00);
INSERT INTO employee_info(employee_id,name,email,phone_number,job_title,AnnualSalary)
VALUES (101,'Neena','Neena@sqltutorial.org','554.123.4567','employee',27500.00);
INSERT INTO employee_info(employee_id,name,email,phone_number,job_title,AnnualSalary)
VALUES (102,'Lex','Lex@sqltutorial.org','8325.123.4567','manager',80000.00);
INSERT INTO employee_info(employee_id,name,email,phone_number,job_title,AnnualSalary)
VALUES (103,'Alexander','alexander.hunold@sqltutorial.org','717.123.4567','employee',27000.00);