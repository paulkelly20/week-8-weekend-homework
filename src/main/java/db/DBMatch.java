package db;

import models.Match;
import models.Player;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMatch {


    private static Session session;


    public static List<Team> findTeamsInMatch(Match match){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> foundTeams = null;
        try{
            Criteria cr = session.createCriteria(Team.class);
            cr.createAlias("matches", "match");
            cr.add(Restrictions.eq("match.id", match.getId()));
            foundTeams = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        } return foundTeams;
    }
}

