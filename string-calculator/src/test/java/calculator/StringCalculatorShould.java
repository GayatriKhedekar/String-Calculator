package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void numbers_comma_delimited_should_be_summed() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1,2"), 3);
        assertEquals(25, stringCalculator.add("10,15"));
    }

    @Test
    public void numbers_newline_delimited_should_be_summed() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1\n2,3"), 6);
        assertEquals(stringCalculator.add("11\n13"), 24);
    }

    @Test
    public void three_numbers_delimited_anyway_should_be_summed() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1,2,3"), 6);
        assertEquals(stringCalculator.add("5\n2\n3"), 10);
    }

    @Test
    public void negative_input_returns_exception() {
        StringCalculator stringCalculator = new StringCalculator();
        try {
            stringCalculator.add("-1");
            stringCalculator.add("-5,10\n-15"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void numbers_greater_than_1000_are_ignored() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("5,12,1001"), 17);
        assertEquals(stringCalculator.add("14124,22\n4,1214"), 26);
    }
}
