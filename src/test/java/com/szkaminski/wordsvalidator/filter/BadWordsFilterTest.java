package com.szkaminski.wordsvalidator.filter;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

public class BadWordsFilterTest {

    private BadWordsFilter wordsFilter;

    @Before
    public void setUp() throws IOException {
        wordsFilter = new BadWordsFilter();
    }

    @Test
    public void isChecked() {
        assertTrue(wordsFilter.isChecked("Notavulgarism"));
    }

    @Test
    public void notChecked(){
        assertFalse(wordsFilter.isChecked("kurwa"));
    }

    @Test
    public void getWordsList() {
        Method[] methods = BadWordsFilter.class.getMethods();
        boolean getWordsList = false;
        for (Method m : methods){
            getWordsList = m.equals("getWordsList");
        }
        assertNotNull(getWordsList);
    }

    @Test
    public void getWordsFilter(){
        List<String> method = BadWordsFilter.getWordsList();

        assertNotNull(method);

        assertFalse(method.isEmpty());

    }
}
