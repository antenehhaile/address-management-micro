package com.address.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

import com.address.management.avro.AddressRecords;
import com.address.management.service.AddressRecordSenderImpl;

import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.netty.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;

@Slf4j
@Configuration
public class RpcConfig {

    @Autowired
    private AddressRecordSenderImpl addressRecordSenderImpl;

    @Bean
    public Server server() throws InterruptedException{
        log.info("Starting Server");
        return new NettyServer(new SpecificResponder(AddressRecords.class, addressRecordSenderImpl), new InetSocketAddress(5000));
    } 
}
