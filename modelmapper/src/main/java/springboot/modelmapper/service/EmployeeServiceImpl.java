package springboot.modelmapper.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.modelmapper.info.AddressInfo;
import springboot.modelmapper.info.DepartmentInfo;
import springboot.modelmapper.info.EmployeeInfo;
import springboot.modelmapper.info.KeyInfo;
import springboot.modelmapper.model.Address;
import springboot.modelmapper.model.Department;
import springboot.modelmapper.model.Employee;
import springboot.modelmapper.respository.AddressRespository;
import springboot.modelmapper.respository.EmployeeRespository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRespository employeeRespository;

    private AddressRespository addressRespository;

    @Override
    public List<KeyInfo> findAll() {
        List<Employee> employeeList=employeeRespository.findAll();
        List<KeyInfo> keyInfos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();

        for(Employee employee:employeeList) {
            KeyInfo keyInfo=modelMapper.map(employee, KeyInfo.class);
            keyInfos.add(keyInfo);

                }
        return keyInfos;
    }

   @Override
    public KeyInfo findById(Long id) {
       Optional<Employee> employeeDetails = employeeRespository.findById(id);
       Employee employee1;

       if (employeeDetails.isPresent()) {
           employee1 = employeeDetails.get();
       } else {
           //we didnt find the employee
           throw new RuntimeException("Did not find employee id-" + id);
       }
       List<Address> addressLists = employee1.getAddressList();
       List<AddressInfo> addressInfoList = new ArrayList<>();
       ModelMapper modelMapper = new ModelMapper();
       for (Address address :  addressLists) {
           AddressInfo addressInfos = modelMapper.map(address, AddressInfo.class);
           addressInfoList.add(addressInfos);
       }
       Department department = employee1.getDepartment();
       DepartmentInfo departmentInfo = modelMapper.map(department, DepartmentInfo.class);

       KeyInfo keyInfo = modelMapper.map(employee1, KeyInfo.class);
       keyInfo.setDepartment(departmentInfo);
       keyInfo.setAddressList(addressInfoList);
       return (keyInfo);
   }


       /* KeyInfo keyInfo = KeyInfo.builder()
                .id(employee1.getId())
                .employeeName(employee1.getEmployeeName())
                .email(employee1.getEmail())
                .departmentInfo(departmentInfo)
                .addressList(addressInfoList)
                .build();
        return keyInfo;

        */

    @Override
    public Employee save(EmployeeInfo employeeInfo) {
        List<AddressInfo> addressInfos = employeeInfo.getAddresses();
        List<Address> addresses = new ArrayList<Address>();
        ModelMapper modelMapper = new ModelMapper();
        for (AddressInfo addressInfoList : addressInfos) {
            Address address = modelMapper.map(addressInfoList, Address.class);
            addresses.add(address);
        }

            DepartmentInfo departmentInfo = employeeInfo.getDepartmentInfo();
            Department department = modelMapper.map(departmentInfo, Department.class);

            Employee employee = modelMapper.map(employeeInfo, Employee.class);
            employee.setAddressList(addresses);
            return employeeRespository.save(employee);

    }

    @Override
    public Employee updateEmployee(EmployeeInfo employeeInfo) {
        List<AddressInfo> addressInfoLists=employeeInfo.getAddresses();
        List<Address> addressDetails=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(AddressInfo addressInfo:addressInfoLists){
            Address address=modelMapper.map(addressInfo, Address.class);
            addressDetails.add(address);
        }
        DepartmentInfo departmentInfo=employeeInfo.getDepartmentInfo();
        Department department=modelMapper.map(departmentInfo, Department.class);

        Employee employee=modelMapper.map(employeeInfo, Employee.class);
        return employeeRespository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRespository.deleteById(id);
    }
}
