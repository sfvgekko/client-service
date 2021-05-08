package com.citapelu.clientservice.infraestructure;

import com.citapelu.clientservice.VO.ResponseTemplateVO;
import com.citapelu.clientservice.application.ClientService;
import com.citapelu.clientservice.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Slf4j
public class ClientAPI {

    @Autowired
    ClientService clientService;


    @PutMapping("/add")
    public Client addClient(@RequestBody Client client){
        log.info("adding client");
        return clientService.addClient(client);
    }

    @GetMapping("/getAll")
    public List<Client> getClients(){
        log.info("get all clients");
        return clientService.getClients();
    }

    @GetMapping("/get/{clientId}")
    public ResponseTemplateVO getClientById(@PathVariable Long clientId){
        log.info("get client vo");
        return clientService.getClientById(clientId);
    }

    /*
    @PutMapping("/link/{clientId}/{centerId}")
    public Client linkClientToCenter(@PathVariable Long clientId, @PathVariable Long centerId){
        return clientService.linkClientToCenter(clientId, centerId);
    }
    */

}
