/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.Notification;
import DAO.NotificationDAO;
import DAO.Status;
import DAO.StatusDAO;
import DAO.User;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    public NotificationDAO notification;
    
    @Override
    public boolean ajouter(String contenu,String piecejointe, User proprio) {
        if(contenu.isEmpty() || proprio == null){
                        return false;   
        }
		else {
                        Status s = new Status();
                        s.setContenu(contenu);
                        s.setDestinataire(proprio);
                        s.setProprio(proprio);
                        s.setPiecejointe(piecejointe);
                        s.setDateheure(new Date());
			status.addStatus(s);
			return true;
		}
    }
    
    @Override
    public boolean ajouterProfile(String contenu,String piecejointe, User proprio, User destinataire) {
        if(contenu.isEmpty() || proprio == null){
                        return false;   
        }
		else {
                        Status s = new Status();
                        s.setContenu(contenu);
                        s.setDestinataire(destinataire);
                        s.setProprio(proprio);
                        s.setPiecejointe(piecejointe);
                        s.setDateheure(new Date());
			status.addStatus(s);
                        
                        // Ajouter une notification au destinataire
                        Notification n = new Notification();
                        n.setContenu(contenu);
                        n.setEtat(Boolean.FALSE);
                        n.setProprio(destinataire);
                        n.setContenu("<a href='profile.htm?user="+proprio.getId()+"'>"+proprio.getNom()+" "+proprio.getPrenom()+"</a> a posté un commentaire sur votre mur");
                        notification.addNotification(n);
			return true;
		}
    }

    @Override
    public ArrayList<Status> getMur(User proprio) {
        return status.getAllByProprio(proprio);
    }
    
}