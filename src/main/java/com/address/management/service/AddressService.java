package com.address.management.service;

import java.util.UUID;

import com.address.management.avro.AvroAddresses;
import com.address.management.models.Addresses;
import com.address.management.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    public String saveAddress(final AvroAddresses avroAddresses){
        final Addresses address = transformAvroAddressToAddress(avroAddresses);
        addressRepository.save(address);
        return address.getId().toString();
    }

    public AvroAddresses getAddress(final String id){
        final Addresses addresses = addressRepository.findById(UUID.fromString(id)).get();
        return transformAddressToAvroAddress(addresses);
    }

    public Addresses transformAvroAddressToAddress(final AvroAddresses avroAddresses){
        return Addresses.builder()
            .id(UUID.fromString(avroAddresses.getId()))
            .address1(avroAddresses.getAddress1())
            .address2(avroAddresses.getAddress2())
            .city(avroAddresses.getCity())
            .state(avroAddresses.getState())
            .zip(avroAddresses.getZip())
            .country(avroAddresses.getCountry())
            .build();
    }

    private AvroAddresses transformAddressToAvroAddress(final Addresses address){
        return AvroAddresses.newBuilder()
            .setId(address.getId().toString())
            .setAddress1(address.getAddress1())
            .setAddress2(address.getAddress2())
            .setCity(address.getCity())
            .setState(address.getState())
            .setZip(address.getZip())
            .setCountry(address.getCountry())
            .build();
    }
}
