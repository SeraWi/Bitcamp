<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 회원가입</title>
<link rel="stylesheet" href="signUp.css">
<style>
</style>
<script>
</script>
</head>
<body>
	<div id="main_wrap">
		<header>
			<h1>
				<a href="http://www.naver.com">NAVER</a>
			</h1>
		</header>


		<!-- 데이터 처리할 위치로 전송 : form, name -->
		<form action ="signup_result.jsp" method ="post">
			<div class="signup">
				<h3>아이디</h3>
				<input type="text" name="id">
				
				<h3>비밀번호</h3>
				<input type="password" name="pw">
				
				<h3>비밀번호 재확인</h3>
				<input type="password" name="pw">
				
				<h3>이름</h3>
				<input type="text" name="name">
				
				<h3>생년월일</h3>
				<div class="birthday">
					<input type="text" name="birthyear" placeholder="년(4자)"> 
					<select name="birthmonth">
						<option value="">월</option>
						<option value="1월">1월</option>
						<option value="2월">2월</option>
						<option value="3월">3월</option>
						<option value="4월">4월</option>
						<option value="5월">5월</option>
						<option value="6월">6월</option>
						<option value="7월">7월</option>
						<option value="8월">8월</option>
						<option value="9월">9월</option>
						<option value="10월">10월</option>
						<option value="11월">11월</option>
						<option value="12월">12월</option>
					</select> 
					<input type="text" name="birthday" placeholder="일">
				</div>

				<h3>성별</h3>
				<select name="sex" class="Option">
					<option value="">성별</option>
					<option value="여성">여자</option>
					<option value="남성">남자</option>
					<option value="선택안함">선택안함</option>
				</select>

				<h3>
					본인 확인 이메일 <span>(선택)</span>
				</h3>

				<input type="text" name="email" placeholder="선택입력">

				<h3>휴대전화</h3>

				<select name="countryCode" class="Option">
					<option value="+82">대한민국+82</option>
					<option value="+1">그레나다+1 473</option>
					<option value="+30">그리스+30</option>
					<option value="+224">기니+224</option>
				</select> 
				<input type="tel" name="tel" placeholder="전화번호 입력" id="tel_num">
				<input type="submit"  value="인증번호 받기" class="check_Btn"><br>
				<input type="text" name="checkNum" placeholder="인증번호 입력하세요"> 
				<input type="submit" value="가입하기" class="signup_Btn">

			</div>
		</form>

		<footer>
			<ul>
				<li>이용약관</li>
				<li>개인정보처리방침</li>
				<li>책임의 한계와 법적고지</li>
				<li>회원정보 고객센터</li>
			</ul>
			<p>Naver Corp.</p>
		</footer>
	</div>
</body>
</html>