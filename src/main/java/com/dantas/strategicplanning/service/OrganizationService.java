package com.dantas.strategicplanning.service;

import com.dantas.strategicplanning.model.Organization;
import com.dantas.strategicplanning.repository.OrganizationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {


    @Autowired
    OrganizationRepository organizationRepository;

    public Organization updateOrganizationProperties(Long id , Organization organization){

        Organization orgSaved = this.findOrgById(id);
        BeanUtils.copyProperties(organization , orgSaved,"id");

        return organizationRepository.save(orgSaved);
    }

    public Organization findOrgById(Long id){
        Organization organizationSaved = organizationRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return organizationSaved;
    }
}
