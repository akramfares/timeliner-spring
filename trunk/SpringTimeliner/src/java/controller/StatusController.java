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
import services.StatusService;
import services.UserService;

/**
 *
 * @author afares01
 */
@Controller
public class StatusController {
	@Autowired
	private StatusService statusService;
        @Autowired
        private UserService userService;
	
        // Mur de l'utilisateur
	@RequestMapping(value="/mur.htm", method=RequestMethod.GET)
	  protected ModelAndView murProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
            User userSession = (User) session.getAttribute("user");

            ModelAndView mv = new ModelAndView("mur");
                mv.addObject("connecte",isConnecte(request));
                mv.addObject("userConnecte",userSession);
		mv.addObject("titre","Ajouter une personne");
                // Récupération des statuts de l'utilisateur connecté
                mv.addObject("list_status",statusService.getMur(userSession));
            return mv; 
	  }
        
        // Profile d'un utilisateur
        @RequestMapping(value="/profile.htm", method=RequestMethod.GET)
	  protected ModelAndView profileProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
            User userSession = (User) session.getAttribute("user");
            
            // Récupération de l'utilisateur à partir de son Id
            String user_id = request.getParameter("user");
            User user = userService.getUserById(Integer.parseInt(user_id));
            
            ModelAndView mv = new ModelAndView("profile");
		mv.addObject("titre","Profile de "+user.getNom()+" "+user.getPrenom());
                // Récupération des statuts de l'utilisateur
                mv.addObject("list_status",statusService.getMur(user));
                mv.addObject("user",user);
                mv.addObject("userConnecte",userSession);
            return mv; 
	  }
	
        // Validation de l'ajout d'un status
	@RequestMapping(value="/ajouter_status.htm", method=RequestMethod.POST)
	  protected ModelAndView ajouterProcess(@RequestParam("piece") MultipartFile file, HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
            User userSession = (User) session.getAttribute("user");
            
            String piecejointe = null;
            ModelAndView mv = new ModelAndView("resultat"); 
            String contenu = request.getParameter("contenu");    
                mv.addObject("connecte",isConnecte(request));
		mv.addObject("titre","Résultat de l'ajout du status");
                
                // Vérification de la taille de la piece jointe et de son type
                if(file.getSize() != 0 && (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png"))){
                    InputStream inputStream = null;
                     OutputStream outputStream = null;
                    inputStream = file.getInputStream();
                    // Enregistrement de l'image sur le disk
                    String fileName = request.getServletContext().getRealPath(File.separator) + "/uploads/status/" + file.getOriginalFilename();
                    outputStream = new FileOutputStream(fileName);
                    int readBytes = 0;
                    byte[] buffer = new byte[10000];
                    while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                            outputStream.write(buffer, 0, readBytes);
                    }
                    outputStream.close();
                    inputStream.close();
                    piecejointe = file.getOriginalFilename();
                }
                // Vérification de l'ajout du status
		if(statusService.ajouter(contenu,piecejointe,userSession))
			mv.addObject("resultat","Status ajouté avec succès");
		else
			mv.addObject("resultat", "Erreur dans le formulaire");
		
	  	return mv; 
	  }
        
        // Validation de l'ajout d'un status sur un profile d'utilisateur
        @RequestMapping(value="/ajouter_status_profile.htm", method=RequestMethod.POST)
	  protected ModelAndView ajouterProfileProcess(@RequestParam("piece") MultipartFile file, HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            HttpSession session=request.getSession(false); 
            User userSession = (User) session.getAttribute("user");    
            String piecejointe = null;
            ModelAndView mv = new ModelAndView("resultat"); 
            String contenu = request.getParameter("contenu");
            // Récupération de l'utilisateur à partir de son Id 
            String user_id = request.getParameter("user");
            User user = userService.getUserById(Integer.parseInt(user_id));
            
		mv.addObject("titre","Résultat de l'ajout du status");
                mv.addObject("connecte",isConnecte(request));
                
                // Vérification de la taille de la piece jointe et de son type
                if(file.getSize() != 0 && (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png"))){
                    InputStream inputStream = null;
                     OutputStream outputStream = null;
                    inputStream = file.getInputStream();
                    // Enregistrement de l'image sur le disk
                    String fileName = request.getServletContext().getRealPath(File.separator) + "/uploads/status/" + file.getOriginalFilename();
                    outputStream = new FileOutputStream(fileName);
                    int readBytes = 0;
                    byte[] buffer = new byte[10000];
                    while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                            outputStream.write(buffer, 0, readBytes);
                    }
                    outputStream.close();
                    inputStream.close();
                    piecejointe = file.getOriginalFilename();
                }
                
                // Vérification de l'ajout du status
		if(statusService.ajouterProfile(contenu,piecejointe, userSession, user))
			mv.addObject("resultat","Status ajouté avec succès");
		else
			mv.addObject("resultat", "Erreur dans le formulaire");
		
	  	return mv; 
	  }
        
        // Fonction qui retourne si l'utilisateur est connecté ou pas
        private boolean isConnecte(HttpServletRequest request){
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            if(userSession == null) return false;
            else return true;
        }

}
