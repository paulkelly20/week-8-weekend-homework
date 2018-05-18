package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "straight_knockout_competitions")
public class StraightKnockout extends Competition {


    public StraightKnockout() {
    }

    public StraightKnockout(String name, int prizeMoney, ArrayList<Match> matches) {
        super(name, prizeMoney, matches);
    }


}
