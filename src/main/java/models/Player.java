package models;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Calendar;

public class Player extends Employee {

    public Player() {
    }

    public Player(String name, int age, double salary, Calendar contractEndDate, Team team) {
        super(name, age, salary, contractEndDate, team);
    }

    @ManyToOne
    @JoinColumn(name ="team_id", nullable = false)
    public Team getTeam() {
        return super.getTeam();
    }


    public void setTeam(Team team) {
        super.setTeam(team);
    }
}
