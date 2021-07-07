package com.address.management.service;

import com.address.management.avro.AddressRecords;
import com.address.management.avro.AvroAddresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressRecordSenderImpl implements AddressRecords {

    @Autowired 
    private AddressService addressService;

    @Override
    public String save(AvroAddresses addresses) {
        log.info("Sending back the user id for address.");
        return addressService.saveAddress(addresses);
    }

    @Override
    public AvroAddresses get(String id) {
        log.info("Sending back the avro address.");
        return addressService.getAddress(id);
    }
}