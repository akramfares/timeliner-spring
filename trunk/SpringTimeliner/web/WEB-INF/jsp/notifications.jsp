<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
<div id="contenu">
    <c:forEach items="${notifications}" var="current">
       <!-- Feed Entry -->
        <div class="row">
          <div class="ten columns">
            <p>${current.contenu}</p>
          </div>
        </div>
        <!-- End Feed Entry -->

        <hr />
    </c:forEach>                          
</div>

 <c:import url="/footer.htm"></c:import>