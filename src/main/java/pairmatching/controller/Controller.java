package pairmatching.controller;

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
//    private List<Pair> pairs;
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
                List<String> selection = inputView.readSelection();
                CourseAndMission courseAndMission = new CourseAndMission(selection.get(0), selection.get(2));
                if(pairManage.containsKey(courseAndMission)) {
                    boolean isRetry = inputView.readRetry();
                    if(isRetry) {
                        Pairs pairs = new Pairs(courseAndMission);
                        pairManage.put(courseAndMission, pairs);
                        outputView.printMatchingResult(pairs);
                    }
                }
                else {
                    Pairs pairs = new Pairs(courseAndMission);
                    pairManage.put(courseAndMission, pairs);
                    outputView.printMatchingResult(pairs);
                }
            }
//            if(command.equals("2")) {
//                outputView.printInformation();
//                List<String> selection = inputView.readSelection();
//                String course = selection.get(0);
//                String level = selection.get(1);
//                String mission = selection.get(2);
//                outputView.print
//            }
            if(command.equals("3")) {
                pairManage.clear();
                outputView.printClear();
            }
            if(command.equals("Q")) {
                return;
            }
        }
    }
}
