package ports.out;

import com.rentcar.employee.ports.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // TODO: Методы для работы с базой данных
}