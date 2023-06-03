<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Objects.violation" %>
<%@ page import="java.util.List" %>
<%@ page import="classes.DAO.DAOFactory" %>
<%@ page import="classes.DAO.mapKey" %>
<%@ page import="classes.DAO.violationsDAO" %>
<%@ page import="classes.DAO.countryDAO" %>
<%@ page import="Objects.city" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.FileInputStream"%>

<!DOCTYPE html>
<html>
<head>
    <title>Online HTML Editor</title>
    <style>
        .frame {
            position: absolute;
            height: 400px;
            width: 1100px;
            background-color: #d9d9d9;
            left: 50%;
            top: 53%;
            transform: translate(-50%,-50%);
            box-shadow: 16px 16px 15px #8c8c8c;
            border-radius: px;
        }
        .down {
            width : 100%;
            border-collapse : collapse;
            top: 20%;
        }
     .submit-btn {
    		display: block;
    		width: 50%;
    		padding: 10px;
    		background-color: #4CAF50;
    		color: #fff;
            font-weight: bold;
    		border: none;
    		border-radius: 5px;
            cursor: pointer;
  		}
  		.center{
            display : flex;
            justify-content : center;
          }
  	.submit-btn:hover {
    		background-color: #45a049;
  		}
  		#last{
               position : fixed;
            bottom : 20px;
          }
  		
    </style>
</head>
<body>
    <h1>Violations:</h1>
    <div class="frame">
        <table class ="down">
           <tbody>
    <% 
        DAOFactory dao = DAOFactory.getInstance();
        violationsDAO vioDao = (violationsDAO) dao.getDAO(mapKey.violation);
        List<violation> violations = (List<violation>) vioDao.getById(null);

        for (violation vio : violations) {
            String dateString = "2023-06-02";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateString);
            LocalDate currentDate = LocalDate.now();

            long days = ChronoUnit.DAYS.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), currentDate);
            if (days >= 30) {
                vioDao.delete(vio.getVioId());
            }
            violations = (List<violation>) vioDao.getById(null);
        }

        if (!violations.isEmpty()) { 
            violation vio = violations.get(0);
            String countryName = (String) ((countryDAO) dao.getDAO(mapKey.country)).getById(vio.getCountryId());
            int id = vio.getVioId();
    %>
    <tr>
        <td>
            <%= vio.getCity() + "<br>" + countryName %>
        </td>
        <td>
            <% 
                String mediaPath = vio.getMedia();
                if (mediaPath.endsWith(".jpg") || mediaPath.endsWith(".jpeg") || mediaPath.endsWith(".png")) {        
                 request.setAttribute("image", mediaPath);
            %>
    		 <jsp:useBean id="mediabean" class="classes.mediaBean" scope="session"></jsp:useBean>
    		 <jsp:setProperty property="path" name="mediabean" value="<%=mediaPath%>"/>
             <form action = "displayImage" action = "get">
                  <input type = "submit" value="View Image">
             </form>      
           
            <% 
                } else if (mediaPath.endsWith(".mp4") || mediaPath.endsWith(".avi") || mediaPath.endsWith(".mov")) { 
            %>
            <video controls>
                <source src="<%= mediaPath %>" type="video/mp4" />
                <h2>Your browser does not support the video tag.</h2>
            </video>
           
            <% 
                } else { 
            %>
            
            Unsupported media format.
            <% } %>
        </td>
        <td>Violation Type: <br> <%= vio.getVioType() %></td>
        <td>Violation Date: <br> <%= vio.getDate() %></td>
        <td>
            <jsp:useBean id="beanid" class="classes.Bean" scope="session" />
            <jsp:setProperty property="id" name="beanid" value="<%= id %>" />
            
        
        </td>
    </tr>
    <% } %>
</tbody>
		
        </table>
        
        <%if(violations.size() != 0) {%>
            <form action="violationAction" method="post">
               <div class="center">
                <input type="submit" class="submit-btn" name="accept" value="Accept" />
                </div>
                <br>
                <div class="center">
                <input type="submit" class="submit-btn" name="accept" value="Reject" />
                </div>
            </form>
        <%}%>
        
    </div>
    <form action="Hello.html" action="post">
        <div class="center">
        <input id ="last" type="submit" class="submit-btn" value="Back">
        </div>
    </form>
</body>
</html>
