package com.intercorp.retail.ircliente.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intercorp.retail.ircliente.bean.Cliente;
import com.intercorp.retail.ircliente.output.ResCrearCliente;
import com.intercorp.retail.ircliente.output.ResKpiCliente;
import com.intercorp.retail.ircliente.output.ResLstCliente;
import com.intercorp.retail.ircliente.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value="API Clientes", description="Consultas y Operaciones de Clientes")
@RequestMapping(value = "/cliente")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "Lista todos los Clientes de la BD",response = ResLstCliente.class)
	@RequestMapping(value = "/listclientes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResLstCliente listClientes() throws Exception {	
		return customerService.lstClientes();
	}
	
	@ApiOperation(value = "Crea un nuevo Cliente a la BD",response = ResCrearCliente.class)
	@RequestMapping(value = "/crearcliente", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResCrearCliente crearCliente(
			@ApiParam(value = "Objeto que contiene los datos del Cliente a crear", required = true) @Valid @RequestBody Cliente cliente) throws Exception {	
		return customerService.crearCliente(cliente);
	}
	
	@ApiOperation(value = "Obtiene el promedio y desviación estándar de la edad delos Clientes de la BD",response = ResKpiCliente.class)
	@RequestMapping(value = "/kpideclientes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResKpiCliente kpiClientes() throws Exception {	
		return customerService.kpiClientes();
	}

}
