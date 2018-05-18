package models;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Calendar;

public class Manager extends Employee {

    public Manager() {
    }

    public Manager(String name, int age, double salary, Calendar contractEndDate, Team team) {
        super(name, age, salary, contractEndDate, team);
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Team getTeam() {
        return super.getTeam();
    }


    public void setTeam(Team team) {
        super.setTeam(team);
    }
}
