package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.model.User;

import java.util.ArrayList;
import java.util.List;

public class RunsListDto {

    List<Run> runs = new ArrayList<>();
    public List<Run> getRuns() {
        return runs;
    }
    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }
}
