import models.Match;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeamTest {

    Team team;
    Match match;

    @Before
    public void before() {
        team = new Team("Rangers");
        match = new Match();
    }

//    @Test
//    public void name() {
//        assertEquals();
//    }
}
