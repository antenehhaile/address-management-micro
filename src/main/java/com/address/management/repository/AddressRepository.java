package com.address.management.repository;

import java.util.UUID;

import com.address.management.models.Addresses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Addresses, UUID> {
}
