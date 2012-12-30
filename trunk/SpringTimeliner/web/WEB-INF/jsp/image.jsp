<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${user.photoprofile}">
        <img src="/SpringTimeliner/uploads/photoprofile/${user.id}" width="${w}" height="${h}"/>
    </c:when>

    <c:otherwise>
        <img src="http://placehold.it/${w}x${h}&text=[Img]"/>
    </c:otherwise>
</c:choose>