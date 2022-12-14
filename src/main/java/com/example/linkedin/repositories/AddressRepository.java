package com.example.linkedin.repositories;

import com.example.linkedin.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findByProfileId(Long profileId);


}
