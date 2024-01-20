<!DOCTYPE html>
<html>

<head>
    <title>Accountant Home</title>
    <style>
        body {
            background-color: black;
            color: white;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        h1 {
            font-size: 150%;
            color: yellow;
            text-align: center;
        }

        h2 {
            font-size: 150%;
            color: green;
            text-align: center;
        }

        h3 {
            font-size: 100%;
            color: white;
            text-align: center;
        }

        #top {
            color: white;
            padding: 20px;
            text-align: center;
            border-bottom: 2px solid white;
        }

        #middle {
            padding: 20px;
            text-align: center;
            border-bottom: 2px solid white;
        }

        #bottom {
            padding: 0px;
            text-align: center;
        }

        .box {
            position: relative;
            width: 1300px;
            height: 400px;
            border: 2px solid white;
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: grey;
        }

        .button-container {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin-top: 10px;
        }

        button {
            padding: 10px;
            font-size: 14px;
        }

        #button1 {
            background-color: brown;
            color: green;
            padding: 5px;
            font-weight: bold;
            font-size: 18px;
        }

        #button2 {
            background-color: brown;
            color: red;
            padding: 5px;
            font-weight: bold;
            font-size: 18px;
        }

    </style>
</head>

<body>
<div id="top">
    <h1>Welcome To The Fall 2023 Project 4 Enterprise System </h1>
    <h2>A Servlet/JSP-based Multi-tiered Enterprise Application Using A Tomcat Container</h2>
</div>
<div id="middle">
    <p text-align="middle">You are connected to the Project 4 Enterprise System database as an <span style="color:red">accountant-level</span> user. </p>
    <p text-align="middle">Please select the operation you would like to perform from the list below. </p>
    <form method="post" action="Accountanthome">
        <div class="box">
            <input type="radio" id="operation1" name="select" value="maxStatus">
            <label for="operation1"><span style="color:blue">Get The Maximum Status Value Of All Suppliers</span><span style="color:black">(Returns a maximum value)</span></label><br>
            <input type="radio" id="operation2" name="select" value="totalWeight">
            <label for="operation2"><span style="color:blue">Get The Total Weight Of All Parts</span><span style="color:black">(Returns a Sum)</span></label><br>
            <input type="radio" id="operation3" name="select" value="numSuppliers">
            <label for="operation3"><span style="color:blue">Get The Number Of Suppliers</span><span style="color:black">(Returns the current number of shipments in total)</span></label><br>
            <input type="radio" id="operation4" name="select" value="workersInfo">
            <label for="operation4"><span style="color:blue">Get The Name And Number Of Workers Of The Job With The Most Workers</span><span style="color:black">(Returns two values)</span></label><br>
            <input type="radio" id="operation5" name="select" value="supplierList">
            <label for="operation5"><span style="color:blue">List The Name And Status Of Every Suppliers</span><span style="color:black">(Returns a list of supplier names with status)</span></label><br>
            <div class="button-container">
                <button type="submit" id="button1" name="button" value="execute">Execute Command</button>
                <button type="button" id="button2" name="button" value="clear">Clear Result</button>
            </div>
        </div>
    </form>
    <p text-align="middle">All execution results will appear below this line. </p>
</div>
<div id="bottom">
    <h3>Execution Results:</h3>
    <div id="result" name = "result"></div>
</div>
</body>
</html>