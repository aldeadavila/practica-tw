<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="HOME" />
    <c:param name="body">
        <h2>Hola equipo!</h2>
        <p>
            ${f:h(serverTime)} <br>
        </p>
        <ul>
            <li><a href='${pageContext.request.contextPath}/person/list/'>LISTA DE PERSONAS</a></li>
            <li><a href='${pageContext.request.contextPath}/person/form/'>CREAR PERSONAS</a></li>
        </ul>
    </c:param>
</c:import>

