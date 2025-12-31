KPMG

List<Employee> list

Employee
id, name, depart


Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())


List<Employee> res = map.entrySet().filter(e -> e.getKey().equals("IT")).map(e -> e.getValue()).toList();


wrong
select * from employee e group by e.id having count(id) > 1;

crt:
SELECT e.id, COUNT(*) AS cnt
FROM employee e
GROUP BY e.id
HAVING COUNT(e.id) > 1;


if u group by e.id... then u cannot use *