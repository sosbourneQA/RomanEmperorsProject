package com.qa.service;


import com.qa.domain.Emperor;
import com.qa.dto.EmperorDTO;
import com.qa.exceptions.EmperorNotFoundException;
import com.qa.repo.EmperorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmperorService {

    private final EmperorsRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public EmperorService(EmperorsRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private EmperorDTO mapToDTO(Emperor emp) {
        return this.mapper.map(emp, EmperorDTO.class);
    }

    public List<EmperorDTO> readEmperors() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public EmperorDTO createEmperor(Emperor emp) {
        Emperor tempEmp = this.repo.save(emp);
        return this.mapToDTO(tempEmp);
    }

    public EmperorDTO findEmperorById(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow(EmperorNotFoundException::new));
    }

    public EmperorDTO updateEmperor(Long id, Emperor emp) {
        Emperor update = this.repo.findById(id).orElseThrow(EmperorNotFoundException::new);
        update.setName(emp.getName());
        update.setReignStart(emp.getReignStart());
        update.setReignStart(emp.getReignEnd());
        Emperor tempEmp = this.repo.save(emp);
        return this.mapToDTO(tempEmp);
    }

    public boolean deleteEmperor(Long id) {
        if(!this.repo.existsById(id)) {
            throw new EmperorNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }



}
