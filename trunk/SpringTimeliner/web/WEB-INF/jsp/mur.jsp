<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
			<div id="contenu">
			<form method='post' action='/SpringTimeliner/${action}.htm' name='formulaire'>
				
                                    <p>Quoi de neuf ? <textarea name='contenu'></textarea></p>
                                <input type='submit' value='Envoyer'/>
                        </form>	
                        
                            <c:forEach items="${list_status}" var="current">
                               <!-- Feed Entry -->
                                <div class="row">
                                  <div class="two columns mobile-one"><img src="http://placehold.it/80x80&text=[img]" /></div>
                                  <div class="ten columns">
                                    <p><strong>Some Person said:</strong> ${current.contenu}</p>
                                    <ul class="inline-list">
                                      <li><a href="">Reply</a></li>
                                      <li><a href="">Share</a></li>
                                    </ul>
                                  </div>
                                </div>
                                <!-- End Feed Entry -->

                                <hr />
                            </c:forEach>                          
			</div>
		
 <c:import url="/footer.htm"></c:import>