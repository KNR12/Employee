package springboot.modelmapper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import springboot.modelmapper.enums.Country;
import springboot.modelmapper.enums.States;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="addressId")
    private Long addressId;

    @Column(name="addressType", length=32)
    private String addressType;

    @Column(name="city", length=32)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name="state")
    private States state;

    @Enumerated(EnumType.STRING)
    @Column(name="country")
    private Country country;



}
