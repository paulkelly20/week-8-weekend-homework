import db.DBCompetition;
import db.DBHelper;
import db.DBMatch;
import db.DBTeam;
import models.*;

import java.util.*;

public class Runner {


    public static void main(String[] args) {
        // setup
        Calendar contractEndDate = Calendar.getInstance();
        contractEndDate.set(Calendar.YEAR, 2020);
        contractEndDate.set(Calendar.MONTH, 5);
        contractEndDate.set(Calendar.DAY_OF_MONTH, 31);

        Team team = new Team("Rangers");

        Team team2 = new Team("Celtic");

        League league = new League("Premier League", 20000);


        Player player1 = new Player("Billy", 28);
        Player player2 = new Player("Stevie", 19);
        Player player3 = new Player("Martin", 39);
        Player player4 = new Player("Niall", 16);


        Manager manager = new Manager("David", 45);
        Manager manager2 = new Manager("Jose", 77);

        Match match = new Match(league, false);


        //Class methods to setup teams and matches

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
        league.addMatchToCompetition(match);


        // save to db
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
        DBHelper.addTeamToMatch(team, match);
        DBHelper.addTeamToMatch(team2, match);




        Team foundTeam = DBHelper.find(Team.class, team.getId());
        Team secondFoundTeam = DBHelper.find(Team.class, team2.getId());
        Manager foundManager = DBHelper.find(Manager.class, manager.getId());
        Manager foundManagerForTeam2 = DBHelper.find(Manager.class, manager2.getId());
        Player teamOnePlayer = DBHelper.find(Player.class, player1.getId());
        Player teamTwoPlayer = DBHelper.find(Player.class, player4.getId());
        Competition foundCompetition = DBHelper.find(Competition.class, league.getId());
        List<Player> playersInTeam = DBTeam.findPlayersInTeam(team);
        List<Match> foundMatchesInACompetition = DBCompetition.matchesInCompetition(league);
        List<Team> foundTeamsInAMatch = DBMatch.findTeamsInMatch(match);

        Match foundMatch = DBHelper.find(Match.class, match.getId());
        List<Team> teamsInComp = DBCompetition.teamsInCompetition(league);
    }
}
