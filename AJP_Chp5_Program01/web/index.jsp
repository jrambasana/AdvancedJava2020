<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Page</title>
    </head>
    <body>
        <h1>Add Customer Page</h1>
        <form action="addCustomer.jsp" method="post">
            First Name:<input type="text" name="first_name"/><br><br/>
            Last Name<input type="text" name="last_name"/><br><br/>
            Age:<input type="text" name="age"/><br><br/>
            City:<input type="text" name="city"/><br><br/>
            Contact:<input type="text" name="contact"/><br><br/>
            Address:<input type="text" name="address"/><br><br/>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
