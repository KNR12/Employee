package springboot.modelmapper.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.modelmapper.model.Address;
import springboot.modelmapper.model.Department;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeyInfo {

    private Long id;

    private String employeeName;

    private String email;

    private List<AddressInfo> addressList;

    private DepartmentInfo department;




}
