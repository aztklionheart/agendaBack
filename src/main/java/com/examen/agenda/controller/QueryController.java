package com.examen.agenda.controller;


import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examen.agenda.domain.EmpresaDTO;
import com.examen.agenda.domain.PersonaDTO;
import com.examen.agenda.service.EmpresaService;
import com.examen.agenda.service.PersonaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("autocomplete")
@Api(value = "autocomplete", consumes="application/json", tags="funcion de Autocomplete")
public class QueryController {
	
	private static final Logger logger = LoggerFactory.getLogger(QueryController.class);

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private PersonaService personaService;
	
	@ApiOperation(value = "empresa", produces="application/json")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
            })
	@RequestMapping(value = "/empresa/{query}", method = RequestMethod.GET)
	public Object queryEmpresa(@PathVariable("query") String query) throws SQLException {

		List<EmpresaDTO>  lstEmpresaDTO = empresaService.autocompleteEmpresas(query);
		
		logger.debug("sql: " + query);
		
		return lstEmpresaDTO;
	}
	
	@ApiOperation(value = "persona", produces="application/json")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
            })
	@RequestMapping(value = "/persona/{query}", method = RequestMethod.GET)
	public Object queryPersona(@PathVariable("query") String query) throws SQLException {

		List<PersonaDTO>  lstPersonaDTO = personaService.autocomplete(query);
		
		logger.debug("sql: " + query);
		
		return lstPersonaDTO;
	}
	
}
