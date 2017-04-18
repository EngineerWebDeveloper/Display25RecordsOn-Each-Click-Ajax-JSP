<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
     <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
</head>
<body>
<table id="table_content">
  <button id="viewmore">View more</button>  
</table>
</body>
<script>
$(document).ready(function() {
	var init=0;
    var end=25;
	(function poll() {
	    $.ajax({
	        url : 'DisplayPosts',
	        type : 'GET',
	        data : {},
	        dataType:'json',
	        success : function(response) {
	        var json_obj = $.parseJSON(JSON.stringify(response));
	        var output="";
	        
	        $("#viewmore").click(function() {
	        	
	        	end=end+25;
	        	poll();
	        
	        });
	        for (i in json_obj) 
	        {  if(i<=end && i >= init) {
	            output+="<tr>";
	            output+="<td>" + json_obj[i].post + "</td>" ;
	            output+="</tr>";}
	        }
	        $('#table_content').html(output);
	        },
	       
	        dataType: "json",
	       
	    })
	})();
});
        </script>
</html>