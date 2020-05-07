package com.qa.service;


import com.qa.domain.Historian;
import com.qa.dto.HistorianDTO;
import com.qa.exceptions.HistorianNotFoundException;
import com.qa.repo.HistoriansRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistorianService {

    private final HistoriansRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public HistorianService(HistoriansRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private HistorianDTO mapToDTO(Historian hist) {
        return this.mapper.map(hist, HistorianDTO.class);
    }

    public List<HistorianDTO> readHistorians() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public HistorianDTO createEmperor(Historian hist) {
        Historian tempHist = this.repo.save(hist);
        return this.mapToDTO(tempHist);
    }

    public HistorianDTO findHistorianById(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow(HistorianNotFoundException::new));
    }

    public HistorianDTO updateHistorian(Long id, Historian hist) {
        Historian update = this.repo.findById(id).orElseThrow(HistorianNotFoundException::new);
        update.setName(hist.getName());
        update.setSpeciality(hist.getSpeciality());
        Historian tempHist = this.repo.save(hist);
        return this.mapToDTO(tempHist);
    }

    public boolean deleteHistorian(Long id) {
        if(!this.repo.existsById(id)) {
            throw new HistorianNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}