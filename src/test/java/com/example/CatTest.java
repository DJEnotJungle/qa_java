package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @InjectMocks
    private Cat cat;

    @Test
    public void testVoice(){
        MatcherAssert.assertThat("Ты слышишь мяу? А оно где-то есть.", "Мяу", is(cat.getSound()));
    }
    @Test
    public void testFood() throws Exception {
        List<String> actualFood = (new Cat(new Feline())).getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        MatcherAssert.assertThat("Вот что я люблю", expectedFood, is(actualFood));
    }
}