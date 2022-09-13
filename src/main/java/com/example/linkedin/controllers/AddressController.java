package com.example.linkedin.controllers;

import com.example.linkedin.model.Address;
import com.example.linkedin.repositories.AddressRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    final
    AddressRepository addressRepository;


    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Address get(@PathVariable Long id) {
        return addressRepository.findById(id).get();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
        return addressRepository.findById(id)
                .map(oldAddress -> {
                    oldAddress.setCity(address.getCity());
                    oldAddress.setColony(address.getColony());
                    oldAddress.setCountry(address.getCountry());
                    oldAddress.sethNo(address.gethNo());
                    oldAddress.setLocality(address.getLocality());
                    oldAddress.setState(address.getState());
                    return addressRepository.save(oldAddress);
                })
                .orElseGet(() -> {
                    address.setId(id);
                    return addressRepository.save(address);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
    }
}
