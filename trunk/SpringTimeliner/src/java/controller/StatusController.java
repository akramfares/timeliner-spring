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
	private StatusService status;
        @Autowired
        private UserService userService;
	
	@RequestMapping(value="/mur.htm", method=RequestMethod.GET)
	  protected ModelAndView murProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
                HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
            
		ModelAndView mv = new ModelAndView("mur");
                mv.addObject("connecte",isConnecte(request));
                mv.addObject("userConnecte",userSession);
		mv.addObject("titre","Ajouter une personne");
		mv.addObject("action","ajouter_status");
                mv.addObject("list_status",status.getMur(userSession));
	  	return mv; 
	  }
        
        @RequestMapping(value="/profile.htm", method=RequestMethod.GET)
	  protected ModelAndView profileProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
                HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
                String user_id = request.getParameter("user");
                User user = userService.getUserById(Integer.parseInt(user_id));
		ModelAndView mv = new ModelAndView("profile");
		mv.addObject("titre","Profile de "+user.getNom()+" "+user.getPrenom());
                mv.addObject("list_status",status.getMur(user));
                 mv.addObject("user",user);
                 mv.addObject("userConnecte",userSession);
	  	return mv; 
	  }
	
	@RequestMapping(value="/ajouter_status.htm", method=RequestMethod.POST)
	  protected ModelAndView ajouterProcess(@RequestParam("piece") MultipartFile file, HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
                String piecejointe = null;
                ModelAndView mv = new ModelAndView("resultat"); 
                mv.addObject("connecte",isConnecte(request));
		String contenu = request.getParameter("contenu");
		HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
		mv.addObject("titre","Résultat de l'ajout du status");
                
                if(file.getSize() != 0){
                    InputStream inputStream = null;
                     OutputStream outputStream = null;
                    inputStream = file.getInputStream();
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
                
		if(status.ajouter(contenu,piecejointe,userSession))
			mv.addObject("resultat","Status ajouté avec succès");
		else
			mv.addObject("resultat", "Erreur dans le formulaire");
		
	  	return mv; 
	  }
        
        @RequestMapping(value="/ajouter_status_profile.htm", method=RequestMethod.POST)
	  protected ModelAndView ajouterProfileProcess(@RequestParam("piece") MultipartFile file, HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
                String piecejointe = null;
		ModelAndView mv = new ModelAndView("resultat"); 
                mv.addObject("connecte",isConnecte(request));
		String contenu = request.getParameter("contenu");
		HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
                String user_id = request.getParameter("user");
                User user = userService.getUserById(Integer.parseInt(user_id));
		mv.addObject("titre","Résultat de l'ajout du status");
                
                if(file.getSize() != 0){
                    InputStream inputStream = null;
                     OutputStream outputStream = null;
                    inputStream = file.getInputStream();
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
                
		if(status.ajouterProfile(contenu,piecejointe, userSession, user))
			mv.addObject("resultat","Status ajouté avec succès");
		else
			mv.addObject("resultat", "Erreur dans le formulaire");
		
	  	return mv; 
	  }
        
        private boolean isConnecte(HttpServletRequest request){
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            if(userSession == null) return false;
            else return true;
        }

}
