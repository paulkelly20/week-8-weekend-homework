import db.DBHelper;
import models.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Runner {


    public static void main(String[] args) {


        Manager manager = new Manager();
        Player player1 = new Player();
        Player player2 = new Player();
        List<Player> players = new ArrayList<Player>();
        Match match = new Match();
        List<Match> matches = new ArrayList<Match>();
        League league = new League();
        List<Team> teams = new ArrayList<Team>();


        Calendar contractEndDate = Calendar.getInstance();
        contractEndDate.set( Calendar.YEAR, 2020);
        contractEndDate.set(Calendar.MONTH, 5);
        contractEndDate.set(Calendar.DAY_OF_MONTH, 31);

        Team team =  new Team("Rangers", manager, players, matches);

        league = new League("Premier League", 20000, matches) ;


        player1 = new Player("Billy", 28, 5000000, contractEndDate, team);
        player2 = new Player("Stevie", 19, 200000, contractEndDate, team);
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);



        teams = new ArrayList<Team>();
        teams.add(team);
           match = new Match(league, teams, false);
            matches.add(match);

            manager =  new Manager("David", 45, 30000, contractEndDate, team);



        DBHelper.save(manager);
        DBHelper.save(team);
        DBHelper.save(match);

        DBHelper.save(player1);
        DBHelper.save(player2);
        DBHelper.save(players);

        DBHelper.save(teams);
        DBHelper.save(league);
        DBHelper.save(matches);
        DBHelper.save(teams);
        DBHelper.save(team);


        Team foundTeam = DBHelper.find(Team.class, team.getId());
        Manager foundManager = DBHelper.find(Manager.class, manager.getId());
        Player player = DBHelper.find(Player.class, player1.getId());
    }
}
