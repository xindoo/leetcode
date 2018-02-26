# Write your MySQL query statement below
SELECT e3.Employee AS Employee
FROM (
	SELECT e1.Name AS Employee, e1.Salary AS Salary, e2.Salary AS managerSalary
	FROM Employee e1
		INNER JOIN Employee e2 ON e1.ManagerId = e2.Id
) e3
WHERE e3.Salary > e3.managerSalary