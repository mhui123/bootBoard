<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../common/common.jsp" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
let updateChk = 0;
let rootPath = "${pageContext.request.contextPath}/";
	$(function(){
		$('#updateBtn').on('click',function(){
			if(updateChk == 0){
				updateChk = 1;
				$('#titlePlace').empty();
				$('#contentPlace').empty();
				$('#titlePlace').append("<input type='text' id='updateTitle'/>")
				$('#contentPlace').append('<textarea id="updateContent" rows="10" cols="50">');
			} else {
				updateChk = 0;
				let url = rootPath+"board/updatePage";
				let newTitle = $('#updateTitle').val();
				let newContent = $('#updateContent').val();
				
				$.ajax({
					url : url,
					method : "put",
					data : {
						idx : "${dto.idx}",
						title : newTitle,
						content : newContent,
						writer : "tester"
					},
					success : function(data) {
						if(data > 0){
							alert("update complete");
							window.location.assign(rootPath); 
						}
					}
				});
			}
		});
		
		$('#deleteBtn').on('click',function(){
			let url = rootPath+"board/deletePage";
			$.ajax({
				url : url,
				method : "delete",
				data : {
					idx : "${dto.idx}"
				},
				success : function(data) {
					if(data > 0){
						alert("delete complete");
						window.location.assign(rootPath); 
					}
				}
			});
		});	
		
		$('#returnBtn').on('click',function(){
			
			let url = "/";
			window.location.assign(url); 
		});	
	})
	
	
</script>
	<table>
		<tr>
			<td>${dto.idx}</td>
			<td id="titlePlace">${dto.title}</td>
			<td>조회수: ${dto.viewCnt}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td id="contentPlace">${dto.content}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.writer}</td>
		</tr>
	</table>
	<div class="btnPlace">
		<button id="updateBtn">수정</button>
		<button id="deleteBtn">삭제</button>
		<button id="returnBtn">돌아가기</button>
	</div>
	
	
</body>
</html>