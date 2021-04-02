<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*,hibernate01.CustomerDAO,hibernate01.Customer,org.hibernate.*,org.hibernate.boot.*,org.hibernate.boot.registry.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Customers Page</title>
    </head>
    <body>
        
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th> 
            <th>Last Name</th>
            <th>Age</th>
            <th>Contact</th> 
            <th>Address</th>
            <th>City</th>
            <th>State</th>
        </tr>
    <%
        List customers = CustomerDAO.listCustomers();
        for (Iterator itr = customers.iterator(); itr.hasNext();)
        {
            Customer cust1 = (Customer) itr.next(); 
    %>
            <tr>
                <td><%= cust1.getId() %></td>
                <td><%= cust1.getFirst_name() %></td>
                <td><%= cust1.getLast_name() %></td>
                <td><%= cust1.getAge()%></td>
                <td><%= cust1.getContact()%></td>
                <td><%= cust1.getAddress()%></td>
                <td><%= cust1.getCity()%></td>
                <td><%= cust1.getState()%></td>
            </tr>   
    <%
        }
    %>
    </table>
    </body>
</html>
