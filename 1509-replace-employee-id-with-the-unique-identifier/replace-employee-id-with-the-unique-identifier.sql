# Write your MySQL query statement below
select coalesce(u.unique_id, null) as unique_id, e.name from Employees e left join EmployeeUNI u on e.id = u.id;