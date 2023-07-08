package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    @Mock
    private Feline feline;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testKittens(){
        when(feline.getKittens()).thenReturn(1);
        int actualKittens=lion.getKittens();
        MatcherAssert.assertThat("Где котята Львовски", feline.getKittens(), is(actualKittens));
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }
    @Test
    public void testException() {
        try {
            new Lion("Гермафродит", feline);
        } catch (Exception actualException) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", actualException.getMessage());
        }
    }
}