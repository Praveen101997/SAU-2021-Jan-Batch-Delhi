#####################################################################################################################
-- DELETE Previosly created database
DROP DATABASE Student;

######################################################################################################################
-- Create Student Database
CREATE DATABASE Student;

######################################################################################################################
-- Select Database
USE Student;

######################################################################################################################
-- Create StudentBasicInformation Table
CREATE TABLE StudentBasicInformation (
    StudentRollNo int NOT NULL,
    StudentName varchar(255) NOT NULL,
    StudentSurname varchar(255),
    StudentAddress varchar(255),
    StudentGender varchar(10),
    StudentDateOfBirth varchar(20),
    StudentContactDetail varchar(22),
    PRIMARY KEY (StudentRollNo)
);

########################################################################################################################
-- Create StudentAdmissionPaymentDetails Table
CREATE TABLE StudentAdmissionPaymentDetails (
    StudentRollNo int NOT NULL,
    AmountPaid int NOT NULL,
    AmountBalance int NOT NULL,
    TotalAmount int NOT NULL,
    ModeOfPayment varchar(20),
    FineTillDate int NOT NULL,
    LastDateOfPayment varchar(20),
    PRIMARY KEY (StudentRollNo)
);

#########################################################################################################################
-- Create StudentSubjectInformation Table
CREATE TABLE StudentSubjectInformation (
    SubjectOpted varchar(20) NOT NULL,
    StudentRollNo int NOT NULL,
    SubjectTotalMarks int NOT NULL,
    SubjectObtainedMarks int NOT NULL,
    StudentMarksPercentage FLOAT(2) NOT NULL,
    StudentGrade varchar(20),
    PRIMARY KEY (StudentRollNo)
);

##########################################################################################################################
-- Create SubjectScholarshipInformation Table
CREATE TABLE SubjectScholarshipInformation (
    StudentRollNo int NOT NULL,
    ScholarshipName varchar(20),
    ScholarshipDescription varchar(255),
    ScholarshipAmount int NOT NULL,
    ScholarshipCategory varchar(20),
    ScholarshipBankDetail varchar(20),
    ScholarshipStatus varchar(20),
    PRIMARY KEY (StudentRollNo)
);

############################################################################################################################
ALTER TABLE StudentAdmissionPaymentDetails
ADD FOREIGN KEY (StudentRollNo) REFERENCES StudentBasicInformation(StudentRollNo);

ALTER TABLE StudentSubjectInformation
ADD FOREIGN KEY (StudentRollNo) REFERENCES StudentBasicInformation(StudentRollNo);

ALTER TABLE SubjectScholarshipInformation
ADD FOREIGN KEY (StudentRollNo) REFERENCES StudentBasicInformation(StudentRollNo);

#############################################################################################################################
-- Insertion of data in StudentBasicInformation
INSERT INTO StudentBasicInformation
  ( StudentRollNo, StudentName, StudentSurname, StudentAddress, StudentGender, StudentDateOfBirth, StudentContactDetail)
VALUES
  (1, 'Mohan','Sharma','RZ12 Badli Delhi', 'M', '20-12-1998', '9876554353'), 
  (2, 'Ramesh','Kumar','RZ35 Ranhola Delhi', 'M', '12-11-1997', '7834234653'), 
  (3, 'Gautam','Singh','RZ75 VikasPuri Delhi', 'M', '24-10-1998', '2783972354'), 
  (4, 'Santosh','Sharma','RZ23 Nangloi Delhi', 'M', '13-12-1998', '8753612983'), 
  (5, 'Deepak','Singh','RZ98 Badli Delhi', 'M', '3-08-1997', '8975618231'), 
  (6, 'Anukriti','Kumari','RZ43 Nangloi Delhi', 'F', '20-12-1998', '6743287398'), 
  (7, 'Manoj','Patel','RZ55 Najafgarh Delhi', 'M', '20-12-1998', '7653829731'), 
  (8, 'Pooja','Kumari','RZ23 Dwarka Delhi', 'F', '3-7-1998', '7232819371'), 
  (9, 'Deepti','Kumari','RZ09 Badl Delhi', 'F', '13-2-1996', '9891235456'), 
  (10, 'Rajesh','Sharma','RZ68 Uttam Nagar Delhi', 'M', '15-9-1998', '5634683711'),
  (11, 'Ashraf','Sharma','RZ422 Nangli Delhi', 'M', '15-10-1998', '5642342371'),
  (12, 'Manish','Sharma','RZ764 Uttam Nagar Delhi', 'M', '25-4-1998', '6545683711');
  
##############################################################################################################################
  -- Insertion of data in StudentAdmissionPaymentDetails
INSERT INTO StudentAdmissionPaymentDetails
  ( StudentRollNo, AmountPaid, AmountBalance, TotalAmount, ModeOfPayment, FineTillDate, LastDateOfPayment)
VALUES
  (1, 5000,5000,10000, 'CASH', 0, '15-12-2020'),
  (2, 3000,7000,10000, 'NET BANKING', 0, '15-12-2020'),
  (4, 7000,3000,10000, 'CASH', 60, '15-10-2020'),
  (5, 6000,4000,10000, 'NET BANKING', 0, '15-12-2020'),
  (6, 5000,5000,10000, 'DEBIT CARD', 0, '15-12-2020'),
  (7, 4500,5500,10000, 'CASH', 0, '15-12-2020'),
  (9, 4000,6000,10000, 'CASH', 0, '15-12-2020'),
  (10, 3500,6500,10000, 'DEBIT CARD', 0, '15-12-2020'),
  (11, 3500,6500,10000, 'CASH', 0, '15-12-2020'),
  (12, 3500,6500,10000, 'DEBIT CARD', 0, '15-12-2020');

###################################################################################################################################
 -- Insertion of data in StudentSubjectInformation
INSERT INTO StudentSubjectInformation
  ( SubjectOpted, StudentRollNo, SubjectTotalMarks, SubjectObtainedMarks, StudentMarksPercentage, StudentGrade)
VALUES
  ("English", 1,100,98, 0, '-'),
  ("English", 2,100,88, 0, '-'),
  ("English", 3,100,74, 0, '-'),
  ("English", 4,100,95, 0, '-'),
  ("English", 5,100,56, 0, '-'),
  ("English", 6,100,56, 0, '-'),
  ("English", 8,100,32, 0, '-'),
  ("English", 9,100,98, 0, '-'),
  ("English", 10,100,77, 0, '-'),
  ("English", 11,100,76, 0, '-'),
  ("English", 12,100,91, 0, '-')
  ;
  
#####################################################################################################################################
-- Insertion of data in StudentSubjectInformation
INSERT INTO SubjectScholarshipInformation
  ( StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipBankDetail, ScholarshipStatus)
VALUES
  (1,'MERIT','MERIT SCHOLARSHIP',10000,'-','45345353535','Accepted'),
  (2,'MERIT','MERIT SCHOLARSHIP',7500,'-','23424234234','Accepted'),
  (3,'MERIT','MERIT SCHOLARSHIP',5000,'-','576756756765','Rejected'),
  (4,'MERIT','MERIT SCHOLARSHIP',8200,'-','456456363663','Accepted'),
  (6,'MERIT','MERIT SCHOLARSHIP',10000,'-','6858757474','Rejected'),
  (7,'MERIT','MERIT SCHOLARSHIP',3300,'-','78657464564','Rejected'),
  (8,'MERIT','MERIT SCHOLARSHIP',4500,'-','2142345325','Accepted'),
  (9,'MERIT','MERIT SCHOLARSHIP',10000,'-','4352342141','Rejected'),
  (10,'MERIT','MERIT SCHOLARSHIP',6300,'-','54635252525','Accepted'),
  (11,'MERIT','MERIT SCHOLARSHIP',2300,'-','7645323543','Rejected'),
  (12,'MERIT','MERIT SCHOLARSHIP',2500,'-','7645323543','Rejected');
  
#######################################################################################################################################
-- Display All 5 tables
SELECT * FROM StudentBasicInformation;
SELECT * FROM StudentAdmissionPaymentDetails;
SELECT * FROM StudentSubjectInformation;
SELECT * FROM SubjectScholarshipInformation;
  
#######################################################################################################################################
-- Update data in Student Database

-- 1
UPDATE StudentBasicInformation
SET StudentAddress = 'RZ23 vikaspuri Delhi'
WHERE StudentRollNo = 4;
-- 2
UPDATE SubjectScholarshipInformation
SET ScholarshipBankDetail = '9898989898'
WHERE StudentRollNo = 1;
-- 3
UPDATE StudentSubjectInformation
SET SubjectObtainedMarks = 82
WHERE StudentRollNo = 2;
-- 4
UPDATE StudentAdmissionPaymentDetails
SET ModeOfPayment = 'CASH'
WHERE StudentRollNo = 2;
-- 5
UPDATE SubjectScholarshipInformation
SET ScholarshipStatus = 'Accepeted'
WHERE StudentRollNo = 6;

##########################################################################################################################################
-- Display All 5 tables
SELECT * FROM StudentBasicInformation;
SELECT * FROM StudentAdmissionPaymentDetails;
SELECT * FROM StudentSubjectInformation;
SELECT * FROM SubjectScholarshipInformation;

##########################################################################################################################################
-- Select the student details records who has received the scholarship more than 5000Rs/-
SELECT * FROM StudentBasicInformation 
WHERE StudentRollNo IN 
	(SELECT StudentRollNo FROM SubjectScholarshipInformation 
		WHERE SubjectScholarshipInformation.ScholarshipAmount > 5000);

##########################################################################################################################################
-- Select the students who opted for scholarship but has not got the scholarship.
SELECT * FROM StudentBasicInformation 
WHERE StudentRollNo IN 
	(SELECT StudentRollNo FROM SubjectScholarshipInformation 
		WHERE SubjectScholarshipInformation.ScholarshipStatus='Rejected');

###########################################################################################################################################
-- Fill in data for the percentage column i.e. StudentMarksPercentage in the table StudentSubjectInformation by creating and using the stored procedure created
SELECT * FROM StudentSubjectInformation;

delimiter $$
DROP PROCEDURE IF EXISTS Percentage_Cal;
CREATE procedure Percentage_Cal ()  
DETERMINISTIC  
BEGIN
   UPDATE StudentSubjectInformation AS sb 
	SET sb.StudentMarksPercentage=sb.SubjectObtainedMarks/sb.SubjectTotalMarks*100 
		WHERE sb.StudentRollNo!=0;
   
   UPDATE StudentSubjectInformation AS sb 
	SET sb.StudentGrade=CASE
		WHEN sb.StudentMarksPercentage>90 THEN '0'
        WHEN sb.StudentMarksPercentage>80 THEN 'A+'
        WHEN sb.StudentMarksPercentage>70 THEN 'A'
        WHEN sb.StudentMarksPercentage>60 THEN 'B+'
        WHEN sb.StudentMarksPercentage>50 THEN 'B'
        WHEN sb.StudentMarksPercentage>40 THEN 'C'
        WHEN sb.StudentMarksPercentage>33 THEN 'P'
		ELSE 'F'
    END
	WHERE sb.StudentRollNo!=0;
   
END $$
delimiter ;

#========================

CALL Percentage_Cal;

SELECT * FROM StudentSubjectInformation;

##############################################################################################################################
-- Decide the category of the scholarship depending upon the marks/percentage 
-- obtained by the student and likewise update the ScholarshipCategory column, 
-- create a stored procedure in order to handle this operation
SELECT * FROM SubjectScholarshipInformation;

delimiter $$
DROP PROCEDURE IF EXISTS Category_Cal;
CREATE procedure Category_Cal ()  
DETERMINISTIC  
BEGIN
   UPDATE SubjectScholarshipInformation AS si
	SET si.ScholarshipCategory=CASE
		WHEN ((SELECT sp.StudentMarksPercentage FROM StudentSubjectInformation AS sp WHERE sp.StudentRollNo=si.StudentRollNo)>80) THEN 'CAT_1'
        WHEN ((SELECT sp.StudentMarksPercentage FROM StudentSubjectInformation AS sp WHERE sp.StudentRollNo=si.StudentRollNo)>60) THEN 'CAT_2'
        WHEN ((SELECT sp.StudentMarksPercentage FROM StudentSubjectInformation AS sp WHERE sp.StudentRollNo=si.StudentRollNo)>40) THEN 'CAT_3'
        WHEN ((SELECT sp.StudentMarksPercentage FROM StudentSubjectInformation AS sp WHERE sp.StudentRollNo=si.StudentRollNo)>20) THEN 'CAT_4'
		ELSE 'CAT_4'
    END
	WHERE si.StudentRollNo!=0;
   
END $$
delimiter ;

#========================

CALL Category_Cal;

SELECT * FROM SubjectScholarshipInformation;

###############################################################################################################################
-- Create the View which shows balance amount to be paid 
-- by the student along with the student detailed information (use join)
CREATE VIEW BalancePay
AS SELECT a.* , b.AmountBalance
FROM StudentBasicInformation a INNER JOIN StudentAdmissionPaymentDetails b
ON a.StudentRollNo=b.StudentRollNo;

SELECT * FROM BalancePay;

################################################################################################################################
-- Get the details of the students who haven’t got any scholarship (use joins/subqueries)
SELECT * FROM StudentBasicInformation 
WHERE StudentRollNo NOT IN 
	(SELECT StudentRollNo FROM SubjectScholarshipInformation 
		WHERE SubjectScholarshipInformation.ScholarshipStatus!='Rejected');

#################################################################################################################################
-- Create Stored Procedure which will be return the amount balance to be paid 
-- by the student as per the student roll number passed through the stored procedure as the input
delimiter $$
DROP PROCEDURE IF EXISTS `student`.`Category_Cal`;
CREATE procedure Category_Cal (IN rollno INT, OUT amount INT)  
DETERMINISTIC  
BEGIN
	SELECT AmountBalance
	INTO amount
	FROM StudentAdmissionPaymentDetails
	WHERE StudentRollNo = rollno;
END $$
delimiter ;

#========================
CALL Category_Cal(2,@balance);
SELECT @balance AS Balance_Pay;

###################################################################################################################################
--  Retrieve the top five student details as per the StudentMarksPercentage values (use subqueries)
SELECT * FROM StudentBasicInformation 
	WHERE StudentRollNo IN 
		( SELECT T2.StudentRollNo FROM 
			(SELECT * FROM StudentSubjectInformation 
				ORDER BY StudentSubjectInformation.SubjectObtainedMarks DESC LIMIT 5) 
					AS T2);

####################################################################################################################################
-- Try to use all the three types of join learned today in a relevant way, and explain the same why you thought of using that particular join for your selected scenarios (try to cover relevant and real time scenarios for all the three studied joins)
-- INNER JOIN, OUTER LEFT JOIN, OUTER RIGHT JOIN
SELECT * FROM StudentBasicInformation 
	AS si 
    INNER JOIN StudentAdmissionPaymentDetails 
		AS sap 
			ON si.StudentRollNo=sap.StudentRollNo;

SELECT * FROM StudentBasicInformation 
	AS si 
	LEFT JOIN StudentSubjectInformation 
		AS ssi 
			ON si.StudentRollNo=ssi.StudentRollNo;

SELECT * FROM StudentAdmissionPaymentDetails 
	AS si 
	RIGHT JOIN SubjectScholarshipInformation 
		AS ssi 
			ON si.StudentRollNo=ssi.StudentRollNo;

######################################################################################################################################
-- Mention the differences between the delete, drop and truncate commands
-- Done in PDF answer sheet

#####################################################################################################################################
-- Get the count of the Scholarship category which is highly been availed by the students, 
-- i.e. get the count of the total number of students corresponding to the each scholarships category
SELECT SubjectScholarshipInformation.ScholarshipCategory, COUNT(*) as Count
	FROM SubjectScholarshipInformation
		GROUP BY SubjectScholarshipInformation.ScholarshipCategory;

#######################################################################################################################################
-- Try to retrieve the maximum used scholarship category
SELECT MAX(t2.CategoryCount) as Max FROM 
	(SELECT SubjectScholarshipInformation.ScholarshipCategory, COUNT(*) CategoryCount FROM 
		SubjectScholarshipInformation GROUP BY 
			SubjectScholarshipInformation.ScholarshipCategory) AS t2;


#######################################################################################################################################
-- Retrieve the percentage of the students along with students detailed information who has scored 
-- the highest percentage along with availing the maximum scholarship amount
SELECT sbi.*,ssi.StudentMarksPercentage,si.ScholarshipAmount FROM StudentBasicInformation as sbi
	INNER JOIN StudentSubjectInformation ssi ON 
		ssi.StudentRollNo=sbi.StudentRollNo
	INNER JOIN SubjectScholarshipInformation si ON 
		si.StudentRollNo=sbi.StudentRollNo
	WHERE ssi.StudentMarksPercentage=
				(SELECT MAX(StudentMarksPercentage) as MaxPercent FROM 
								StudentSubjectInformation)
	AND  si.ScholarshipAmount=
				(SELECT MAX(ScholarshipAmount) as MaxScholar FROM 
								SubjectScholarshipInformation)
	