package ports.in;

import ports.data.Employee;
import ports.out.EmployeeRepository;

import java.util.List;

public interface EmployeeManager {

    public Employee createEmployee(Employee employee);

    public List<Employee> getAllEmployees();

}