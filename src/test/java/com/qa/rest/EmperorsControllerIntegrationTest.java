package com.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Emperor;
import com.qa.dto.EmperorDTO;
import com.qa.repo.EmperorsRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmperorsControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private EmperorsRespository repo;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Emperor testEmp;

    private Emperor testEmpWithID;

    private long id;

    private EmperorDTO empDTO;

    private EmperorDTO mapToDTO(Emperor emp){
        return this.mapper.map(emp, EmperorDTO.class);
    }

    @Before
    public void setUp(){
        this.repo.deleteAll();
        this.testEmp = new Emperor("name", "date", "date");
        this.testEmpWithID = this.repo.save(testEmp);
        this.id = testEmpWithID.getId();
        this.empDTO = this.mapToDTO(testEmpWithID);
    }

    @Test
    public void getAllNotesTest() throws Exception {
        List<EmperorDTO> noteDTOList = new ArrayList<>();
        noteDTOList.add(empDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllNotes")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(noteDTOList));
    }

    @Test
    public void getNoteByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getNoteById/" + this.id)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(empDTO));
    }

    @Test
    public void createNoteTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createNote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(testEmp))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(empDTO));
    }

    @Test
    public void deleteNoteTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteNote/" + this.id)
        ).andExpect(status().isNoContent());
    }


}