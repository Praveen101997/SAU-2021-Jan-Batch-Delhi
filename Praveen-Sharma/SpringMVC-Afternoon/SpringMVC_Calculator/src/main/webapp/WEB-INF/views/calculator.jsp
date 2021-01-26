<html>
<head>
    <title>Spring MVC Calculator</title>
    <style><%@include file="/WEB-INF/css/calculator.css"%></style>
</head>
<body>
    <form action="/springmvccalculator/calculator" method="POST">
        Enter First Number : <input name="firstNum" type="text" />
        Enter Second Number : <input name="secondNum" type="text" />
        Operation : <select name="operation">
            <option value="add">Addition</option>
            <option value="sub">Substraction</option>
            <option value="mul">Multiply</option>
            <option value="div">Division</option>
        </select>
        <input type="submit" text="Calculate"/>
    </form>
</body>
</html>