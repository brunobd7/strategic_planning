package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.Organization;
import com.dantas.strategicplanning.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @PostMapping
    public ResponseEntity<Organization> createOrganization(@Valid @RequestBody Organization organization){

        //todo refactor to return location into response header using httpServletResponse.
        Organization organizationCreated = organizationRepository.save(organization);

        return ResponseEntity.status(HttpStatus.CREATED).body(organizationCreated);
    }
}
