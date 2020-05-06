package com.qa.service;


import com.qa.repo.EmperorsRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmperorService {

    private final EmperorsRespository repo;
    private final ModelMapper mapper;

    @Autowired
    public EmperorService(EmperorsRespository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

}
