package com.crud.crud.infra.service;

import com.crud.crud.domain.entity.client.Client;
import com.crud.crud.infra.rest.dto.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ClientService {

    List<ClientDTO> getAll();

    ClientDTO getById(Long id);

    ClientDTO updateById(Long id, ClientDTO clientDTO);

    ClientDTO addClient(ClientDTO clientDTO);

    void deleteById(Long id);


}
