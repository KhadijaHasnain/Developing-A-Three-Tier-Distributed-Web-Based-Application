<!DOCTYPE html>
<html>

<head>
    <title>Add shipment record</title>
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
            color: skyblue;
            text-align: center;
        }

        h3 {
            font-size: 100%;
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

        .box {
            position: relative;
            width: 1300px;
            height: 200px;
            border: 2px solid white;
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .box::before {
            content: "Record Insert";
            position: absolute;
            top: -15px;
            left: 5px;
            background-color: black;
            padding: 0 5px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            text-align: center;
        }

        th, td {
            border: 1px solid;
            padding: 8px;
            border-color : yellow;
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
    <h2>Data Entry Application</h2>
</div>
<div id="middle">
    <p text-align="middle">You are connected to the Project 4 Enterprise System database as a <span style="color:red">data-entry-level</span> user. </p>
    <p text-align="middle">Enter data values in the form below to add a new record to the corresponding database table. </p>
    <form method="post" action="Dataentry">
        <div class="box">
            <table>
                <tr>
                    <th>snum</th>
                    <th>sname</th>
                    <th>status</th>
                    <th>city</th>
                </tr>
                <tr>
                    <td><input type="text" name="snum"></td>
                    <td><input type="text" name="sname"></td>
                    <td><input type="text" name="sstatus"></td>
                    <td><input type="text" name="scity"></td>
                </tr>
            </table>
            <div class="button-container">
                <button type="submit" id="button1" name="button" value="addsupplier">Enter Supplier Records into Database</button>
                <button type="button" id="button2" name="button" >Clear Data and Result</button>
            </div>
        </div>
 
        <div class="box">
            <table>
                <tr>
                    <th>pnum</th>
                    <th>pname</th>
                    <th>color</th>
                    <th>weight</th>
                    <th>city</th>
                </tr>
                <tr>
                    <td><input type="text" name="pnum"></td>
                    <td><input type="text" name="pname"></td>
                    <td><input type="text" name="pcolor"></td>
                    <td><input type="text" name="pweight"></td>
                    <td><input type="text" name="pcity"></td>
                </tr>
            </table>
            <div class="button-container">
                <button type="submit" id="button1" name="button" value="addparts">Enter Parts Records into Database</button>
                <button type="button" id="button2" name="button" >Clear Data and Result</button>
            </div>
        </div>

        <div class="box">
            <table>
                <tr>
                    <th>jnum</th>
                    <th>jname</th>
                    <th>numworker</th>
                    <th>city</th>
                </tr>
                <tr>
                    <td><input type="text" value="jnum"></td>
                    <td><input type="text" value="jname"></td>
                    <td><input type="text" value="jnumworker"></td>
                    <td><input type="text" value="jcity"></td>
                </tr>
            </table>
            <div class="button-container">
                <button type="submit" id="button1" name="button" value="addjob">Enter Jobs Records into Database</button>
                <button type="button" id="button2" name="button" >Clear Data and Result</button>
            </div>
        </div>

        <div class="box">
            <table >
                <tr>
                    <th>snum</th>
                    <th>pnum</th>
                    <th>jnum</th>
                    <th>quantity</th>
                </tr>
                <tr>
                    <td><input type="text" name="ssnum"></td>
                    <td><input type="text" name="spnum"></td>
                    <td><input type="text" name="sjnum"></td>
                    <td><input type="text" name="squantity"></td>
                </tr>
            </table>
            <div class="button-container">
                <button type="submit" id="button1" name="button" value="addshipment">Enter Shipment Records into Database</button>
                <button type="button" id="button2" name="button" >Clear Data and Result</button>
            </div>
        </div>
    </form>
</div>
<div id="bottom">
    <h3>Execution Results:</h3>
    <div id="result" name ="result"></div>
</div>
</body>

</html>
