package db;

import models.Competition;
import models.Match;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBCompetition {

    private static Session session;


    public static List<Team> teamsInCompetition(Competition competition){
        List<Team> teamsInComp = new ArrayList<Team>();
        List<Team> duplicateChecckedArray = new ArrayList<Team>();
        List<Match> matchesInComp = matchesInCompetition(competition);
            for(Match match: matchesInComp){
                duplicateChecckedArray.addAll(DBMatch.findTeamsInMatch(match));
            } for (Team team: duplicateChecckedArray){
                if(!teamsInComp.contains(team)){
                    teamsInComp.add(team);
                }
        }
        return teamsInComp;
    }


        public static List<Match> matchesInCompetition(Competition competition){
                session = HibernateUtil.getSessionFactory().openSession();
                List<Match> matchesInComp = null;
                try{
                    Criteria cr = session.createCriteria(Match.class);
                    cr.add(Restrictions.eq("competition", competition));
                    matchesInComp = cr.list();

                }catch (HibernateException e){

                    e.printStackTrace();
                }finally {
                    session.close();
                } return matchesInComp;
            }

}
