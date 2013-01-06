/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.Status;
import DAO.User;
import DAO.UserDAO;
import java.util.ArrayList;

/**
 *
 * @author afares01
 */
public interface StatusService {
	// Ajoute un statut d'un utilisateur sur son propre mur
	public boolean ajouter(String contenu,String piecejointe, User proprio);
        // Ajoute un statut d'un utilisateur sur le mur d'un autre
        public boolean ajouterProfile(String contenu,String piecejointe, User proprio, User destinataire);
        // Retourne la liste des statuts d'un utilisateur
        public ArrayList<Status> getMur(User proprio);
	
}
