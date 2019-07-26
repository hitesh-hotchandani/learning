SELECT EmpId, Project, Salary, COUNT(*)
FROM EmployeeSalary
GROUP BY EmpId, Project, Salary
HAVING COUNT(*) > 1;