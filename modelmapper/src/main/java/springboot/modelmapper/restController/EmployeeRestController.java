package springboot.modelmapper.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.modelmapper.info.EmployeeInfo;
import springboot.modelmapper.info.KeyInfo;
import springboot.modelmapper.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("employeeApi")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    //  "/employees" and return employees list
    @GetMapping("/employees")
    public List<KeyInfo> findAll(){
        return employeeService.findAll();
    }
    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/")
    public KeyInfo getEmployee(@RequestParam Long id){
        KeyInfo theEmployee = employeeService.findById(id);
        return theEmployee;
    }
    //add mapping for POST
    @PostMapping("/employee")
    public ResponseEntity createEmployee(@RequestBody EmployeeInfo employeeInfo) {

        employeeService.save(employeeInfo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("created successful");
    }
    @PutMapping("/employeeu")
    public ResponseEntity updateEmployee(@RequestBody EmployeeInfo employeeInfo){
        KeyInfo employee1=employeeService.findById(employeeInfo.getId());
        employeeService.updateEmployee(employeeInfo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("updated successful");
    }
    @DeleteMapping("/delete/")
    public String deleteEmployee(@RequestParam Long id) {
        KeyInfo employee = employeeService.findById(id);
        employeeService.deleteById(id);
        return "Deleted employee id-" + id;
    }
}
