<%@ page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*" %> 
<%@ page import="org.sqlite.*" %> 
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Thank you</title>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <% 
        String feedback; 
        String service; 
        feedback = request.getParameter("feedback"); 
        service = request.getParameter("service");
        String feedback_id = (int) Math.floor(Math.random() * 10) +"@"+ service;
        Class.forName("org.sqlite.JDBC"); 
        String url ="jdbc:sqlite:D:/sqlite/db/feeback.db"; 
        String sql = "CREATE TABLE IF NOT EXISTS feedbacks (feedback_id text PRIMARY KEY, service text NOT NULL, feedback text NOT NULL)"; 
        
        try{ 
            Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();
            stmt.execute(sql); 
            String query = "insert into feedbacks(feedback_id, service, feedback) value(?,?,?)"; 
            PreparedStatement pstm = conn.prepareStatement(query); pstm.setString(1, feedback_id);
            pstm.setString(2, service); 
            pstm.setString(3, feedback);
            pstm.executeUpdate(); 
        }catch (SQLException e) {
            System.out.println(e.getMessage()); 
        } 
    %>

    <div class="container m-3">
      <h1>Thanks for feedback. Your query number is: <%= feedback_id %>  </h1>
    </div>
  </body>
</html>
