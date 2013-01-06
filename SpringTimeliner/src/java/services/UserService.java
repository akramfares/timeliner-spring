/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.User;
import DAO.UserDAO;
import java.util.List;

/**
 *
 * @author afares01
 */
public interface UserService {
	

        // Validation d'Inscription d'un utilisateur
	public boolean inscription(String nom, String prenom, String sexe, String adresse, String login, String motdepasse);
	// Validation de la Connexion d'un utilisateur
        public boolean connexion(String login, String motdepasse);
	// Retourne la liste de tout les utilisateurs
        public List<User> getAllUsers();
	public UserDAO getUserDAO();
        // Récupère un utilisateur à partir de son Id
        public User getUserById(Integer id);
        // Ajouter une demande d'ami
        public boolean ajouterAmi(User userSession, User ami);
        // Retourne la liste des demandes d'amis
        public List<User> getDemandesAmi(User userSession);
        // Retourne les liste d'amis d'un utilisateur
        public List<User> getAmis(User userSession);
        // Confirme la demande d'ami
        public boolean confirmerAmi(User userSession, User ami);
        // Modifie la photo de profile d'un utilisateur
        public void modifierPhoto(User userSession);
        // Retourne le nombre de demandes d'ami
        public Integer countDemandesAmi(User userSession);
        
}
