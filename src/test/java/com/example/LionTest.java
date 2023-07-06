package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Lion lion;
    @Spy
    private Feline feline;

    @Before
    public void set() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testDoesHaveMane(){
        boolean expectedResult = true;
        boolean actualResult = lion.doesHaveMane();
        MatcherAssert.assertThat("Ты зачем сбрил гриву?", expectedResult, is(actualResult));
    }

    @Test
    public void testKittens(){
        when(lion.getKittens()).thenReturn(1);
        MatcherAssert.assertThat("Где котята Львовски", 1, is(lion.getKittens()));
    }
    @Test
    public void testFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(lion.getFood()).thenReturn(expectedFood);
        MatcherAssert.assertThat("Какая-то неправильная добыча у этих львов", expectedFood, is(lion.getFood()));
    }
}