package com.course.fullstackprojectbackend.resources;

import com.course.fullstackprojectbackend.domain.Category;
import com.course.fullstackprojectbackend.domain.Client;
import com.course.fullstackprojectbackend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id){
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

}
