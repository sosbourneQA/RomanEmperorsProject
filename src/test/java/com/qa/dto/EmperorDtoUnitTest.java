package com.qa.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class EmperorDtoUnitTest {
//    13 Tests

    private EmperorDTO emperor;
    private EmperorDTO other;
    private List<ArticleDTO> articles;

    @Before
    public void setUp(){
        emperor = new EmperorDTO(1L, "name", "start date", "end date", articles);
        other = new EmperorDTO(1L, "name", "start date", "end date", articles);
    }

    @Test
    public void settersTest(){
        assertNotNull(emperor.getId());
        assertNotNull(emperor.getName());
        assertNotNull(emperor.getReignStart());
        assertNotNull(emperor.getReignEnd());
        assertNull(emperor.getArticles());


        emperor.setId(null);
        assertNull(emperor.getId());
        emperor.setName(null);
        assertNull(emperor.getName());
        emperor.setReignStart(null);
        assertNull(emperor.getReignStart());
        emperor.setReignEnd(null);
        assertNull(emperor.getReignEnd());
        emperor.setArticles(null);
        assertNull(emperor.getArticles());
    }

    @Test
    public void equalsWithNull(){
        assertFalse(emperor.equals(null));
    }

    @Test
    public void equalsWithDifferentObject(){
        assertFalse(emperor.equals(new Object()));
    }

    @Test
    public void createEmperorWithId(){
        assertEquals(1L, emperor.getId(),0);
        assertEquals("name", emperor.getName());
        assertEquals("start date", emperor.getReignStart());
        assertEquals("end date", emperor.getReignEnd());
        assertEquals(null, emperor.getArticles());
    }

    @Test
    public void checkEquality(){
        assertTrue(emperor.equals(emperor));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects(){
        assertTrue(emperor.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void emperorIdNullButOtherIdNotNull(){
        emperor.setId(null);
        assertFalse(emperor.equals(other));
    }

    @Test
    public void emperorIdNotEqual(){
        other.setId(2L);
        assertFalse(emperor.equals(other));
    }

//    @Test(expected = NullPointerException.class)
//    public void checkEqualityBetweenDifferentObjectsNullDescription(){
//        emperor.setName(null);
//        other.setName(null);
//        assertTrue(emperor.equals(other));
//    }

    @Test
    public void constructorWithoutId(){
        EmperorDTO emperor = new EmperorDTO("name", "start date", "end date", articles);
        assertNull(emperor.getId());
        assertNotNull(emperor.getName());
        assertNotNull(emperor.getReignStart());
        assertNotNull(emperor.getReignEnd());
        assertNull(emperor.getArticles());
    }

    @Test
    public void emptyConstructor(){
        EmperorDTO playbook = new EmperorDTO();
        assertNull(playbook.getId());
    }

    @Test
    public void hashCodeTestWithNull(){
        EmperorDTO playbook = new EmperorDTO(null, null, null, null);
        EmperorDTO other = new EmperorDTO(null, null, null, null);
        assertEquals(playbook.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTest(){
        assertEquals(emperor.hashCode(), other.hashCode());
    }
}
