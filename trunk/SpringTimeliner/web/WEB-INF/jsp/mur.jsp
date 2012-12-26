                <jsp:include page="header.jsp" />
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<div id="contenu">
			<form method='post' action='/SpringTimeliner/${action}.htm' name='formulaire'>
				
                                    <p>Contenu : <textarea name='contenu'></textarea></p>
                                <input type='submit' value='Envoyer'/>
                        </form>	
                        
                        <table>
                            <th>Contenu</th>
                            <c:forEach items="${list_status}" var="current">
                              <tr>
                                  <td>${current.contenu}</td>
                              </tr>
                            </c:forEach>                          
                        </table>
			</div>
		</div>
		
	</body>
</html>
