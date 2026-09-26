package com.mannvaasam.repo;

import com.mannvaasam.model.Address;
import com.mannvaasam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserOrderByPrimaryAddressDescIdDesc(User user);
    Optional<Address> findByIdAndUser(Long id, User user);
}
