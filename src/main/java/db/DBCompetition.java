package db;

import models.Competition;
import models.Match;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

}
