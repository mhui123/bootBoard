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
		$('#confirmBtn').on('click',function(){
			let url = rootPath + "board/writeContent"
			let newTitle = $('#titleInput').val();
			let newContent = $('#contentInput').val();
			$.ajax({
				url : url,
				method : "post",
				data : {
					title : newTitle,
					content : newContent,
					writer : "tester"
				},
				success : function(data) {
					if(data > 0){
						alert("write complete");
						window.location.assign(rootPath); 
					}
				}
			});
		})
	});
	</script>
	<table>
		<tbody>
			<tr>
				<td>
					<p>제목</p>
					<input type="text" id="titleInput"/>
				</td>
			</tr>
			<tr>
				<td>
					<p>내용</p>
					<input type="text" id="contentInput"/>
				</td>
			</tr>
		</tbody>
	</table>
	<button id="confirmBtn">확인</button>
	<button id="cancelBtn">취소</button>
</body>
</html>