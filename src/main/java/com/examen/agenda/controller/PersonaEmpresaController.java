package com.examen.agenda.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examen.agenda.domain.PersonaEmpresaDTO;
import com.examen.agenda.service.PersonaEmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("contacto")
@Api(value = "contacto", consumes="application/json", tags="Contacto")
public class PersonaEmpresaController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonaEmpresaController.class);

	@Autowired
	private PersonaEmpresaService personaEmpresaService;
	
	@ApiOperation(value = "alta", produces="application/json")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
            })
	@RequestMapping(value = "/alta", method = RequestMethod.PUT)
	public Object alta(@RequestBody @Valid PersonaEmpresaDTO personaEmpresaDTO) throws Exception {
		
		personaEmpresaService.add(personaEmpresaDTO);
		
		return personaEmpresaService.findAll();
	}


    @ApiOperation(value = "getPersonaEmpresa", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @RequestMapping(value = "/getPersona/{idPersona}", method = RequestMethod.GET)
    public Object getPersonaEmpresa(@PathVariable("idPersona") Integer idPersona ) throws Exception {

        return personaEmpresaService.findByPersonaId(idPersona);
    }
    


    @ApiOperation(value = "update", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public Object actualizar(@RequestBody @Valid PersonaEmpresaDTO personaEmpresaDTO) throws Exception {

        logger.debug("sql: " + personaEmpresaDTO.getPersonaDTO().getNombre());

        return personaEmpresaDTO.getPersonaDTO();
    }

    
    
    
    @ApiOperation(value = "getPersonas", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @RequestMapping(value = "/getPersonas", method = RequestMethod.GET)
    public Object getPersonas() throws Exception {

        return personaEmpresaService.findAll();
    }
    
    
    
    @ApiOperation(value = "getPersonasPorTipo", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @RequestMapping(value = "/getPersonasPorTipo/{idTipo}", method = RequestMethod.GET)
    public Object getPersonasPorTipo(@PathVariable("idTipo") Integer idTipo ) throws Exception {
 List<PersonaEmpresaDTO> resultado = new ArrayList<>();
    	if(idTipo!=null){
    		resultado= personaEmpresaService.findByTipoPersonaId(idTipo);
    	}
        return resultado;
    }
}
