<!DOCTYPE html>
<html>

<head>
    <title>Root Page</title>
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
            color: red;
            text-align: center;
        }

        p1 {
            font-size: 150%;
            color: green;
            text-align: center;
        }
        
        h3 {
            font-size: 100%;
            color: White;
            text-align: center;
        }
        
         h4 {
            font-size: 80%;
            color: White;
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
        
        textarea {
            background-color: blue;
            color: white;
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
        
        #button3 {
            background-color: brown;
            color: yellow;
            padding: 5px;
            font-weight: bold;
            font-size: 18px;
        }
        
    </style>
</head>

<body>
    <div id="top">
        <h1>Welcome To The Fall 2023 Project 4 Enterprise System </h1>
        <p1>A Servlet/JSP-based Multi-tried Enterprise Application Using a Tomcat Container </p1>
        <h2>- User Authentication Page -</h2>
    </div>
    <div id="middle">
        <p text-align="middle">You are connected to the Project 4 Enterprise System database as a <span style="color:red">root-level</span> user. </p>
        <p text-align="middle">please enter any SQL query or update command in the box below. </p>
        <form method="post" action="Roothome" enctype="text/plain">
        <textarea id="input" name="input" rows="6" cols="90" ></textarea><br> <br>
        <button type="submit" id="button1" name="button" value="execute"><b>Execute Command</b></button> 
        <button type="submit" id="button2" name="button" value="clearfrm">Reset Form</button> 
        <button type="submit" id="button3" name="button" value="clearrst">Clear Result</button>
    </form>
    <p text-align="middle">All execution result will appear below this line. </p>
    </div>
    <div id="bottom">
        <h3>Execution Results:</h3>
        <div name="result">${resultData}</div> 
    </div>
</body>

</html>
