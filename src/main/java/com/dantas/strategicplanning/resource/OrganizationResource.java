package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.Organization;
import com.dantas.strategicplanning.repository.OrganizationRepository;
import com.dantas.strategicplanning.service.OrganizationService;
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

    @Autowired
    OrganizationService organizationService;

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

    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable Long id , @Valid @RequestBody Organization organization){

        Organization updatedOrganization = organizationService.updateOrganizationProperties(id,organization);

        return ResponseEntity.status(HttpStatus.OK).body(updatedOrganization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Organization> deleteOrgById(@PathVariable Long id){
        organizationRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
