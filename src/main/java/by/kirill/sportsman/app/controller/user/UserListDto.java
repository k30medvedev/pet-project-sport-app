package by.kirill.sportsman.app.controller.user;

import java.util.ArrayList;
import java.util.List;

public class UserListDto {

    List<UserDto> sportsmans = new ArrayList<>();

    public List<UserDto> getSportsmans() {
        return sportsmans;
    }

    public void setSportsmans(List<UserDto> sportsmans) {
        this.sportsmans = sportsmans;
    }
}
