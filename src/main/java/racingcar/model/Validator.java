package racingcar.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String NUMERIC_REGEXP = "\\d";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile(NUMERIC_REGEXP);
    private static final int MAX_NUMBER_RANGE = 9;
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public void nullCheck(String input) {
        if (input == null || input.isBlank()) {
            throw new NullPointerException("입력이 되지 않았습니다");
        }
    }

    public void numericCheck(String input) {
        Matcher matcher = NUMERIC_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        numberRangeCheck(input);
    }

    private void numberRangeCheck(String input) {
        Integer number = Integer.parseInt(input);
        if (number > MAX_NUMBER_RANGE || number < MIN_NUMBER_RANGE) {
            throw new IllegalArgumentException("숫자의 입력 범위가 잘 못 되었습니다");
        }
    }

    public void stringRangeCheck(String[] stringArray) {
        for (String name : stringArray) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
    }

}
