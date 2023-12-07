package pairmatching.view;

import static pairmatching.utils.ErrorMessage.CONTAINS_WHITESPACE;
import static pairmatching.utils.ErrorMessage.INVALID_COMMAND;
import static pairmatching.utils.ErrorMessage.formatErrorWithRetry;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String WHITESPACE_REGEX = "\\s";

    public void readCommand() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        String command = Console.readLine();
        try {
            validate(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCommand();
        }
    }

    private void validate(String command) {
        validateNotBlank(command);
        validateRange(command);
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank() || containsWhitespace(input)) {
            throw new IllegalArgumentException(formatErrorWithRetry(CONTAINS_WHITESPACE));
        }
    }

    private boolean containsWhitespace(String input) {
        Pattern pattern = Pattern.compile(WHITESPACE_REGEX);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private void validateRange(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_COMMAND));
        }
    }
}
