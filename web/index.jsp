<%--
  Created by IntelliJ IDEA.
  User: dog
  Date: 2/5/16
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <center>
    <form name="post" action="http://localhost:8080/GenericServlet">
        <table>
            <tr>
                <td><b>Employee</b></td>
                <td><input type= textbox name="p" size="25" value=""></td>
            </tr>
            <tr>
                <td><b>Phone</b></td>
                <td><input type= textbox name="p" size="25" value=""></td>
            </tr>
        </table>
        <input type=submit value="Submit">
  </body>
</html>
