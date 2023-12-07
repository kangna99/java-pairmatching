package pairmatching.controller;

import static pairmatching.utils.ErrorMessage.PAIR_MATCHING_NOT_FOUND;
import static pairmatching.utils.ErrorMessage.formatErrorWithRetry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.model.CourseAndMission;
import pairmatching.model.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private Map<CourseAndMission, Pairs> pairManage;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        pairManage = new HashMap<>();
    }

    public void run() {
        while(true) {
            String command = inputView.readCommand();
            if(command.equals("1")) {
                outputView.printInformation();
                makePairsAndPrint(getCourseAndMission());
            }
            if(command.equals("2")) {
                outputView.printInformation();
                Pairs pairs = pairManage.get(getCourseAndMission());
                if(pairs == null) {
                    System.out.println(formatErrorWithRetry(PAIR_MATCHING_NOT_FOUND));
                    continue;
                }
                outputView.printMatchingResult(pairs);
            }
            if(command.equals("3")) {
                pairManage.clear();
                outputView.printClear();
            }
            if(command.equals("Q")) {
                return;
            }
        }
    }

    private CourseAndMission getCourseAndMission() {
        List<String> selection = inputView.readSelection();
        CourseAndMission courseAndMission = new CourseAndMission(selection.get(0), selection.get(2));
        return courseAndMission;
    }

    private void makePairsAndPrint(CourseAndMission courseAndMission) {
        if(pairManage.containsKey(courseAndMission)) {
            boolean isRetry = inputView.readRetry();
            if (isRetry) {
                Pairs pairs = new Pairs(courseAndMission);
                pairManage.put(courseAndMission, pairs);
                outputView.printMatchingResult(pairs);
            }
            return;
        }

        Pairs pairs = new Pairs(courseAndMission);
        pairManage.put(courseAndMission, pairs);
        outputView.printMatchingResult(pairs);
    }
}
