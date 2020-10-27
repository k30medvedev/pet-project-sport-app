package by.kirill.sportsman.app.controller.run;

import java.util.ArrayList;
import java.util.List;

public class RunsListDto {

    List<RunUserDto> runs = new ArrayList<>();

    public List<RunUserDto> getRuns() {return runs;}

    public void setRuns(List<RunUserDto> runs) {this.runs = runs;}
}
