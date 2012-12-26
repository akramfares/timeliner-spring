<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
			<div id="contenu">
			<form method='post' action='/SpringTimeliner/${action}.htm' name='formulaire'>
				
				<p>Nom : <input type='text' name='nom'/></p>
				<p>Prenom : <input type='text' name='prenom'/></p>
				<p>Telephone : <input type='text' name='numtel'/></p>
			<input type='submit' value='Envoyer'/>
		</form>	
			</div>
                        		
 <c:import url="/footer.htm"></c:import>