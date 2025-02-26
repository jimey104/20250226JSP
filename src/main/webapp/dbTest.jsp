<%@page import="dto.EmpDTO"%>
<%@page import="dao.EmpDAO"%>
<%@page import="dto.DeptDTO"%>
<%@page import="dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DeptDAO deptDAO = new DeptDAO();
deptDAO.connect();

EmpDAO empDAO = new EmpDAO();
for(EmpDTO empDTO : empDAO.selectAll()){
	System.out.println(empDTO.getEmpno());
	System.out.println(empDTO.getEname());
	System.out.println(empDTO.getSal());
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
for(DeptDTO deptDTO : deptDAO.selectAll()){
%>

	<tr>
		<td><%=deptDTO.getDeptno() %></td>
		<td><%=deptDTO.getDname() %></td>
		<td><%=deptDTO.getLoc() %></td>
	</tr>

<% 
}
%>
</table>
</body>
</html>