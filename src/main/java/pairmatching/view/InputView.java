package pairmatching.view;

import static pairmatching.model.Mission.getMissionsByLevel;
import static pairmatching.utils.ErrorMessage.CONTAINS_WHITESPACE;
import static pairmatching.utils.ErrorMessage.END_WITH_DELIMITER;
import static pairmatching.utils.ErrorMessage.INVALID_COMMAND;
import static pairmatching.utils.ErrorMessage.INVALID_COURSE;
import static pairmatching.utils.ErrorMessage.INVALID_LEVEL;
import static pairmatching.utils.ErrorMessage.INVALID_MISSION;
import static pairmatching.utils.ErrorMessage.INVALID_RETRY;
import static pairmatching.utils.ErrorMessage.formatErrorWithRetry;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.utils.Formatter;

public class InputView {
    private static final String WHITESPACE_REGEX = "\\s";
    private static final String COMMA_DELIMITER = ",";

    public String readCommand() {
        while(true) {
            System.out.println("기능을 선택하세요.");
            System.out.println("1. 페어 매칭");
            System.out.println("2. 페어 조회");
            System.out.println("3. 페어 초기화");
            System.out.println("Q. 종료");
            String command = Console.readLine();
            try {
                validateCommand(command);
                return command;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> readSelection() {
        while(true) {
            System.out.println("과정, 레벨, 미션을 선택하세요.");
            System.out.println("ex) 백엔드, 레벨1, 자동차경주");
            String selection = Console.readLine();
            try {
                validateSelection(selection);
                return Formatter.parser(selection, COMMA_DELIMITER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean readRetry() {
        while(true) {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
            System.out.println("네 | 아니오");
            String retry = Console.readLine();
            try {
                validateNotBlank(retry);
                validateRetryValue(retry);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if(retry.equals("네")) {
                return true;
            }
            if(retry.equals("아니오")) {
                return false;
            }
        }
    }

    private void validateCommand(String command) {
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

    private void validateSelection(String input) {
        validateNotEndWithDelimiter(input);
        validateEachValue(input);
    }

    private void validateNotEndWithDelimiter(String input) {
        if (input.endsWith(COMMA_DELIMITER)) {
            throw new IllegalArgumentException(formatErrorWithRetry(END_WITH_DELIMITER));
        }
    }

    private void validateEachValue(String input) {
        List<String> selections = Formatter.parser(input, COMMA_DELIMITER);
        validateCourse(selections.get(0));
        validateLevel(selections.get(1));
        validateMission(selections.get(1), selections.get(2));
    }

    private void validateCourse(String course) {
        if(!Course.contains(course)) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_COURSE));
        }
    }

    private void validateLevel(String level) {
        if(!Level.contains(level)) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_LEVEL));
        }
    }

    private void validateMission(String level, String mission) {
        List<String> missions = Mission.getMissionsByLevel(Level.get(level));
        if(!missions.contains(mission)) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_MISSION));
        }
    }

    private void validateRetryValue(String input) {
        if(!input.equals("네") && !input.equals("아니오")) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_RETRY));
        }
    }
}
