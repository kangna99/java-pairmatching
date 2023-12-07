package pairmatching.model;

import static pairmatching.utils.Formatter.readCrewMembersFrom;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Crew {
    private List<String> frontendCrewNames;
    private List<String> backendCrewNames;

    public Crew() {
        this.frontendCrewNames = readCrewMembersFrom("src/main/resources/frontend-crew.md");
        this.backendCrewNames = readCrewMembersFrom("src/main/resources/backend-crew.md");
    }

    public List<String> getShuffledCrew(String courseName) {
        if(courseName.equals("백엔드")) {
            return getBackendCrewNames();
        }
        return getFrontendCrewNames();
    }

    private List<String> getFrontendCrewNames() {
        return Randoms.shuffle(frontendCrewNames);
    }
    private List<String> getBackendCrewNames() {
        return Randoms.shuffle(backendCrewNames);
    }

}