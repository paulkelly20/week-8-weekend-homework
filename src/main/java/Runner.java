import db.DBHelper;
import models.*;

import java.util.*;

public class Runner {


    public static void main(String[] args) {


        Manager manager = new Manager();
        Manager manager2 = new Manager();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();


        League league = new League();



        Calendar contractEndDate = Calendar.getInstance();
        contractEndDate.set( Calendar.YEAR, 2020);
        contractEndDate.set(Calendar.MONTH, 5);
        contractEndDate.set(Calendar.DAY_OF_MONTH, 31);

        Team team =  new Team("Rangers");

        Team team2 =  new Team("Celtic");

        league = new League("Premier League", 20000) ;


        player1 = new Player("Billy", 28);
        player2 = new Player("Stevie", 19);
        player3 = new Player("Martin", 39);
        player4 = new Player("Niall", 16);


        manager =  new Manager("David", 45);
        manager2 =  new Manager("Jose", 77);

        Match match = new Match(league, false);

        match.addTeamToMatch(team);
        match.addTeamToMatch(team2);
        team.newMatchForTeam(match);
        team2.newMatchForTeam(match);
        team.addPlayerToTeam(player1, contractEndDate, 1000000);
        team.addPlayerToTeam(player2, contractEndDate, 25000000);
        team2.addPlayerToTeam(player3, contractEndDate, 50000);
        team2.addPlayerToTeam(player4, contractEndDate, 100000000);
        player1.setTeam(team);
        player2.setTeam(team);
        player3.setTeam(team2);
        player4.setTeam(team2);
        team.hireManager(manager, contractEndDate, 7500000);
        team2.hireManager(manager2, contractEndDate, 10000000);


        DBHelper.save(manager);
        DBHelper.save(manager2);
        DBHelper.save(team);
        DBHelper.save(team2);
        DBHelper.save(match);
        DBHelper.save(player1);
        DBHelper.save(player2);
        DBHelper.save(player3);
        DBHelper.save(player4);
        DBHelper.save(league);
        DBHelper.save(team);
        DBHelper.save(team2);


        Team foundTeam = DBHelper.find(Team.class, team.getId());
        Team secondFoundTeam = DBHelper.find(Team.class, team2.getId());
        Manager foundManager = DBHelper.find(Manager.class, manager.getId());
        Manager foundManagerForTeam2 = DBHelper.find(Manager.class, manager2.getId());
        Player teamOnePlayer = DBHelper.find(Player.class, player1.getId());
        Player teamTwoPlayer = DBHelper.find(Player.class, player4.getId());

    }
}
