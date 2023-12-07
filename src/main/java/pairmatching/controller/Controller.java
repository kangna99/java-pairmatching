package pairmatching.controller;

import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.readCommand();
        outputView.printInformation();
    }
}