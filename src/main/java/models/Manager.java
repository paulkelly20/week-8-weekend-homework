package models;

import javax.persistence.*;
import java.util.Calendar;


@Entity
@Table(name = "managers")
public class Manager extends Employee {
    Team team;



    public Manager() {
    }

    public Manager(String name, int age) {
        super(name, age);

    }



    @OneToOne()
    @PrimaryKeyJoinColumn
    public Team getTeam() {
        return this.team;
    }


    public void setTeam(Team team) {
        this.team = team;
    }
}
