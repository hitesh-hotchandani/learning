SELECT DISTINCT Emp.FullName
FROM EmployeeDetails Emp
INNER JOIN EmployeeDetails Manager
ON Emp.EmpID = Manager.ManagerID;