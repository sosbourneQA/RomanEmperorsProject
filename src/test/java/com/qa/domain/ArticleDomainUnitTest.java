package com.qa.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleDomainUnitTest {
//  13 Tests

    private Article article;
    private Article other;

    @Before
    public void setUp(){
        article = new Article(1L, "test article");
        other = new Article(1L, "test article");
    }

    @Test
    public void settersTest(){
        assertNotNull(article.getId());
        assertNotNull(article.getText());
//        assertNull(article.getEmperor());

        article.setId(null);
        assertNull(article.getId());
        article.setText(null);
        assertNull(article.getText());
//        article.setEmperor(null);
//        assertNull(article.getEmperor());
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
    public void createArticleWithId(){
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
    public void articleIdNullButOtherIdNotNull(){
        article.setId(null);
        assertFalse(article.equals(other));
    }

    @Test
    public void articleIdNotEqual(){
        other.setId(2L);
        assertFalse(article.equals(other));
    }

//    @Test(expected = NullPointerException.class)
//    public void checkEqualityBetweenDifferentObjectsNullDescription(){
//        article.setText(null);
//        other.setText(null);
//        assertTrue(article.equals(other));
//    }

    @Test
    public void constructorWithoutId(){
        Article article = new Article("test");
        assertNull(article.getId());
        assertNotNull(article.getText());
    }

    @Test
    public void emptyConstructor(){
        Article article = new Article();
        assertNull(article.getId());
    }

    @Test
    public void hashCodeTestWithNull(){
        Article article = new Article(null, null);
        Article other = new Article(null, null);
        assertEquals(article.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTest(){
        assertEquals(article.hashCode(), other.hashCode());
    }

}
