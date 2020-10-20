package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListDto {

    List<User> sportsmens = new ArrayList<>();

    public List<User> getSportsmens() {
        return sportsmens;
    }

    public void setSportsmens(List<User> sportsmens) {
        this.sportsmens = sportsmens;
    }


}
