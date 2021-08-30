<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FeedView</title>
<link rel="stylesheet" href="<c:url value='/css/feed/feedview.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
</head>
<body>



	<!-- 좋아요 표시 -->
    <!-- 닫기버튼 -->
    <section class="container">
        <button><img src="<c:url value="/images/feed/feedw/닫기.png"/>"></button>

        <section class="leftbox">
            <img src="<c:url value="/images/feed/feedw/feed.png"/>" alt="feed-img">
            <button><img src="<c:url value="/images/feed/feedw/icon-05.png"/>"></button>
        </section>

        <section class="rightbox">
            <div class="profile">
                <div class="photo">
                    <button><img src="<c:url value="/images/feed/feedw/profile.jpg"/>" alt="profile-img"></button>
                </div>
                <a href="#" class="nickname">NICKNAME</a>
                <button>팔로우</button>

                <div class="contents">
                    <p>피드는 스트리밍 형태로 제공되고 스크롤해서 볼 수 있는 콘텐츠입니다. </p>
                    <div><a class="hashtag">#해시태그</a></div>
                </div>
            </div>

            <section class="commentbox">
                <div>
                    <div class="comments">
                        <div class="cmt-profile">
                            <button><img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>" alt="cmt-profile-img"></button>
                        </div>
                        <div class="comment">
                            <p><a href="#" class="nickname">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다</p>
                        </div>
                    </div>
                    <div class="comments">
                        <div class="cmt-profile">
                            <button><img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>" alt="cmt-profile-img"></button>
                        </div>
                        <div class="comment">
                            <p><a href="#" class="nickname">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다</p>
                        </div>
                    </div>
                    <div class="comments">
                        <div class="cmt-profile">
                            <button><img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>" alt="cmt-profile-img"></button>
                        </div>
                        <div class="comment">
                            <p><a href="#" class="nickname">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다</p>
                        </div>
                    </div>
                    <div class="comments">
                        <div class="cmt-profile">
                            <button><img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>" alt="cmt-profile-img"></button>
                        </div>
                        <div class="comment">
                            <p><a href="#" class="nickname">NICKNAME</a>댓글입니다 댓글입니다</p>
                        </div>
                    </div>
                    <div class="comments">
                        <div class="cmt-profile">
                            <button><img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>" alt="cmt-profile-img"></button>
                        </div>
                        <div class="comment">
                            <p><a href="#" class="nickname">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다</p>
                        </div>
                    </div>
                </div>
            </section>

            <section class="commentingbox">
                <div class="buttonline">
                    <div>
                        <button class="like">
                            <img src="<c:url value="/images/feed/feedw/like-black.png"/>" class="nolike" alt="like-img">
                            <!-- <img src="/images/like.png" class="like-red" alt="nolike-img"> -->
                        </button>
                        <button class="write"><img src="<c:url value="/images/feed/feedw/comment.png"/>" alt="comment-img"></button>
                        <button class="share"><img src="<c:url value="/images/feed/feedw/share.png"/>" alt="share-img"></button>
                    </div>
                    <div class="likeline">
                        <p>좋아요 1,000개</p>
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



</body>
</html>