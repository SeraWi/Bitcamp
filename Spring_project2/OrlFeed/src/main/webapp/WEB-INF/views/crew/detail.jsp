<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Crew Details</title>
<link rel="stylesheet" href="<c:url value='/css/crew/crew-detail.css'/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function(){
		
		commentList(0);
		
		$('#submit').click(function(){
			
			var formData = new FormData();
			formData.append("crewIdx", $('#crewIdx').val());
			formData.append("crewComment", $('#crewComment').val());
			
			$.ajax({
				url: 'http://localhost:8080/orl/crew/commentInsert',
				type: 'post',
				data: formData,
				processData: false,
				contentType: false,
				cache: false,
				success : function(data){
					if(data==0){
						alert('로그인 여부를 확인해주세요.');
					}
					commentList(0);
				}
			})
		});
	});
	
	function commentList(parameter){
		$.ajax({
			url: 'http://localhost:8080/orl/crew/getCommentInfo',
			type: 'GET',
			data: {
				crewIdx: '${crew.crewIdx}',
				currentPageNum : '${cri.currentPageNum}'
			},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
			success: function(data){ // data가 json -> js객체로 변환해서 옴
				var html = '';
				var html2 = '';
				$.each(data.infoList, function(index, item){
					html += '<tr><td><img id="profile" src="<c:url value="/images/default.jpg"/>"></td>';
					html +=	'<td><p id="nickname">'+item.memberNickName+'</p>';
					html += '<p class="content">'+item.crewComment+'</p>';
					html += '<p class="date">'+item.crewCommentDate+'</p>';
					html += '</td></tr>';
					$('#commentList').html(html);
				});
				
				var currentPageNum = parseInt('${cri.currentPageNum}');
				var prev = currentPageNum-1;
				if (prev==0){
					prev = 1;
				}
				var next = currentPageNum+1;
				if (next>data.totalPageNum){
					next = data.totalPageNum
				}
				
				html2 += '<li class="page-item"><a class="page-link" href="<c:url value="/crew/detail/${crew.crewIdx}&'+prev+'"/>">&lt</a></li>';
				for(var i=1 ; i <= data.totalPageNum; i++){
					html2 += '<li class="page-item"><a href="<c:url value="/crew/detail/${crew.crewIdx}&'+i+'"/>" class="page-link">'+i+'</a></li>';
				}
				html2 += '<li class="page-item"><a class="page-link" href="<c:url value="/crew/detail/${crew.crewIdx}&'+next+'"/>">&gt</a></li>';
				$('#paging').html(html2);
			}
		});                                                                                                                     
	}
</script>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
</head>
<body>
	<div class="section">
		<section>
			<div class="box">
				<div class="card">
					<img src="<c:url value='/images/crew/${crew.crewPhoto}'/>" class="card-img-top" alt="...">
						
					<div class="card-body">
					
						<div class="crew_name_section">
							<h3 class="card-title">${crew.crewName}</h3>
							<c:if test="${member.memberIdx eq crew.memberIdx}">
							<a href='<c:url value="/crew/edit"/>'
								class="btn btn-sm color_blue text_bold">크루 관리</a>
							</c:if>
						</div>
						
						<p class="card-text">${crew.crewDiscription}</p>
						<p class="crew_hashtag">${crew.crewTag}</p>
						
						<div class="crew_information">
							<span class="crew_captain">
								<p class="text_bold">${crew.memberNickName}</p> 
								<img id="profile" src="<c:url value='/images/default.jpg'/>">
							</span>
							<span class="crew_number">
								<p class="text_bold">크루원</p>
								<p>${crew.crewMemberNum}</p>
							</span>
							<span class="crew_comment_number">
								<p class="text_bold">댓글</p>
								<p>${crew.crewCommentNum}</p>
							</span>
						</div>
						
						<c:if test="${crew.isReg ne true}">
							<div class="join_section">
	              <a href="<c:url value='/crew/memberReg/${crew.crewIdx}'/>" class="btn btn-sm btn-light">가입하기</a>
	            </div>
            </c:if>
						
					</div>
				</div>
				
				<div class="comment_section">
					<div class="comment_table">
						<table id="commentList">
							
						</table>
					</div>
					
					<div class="input_section">
						<div>
							<ul class="pagination" id="paging">
							</ul>
						</div>
						
						<c:if test="${crew.isReg ne true}">
							<div class="input_control">
								<div>
									<input type="text" class="form-control" readonly="readonly">
								</div>
								<div>
									<input type="submit" value="게시" class="btn1 btn-light form-control" readonly="readonly">
								</div>
							</div>
						</c:if>
						<c:if test="${crew.isReg eq true}">
							<form method="post">
								<div class="input_control">
									<div>
										<input type="text" name="crewComment" class="form-control" id="crewComment">
										<input type="hidden" value="${crew.crewIdx}" id="crewIdx">
									</div>
									<div>
										<input type="submit" value="게시" class="btn1 btn-light form-control" id="submit">
									</div>
								</div>
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>