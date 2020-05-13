package com.qa.service;

import com.qa.domain.Emperor;
import com.qa.dto.EmperorDTO;
import com.qa.repo.EmperorsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmperorServiceIntegrationTest {
//    4 Tests

    @Autowired
    private EmperorService service;

    @Autowired
    private EmperorsRepository repo;

    @Autowired
    private ModelMapper mapper;

    private Emperor testEmp;

    private Emperor testEmpWithId;

    private EmperorDTO mapToDTO(Emperor emp) {
        return this.mapper.map(emp, EmperorDTO.class);
    }

    @Before
    public void setUp() {
        this.repo.deleteAll();
        this.testEmp = new Emperor("name", "date", "date");
        this.testEmpWithId = this.repo.save(this.testEmp);

    }

    @Test
    public void readEmperorsTest() {
        assertThat(this.service.readEmperors()).isEqualTo(
                Stream.of(this.mapToDTO(testEmpWithId)).collect(Collectors.toList())
        );
    }

    @Test
    public void createEmperorTest() {
        assertEquals(this.mapToDTO(this.testEmpWithId), this.service.createEmperor(testEmp));
    }

    @Test
    public void findEmperorByIdTest() {
        assertThat(this.service.findEmperorById(this.testEmpWithId.getId())).isEqualTo(this.mapToDTO(this.testEmpWithId));
    }

    @Test
    public void deleteEmperorTest() {
        assertThat(this.service.deleteEmperor(this.testEmpWithId.getId())).isFalse();
    }
}

