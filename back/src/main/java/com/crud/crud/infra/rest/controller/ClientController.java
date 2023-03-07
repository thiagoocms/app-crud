package com.crud.crud.infra.rest.controller;

import com.crud.crud.infra.rest.dto.ClientDTO;
import com.crud.crud.infra.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "",
            produces = "application/json"
    )
    public ResponseEntity<List<ClientDTO>> findAll(){

        List<ClientDTO> clientDTOS = this.clientService.getAll();

        return new ResponseEntity<>(clientDTOS, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<ClientDTO> findById(@PathVariable(name="id") Long id){

        ClientDTO clientDTO = this.clientService.getById(id);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            produces = "application/json"
    )
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO dto){

        ClientDTO clientDTO = this.clientService.addClient(dto);

        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<ClientDTO> updateById(@PathVariable(name="id") Long id, @RequestBody ClientDTO dto){

        ClientDTO clientDTO = this.clientService.updateById(id, dto);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<Void> deleteById(@PathVariable(name="id") Long id){

        this.clientService.deleteById(id);

        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }




}
