package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.Organization;
import com.dantas.strategicplanning.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationResource {

    @Autowired
    OrganizationRepository organizationRepository;


    @GetMapping
    public List<Organization> listAll(){
        return organizationRepository.findAll();
    }
}
