<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>
    <head>
        <tiles:insertAttribute name="head" />
    </head>

    <body>
        <%--div di header--%>
        <tiles:insertAttribute name="header" />

        <%--di per il menu--%>
        <tiles:insertAttribute name="menu" />

        <!--search div-->
        <div class="container-fluid sfondo body">
            <tiles:insertAttribute name="content" />
        </div>

        <%--footer div --%>
        <tiles:insertAttribute name="footer" />
    </body>
</html>