select e1.name
from Employee as e1 left outer join Employee e2 on e1.id = e2.managerId
group by e1.id
having count(e1.id) >= 5