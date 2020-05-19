package com.qa.service;


import com.qa.domain.Emperor;
import com.qa.dto.EmperorDTO;
import com.qa.exceptions.EmperorNotFoundException;
import com.qa.repo.ArticlesRepository;
import com.qa.repo.EmperorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmperorService {

    private final EmperorsRepository emperorsRepository;
    private final ArticlesRepository articlesRepository;
    private final ModelMapper mapper;

    @Autowired
    public EmperorService(EmperorsRepository emperorsRepository, ArticlesRepository articlesRepository, ModelMapper mapper) {
        this.emperorsRepository = emperorsRepository;
        this.articlesRepository = articlesRepository;
        this.mapper = mapper;
    }

    private EmperorDTO mapToDTO(Emperor emperor) {
        return this.mapper.map(emperor, EmperorDTO.class);
    }

    public List<EmperorDTO> readEmperors() {
        return this.emperorsRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public EmperorDTO createEmperor(Emperor emp) {
        return this.mapToDTO(this.emperorsRepository.save(emp));
    }

    public EmperorDTO findEmperorById(Long id) {
        return this.mapToDTO(this.emperorsRepository.findById(id).orElseThrow(EmperorNotFoundException::new));
    }

    public EmperorDTO updateEmperor(Long id, Emperor emp) {
        Emperor update = this.emperorsRepository.findById(id).orElseThrow(EmperorNotFoundException::new);
        update.setName(emp.getName());
        update.setReignStart(emp.getReignStart());
        update.setReignStart(emp.getReignEnd());
        Emperor tempEmp = this.emperorsRepository.save(emp);
        return this.mapToDTO(tempEmp);
    }

    public boolean deleteEmperor(Long id) {
        if(!this.emperorsRepository.existsById(id)) {
            throw new EmperorNotFoundException();
        }
        this.emperorsRepository.deleteById(id);
        return this.emperorsRepository.existsById(id);
    }



}
