package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private List<List<String>> pairedCrews;
    private Crew crew;

    public Pairs(CourseAndMission courseAndMission) {
        crew = new Crew();
        pairedCrews = new ArrayList<>();
        List<String> shuffledCrew = crew.getShuffledCrew(courseAndMission.course());
        for(int i = 1; i <= shuffledCrew.size(); i+=2) {
            List<String> pairedCrew = new ArrayList<>();
            if(shuffledCrew.size() % 2 == 1 && i == shuffledCrew.size() - 2) {
                pairedCrew.add(shuffledCrew.get(i-1));
                pairedCrew.add(shuffledCrew.get(i));
                pairedCrew.add(shuffledCrew.get(i+1));
                pairedCrews.add(pairedCrew);
                break;
            }
            pairedCrew.add(shuffledCrew.get(i-1));
            pairedCrew.add(shuffledCrew.get(i));
            pairedCrews.add(pairedCrew);
        }
    }

    public List<List<String>> getPairedCrews() {
        return pairedCrews;
    }
}
