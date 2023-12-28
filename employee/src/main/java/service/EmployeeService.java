package service;

import ports.in.EmployeeManager;
import ports.out.EmployeeRepository;
import ports.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeManager {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        // TODO: Реализация создания сотрудника
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        // TODO: Реализация получения всех сотрудников
        return employeeRepository.findAll();
    }


}
