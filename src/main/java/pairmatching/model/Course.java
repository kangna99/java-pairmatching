package pairmatching.model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static String formatted() {
        StringBuilder result = new StringBuilder();
        result.append("과정: ");
        for (Course course : Course.values()) {
            result.append(course.name).append(" | ");
        }
        result.setLength(result.length() - 3);
        return result.toString();
    }
}
