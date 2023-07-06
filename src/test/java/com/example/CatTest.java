package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    private Feline feline;
    @InjectMocks
    private Cat cat;

    @Test
    public void testVoice(){
        MatcherAssert.assertThat("Ты слышишь мяу? А оно где-то есть.", "Мяу", is(cat.getSound()));
    }
    @Test
    public void testFood() throws Exception {
        when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        MatcherAssert.assertThat("Вот что я люблю", expectedFood, is(cat.getFood()));
    }
}