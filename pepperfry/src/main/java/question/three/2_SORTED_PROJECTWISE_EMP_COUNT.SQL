SELECT Project, count(EmpId) EmpCount
FROM EmployeeSalary
GROUP BY Project
ORDER BY EmpCount DESC;