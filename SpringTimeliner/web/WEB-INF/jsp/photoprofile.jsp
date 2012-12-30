<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
    <div id="contenu">
        <form method='post' action='/SpringTimeliner/valid_photoprofile.htm' name='formulaire' enctype="multipart/form-data">

                        <p>Photo de profile : <input type='file' name='photo'/></p>
                <input type='submit' value='Envoyer'/>
        </form>	
    </div>
		
 <c:import url="/footer.htm"></c:import>