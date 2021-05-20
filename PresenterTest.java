package com.example.appb;

import android.content.ContentResolver;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PresenterTest extends TestCase {

    @Mock
    private ContentResolver contentResolver;

    //@Mock
    private Presenter presenter;

    /*@Test
    public void addition_isCorrect(){
        assertEquals(4,2+2);
    }*/

    @Before
    public void beforeTest(){
        //contentResolver = mock(ContentResolver.class);
        //presenter = new Presenter(contentResolver);
    }

    @Test
    public void testInsert(){
        contentResolver = mock(ContentResolver.class);
        presenter = new Presenter(contentResolver);
        presenter.setCnt(3);
        for(int i=0;i<10;i++){
            presenter.insert();
        }
        assertEquals(3, presenter.getCnt());
        //verify(presenter).insert();

        //two actions under here doesn't have mean in test
        assertTrue(presenter!=null);
        assertNotNull(presenter);

        //presenter = null;
    }

    @After
    public void afterTest(){
        presenter = null;
    }
}