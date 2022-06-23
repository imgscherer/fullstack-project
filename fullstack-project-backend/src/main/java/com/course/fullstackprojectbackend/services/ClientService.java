package com.course.fullstackprojectbackend.services;

import com.course.fullstackprojectbackend.domain.Category;
import com.course.fullstackprojectbackend.domain.Client;
import com.course.fullstackprojectbackend.repositories.ClientRepository;
import com.course.fullstackprojectbackend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client findById(Integer id){
        Optional<Client> client = repository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(
                "Object Not Found. ID: " + id + " Type: " + Category.class.getName()
        ));
    }


}
