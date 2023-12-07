package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.model.Pairs;

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

    public void printMatchingResult(Pairs pairs) {
        System.out.println("\n페어 매칭 결과입니다.");
        pairs.getPairedCrews().forEach(pair -> {
            System.out.println(String.join(" : ", pair));
        });
    }

    public void printClear() {
        System.out.println("\n초기화 되었습니다.");
    }
}
