package com.example.linkedin.services;

import com.example.linkedin.entities.Address;
import com.example.linkedin.repositories.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AddressService {
    final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id).get();
    }

    public List<Address> getAddressByProfile(@PathVariable Long profileId) {
        return addressRepository.findByProfileId(profileId);
    }

    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address newAddress = addressRepository.findById(id)
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
        return newAddress;
    }

    public void deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
    }
}
