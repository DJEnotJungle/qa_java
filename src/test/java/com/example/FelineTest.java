package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void hunterFeline() throws Exception {
        List<String> actualFood = (new Feline()).eatMeat();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        MatcherAssert.assertThat("Вот что я люблю", expectedFood, is(actualFood));
    }
    @Test
    public void isItACat(){
        String expectedFamily = "Кошачьи";
        when(feline.getFamily()).thenReturn(expectedFamily);
        String actualFamily = feline.getFamily();
        MatcherAssert.assertThat("Я не котик", expectedFamily, is(actualFamily));
    }
    @Test
    public void howManyKittens(){
        int kittensCount = 1;
        when(feline.getKittens()).thenReturn(kittensCount);
        int actualKittens = feline.getKittens();
        MatcherAssert.assertThat("Где котята Мурковски", kittensCount, is(actualKittens));
    }
}