<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/common.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function idChk(id){
		console.log("clicked id: "+id); //ctntIdxXX
		let url = "board/detail/"+id
		
		$.ajax({
			url : "board/cntPlus/"+id,
			method : "get"
			});
		$.ajax({
			url : url,
			method : "get",
			success: function(data){
				//window.location.href(url); deprecated
				window.location.assign(url); 
			}
			});
	}
</script>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="boardDTO" items="${boardList}" varStatus="status">  
			<tr>
				<td>${boardDTO.idx}</td>
				<td id="${boardDTO.idx}" onclick="idChk(id)">${boardDTO.title}</td>
				<td>${boardDTO.writer}</td>
				<td>${boardDTO.viewCnt}</td>
				<td><c:out value="${boardDTO.insertTime}"/> </td>
			</tr>  
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>