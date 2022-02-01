<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환율계산</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	*{
		font-size : 20px;
	}
	body{
		margin-top:50px;
		margin-left: 70px;
	}
	div{
		padding: 10px;
	}
	
</style>
</head>

<body>
	<h1>환율 계산</h1>
	
	<form method="post" id="transferForm">
		<div> 
			<div>송금국가 : 미국(USD) </div>
			<div>수취국가: 
				<select name ="country" id="country" onchange="selectCountry(this.value);">
					<option value="">--선택--</option>
					<option value="KRW">한국(KRW)</option>
					<option value="JPY">일본(JPY)</option>
					<option value="PHP">필리핀(PHP)</option>
				</select>
			</div>
			<div>환율: <span id="exchangeRate"></span></div>
			<div>송금액:<input type="number" id="transferAmount" size="20px" maxlength="10" required>USD</div>
			<div><input type="button" value ="submit" ></div>
		</div> 
	</form> <!-- from 끝 -->
	
	
	
	<script>
	
	
	/* access_keyㅌ, 송금국가 USD 고정 */
	const access_key='8711282f6324e9bbcaf2ea89273b8953';
	const source ='USD';
	
	function selectCountry(country){
		/* 수취국가 KRW  */
		var country = country;  	
		console.log(country);
		
		 $.ajax({
			   url:'http://apilayer.net/api/live',
			   type:'GET',
			   data:{
				   access_key : access_key,
				   currencies : country,
				   source : source				  
			   },
			   success: function(data){
				   console.log(data);
				   
				   // USDKRW 정확히 입력해야 데이터 가져옴
				   /* 여기 해결해야함 */
				   
				   $('#exchangeRate').text(data.quotes.USDKRW);
				   
				  
				   console.log('성공');
				   
			   }/* success 끝 */
			   
		   });/*ajax끝 */
	}
	
	
	/* 	송금 불가
		1. 송금액 0원 이하인 경우
		2. 입력하지 않은 경우
		3. 10,000보다 큰 금액인 경우
	*/
	
	$('#transferForm').on('click','input[type=button]',function(){
		var transferAmount = $('#transferAmount').val();
		
		transferAmount = parseInt(transferAmount);
		console.log(transferAmount);

		if(!transferAmount){
			alert('송금액을 입력해주세요.');
			return false;
		}else if(transferAmount <= 0){
			alert('송금액이 0원 이하입니다. 다시 입력해주세요.');
			return false;
		}else if(transferAmount > 10000){
			alert('송금액이 10,000USD를 초과했습니다. 다시 입력해주세요.')
			return false;
		}
		
		
		/* ajax 로 아래에 수취금 보여주기 */
	});
	
	
	</script>	
</body>
	


</html>