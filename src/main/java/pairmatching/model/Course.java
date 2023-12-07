package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static String formatted() {
        List<String> courseNames = Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());

        return "과정: " + String.join(" | ", courseNames);
    }

    public static boolean contains(String name) {
        return Arrays.stream(Course.values())
                .anyMatch(course -> course.name.equals(name));
    }

    private String getName() {
        return name;
    }
}
