<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <script>
	var date;
   	var hour;
   	var footballField;
   	
        $(function(){
            var registerMatchTable = $( "#registerMatchTable > tbody > tr");
            
           	registerMatchTable.filter(":even").addClass("tableEven");
           	registerMatchTable.filter(":odd").addClass("tableOdd");
           	
       
           	
           	registerMatchTable.click(function(){
               		registerMatchTable.not(this)
               						  .find("input[type=checkbox]")
               						  .removeAttr("checked");
               	});

           
        })
    </script>

    <div class="grid_12">

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
            <button type="submit">Search</button>
        </form>
    </div>
    <div class="clear"></div>
        <div class="grid_6 ">
            <form name="registerMatch">
            <c:if test="${avaibleFootBallFields != null}">
                <table id="registerMatchTable">
                    <thead>
                    <tr>
                        <td>Date</td>
                        <td>Hour</td>
                        <td>FootBall Field</td>
                        <td>Choice</td>
                    </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${avaibleFootBallFields}" var = "avaibleFootBallField">
                            <tr>
                            <td>${dateRequest}</td>
                            <td>${hourRequest}</td>
                            <td>${avaibleFootBallField}</td>
                            <td><input type="checkbox"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </c:if>
               

                <table class="datePickerMarker teamBox">
                    <thead>
                    <tr>
                        <td>Team name</td>
                        <td>Select</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${squadreByReferente}" var="squadra">
                        <tr>
                            <td>${squadra.nome}</td>
                            <td onclick="prenotaPartita('${squadra.nome}')">join</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>

        <div class="grid_6 "></div>
        <div class="clear"></div>