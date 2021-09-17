<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#all{
    font-family: var(--text-sans);
    display:flex;
    justify-content: center;
    align-items: center;
    height:100vh;
    /* no-repeat:배경이미지 반복X */
     background:url("../../images/member/main.jpg") no-repeat center;
    background-size: cover;
}

#all::before{
    content:"";
    position:absolute; z-index:1;
    top:0;
    right:0;
    bottom:0;
    left:0;
    background-color:rgba(0,0,0,0.7); 
}

/* section 영역 전체 */
.content{
    position:relative;
    z-index:2;
}

.content h1{
    font-size: 32px;
    font-weight: lighter;
    color:#FDEF7B;
    text-align:center;
    letter-spacing: 5px;

    margin-bottom:30px;
}

.content p{
	font-size:15px;
    font-weight: lighter;
    color:#fff;
    background-color: transparent;
	text-align:center;

}

.btn-area{
    margin-top:40px;
    width:250px;
    height:50px;
    
    border:none;
    border-radius:10px;
	cursor:pointer;
	
	
	text-align:center;
	margin-left:100px;
}

.btn-area a{
  /*   width:70%;
    height:50px;
    background:#FDEF7B; */
    display:block;
    width:250px;
    height:50px;
    line-height:50px;
    text-align:center;
    background:#FDEF7B;
    
    font-size:15px;
    font-weight: 600;
    color:black;
    cursor:pointer;
}



</style>
</head>
<body>
	<div id="all">
    <section class="content">
      	<h1>서비스 이용에 불편을 드려 죄송합니다.</h1>
        
        <!-- id 보여주는 영역 -->
        <p>
        	요청하신 페이지는 삭제되었거나, 처리중에 요류가 발생했습니다.<br>
       		 동일한 문제가 지속적으로 발생하는 경우 고객센터로 문의 부탁드립니다.
        </p>
    
        <!--로그인하기, 비밀번호 찾기 영역 -->

       <div class="btn-area"> 
                <a class="btn-area">메인으로 가기</a>
       </div>

    </section>
    </div>
</body>
</html>