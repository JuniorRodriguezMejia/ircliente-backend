package com.intercorp.retail.ircliente.repository;

import org.springframework.stereotype.Repository;

import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import com.intercorp.retail.ircliente.model.Customer;

@Repository
public class CustomerRepository extends DefaultFirebaseRealtimeDatabaseRepository<Customer, String> {

}