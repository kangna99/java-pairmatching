package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Mission;

public class OutputView {

    public void printInformation() {
        System.out.println("\n#############################################");
        printCourse();
        printMission();
        System.out.println("#############################################");
    }
    private void printCourse() {
        System.out.println(Course.formatted());
    }

    private void printMission() {
        System.out.println(Mission.formatted());
    }
}
