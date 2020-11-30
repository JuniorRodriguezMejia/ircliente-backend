package com.intercorp.retail.ircliente.service;

import com.intercorp.retail.ircliente.bean.Cliente;
import com.intercorp.retail.ircliente.output.ResCrearCliente;
import com.intercorp.retail.ircliente.output.ResKpiCliente;
import com.intercorp.retail.ircliente.output.ResLstCliente;

public interface CustomerService {
	
	public ResLstCliente lstClientes();
	
	public ResCrearCliente crearCliente(Cliente cliente);
	
	public ResKpiCliente kpiClientes();
}
