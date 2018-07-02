package com.examen.agenda.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examen.agenda.service.PersonaService;
import com.examen.agenda.service.TipoPersonaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("contacto")
@Api(value = "contacto", consumes="application/json", tags="Contacto")
public class ContactoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);

	@Autowired
	private TipoPersonaService tipoPersonaService;
	
	
	@Autowired
	private PersonaService personaService;
	

    

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



}
