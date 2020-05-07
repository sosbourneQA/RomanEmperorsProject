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
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

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
        this.testEmpWithId.setId(this.id);
        this.empDTO = this.mapToDTO(testEmpWithId);
    }

    @Test
    public void

}
