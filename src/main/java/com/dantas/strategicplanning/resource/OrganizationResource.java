package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.Organization;
import com.dantas.strategicplanning.repository.OrganizationRepository;
import com.dantas.strategicplanning.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("/{id}")
    public ResponseEntity<Organization> findOrgById(@PathVariable Long id){

        Organization orgFounded = organizationRepository.findById(id).orElse(null);

        return Objects.nonNull(orgFounded) ? ResponseEntity.ok(orgFounded) : ResponseEntity.noContent().build();

    }


    @PostMapping
    public ResponseEntity<Organization> createOrganization(@Valid @RequestBody Organization organization, HttpServletResponse response){

        // TODO Apply spring events / publishing  always on create any resource into application
        Organization organizationCreated = organizationRepository.save(organization);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(organizationCreated.getId()).toUri();
//        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(organizationCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable Long id , @Valid @RequestBody Organization organization){

        Organization updatedOrganization = organizationService.updateOrganizationProperties(id,organization);

        return ResponseEntity.status(HttpStatus.OK).body(updatedOrganization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrgById(@PathVariable Long id){
        organizationRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
