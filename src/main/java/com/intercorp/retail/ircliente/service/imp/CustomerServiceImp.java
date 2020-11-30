package com.intercorp.retail.ircliente.service.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorp.retail.ircliente.bean.Cliente;
import com.intercorp.retail.ircliente.model.Customer;
import com.intercorp.retail.ircliente.output.ResCrearCliente;
import com.intercorp.retail.ircliente.output.ResKpiCliente;
import com.intercorp.retail.ircliente.output.ResLstCliente;
import com.intercorp.retail.ircliente.repository.CustomerRepository;
import com.intercorp.retail.ircliente.service.CustomerService;
import com.intercorp.retail.ircliente.utils.CustomerUtils;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public ResLstCliente lstClientes() {
		ResLstCliente resLstCliente = new ResLstCliente();
		try {
			List<Cliente> lstClientes = new ArrayList<>();
			List<Customer> lstCustomers = customerRepository.findAll();
			for (Customer customer : lstCustomers) {
				Cliente cliente = new Cliente();
				cliente.setId(customer.getId());
				cliente.setNombre(customer.getFirstname());
				cliente.setApellido(customer.getLastname());
				cliente.setFechaNacimiento(CustomerUtils.getDateFormatted(customer.getBirthday()));
				cliente.setEdad(CustomerUtils.getAgeFromBirthday(customer.getBirthday()));
				cliente.setFechaProbableMuerte(CustomerUtils.getDeathday(Long.parseLong(cliente.getEdad().toString())));
				lstClientes.add(cliente);
			}
			resLstCliente.setClientes(lstClientes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resLstCliente;
	}
	
	@Override
	public ResCrearCliente crearCliente(Cliente cliente) {
		ResCrearCliente resCrearCliente = new ResCrearCliente();
		try {
			Customer customer = new Customer();
			customer.setFirstname(cliente.getNombre());
			customer.setLastname(cliente.getApellido());
			customer.setBirthday(cliente.getFechaNacimiento());
			customer = customerRepository.push(customer);
			resCrearCliente.setId(customer.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resCrearCliente;
	}
	
	@Override
	public ResKpiCliente kpiClientes() {
		ResKpiCliente resKpiCliente = new ResKpiCliente();
		try {
			List<Double> lstAges = new ArrayList<>();
			ResLstCliente resLstCliente = this.lstClientes();
			for (Cliente cliente : resLstCliente.getClientes()) {
				lstAges.add(Double.parseDouble(cliente.getEdad().toString()));
			}
			BigDecimal avg = new BigDecimal(Double.toString(CustomerUtils.average(lstAges)));
			avg = avg.setScale(1, RoundingMode.HALF_UP);
			resKpiCliente.setPromedio(avg.doubleValue());
			BigDecimal stdDev = new BigDecimal(Double.toString(CustomerUtils.standardDeviation(lstAges)));
			stdDev = stdDev.setScale(1, RoundingMode.HALF_UP);
			resKpiCliente.setDesvEstandar(stdDev.doubleValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resKpiCliente;
	}

}
