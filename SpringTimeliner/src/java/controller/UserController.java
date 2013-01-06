/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

/**
 *
 * @author Fares
 */
@Controller
public class UserController {
    @Autowired
	private UserService userService;	
	
        // Affichage des amis de l'utilisateur connecté ainsi que les demandes d'amis 
        // et la liste de tout les utilisateurs du réseau social
	@RequestMapping(value="/membres.htm",method=RequestMethod.GET)
	protected ModelAndView indexProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
            User userSession = (User) session.getAttribute("user");
                
            ModelAndView mv = new ModelAndView("membres"); 
            
            mv.addObject("amis",userService.getAmis(userSession)); // Liste d'amis
            mv.addObject("demandes_ami",userService.getDemandesAmi(userSession)); // Liste des demandes d'amis
            mv.addObject("users",userService.getAllUsers()); // Liste des utilisateurs
            return mv;
        }
        
        // Validation de la demande d'ami
        @RequestMapping(value="/ajouter_ami.htm", method=RequestMethod.GET)
	  protected ModelAndView ajouterProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
            User userSession = (User) session.getAttribute("user");	
            
            ModelAndView mv = new ModelAndView("resultat"); 
            mv.addObject("titre","Résultat de l'ajout d'un ami");
           
            // Récupération de l'utilisateur à partir de son Id
            String ami_id = request.getParameter("ami_id");
            User ami = userService.getUserById(Integer.parseInt(ami_id));		
                
            // Validation de l'ajout d'ami
            if(userService.ajouterAmi(userSession, ami))
                    mv.addObject("resultat","Demande d'amitié ajoutée avec succès");
            else
                    mv.addObject("resultat", "Erreur");

            return mv; 
	  }
        
        // Validation de la confirmation d'ajout d'ami
        @RequestMapping(value="/confirmer_ami.htm", method=RequestMethod.GET)
	  protected ModelAndView confirmerProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		// Récupération de l'utilisateur connecté
                HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
                
                ModelAndView mv = new ModelAndView("resultat"); 
		mv.addObject("titre","Résultat de l'ajout d'un ami");
                
                // Récupération de l'utilisateur à partir de son Id
                String ami_id = request.getParameter("ami_id");
                User ami = userService.getUserById(Integer.parseInt(ami_id));
                
                // Validation de la confirmation d'ami
		if(userService.confirmerAmi(userSession, ami))
			mv.addObject("resultat","Demande d'amitié confirmée avec succès");
		else
			mv.addObject("resultat", "Erreur");
		
	  	return mv; 
	  }
        
        // Page de modification de la photo de profile de l'utilisateur connecté
        @RequestMapping(value="/photoprofile.htm", method=RequestMethod.GET)
	  protected ModelAndView photoprofileProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("photoprofile"); 
		mv.addObject("titre","Changer la photo de profile");
	  	return mv; 
	  }
        
        // Validation de la modification de la photo de profile
        @RequestMapping(value="/valid_photoprofile.htm", method=RequestMethod.POST)
	  protected ModelAndView validPhotoprofileProcess(@RequestParam("photo") MultipartFile file, HttpServletRequest
	  request, HttpServletResponse response) throws Exception {
                // Récupération de l'utilisateur connecté
                HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
                
		ModelAndView mv = new ModelAndView("resultat"); 
		mv.addObject("titre","Changer la photo de profile");
                
                InputStream inputStream = null;
                OutputStream outputStream = null;
                
                // Vérification de la taille de la piece jointe et de son type
                if(file.getSize() != 0 && (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png"))){
                    inputStream = file.getInputStream();
                    // Enregistrement de l'image sur le disk
                    String fileName = request.getServletContext().getRealPath(File.separator) + "/uploads/photoprofile/" + userSession.getId();
                    outputStream = new FileOutputStream(fileName);
                    int readBytes = 0;
                    byte[] buffer = new byte[10000];
                    while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                            outputStream.write(buffer, 0, readBytes);
                    }
                    outputStream.close();
                    inputStream.close();
                    userService.modifierPhoto(userSession);
                    mv.addObject("resultat","Image uploadée avec succès.");
                }
                else mv.addObject("resultat","Erreur");
                
	  	return mv; 
	  }
        
}
