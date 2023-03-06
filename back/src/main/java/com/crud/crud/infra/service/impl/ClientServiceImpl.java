package com.crud.crud.infra.service.impl;

import com.crud.crud.domain.entity.client.Client;
import com.crud.crud.domain.repository.ClientRepository;
import com.crud.crud.infra.rest.dto.ClientDTO;
import com.crud.crud.infra.rest.exception.BadRequestException;
import com.crud.crud.infra.rest.exception.NotFoundException;
import com.crud.crud.infra.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private  final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> getAll() {

        List<Client> clients = this.clientRepository.findAll();

        List<ClientDTO> clientDTOS = this.convertListDTO(clients);

        return clientDTOS;
    }

    @Override
    public ClientDTO getById(Long id) {

        Client client = this.validExistClient(id);

        ClientDTO clientDTO = new ClientDTO();

        BeanUtils.copyProperties(client,clientDTO);

        return clientDTO;
    }

    @Override
    public ClientDTO updateById(Long id, ClientDTO clientDTO) {

        Client client = this.validExistClient(id);

        this.validFildsUpdateClient(clientDTO,client);

        client = this.clientRepository.save(client);

        BeanUtils.copyProperties(client, clientDTO);

        return clientDTO;
    }

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {

        this.validFildsClient(clientDTO);

        Client client = new Client();

        BeanUtils.copyProperties(clientDTO, client);

        client = this.clientRepository.save(client);

        BeanUtils.copyProperties(client, clientDTO);

        return clientDTO;
    }

    @Override
    public void deleteById(Long id) {

        Client client = this.validExistClient(id);

        this.clientRepository.delete(client);

    }

    private void validFildsClient(ClientDTO clientDTO){

        if(Objects.isNull(clientDTO)){
           throw new BadRequestException("objeto vazio.");
        }
    }

    private Client validExistClient(Long id){

        Optional<Client> client = this.clientRepository.findById(id);

        if (!client.isPresent()){
            throw new NotFoundException("cliente não encontrado.");
        }

     return client.get();
    }

    private void validFildsUpdateClient(ClientDTO clientDTO, Client client){

        if (clientDTO.getName() != null){
            client.setName(clientDTO.getName());
        }
        if (clientDTO.getBirth() != null){
            client.setBirth(clientDTO.getBirth());
        }
        if (clientDTO.getFone() != null){
            client.setFone(clientDTO.getFone());
        }
        if (clientDTO.getEmail() != null){
            client.setEmail(clientDTO.getEmail());
        }
        if (clientDTO.getJob() != null){
            client.setJob(clientDTO.getJob());
        }
    }
    private List<ClientDTO> convertListDTO(List<Client> clients){

        List<ClientDTO> clientDTOS = new ArrayList<>();

        clientDTOS = clients.stream().map(client -> {

            ClientDTO clientDTO = new ClientDTO();

            BeanUtils.copyProperties(client,clientDTO);

            return clientDTO;

        }).collect(Collectors.toList());

        return clientDTOS;
    }
}
