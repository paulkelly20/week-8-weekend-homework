package models;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leagues")
public class League extends Competition {

    public League() {
    }

    public League(String name, int prizeMoney) {
        super(name, prizeMoney);
    }

    public void addMatchToCompetition(Match match) {
        if(!match.isKnockoutMatch())
        { super.getMatches().add(match);}
    }
}
