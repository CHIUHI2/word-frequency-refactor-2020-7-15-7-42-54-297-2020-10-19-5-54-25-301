package com.ooclbootcamp.game.wordfrequency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ooclbootcamp.game.wordfrequency.exception.CalculateErrorException;
import com.ooclbootcamp.game.wordfrequency.WordFrequencyGame;
import org.junit.jupiter.api.Test;

public class WordFrequencyGameTest {

    @Test
    public void should_return_the_1_when_get_result_given_the() throws Exception {
        //Given
        String inputStr = "the";
        String expectResult = "the 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    public void should_return_the_1_is_1_when_get_result_given_the_is() throws Exception {
        //Given
        String inputStr = "the is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    public void should_return_the_1_is_1_when_get_result_given_the_is_with_special_spaces() throws Exception {
        //Given
        String inputStr = "the      is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    public void should_return_the_1_is_1_when_get_result_given_the_is_with_special_enter() throws Exception {
        //Given
        String inputStr = "the   \n   is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    public void should_return_the_2_is_1_when_get_result_given_the_the_is() throws Exception {
        //Given
        String inputStr = "the the is";
        String expectResult = "the 2\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    public void should_return_is_2_the_1_when_get_result_given_the_is_is() throws Exception {
        //Given
        String inputStr = "the is is";
        String expectResult = "is 2\nthe 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    private void validate_Input_words_process_to_expected_word(String inputStr, String expectResult) throws CalculateErrorException {
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertEquals(result, expectResult);
    }
}
