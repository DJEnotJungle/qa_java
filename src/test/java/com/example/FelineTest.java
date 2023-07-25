package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

public class FelineTest {
    Feline feline = new Feline();
    @Test
    public void hunterFeline() throws Exception {
        List<String> actualFood = feline.eatMeat();
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
        int kittensCount = 1;
        int actualKittens = feline.getKittens();
        MatcherAssert.assertThat("Где котята Мурковски", kittensCount, is(actualKittens));
    }
}