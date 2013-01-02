/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fares
 */
@Repository("NotificationDAO")
public class NotificationDAO {
    @PersistenceContext(unitName="SpringTimelinerPU")
    private EntityManager em;
    
    @Transactional
    public void addNotification(Notification n) {
        n.setDateheure(new Date());
        em.persist(em.merge(n));
    }
    @Transactional
    public ArrayList<Notification> getAllByProprio(User proprio) {
        Query q = em.createQuery("SELECT p FROM Notification p WHERE p.proprio=? ORDER BY p.dateheure");
        q.setParameter(1, proprio);
        
        Query update = em.createQuery("UPDATE Notification p SET p.etat=true WHERE p.proprio=?");
        update.setParameter(1, proprio);
        update.executeUpdate();
        
        return (ArrayList) q.getResultList();
    }

    public Integer countAllByProprio(User proprio) {
        Query q = em.createQuery("SELECT p FROM Notification p WHERE p.proprio=? AND p.etat=false ORDER BY p.dateheure");
        q.setParameter(1, proprio);
        return q.getResultList().size();
    }
}
