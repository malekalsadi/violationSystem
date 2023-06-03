<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="classes.DAO.DAOFactory" %>
<%@ page import="classes.DAO.mapKey" %>
<%@ page import="classes.DAO.violationsDAO" %>
<%@ page import="classes.DAO.countryDAO" %>
<%@ page import="classes.DAO.citiesDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="Objects.city"%>
<html>
<head>
    <title>City Videos</title>
    <style>
        body{
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h3{
            margin-bottom: 20px;
            font-family: "Franklin Gothic Book"; 
        }
        
        .video-container{
            max-width: 1000px;
            margin: 0 auto;
        }
        iframe{
            width: 100%;
            height: 500px;
        }
    </style>
</head>
<body>
    <h1>City Videos</h1>
    <div class="video-container">
        <%
        String id = (String) request.getAttribute("city");
        String country = (String) request.getAttribute("country");
        // Java code block
        if (id!=null){
            switch(id){
                // USA
                case "NewYork":
                    String videoUrl1 = "https://www.youtube.com/embed/MtCMtC50gwY";
                    out.println("<iframe src=\"" + videoUrl1 + "\"></iframe>");
                    break;
                
                case "Los Angeles":
                    String videoUrl2 = "https://www.youtube.com/embed/bTvr_2v-0HI";
                    out.println("<iframe src=\"" + videoUrl2 + "\"></iframe>");
                    break;
                
                case "Chicago":
                    String videoUrl3 = "https://www.youtube.com/embed/UWdfaNWThnA";
                    out.println("<iframe src=\"" + videoUrl3 + "\"></iframe>");
                    break;
                
                case "Houston":
                    String videoUrl4 = "https://www.youtube.com/embed/nBH6FwbOgPs";
                    out.println("<iframe src=\"" + videoUrl4 + "\"></iframe>");
                    break;
                
                // UK
                case "London":
                    String videoUrl = "https://www.youtube.com/embed/NYY2ELEH0AA";
                    out.println("<iframe src=\"" + videoUrl + "\"></iframe>");
                    break;
                
                case "Manchester":
                    String videoUrl5 = "https://www.youtube.com/embed/o_TKIM1vUEs";
                    out.println("<iframe src=\"" + videoUrl5 + "\"></iframe>");
                    break;
                
                case "Birmingham":
                    String videoUrl6 = "https://www.youtube.com/embed/Yd75ADasBoo";
                    out.println("<iframe src=\"" + videoUrl6 + "\"></iframe>");
                    break;
                
                case "Glasgow":
                    String videoUrl7 = "https://www.youtube.com/embed/k7ZqiSKIB9g";
                    out.println("<iframe src=\"" + videoUrl7 + "\"></iframe>");
                    break;
                
                // UAE
                case "Dubai":
                    String videoUrl8 = "https://www.youtube.com/embed/ahy5o5nT4oI";
                    out.println("<iframe src=\"" + videoUrl8 + "\"></iframe>");
                    break;
                
                case "Sharjah":
                    String videoUrl9 = "https://www.youtube.com/embed/tMydHsGB4wg";
                    out.println("<iframe src=\"" + videoUrl9 + "\"></iframe>");
                    break;
                
                case "AbuDhabi":
                    String videoUrl10 = "https://www.youtube.com/embed/_5CSitKheXQ";
                    out.println("<iframe src=\"" + videoUrl10 + "\"></iframe>");
                    break;
                
                case "Fujairah":
                    String videoUrl11 = "https://www.youtube.com/embed/zPUe9n1_2AM";
                    out.println("<iframe src=\"" + videoUrl11 + "\"></iframe>");
                    break;
                
                // Jordan
                case "Amman":
                    String videoUrl12 = "https://www.youtube.com/embed/p7qMrcLMbOk";
                    out.println("<iframe src=\"" + videoUrl12 + "\"></iframe>");
                    break;
                
                case "Aqaba":
                    String videoUrl13 = "https://www.youtube.com/embed/OqVROy0EXCI";
                    out.println("<iframe src=\"" + videoUrl13 + "\"></iframe>");
                    break;
                
                case "Irbid":
                    String videoUrl14 = "https://www.youtube.com/embed/RSYLGD3-lsc";
                    out.println("<iframe src=\"" + videoUrl14 + "\"></iframe>");
                    break;
                
                case "WadiRam":
                    String videoUrl15 = "https://www.youtube.com/embed/ZJ6fQhE4pcY";
                    out.println("<iframe src=\"" + videoUrl15 + "\"></iframe>");
                    break;
            }
           
          DAOFactory fact = DAOFactory.getInstance();
          citiesDAO ct = (citiesDAO)fact.getDAO(mapKey.city);
          city cy = new city();
          cy.setCityName(id);
          int countryId = ((countryDAO) fact.getDAO(mapKey.country)).getCountryId(country);
          cy.setId(countryId);
          
          List<Integer> lst = (List<Integer>)ct.getById(cy);
          if(lst.get(0)<10){%>
               <h1>the city is : clear</h1>
               <h3><%= id %> is considered one of the cleanest cities in <%=country%> with number of clean violations less than <%=lst.get(0)+1%></h3> 
         <%}else{ %>
               <h1>the city is : dirty</h1>
               <h3><%= id %> is considered one of the dirtiest cities in <%=country%> with number of clean violations more than <%=lst.get(0)+1%></h3>         
          <%}
          
          if(lst.get(1)<10 && lst.get(2)<10){%>
               <h1>the city is : safe</h1>
               <h3><%= id %> is considered one of the safest cities in <%=country%> with number of safe violations less than <%=lst.get(1)+1%></h3> 
               
         <%}else{ %>
               <h1>the city is : Dangerous</h1>
               <% int mx = Math.max(lst.get(1),lst.get(2));%>
               <h3><%= id %> is considered one of the most dangerous cities in <%=country%> with number of dangerous violations more than <%=mx%></h3> 
          <%}
          
          
          if(lst.get(3)<10){%>
               <h1>the city is : sane</h1>
               <h3><%= id %> is considered one of the sane cities in <%=country%> with number of clean violations less than <%=lst.get(3)+1%></h3> 
         <%}else{ %>
               <h1>the city is : Insane</h1>
               <h3><%= id %> is considered one of the Insane cities in <%=country%> with number of Insane violations more than <%=lst.get(3)+1%></h3> 
          <%}
        }
        %>
    </div>
</body>
</html>
