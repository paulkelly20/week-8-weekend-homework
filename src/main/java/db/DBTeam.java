package db;

import models.Competition;
import models.Player;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBTeam {

    private static Session session;


    public static List<Player> findPlayersInTeam(Team team) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> foundPlayers = null;
        try {
            Criteria cr = session.createCriteria(Player.class);
            cr.add(Restrictions.eq("team", team));
            foundPlayers = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return foundPlayers;
    }


}




