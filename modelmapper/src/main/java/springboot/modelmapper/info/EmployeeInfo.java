package springboot.modelmapper.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.modelmapper.model.Address;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeInfo {

    private Long id;

    private String employeeName;

    private String email;

    private List<AddressInfo> addresses;

    private DepartmentInfo departmentInfo;

}
