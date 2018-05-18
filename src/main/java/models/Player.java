package models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "players")
public class Player extends Employee {
    Team team;

    public Player() {
    }

    public Player(String name, int age, double salary, Calendar contractEndDate, Team team) {
        super(name, age, salary, contractEndDate);
        this.team = team;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="team_id")
    public Team getTeam() {
        return this.team;
    }


    public void setTeam(Team team) {
        this.team = team;
    }
}
