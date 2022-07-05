<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../common/common.jsp" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
let rootPath = "${pageContext.request.contextPath}/";
	$(function(){
		$('#updateBtn').on('click',function(){
			let param = "${dto.idx}";
			let rootPath = "${pageContext.request.contextPath}/";
			$.ajax({
				url : rootPath + "board/updateContent",
				method : "post",
				data : {
					id : "${dto.idx}"
				},
				success : function(data) {
					let newUrl = rootPath + data;
					window.location.assign(newUrl);
				}
			});
			
		});
		
		$('#deleteBtn').on('click',function(){
			let option = {
					url : "",
					method : "get",
					success : function(data) {
						
					}
				};
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
			<td>${dto.title}</td>
			<td>조회수: ${dto.viewCnt}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${dto.content}</td>
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