<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Calculator</title>
          <link href="${pageContext.request.contextPath}/resources/css/style.css"
    rel="stylesheet">
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/javascript.js"></script>
</head>
<body>
<h>${errormessage}</h>
<h1>  Calculator</h1> 


      
            <div id="calculator" class="calculator">
       
        <table>
            <tr>


                <input type="text" class="dis" id="display" name="display"  onkeydown=" return keydown(event)" onpaste=" return false" value="${obj.result.Answer}"/><br>
            </tr>
            <tr>
                <input type="button" class="num" value="7" onclick="numInput(value)" />
                <input type="button" class="num" value="8" onclick="numInput(value)" />
                <input type="button" class="num" value="9" onclick="numInput(value)" />
                <input type="button" class="ops" value="+" onclick="setOperator(value)" /><br>
            </tr>
            <tr>
                <input type="button" class="num" value="4" onclick="numInput(value)" />
                <input type="button" class="num" value="5" onclick="numInput(value)" />
                <input type="button" class="num" value="6" onclick="numInput(value)" />
                <input type="button" class="ops" value="-" onclick="setOperator(value)" /><br>
            </tr>
            <tr>
                <input type="button" class="num" value="1" onclick="numInput(value)" />
                <input type="button" class="num" value="2" onclick="numInput(value)" />
                <input type="button" class="num" value="3" onclick="numInput(value)" />
                <input type="button" class="ops" value="*" onclick="setOperator(value)" /><br>
            </tr>
            <tr>
                <input type="button" class="num" value="0" onclick="numInput(value)" />
                <input type="button" class="num" value="." onclick="insertDecimal(value)"/>
                <input type="button" class="ops" value="C" onclick="clearDisplay()" />
                <input type="button" class="ops" value="/" onclick="setOperator(value)" /><br>
            </tr>
            <tr>
                <input type="button" class="ops" value="(" onclick="numInput(value)" />
                <input type="button" class="ops" value=")" onclick="numInput(value)" />
                <input type="button" class="ops" value="Del" onclick="deleteLastDigit()" />
                 <input type="button" class="ops" value="=" onclick="getDataOfCalculator()" />
             
            </tr>
            
            </table>
            </div>
            <div id="result1"> Result</div>
      


</body>
</html>