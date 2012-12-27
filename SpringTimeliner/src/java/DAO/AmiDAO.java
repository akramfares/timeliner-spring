/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fares
 */
@Repository("AmiDAO")
public class AmiDAO {
    @PersistenceContext(unitName="SpringTimelinerPU")
    private EntityManager em;
    
    @Transactional
    public void addAmi(Ami a) {
        em.persist(em.merge(a));
    }
}
