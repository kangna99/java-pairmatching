package pairmatching.model;

import static pairmatching.model.Level.LEVEL1;
import static pairmatching.model.Level.LEVEL2;
import static pairmatching.model.Level.LEVEL4;
import static pairmatching.model.Level.LEVEL5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Mission {
    RACING_CAR("자동차경주", LEVEL1),
    LOTTO("로또", LEVEL1),
    BASEBALL_GAME("숫자야구게임", LEVEL1),
    SHOPPING_CART("장바구니", LEVEL2),
    PAYMENT("결제", LEVEL2),
    SUBWAY_MAP("지하철노선도", LEVEL2),
    PERFORMANCE_IMPROVEMENT("성능개선", LEVEL4),
    DEPLOYMENT("배포", LEVEL4);

    private String name;
    private Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    private static List<String> getMissionsByLevel(Level targetLevel) {
        return Stream.of(Mission.values())
                .filter(mission -> mission.getLevel() == targetLevel)
                .map(Mission::getName)
                .toList();
    }

    private String getName() {
        return name;
    }

    private Level getLevel() {
        return level;
    }

    public static String formatted() {
        StringBuilder result = new StringBuilder();
        result.append("미션:");
        for(Level level : Level.values()) {
            result.append("\n - ").append(level.getName()).append(": ");
            List<String> missions = getMissionsByLevel(level);
            if (!missions.isEmpty()) {
                for (String mission : missions) {
                    result.append(mission).append(" | ");
                }
                result.setLength(result.length() - 3);
            }
        }
        return result.toString();
    }
}
