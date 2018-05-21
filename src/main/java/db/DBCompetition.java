package db;

import models.Competition;
import models.League;
import models.Match;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class DBCompetition {

    private static Session session;




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



    public static List<Team> findTeamsInCompetition(Competition competition){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> foundTeams = null;
        try{
            Criteria cr = session.createCriteria(Team.class, "team");
            cr.createAlias("competitions", "competition");
            cr.add(Restrictions.eq("competition.id", competition.getId()));

            foundTeams = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        } return foundTeams;
    }



}
