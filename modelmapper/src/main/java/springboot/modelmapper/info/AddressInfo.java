package springboot.modelmapper.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.modelmapper.enums.Country;
import springboot.modelmapper.enums.States;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressInfo {

    private Long addressId;

    private String addressType;

    private String city;

    private States state;

    private Country country;



}
