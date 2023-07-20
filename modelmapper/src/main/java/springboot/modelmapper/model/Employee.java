package springboot.modelmapper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="employeeName", length=32, nullable=false)
    private String employeeName;

    @Column(name="email", length=32, nullable=false)
    private String email;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="employee_id")
    private List<Address> addressList;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="dpt_id")
    private Department department;
}