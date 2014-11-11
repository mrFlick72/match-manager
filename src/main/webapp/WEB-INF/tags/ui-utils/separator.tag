<%@ attribute name="columnNumber" required="true" %>
<%@ attribute name="containerClass" required="false" %>
<%@ attribute name="separatorClass" required="false" %>

<div class="row ${containerClass}">
    <div class = "col-lg-${columnNumber} col-md-${columnNumber} col-sm-${columnNumber} col-xs-${columnNumber}">
        <hr class="${separatorClass}"/>
    </div>
</div>