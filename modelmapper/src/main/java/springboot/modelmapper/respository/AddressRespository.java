package springboot.modelmapper.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.modelmapper.model.Address;


public interface AddressRespository extends JpaRepository<Address,Long> {
}
