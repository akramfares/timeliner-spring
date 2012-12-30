/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fares
 */
@Repository("StatusDAO")
public class StatusDAO {
    @PersistenceContext(unitName="SpringTimelinerPU")
    private EntityManager em;
    
    @Transactional
    public void addStatus(Status s) {
        em.persist(em.merge(s));
    }

    public ArrayList<Status> getAllByProprio(User proprio) {
        Query q = em.createQuery("SELECT p FROM Status p WHERE p.proprio=? OR p.destinataire=?");
		q.setParameter(1, proprio);
                q.setParameter(2, proprio);
		return (ArrayList) q.getResultList();
    }
    
}
