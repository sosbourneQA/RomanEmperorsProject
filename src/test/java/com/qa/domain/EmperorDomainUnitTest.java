package com.qa.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class EmperorDomainUnitTest {

    private Emperor emperor;
    private Emperor other;

    @Before
    public void setUp(){
        emperor = new Emperor(1L, "name", "start date", "end date");
        other = new Emperor(1L, "name", "start date", "end date");
    }

    @Test
    public void settersTest(){
        assertNotNull(emperor.getId());
        assertNotNull(emperor.getName());
        assertNotNull(emperor.getReignStart());
        assertNotNull(emperor.getReignEnd());

        emperor.setId(null);
        assertNull(emperor.getId());
        emperor.setName(null);
        assertNull(emperor.getName());
        emperor.setReignStart(null);
        assertNull(emperor.getReignStart());
        emperor.setReignEnd(null);
        assertNull(emperor.getReignEnd());
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
    public void createPlayWithId(){
        assertEquals(1L, emperor.getId(),0);
        assertEquals("test play", emperor.getName());
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
    public void playsIdNullButOtherIdNotNull(){
        emperor.setId(null);
        assertFalse(emperor.equals(other));
    }

    @Test
    public void playsIdNotEqual(){
        other.setId(2L);
        assertFalse(emperor.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void checkEqualityBetweenDifferentObjectsNullDescription(){
        emperor.setName(null);
        other.setName(null);
        assertTrue(emperor.equals(other));
    }

    @Test
    public void constructorWithoutId(){
        Emperor emperor = new Emperor("name", "start date", "end date");
        assertNull(emperor.getId());
        assertNotNull(emperor.getName());
    }

    @Test
    public void emptyConstructor(){
        Emperor plays = new Emperor();
        assertNull(plays.getId());
    }

    @Test
    public void hashCodeTestWithNull(){
        Emperor emperor = new Emperor(null, null, null);
        Emperor other = new Emperor(null, null, null);
        assertEquals(emperor.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTest(){
        assertEquals(emperor.hashCode(), other.hashCode());
    }

}
