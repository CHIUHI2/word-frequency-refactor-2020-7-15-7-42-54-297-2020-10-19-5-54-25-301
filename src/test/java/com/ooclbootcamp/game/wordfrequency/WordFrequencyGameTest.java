package com.ooclbootcamp.game.wordfrequency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.ooclbootcamp.game.wordfrequency.exception.CalculateErrorException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WordFrequencyGameTest {
    private WordFrequencyGame wordFrequencyGame = new WordFrequencyGame();

    @Test
    void should_return_the_1_when_get_result_given_the() throws CalculateErrorException {
        //given
        String sentence = "the";

        //when
        String result = wordFrequencyGame.getResult(sentence);

        //then
        assertEquals("the 1", result);
    }

    @Test
    void should_return_the_1_is_1_when_get_result_given_the_is() throws CalculateErrorException {
        //given
        String sentence = "the is";

        //when
        String result = wordFrequencyGame.getResult(sentence);

        //then
        assertEquals("the 1\nis 1", result);
    }

    @Test
    void should_return_the_1_is_1_when_get_result_given_the_is_with_special_spaces() throws CalculateErrorException {
        //given
        String sentence = "the      is";

        //when
        String result = wordFrequencyGame.getResult(sentence);

        //then
        assertEquals("the 1\nis 1", result);
    }

    @Test
    void should_return_the_1_is_1_when_get_result_given_the_is_with_special_enter() throws CalculateErrorException {
        //given
        String sentence = "the   \n   is";

        //when
        String result = wordFrequencyGame.getResult(sentence);

        //then
        assertEquals("the 1\nis 1", result);
    }

    @Test
    void should_return_the_2_is_1_when_get_result_given_the_the_is() throws CalculateErrorException {
        //given
        String sentence = "the the is";

        //when
        String result = wordFrequencyGame.getResult(sentence);

        //then
        assertEquals("the 2\nis 1", result);
    }

    @Test
    void should_return_is_2_the_1_when_get_result_given_the_is_is() throws CalculateErrorException {
        //given
        String sentence = "the is is";

        //when
        String result = wordFrequencyGame.getResult(sentence);

        //then
        assertEquals("is 2\nthe 1", result);
    }

    @Test
    void should_throw_calculate_error_exception_when_get_result_given_null() throws CalculateErrorException {
        //given
        WordFrequencyGame wordFrequencyGame = Mockito.mock(WordFrequencyGame.class);
        when(wordFrequencyGame.getResult(null)).thenCallRealMethod();

        //then
        assertThrows(CalculateErrorException.class, () -> {
                    //when
                    wordFrequencyGame.getResult(null);
                }
        );
    }
}
