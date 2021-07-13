//생성자 함수
function Member(id, pw, name, birthYear, birthMonth, birthDay, sex,email,){
     this.id = id;
     this.pw = pw;
     this.name = name;
     this.birthYear = birthYear;
     this.birthMonth = birthMondth;
     this.birthDay = birthDay;
     this.sex= sex;
     this.email = email;
}

// 커서 들어갔을 때 border 초록색으로 바꾸기


//회원정보를 담는 배열 members
var members=[];


$(document).ready(function(){
    //가입하기 버튼 눌렀을 때!
    $('#regForm').submit(function(){
        // 사용자가 입력한 값 캐스팅
        // 유효성 검사 -경고 메세지 띄우기
    });
    return false;
});