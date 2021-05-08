package com.citapelu.clientservice.application;

import com.citapelu.clientservice.VO.Center;
import com.citapelu.clientservice.VO.ResponseTemplateVO;
import com.citapelu.clientservice.domain.Client;
import com.citapelu.clientservice.domain.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public ResponseTemplateVO getClientById(Long clientId) {

        Optional<Client> clientOpt = clientRepository.findById(clientId);

        if (clientOpt.isPresent()){
            Client client = clientOpt.get();

            RestTemplate restTemplate = new RestTemplate();
            Center center = restTemplate.getForObject("http://center-app:8082/centers/get/" + client.getCenterId(), Center.class);

            return new ResponseTemplateVO(client, center);

        } else {
            throw new IllegalArgumentException();
        }
    }




    /*
    public Client linkClientToCenter(Long clientId, Long centerId) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        Center center = null;


        if (clientOpt.isPresent()){
            Client client = clientOpt.get();
            Set<Center> centerList = client.getCenterList();

            Optional<Center> centerOpt = centerRepository.findById(centerId);

            if (centerOpt.isPresent()){

                center = centerOpt.get();

            } else {
                RestTemplate restTemplate = new RestTemplate();
                center = restTemplate.getForObject("http://localhost:8082/centers/get/" + centerId, Center.class);
                centerRepository.save(center);

            }


            centerList.add(center);
            return clientRepository.save(client);

        } else {
            throw new IllegalArgumentException();
        }

    }

     */
}
