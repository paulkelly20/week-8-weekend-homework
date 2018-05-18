package models;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "leagues")
public class League extends Competition {

    public League() {
    }

    public League(String name, int prizeMoney, ArrayList<Match> matches) {
        super(name, prizeMoney, matches);
    }
}
