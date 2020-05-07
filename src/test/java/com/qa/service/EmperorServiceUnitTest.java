package com.qa.service;


import com.qa.domain.Emperor;
import com.qa.dto.EmperorDTO;
import com.qa.exceptions.EmperorNotFoundException;
import com.qa.repo.EmperorsRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EmperorServiceUnitTest {

    @InjectMocks
    private ArticleService service;

    @Mock
    private EmperorsRespository repo;

    @Mock
    private ModelMapper mapper;

    private List<Emperor> empList;

    private Emperor testEmp;

    private long id = 1L;

    private Emperor testEmpWithId;

    private EmperorDTO emperorDTO;

    private EmperorDTO mapToDTO(Emperor emp) {
        return this.mapper.map(emp, EmperorDTO.class);
    }

    @Before
    public void setUp() {
        this.empList = new ArrayList<>();
        this.testEmp = new Emperor("Trajan", "98 AD", "117 AD");
        this.empList.add(testEmp);
        this.testEmpWithId = new Emperor(testEmp.getName(), testEmp.getReignStart(), testEmp.getReignEnd());
        this.testEmpWithId.setId(id);
        this.emperorDTO = this.mapToDTO(testEmpWithId);
    }

    @Test
    public void getAllEmperorsTest() {
        when(repo.findAll()).thenReturn(this.empList);
        when(this.mapper.map(testEmpWithId, EmperorDTO.class)).thenReturn(emperorDTO);
        assertFalse("Service returned no Emperos", this.service.readEmperors().isEmpty());
        verify(repo, times(1)).findAll();
    }

    @Test
    public void createEmperorTest() {
        when(repo.save(testEmp)).thenReturn(testEmpWithId);
        when(this.mapper.map(testEmpWithId, EmperorDTO.class)).thenReturn(emperorDTO);
        assertEquals(this.service.createEmperor(testEmp), this.emperorDTO);
        verify(repo, times(1)).save(this.testEmp);
    }

    @Test
    public void findEmperorByIdTest() {
        when(this.repo.findById(id)).thenReturn(java.util.Optional.ofNullable(testEmpWithId));
        when(this.mapper.map(testEmpWithId, EmperorDTO.class)).thenReturn(emperorDTO);
        assertEquals(this.service.findEmperorById(this.id), emperorDTO);
        verify(repo, times(1)).findById(id);
    }

    @Test
    public void deleteEmperorById() {
        when(this.repo.existsById(id)).thenReturn(true, false);
        assertFalse(service.deleteEmperor(id));
        verify(repo, times(1)).deleteById(id);
        verify(repo, times(2)).existsById(id);
    }

    @Test(expected = EmperorNotFoundException.class)
    public void deleteEmperorByNonExistingId() {
        when(this.repo.existsById(id)).thenReturn(false);
        service.deleteEmperor(id);
        verify(repo, times(1)).existsById(id);
    }


}
