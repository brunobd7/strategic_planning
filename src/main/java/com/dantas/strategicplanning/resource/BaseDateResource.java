package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.BaseDate;
import com.dantas.strategicplanning.repository.BaseDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base_dates")
public class BaseDateResource {

    @Autowired
    BaseDateRepository baseDateRepository;

    @GetMapping
    public List<BaseDate> listAll(){
        return baseDateRepository.findAll();
    }

}
