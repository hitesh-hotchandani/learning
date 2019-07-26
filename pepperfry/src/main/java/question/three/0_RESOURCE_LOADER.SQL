CREATE TABLE EmployeeDetails
    (`EmpID` int, `FullName` varchar(12), `ManagerId` int, `DateOfJoining` varchar(10))
;

INSERT INTO EmployeeDetails
    (`EmpID`, `FullName`, `ManagerId`, `DateOfJoining`)
VALUES
    (121, 'John Snow', 321, '01/31/2014'),
    (321, 'Walker White', 986, '01/30/2015'),
    (421, 'Kuldeep Rana', 876, '27/11/2016')
;


CREATE TABLE EmployeeSalary
    (`EmpID` int, `Project` varchar(2), `Salary` int)
;

INSERT INTO EmployeeSalary
    (`EmpID`, `Project`, `Salary`)
VALUES
    (121, 'P1', 8000),
    (321, 'P2', 1000),
    (421, 'P1', 12000)
;
