package springboot.modelmapper.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.modelmapper.model.Department;


public interface DepartmentRespository extends JpaRepository<Department,Long> {
}
