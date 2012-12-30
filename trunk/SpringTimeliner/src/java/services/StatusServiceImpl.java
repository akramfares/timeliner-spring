/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.Status;
import DAO.StatusDAO;
import DAO.User;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fares
 */
@Service("StatusService")
public class StatusServiceImpl implements StatusService{
    @Autowired
    public StatusDAO status;
    
    @Override
    public boolean ajouter(String contenu, User proprio) {
        if(contenu.isEmpty() || proprio == null){
                        return false;   
        }
		else {
                        Status s = new Status();
                        s.setContenu(contenu);
                        s.setDestinataire(proprio);
                        s.setProprio(proprio);
                        s.setPiecejointe(contenu);
			status.addStatus(s);
			return true;
		}
    }
    
    @Override
    public boolean ajouterProfile(String contenu, User proprio, User destinataire) {
        if(contenu.isEmpty() || proprio == null){
                        return false;   
        }
		else {
                        Status s = new Status();
                        s.setContenu(contenu);
                        s.setDestinataire(destinataire);
                        s.setProprio(proprio);
                        s.setPiecejointe(contenu);
			status.addStatus(s);
			return true;
		}
    }

    @Override
    public ArrayList<Status> getMur(User proprio) {
        return status.getAllByProprio(proprio);
    }
    
}
