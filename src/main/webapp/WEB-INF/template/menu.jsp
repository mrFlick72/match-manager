<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container_12 sfondo Menu">
    <script>

        $(function() {
            $( "#menu > a" ).button();
        });

    </script>
    <div id="menu" class="grid_12">
        <a href="index">Home</a>
        <a href="registerSquadraForm">Create team</a>
        <a href="getSquadre">View all team</a>
        <a href="registerMathcForm">New match</a>
        <a href="joinInMatch">Search a match</a>

    </div>
    <div class="clear"></div>
</div>
