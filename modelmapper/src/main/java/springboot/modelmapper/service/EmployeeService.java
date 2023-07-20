package springboot.modelmapper.service;

import springboot.modelmapper.info.EmployeeInfo;
import springboot.modelmapper.info.KeyInfo;
import springboot.modelmapper.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<KeyInfo> findAll();

    public KeyInfo findById(Long id);

    public Employee save(EmployeeInfo employeeInfo);


    public Employee updateEmployee(EmployeeInfo employeeInfo);

    public void deleteById(Long id);
}
