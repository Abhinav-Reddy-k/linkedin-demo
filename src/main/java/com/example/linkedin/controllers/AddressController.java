package com.example.linkedin.controllers;

import com.example.linkedin.entities.Address;
import com.example.linkedin.repositories.AddressRepository;
import com.example.linkedin.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;



    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping(value = "/{id}")
    public Address get(@PathVariable Long id) {
        return addressService.get(id);
    }

    @GetMapping("/profile/{profileId}")
    public List<Address> getByProfile(@PathVariable Long profileId){
        return addressService.getByProfile(profileId);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
        return addressService.updateAddress(id,address);
    }


    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
       addressService.deleteAddress(id);
    }
}
