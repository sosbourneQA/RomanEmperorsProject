package com.qa.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleDtoUnitTest {

    private ArticleDTO article;
    private ArticleDTO other;

    @Before
    public void setUp(){
        article = new ArticleDTO(1L, "test article");
        other = new ArticleDTO(1L, "test article");
    }

    @Test
    public void settersTest(){
        assertNotNull(article.getId());
        assertNotNull(article.getText());

        article.setId(null);
        assertNull(article.getId());
        article.setText(null);
        assertNull(article.getText());
    }

    @Test
    public void equalsWithNull(){
        assertFalse(article.equals(null));
    }

    @Test
    public void equalsWithDifferentObject(){
        assertFalse(article.equals(new Object()));
    }

    @Test
    public void createPlayWithId(){
        assertEquals(1L, article.getId(),0);
        assertEquals("test article", article.getText());
    }

    @Test
    public void checkEquality(){
        assertTrue(article.equals(article));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects(){
        assertTrue(article.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void playsIdNullButOtherIdNotNull(){
        article.setId(null);
        assertFalse(article.equals(other));
    }

    @Test
    public void playsIdNotEqual(){
        other.setId(2L);
        assertFalse(article.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void checkEqualityBetweenDifferentObjectsNullDescription(){
        article.setText(null);
        other.setText(null);
        assertTrue(article.equals(other));
    }

    @Test
    public void constructorWithoutId(){
        ArticleDTO plays = new ArticleDTO("test");
        assertNull(plays.getId());
        assertNotNull(plays.getText());
    }

    @Test
    public void emptyConstructor(){
        ArticleDTO plays = new ArticleDTO();
        assertNull(plays.getId());
    }

    @Test
    public void hashCodeTestWithNull(){
        ArticleDTO play = new ArticleDTO(null, null);
        ArticleDTO other = new ArticleDTO(null, null);
        assertEquals(play.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTest(){
        assertEquals(article.hashCode(), other.hashCode());
    }

}
