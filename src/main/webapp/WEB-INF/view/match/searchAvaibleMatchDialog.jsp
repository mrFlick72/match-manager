<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>

    <script>
        $(document).ready(function() {
            var searchAvaibleMatch = $('#searchAvaibleMatch');
            var searchAvaibleMatchForm = searchAvaibleMatch.children('form').filter('form');

            searchAvaibleMatch.dialog({
                resizable:false,
                buttons: {"OK": function() {searchAvaibleMatchForm.submit(); $( this ).dialog( "close" );}}
            });

        } );
    </script>

    <div id="searchAvaibleMatch" title="Search vaible match dialog form!">

        <h1> Choice a day </h1>

        <form name="searchAvaibleMatch" method="post" action="searchAvaibleMatch">
            <input name="date" type="text" class="datePickerMarker"/>

                <select name="selectedHour">
                    <option> ---------- </option>
                    <c:forEach items="${hours}" var = "hour">
                        <option>
                            ${hour}
                        </option>
                    </c:forEach>
                </select>
        </form>
    </div>

</div>