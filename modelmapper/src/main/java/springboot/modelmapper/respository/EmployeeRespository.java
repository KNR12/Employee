package springboot.modelmapper.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.modelmapper.model.Employee;


public interface EmployeeRespository extends JpaRepository<Employee,Long> {
}
