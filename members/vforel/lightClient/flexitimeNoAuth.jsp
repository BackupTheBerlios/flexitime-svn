<!DOCTYPE HTML PUBLIC "-//W3//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<title>FlexiTime</title>
<link rel="stylesheet" type="text/css" title="flexicss" href="/res/flexitime.css" />
  
</head>
<body>
<%
	String login = (String) request.getAttribute("login");
	String codeErreur = (String) request.getAttribute("codeErreur");
%>
<center>
<table class="sampletable">
<tr><td colspan="3"><table bgcolor="#f7f9fb" border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
<td WIDTH="8"><img name="header_r2_c1" src="/res/header_r2_c1.jpg" width="8" height="70" border="0" alt="1"></td>

<td WIDTH="100%" background="/res/header_r2_c9.jpg"><a href="/"><img name="header_r2_c2" src="/res/logo.jpg" width="300" height="70" border="0" alt="Bienvenue sur " TITLE="Bienvenue sur "></A></td>
<td nowrap background="/res/header_r2_c9.jpg" >
</td>
<td WIDTH="1"><img src="/res/spacer.gif" width="1" height="70" border="0" alt=""></td>
</tr>
</TABLE></td></tr>
<tr bgcolor="#F7F9FB">
	<form action="" method="post">
		<td background="/res/header_r3_c8.jpg"><b>Nom: </b><input type="text" name="login" 
			<%
			 if(!codeErreur.equals("0") || login!=null){ out.println(" value=\"" + login + "\""); } 
			 %>
		></td>
		<td background="/res/header_r3_c8.jpg"><b>Mot de passe: </b><input type="password" name="password"></td>
		<td background="/res/header_r3_c8.jpg"><input type="submit" name="auth" value="Valider">
												<input type="submit" name="aide" value="Aide"></td>
	</form>
</tr>
<% if(!codeErreur.equals("0")){ 
out.println("<tr><td background=\"/res/header_r3_c8.jpg\" align=\"center\" colspan=\"3\"><font color=\"red\"><b>"+codeErreur+"</b></font></td></tr>");
} %>
<tr>
<td colspan="3" align="center"><img src="/res/logo-umlv.jpg" alt="umlv"></td>
</tr>
<tr>
<td colspan="3" align="center">Ce site a pour but d'afficher les emplois du temps des étudiants de Marne-la-Vallée !</td>
</tr>
</table>
</center>
</body>


</html>