package pairmatching.utils;

public class ErrorMessage {
    public static final String CONTAINS_WHITESPACE = "공백이 포함되어 있습니다.";
    public static final String INVALID_COMMAND = "1, 2, 3 중 원하는 기능을 선택하거나, Q를 입력해 종료해주세요.";
    public static final String END_WITH_DELIMITER = "구분자(,)로 끝날 수 없습니다.";
    public static final String INVALID_COURSE = "존재하지 않는 과정입니다.";
    public static final String INVALID_LEVEL = "존재하지 않는 레벨입니다.";
    public static final String INVALID_MISSION = "존재하지 않는 미션입니다.";

    public static String formatErrorWithRetry(String error) {
        return "[ERROR] " + error ;
    }
}
