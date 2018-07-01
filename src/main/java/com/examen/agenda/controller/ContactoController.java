package com.examen.agenda.controller;


import com.examen.agenda.domain.PersonaEmpresaDTO;
import com.examen.agenda.service.PersonaEmpresaService;
import com.examen.agenda.service.PersonaService;
import com.examen.agenda.service.TipoPersonaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("contacto")
@Api(value = "contacto", consumes="application/json", tags="Contacto")
public class ContactoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);

	@Autowired
	private TipoPersonaService tipoPersonaService;
	
	@Autowired
	private PersonaEmpresaService personaEmpresaService;
	
	@Autowired
	private PersonaService personaService;
	
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


    @ApiOperation(value = "tipoPersona", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @RequestMapping(value = "/tipoPersona/{query}", method = RequestMethod.GET)
    public Object query(@PathVariable("query") String query ) throws Exception {


        logger.debug("sql: " + query );

        return tipoPersonaService.getTiposPersona();
    }

    @ApiOperation(value = "getAllTipoPersona", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @RequestMapping(value = "/getAllTipoPersona", method = RequestMethod.GET)
    public Object getAllTipoPersona() throws Exception {


        return tipoPersonaService.getTiposPersona();
    }

    @ApiOperation(value = "delete", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @RequestMapping(value = "/delete/{idPersona}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("idPersona") Integer idPersona ) throws Exception {

    	personaService.deletePersona(idPersona);

        return "delete success";
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

}
