<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FEED VIEW</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<link rel="stylesheet" href="<c:url value='/css/feed/feedview.css'/>">
</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/frame/default/header.jsp"%>
	<div class="background">
		<section class="container_view">
			<button class="v_option">
				<img src="<c:url value="/images/feed/feedw/option.png"/>">
			</button>

			<section class="v_leftbox">
				<img
					src="<c:url value="/images/feed/feedw/uploadfile/${selectFeedView.boardPhoto}"/>"
					alt="feed-img">
				<button>
					<!-- 프로필 사진 받아오기 -->
					<img src="<c:url value="/images/feed/feedw/icon-05.png"/>">
				</button>
			</section>

			<section class="v_rightbox">
				<div class="v_profile">
					<div class="v_photo">
						<button>
							<img src="<c:url value="/images/feed/feedw/profile.jpg"/>"
								alt="profile-img">
						</button>
					</div>
					<a href="<c:url value="/feed/userFeed/${selectFeedView.memberIdx}"/>" class="v_nickname">${selectFeedView.memberNickname}</a>
					<!-- <button>팔로우</button> -->

					<div class="contents">
						<p>${content}</p>
						<div>
							<a class="hashtag">${hashtag}</a>
						</div>
					</div>
				</div>

				<section class="commentbox">
					<div>
						<div class="comments">
							<div class="cmt-profile">
								<button>
									<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
										alt="cmt-profile-img">
								</button>
							</div>
							<div class="comment">
								<p>
									<a href="#" class="v_nicknam">NICKNAME</a>
								</p>
							</div>
						</div>
						<div class="comments">
							<div class="cmt-profile">
								<button>
									<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
										alt="cmt-profile-img">
								</button>
							</div>
							<div class="comment">
								<p>
									<a href="#" class="v_nicknam">NICKNAME</a>
								</p>
							</div>
						</div>
						<div class="comments">
							<div class="cmt-profile">
								<button>
									<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
										alt="cmt-profile-img">
								</button>
							</div>
							<div class="comment">
								<p>
									<a href="#" class="v_nicknam">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다
									댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다
								</p>
							</div>
						</div>
						<div class="comments">
							<div class="cmt-profile">
								<button>
									<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
										alt="cmt-profile-img">
								</button>
							</div>
							<div class="comment">
								<p>
									<a href="#" class="v_nicknam">NICKNAME</a>댓글입니다 댓글입니다
								</p>
							</div>
						</div>
						<div class="comments">
							<div class="cmt-profile">
								<button>
									<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
										alt="cmt-profile-img">
								</button>
							</div>
							<div class="comment">
								<p>
									<a href="#" class="v_nicknam">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다
									댓글입니다 댓글입니다 댓글입니다
								</p>
							</div>
						</div>
					</div>
				</section>

				<section class="commentingbox">
					<div class="buttonline">
						<div>
							<!--  좋아요 버튼 -->
			                 <button class="like"  id="likeButton">
			                 	<!-- 현재: 좋아요 한 상태, 누르면: 좋아요 취소 -->
			                    <c:if test="${likeStatus>0}">
			                       <img id="current-like" name="delete" src="<c:url value="/images/feed/feedw/like.png"/>"  onclick="clickLike(this.name)">
			                    </c:if>
			                    <!-- 현재: 좋아요 안한 상태 , 누르면: 좋아요 하기 -->
			                    <c:if test="${likeStatus==0}">
			                       <img id="current-dislike" name="insert" src="<c:url value="/images/feed/feedw/nolike.png"/>" onclick="clickLike(this.name)">
			                    </c:if> 
			                 </button>		
			                  					
							<button class="write">
								<img src="<c:url value="/images/feed/feedw/comment.png"/>"
									alt="comment-img">
							</button>
							<!-- 카톡으로 공유하기 -->
							<a id="kakao-link-btn" href="javascript:sendLink()">
							  <img
							    src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
							  />
							</a>					
							
						</div>
						<div class="likeline">
							<p>좋아요 <span id="totaLikeCount">${totalLikeCount}</span>개</p>
						</div>
					</div>

					<div class="commentingline">
						<div class="textbox">
							<input type="text" placeholder="댓글달기">
						</div>
						<div class="submitbox">
							<input type="submit" value="게시">
						</div>
					</div>
				</section>

			</section>

		</section>
	</div>
	

	<script>
		function clickLike(click){
			
			console.log(click);
			
			if(click == 'insert'){
				//비동기 통신 시작
				
				
				$.ajax({
					url:'<c:url value="/feed/likeButtonClick"/>',
        			type:'POST',
					data:{
						likeChange:'1',
						boardIdx:'${selectFeedView.boardIdx}'
					},
					success:function(data){
						//좋아요 누르기 성공
						if(data ==1){
							
							console.log('insert성공');
							
							
							 var html  ='<img id="current-like" name="delete" src="<c:url value="/images/feed/feedw/like.png"/>"  onclick="clickLike(this.name)">';
							 
							$('#likeButton').html(html);
							
							// 비동기 통신으로 좋아요 개수 +1 시키기
							var currentLikeCount = parseInt($('#totaLikeCount').text());
							
							var newLikeCount = currentLikeCount+1;
							
							$('#totaLikeCount').text(newLikeCount);
							
							
							// 피드로 돌아가면 좋아요 정렬 다시 업데이트 하기
							
						}/*if 끝  */
						
					}/* success 끝 */
					
				});/* ajax 끝*/
			}else{
				// click == 'delete'
				
				$.ajax({
					url:'<c:url value="/feed/likeButtonClick"/>',
        			type:'POST',
					data:{
						likeChange:'-1',
						boardIdx:'${selectFeedView.boardIdx}'
					},
					success:function(data){
						//좋아요 취소하기 성공
						if(data == 1){
							
							console.log('좋아요 취소하기 성공');
							
			                var html  ='<img id="current-dislike" name="insert" src="<c:url value="/images/feed/feedw/nolike.png"/>" onclick="clickLike(this.name)">';
							
							$('#likeButton').html(html);
							
							// 비동기 통신으로 좋아요 개수 -1시키기
							// 피드로 돌아가면 좋아요 정렬 다시 업데이트 하기 or 닫기 버튼 누르면 그전 페이지로 요청 주기 /feed/userFeed/{memberIdx}
							var currentLikeCount = parseInt($('#totaLikeCount').text());
							
							var newLikeCount = currentLikeCount-1;
							
							$('#totaLikeCount').text(newLikeCount);
							
							
						}/*if 끝  */
						
					}/* success 끝 */
				});/* ajax 끝 */
			}
		};
	
	</script>
	
	<!--  카카오톡으로 공유하기  -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
	 var img ="http://localhost:8080/orl/images/feed/feedw/profile.jpg";
	 
	 
	  function sendLink() {
		Kakao.init("daeecdc3ce37abac4a9a3f8ad3e05b0a");
		
	    Kakao.Link.sendDefault({
	      objectType: 'feed',
	      content: {
	        title: '오를래 사진을 공유합니다.',
	        description: '오를래',
	        imageUrl:'http://localhost:8080/orl/images/feed/feedw/profile.jpg',
	        link: {
	          mobileWebUrl: 'http://localhost:8080/orl/feed/feedmain',
	          webUrl: 'http://localhost:8080/orl/feed/feedmain',
	        },
	      },
	      social: {
	        likeCount:${totalLikeCount},
	        /* commentCount: 45,
	        sharedCount: 845, */
	      },
	      buttons: [
	        {
	          title: '웹으로 보기',
	          link: {
	            mobileWebUrl: 'http://localhost:8080/orl/',
	            webUrl: 'http://localhost:8080/orl/feed/feedmain',
	          },
	        }
	        /* {
	          title: '앱으로 보기',
	          link: {
	            mobileWebUrl: 'https://developers.kakao.com',
	            webUrl: 'https://developers.kakao.com',
	          },
	        }, */
	      ],
	    })
	  }
	</script>
	

	<!-- footer -->
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>

</body>
</html>