use shop;
select count(em.EmployeeID) as total, em.EmployeeID from employees em
join orders o
on o.EmployeeID = em.EmployeeID group by em.EmployeeID order by 1;
