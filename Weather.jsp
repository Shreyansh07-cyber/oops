<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>____WEATHER FORECAST____</title>
    
</head>
<body>

<%
    try {
        String city = request.getParameter("CityName");
        String apiKey = "648239e333d7415271fa154172f4a457";

        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey +"&units=imperial";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder resp = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                resp.append(line);
            }
            reader.close();
			

	    JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(resp.toString());
			
            JSONObject main = (JSONObject) data.get("main");
            String tempValue = main.get("temp").toString();
            
            JSONObject feelslike = (JSONObject) data.get("main");
            String feelslikeValue = main.get("feels_like").toString();
            
            
            String placeName = data.get("name").toString();
            
                        
            out.print("<table border='1'>");
            out.print("<tr><th>Field</th><th>Value</th></tr>");
			
            out.print("<tr><td>City Name</td><td>" + placeName + "</td></tr>");
            out.print("<tr><td>Temperature</td><td>" + tempValue + "°F</td></tr>");
            out.print("<tr><td>Feels Like</td><td>" + feelslikeValue + "°F</td></tr>");
            
			
            out.print("</table>");
            out.print("</p>");
            
        } else {
        
            out.print("Error: Unable to get weather data due to \"wrong input\", please insert CITYNAME again </br></br>");
            out.print("<a href='Weather.html'>Click to enter CITYNAME again</a>");
           // response.sendRedirect("Weather.html");

        }
    } catch (Exception e) {
        e.printStackTrace();
        out.print("Error: An exception occurred.");
    }
%>
</body>
</html>
