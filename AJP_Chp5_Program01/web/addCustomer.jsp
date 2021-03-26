<%@page contentType="text/html" pageEncoding="UTF-8"
import="hibernate01.CustomerDAO,hibernate01.Customer,org.hibernate.*,org.hibernate.boot.*,org.hibernate.boot.registry.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Page</title>
    </head>
    <body>
        <jsp:useBean id="cust1" class="hibernate01.Customer"/>
        <jsp:setProperty name="cust1" property="*"/>
        
        <%
            int i = CustomerDAO.register(cust1);
            if (i>0)
            {
        %>  
                <h3>Customer added successfully!</h3>
        <%
            }
            else
            {
        %>
                <h3>Customer Not added!!!</h3>
        <% 
            }
        %>
        <p>View all the Customers <a href="viewCustomers.jsp">here</a></p>
    </body>
</html>
