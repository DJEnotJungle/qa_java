package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    public static final List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    @Spy
    private Feline feline;

    @Test
    public void hunterFeline() throws Exception {
        MatcherAssert.assertThat("Это не удачливый охотник", expectedFood, is(feline.eatMeat()));
    }

    @Test
    public void isItACat(){
        MatcherAssert.assertThat("Я не котик", "Кошачьи", is(feline.getFamily()));
    }
    @Test
    public void howManyKittens(){
        MatcherAssert.assertThat("Где котята Мурковски", 1, is(feline.getKittens()));
    }
}