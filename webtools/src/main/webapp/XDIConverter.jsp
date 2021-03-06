<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XDI Converter</title>
<link rel="stylesheet" target="_blank" href="style.css" TYPE="text/css" MEDIA="screen">
</head>
<body style="background-image: url('images/back.png'); background-repeat: repeat-y; margin-left: 30px;">

	<div class="header">
	<img src="images/logo64.png" align="middle">&nbsp;&nbsp;&nbsp;<span id="appname">XDI Converter</span>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<% for (int i=0; i<((Integer) request.getAttribute("sampleInputs")).intValue(); i++) { %>
		<a href="XDIConverter?sample=<%= i+1 %>">Sample <%= i+1 %></a>&nbsp;&nbsp;
	<% } %>
	<a href="index.jsp">&gt;&gt;&gt; Other Apps...</a>
	</div>

	<% if (request.getAttribute("error") != null) { %>
			
		<p><font color="red"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></font></p>

	<% } %>

	<form action="XDIConverter" method="post">

		<textarea class="input" name="input" style="width: 100%" rows="12"><%= request.getAttribute("input") != null ? request.getAttribute("input") : "" %></textarea><br>

		<% String from = (String) request.getAttribute("from"); if (from == null) from = ""; %>
		<% String to = (String) request.getAttribute("to"); if (to == null) to = ""; %>

		Convert from:
		<select name="from">
		<option value="AUTO" <%= from.equals("AUTO") ? "selected" : "" %>>auto-detect</option>
		<option value="XDI/JSON" <%= from.equals("XDI/JSON") ? "selected" : "" %>>XDI/JSON</option>
		<option value="STATEMENTS" <%= from.equals("STATEMENTS") ? "selected" : "" %>>STATEMENTS</option>
		</select>
		to:
		<select name="to">
		<option value="XDI/JSON" <%= to.equals("XDI/JSON") ? "selected" : "" %>>XDI/JSON</option>
		<option value="STATEMENTS" <%= to.equals("STATEMENTS") ? "selected" : "" %>>STATEMENTS</option>
		<option value="STATEMENTS_WITH_CONTEXT_STATEMENTS" <%= to.equals("STATEMENTS_WITH_CONTEXT_STATEMENTS") ? "selected" : "" %>>STATEMENTS_WITH_CONTEXT_STATEMENTS</option>
		</select>
		<input type="submit" value="Go!">
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="XDIConverterHelp.jsp">What can I do here?</a>

		<% if (request.getAttribute("stats") != null) { %>
			<p>
			<%= request.getAttribute("stats") %>

			<% if (request.getAttribute("output") != null) { %>
				Copy&amp;Paste: <textarea style="width: 100px; height: 1.2em; overflow: hidden"><%= request.getAttribute("output") != null ? request.getAttribute("output") : "" %></textarea>
			<% } %>
			</p>
		<% } %>

		<% if (request.getAttribute("output") != null) { %>
			<div class="result"><pre><%= request.getAttribute("output") != null ? request.getAttribute("output") : "" %></pre></div><br>
		<% } %>
	</form>
	
</body>
</html>
