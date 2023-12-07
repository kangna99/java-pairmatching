package pairmatching.utils;

import static java.util.List.of;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Formatter {
    public static List<String> parser(String input, String delimiter) {
        List<String> before = List.of(input.split(delimiter));
        List<String> after = new ArrayList<>();

        for (String str : before) {
            after.add(str.strip());
        }

        return after;
    }

    public static List<String> readCrewMembersFrom(String filePath) {
        List<String> crewMembers = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            crewMembers.addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crewMembers;
    }
}
