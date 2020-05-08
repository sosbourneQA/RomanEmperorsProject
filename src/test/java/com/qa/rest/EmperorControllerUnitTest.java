package com.qa.rest;

import com.qa.domain.Emperor;
import com.qa.dto.EmperorDTO;
import com.qa.service.EmperorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmperorControllerUnitTest {

    @InjectMocks
    private EmperorController controller;

    @Mock
    private EmperorService service;

    private List<Emperor> emperors;

    private Emperor testEmp;

    private Emperor testEmpWithId;

    private long id = 1L;

    private EmperorDTO empDTO;

    private final ModelMapper mapper = new ModelMapper();

    private final EmperorDTO mapToDTO(Emperor emp) {
        return this.mapper.map(emp, EmperorDTO.class);
    }

    @Before
    public void setUp() {
        this.emperors = new ArrayList<>();
        this.testEmp = new Emperor("name", "date", "date");
        this.emperors.add(testEmp);
        this.testEmpWithId = new Emperor(testEmp.getName(), testEmp.getReignStart(), testEmp.getReignEnd());
        this.testEmpWithId.setId(this.id);
        this.empDTO = this.mapToDTO(testEmpWithId);
    }

    @Test
    public void getAllEmperorsTest() {
        when(service.readEmperors()).thenReturn(this.emperors.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No emperors found", this.controller.getAllEmperors().getBody().isEmpty());
        verify(service, times(1)).readEmperors();
    }

    @Test
    public void createEmperorsTest() {
        when(this.service.createEmperor(testEmp)).thenReturn(this.empDTO);
        assertEquals(this.controller.createEmperor(testEmp), new ResponseEntity<EmperorDTO>(this.empDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createEmperor(testEmp);
    }

    @Test
    public void deleteEmperorTestFalse() {
        this.controller.deleteEmperor(id);
        verify(service, times(1)).deleteEmperor(id);
    }

    @Test
    public void deleteEmperorTestTrue() {
        when(service.deleteEmperor(3L)).thenReturn(true);
        this.controller.deleteEmperor(3L);
        verify(service, times(1)).deleteEmperor(3L);
    }

    @Test
    public void getEmperorByIdTest() {
        when(this.service.findEmperorById(id)).thenReturn(this.empDTO);
        assertEquals(this.controller.getEmperorById(id), new ResponseEntity<EmperorDTO>(this.empDTO, HttpStatus.OK));
        verify(service, times(1)).findEmperorById(id);
    }

}
