<!DOCTYPE HTML PUBLIC "-//W3//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*,fr.umlv.ir3.flexitime.common.tools.*,fr.umlv.ir3.flexitime.common.data.general.*" %>
<title>FlexiTime</title>
<link rel="stylesheet" type="text/css" title="flexicss" href="/res/flexitime.css" />
 
</head>
<body bgcolor="#E5F8FE">
<%
	String login = (String) request.getAttribute("login");
	String nom = (String) request.getAttribute("longName");
	String edt = (String) request.getAttribute("edt");
	String semaine = (String)request.getAttribute("semaine");
    String planning = (String)request.getAttribute("planning");
    String typeedt = (String)request.getAttribute("typeedt");
	Time time = new Time();
	String typePerson = (String) request.getAttribute("typePerson");
	String listtracks = (String)request.getAttribute("listtracks");
	
%>
<center>

<table bgcolor="#f7f9fb" border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
<td WIDTH="8"><img name="header_r2_c1" src="/res/header_r2_c1.jpg" width="8" height="70" border="0" alt="1"></td>
<td WIDTH="30%" background="/res/header_r2_c9.jpg"><a href="/"><img name="header_r2_c2" src="/res/logo.jpg" width="300" height="70" border="0" alt="Bienvenue sur " TITLE="Bienvenue sur "></A></td>
<td width="*" background="/res/header_r2_c9.jpg" align="center" valign="middle"><b>Bonjour <%= nom %></b><br></td>
<td width="20%" background="/res/header_r2_c9.jpg" align="center" valign="middle" width="300"><b><%= time.getStrDate() %><b></td>
<td nowrap background="/res/header_r2_c9.jpg" ></td>
<td WIDTH="1"><img src="/res/spacer.gif" width="1" height="70" border="0" alt=""></td>
</tr>
</TABLE>
</center>

<table width="100%">
<tr>
<td width="100%" align="right" valign="top">
<form action="/lightClient/" method="post">
<input type="hidden" name="login" value="<%= login %>">
<input type="submit" name="devalid" value="Déconnexion">
</form>
</td>
</tr>
</table>
<center>
<form action="/lightClient<%=typePerson%>" method="post">
<input type="hidden" name="login" value="<%=login%>">
<input type="hidden" name="planning" value="<%= planning %>">
<input type="hidden" name="semaine" value="<%= semaine %>">
<table class="sampletable" width="100%"  cellpadding="0" cellspacing="0"><tr><td colspan="3">
<%
if(typePerson.equals("/TraitementTeacher")){
%>
<%
}else{
%>
<table width="100%" cellpadding="0" cellspacing="0"><tr>
<td align="center" width="50%" background="/res/header_r3_c8.jpg">
<input type="submit" name="typeedt" value="Emploi du temps">
</td>
<td align="center" width="50%" background="/res/header_r3_c8.jpg">
<input type="submit" name="edtsalle" value="Salles">
</td>
</tr></table>
<%
}
%>
</td></tr>
<tr>
<%
if(typePerson.equals("/TraitementTeacher")){
%>
<%
}else{
%>
<td align="center" width="33%" background="/res/header_r3_c8.jpg">
<%
if(planning.equals("hebdo") && !semaine.equals("0")){
%>
<input type="submit" name="stepbefore" value="Semaine précédente">
<%
}else{
%>
&nbsp;
<%
}
%>
</td>
<td align="center" width="*" background="/res/header_r3_c8.jpg">
<%
if(planning.equals("hebdo")){
%><input type="submit" name="switch" value="EDT Trimestriel">
<%
}else{
%>
<input type="submit" name="switch" value="EDT Hebdomadaire">
<%
}
%></td>
<td align="center" width="33%" background="/res/header_r3_c8.jpg">
<%
if(planning.equals("hebdo") && !semaine.equals("2")){
%>
<input type="submit" name="stepafter" value="Semaine suivante">
<%
}else{
%>
&nbsp;
<%
}
%></td>
<%
}
%>
</tr></table>
</form>
<%
if(typeedt.equals("edt")) out.println(edt);
%>
</center>
</body>
</html>