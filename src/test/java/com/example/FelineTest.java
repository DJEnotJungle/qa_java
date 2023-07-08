package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @InjectMocks
    private Feline feline;

    @Test
    public void hunterFeline() throws Exception {
        List<String> actualFood = (new Feline()).eatMeat();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        MatcherAssert.assertThat("Вот что я люблю", expectedFood, is(actualFood));
    }
    @Test
    public void isItACat(){
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        MatcherAssert.assertThat("Я не котик", expectedFamily, is(actualFamily));
    }
    @Test
    public void howManyKittens(){
        MatcherAssert.assertThat("Где котята Мурковски", 1, is(feline.getKittens()));
    }
}