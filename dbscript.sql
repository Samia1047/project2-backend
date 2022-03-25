CREATE DATABASE ers;
\c ers;
CREATE TABLE employee(employee_id INT GENERATED ALWAYS AS IDENTITY,
employee_password varchar(50),employee_first_name varchar(50),
employee_last_name varchar(50),employee_contact varchar(50),
employee_address varchar(50),employee_image_url varchar(50),PRIMARY KEY(employee_id));


INSERT INTO employee(employee_password,employee_first_name,employee_last_name,employee_contact,employee_address,employee_image_url)
						VALUES('root', 'Samia', 'Jahan', 'samia@gmail.com', 'D drive',''); 

INSERT INTO employee(employee_password,employee_first_name,employee_last_name,employee_contact,employee_address,employee_image_url)
						VALUES('root', 'Michael', 'Haile', 'Haile@gmail.com', 'g drive lane',''); 						

						
CREATE TABLE manager(manager_id INT GENERATED ALWAYS AS IDENTITY,manager_password varchar(50),
manager_first_name varchar(50),manager_last_name varchar(50),manager_contact varchar(50),
manager_address varchar(50),manager_image_url varchar(50),PRIMARY KEY(manager_id));

INSERT INTO manager(manager_password,manager_first_name,manager_last_name,manager_contact,manager_address,manager_image_url)
						VALUES('root', 'Poonga', 'Anand', 'Poonga@gmail.com', 'F drive lane','');


  CREATE TABLE pending_reimbursment(reimbursement_id INT GENERATED ALWAYS AS IDENTITY,
   									requesting_employee_id INT,		
   									reimbursement_amount double precision,
  									date_of_request TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
   									PRIMARY KEY(reimbursement_id ),
   									CONSTRAINT fk_employee
   									FOREIGN KEY(requesting_employee_id) 
  									REFERENCES employee(employee_id)
									);


INSERT INTO pending_reimbursment(requesting_employee_id,reimbursement_amount)
						VALUES('1','500.00'); 

CREATE TABLE resolved_reimbursment(reimbursement_id INT GENERATED ALWAYS AS IDENTITY,
   									requesting_employee_id INT,		
   									reimbursement_amount double precision,
   									request_approved boolean,
   									date_resolved TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
   									PRIMARY KEY(reimbursement_id ),
   									CONSTRAINT fk_employee
   									FOREIGN KEY(requesting_employee_id) 
   									REFERENCES employee(employee_id)
									);


INSERT INTO resolved_reimbursment(requesting_employee_id,reimbursement_amount,request_approved)
 VALUES('1','500.00','yes');
 
--CREATE TABLE merged_reimbursment(reimbursement_id INT GENERATED ALWAYS AS IDENTITY,
--								requesting_employee_id INT,
--								reimbursement_amount double precision,
--								request_approved boolean,
--  								date_of_request DATE NOT NULL DEFAULT CURRENT_DATE,
--  								date_resolved DATE NOT NULL DEFAULT CURRENT_DATE,
--								PRIMARY KEY(reimbursement_id));
--								
--INSERT INTO merged_reimbursment(requesting_employee_id, reimbursement_amount, request_approved)
--	VALUES('1','10000.00', 'NO');
--	
	
CREATE TABLE reimbursement_proof(reimbursement_id INT GENERATED ALWAYS AS IDENTITY,
								requesting_employee_id INT,
								tphoto bytea,
								PRIMARY KEY(reimbursement_id ),
   								CONSTRAINT fk_employee
   								FOREIGN KEY(requesting_employee_id) 
   								REFERENCES employee(employee_id));
								
INSERT INTO reimbursement_proof(requesting_employee_id, tphoto)
	VALUES('1','login.png');

		
CREATE TABLE files(id INT GENERATED ALWAYS AS IDENTITY,
						name varchar(50),
						type varchar(50),
						data bytea,
						PRIMARY KEY(id));
								
INSERT INTO files(name, type, data)
	VALUES('psg','file','https://th.bing.com/th/id/R.3de505503a610164015b15024a77002c?');
 