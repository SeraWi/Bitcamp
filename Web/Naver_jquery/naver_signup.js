//생성자 함수
function Member(id, pw, name, birthYear, birthMonth, birthDay, sex,email,telFront,tel){
     this.id = id;
     this.pw = pw;
     this.name = name;
     this.birthYear = birthYear;
     this.birthMonth = birthMondth;
     this.birthDay = birthDay;
     this.sex= sex;
     this.email = email;
     this.telFront = telFront;
     this.tel = tel;
}

// 입력창 클릭하면 border 초록색으로 바꾸기
// $('#regForm').click(function(e){
//     $('#regForm>input[type=text]').addClass('click_border');
//     console.log(e);
// });


//회원정보를 담는 배열 members
var members=[];


$(document).ready(function(){
    //가입하기 버튼 눌렀을 때!
    $('#regForm').submit(function(){
        // 사용자가 입력한 값 캐스팅
        // 유효성 검사 -경고 메세지 띄우기
        var id = $('#id').val();
        var pw = $('#pw').val();
        var repw =$('#repw').val();
        var name =$('#name').val();
        var birthYear =$('#birthYear').val();
        var birthMonth = $('#birthMonth').val();
        var birthDay =$('#birthDay').val();
        var sex =$('#sex').val();
        var email =$('#email').val(); 
        var telFront =$('#tel').val(); //82
        var tel =$('#tel_num').val(); //35248600

        //사용자가 입력하지 않은거 있으면 경고 메세지 

        //콘솔에 확인
        console.log(id);
        console.log(pw);
        console.log(repw);
        console.log(name);
        console.log(birthYear);
        console.log(birthMonth);
        console.log(birthDay);
        console.log(sex); 
        console.log(email);
        console.log(telFront); //+82 ,
        console.log(tel);

        //배열에 저장하기
        members.push(new Member(id,pw,repw,name,birthYear,birthMonth,birthDay,sex,email,telFront,tel));
        
        
        return false;
    });
    return false;
});