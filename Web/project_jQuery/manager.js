
// 생성자 함수
function Member(id,pw,name){
    this.userId = id;
    this.pw =pw;
    this.userName = userName;
}

Member.prototype.makeHtml= function(){
    return'[id'+this.userId+',pw:'+this.pw+',name:'+this.userName+']';
}

//회원정보를 담는 배열 members
var members =[];


$(document).ready(function(){


    //사용자가 입력한 값 캐스팅
    // var userId = $('#userId').val(); //getter
    // var pw = $('#pw').val();
    // var repw =$('#repw').val();
    // var userName =$('#userName').val();
    

    //regForm 캐스팅
    //var regForm = $('#regForm').val();

    //등록 버튼 눌렀을 때 -> 아이디, 비밀번호, 재확인, 이름 체크하고 배열에 저장 
    $('#regForm').submit(function(){
       
        //사용자가 입력한 값 캐스팅
        var userId = $('#userId').val(); //getter
        var pw = $('#pw').val();
        var repw =$('#repw').val();
        var userName =$('#userName').val();

        //아이디 입력 하지 않았을 때
        if(userId.length<1){
            //경고 메세지
            $('#userId+div.msg').html('필수 항목 입니다.');
            $('#userId+div.msg').css('display','block');
            return false; 
        }
        //비밀번호 입력하지 않았을 때
        if(pw.length<1){
            //경고 메세지
            $('#pw+div.msg').html('필수 항목 입니다.');
            $('#pw+div.msg').css('display','block');
            return false; 
        }
        //비밀번호 확인 입력하지 않았을 때
        if(repw.length<1){
            //경고 메세지
            $('#repw+div.msg').html('필수 항목 입니다.');
            $('#repw+div.msg').css('display','block');
            return false; 
        }
        //비번과 비번 확인 일치 하지 않았을 때
        if(pw != repw){
            $('#repw+div.msg').html('비밀번호가 일치 하지 않습니다.');
            $('#repw+div.msg').css('display','block');
            return false; 
        }
        
        //이름입력하지 않았을 때
        if(userName.length<1){
            //경고 메세지
            $('#userName+div.msg').html('필수 항목 입니다.');
            $('#userName+div.msg').css('display','block');
            return false; 
        }
        
        //콘솔에서 확인
        console.log(userId);
        console.log(pw);
        console.log(repw);
        console.log(userName);

        //배열에 저장
        members.push(new Member(userId, pw, userName));

        //저장 후 알림창
        alert('등록되었습니다.');
        console.log('회원리스트',members);

        //form 초기화
        this.reset();
        
         return false;
    });

    //안족 입력창에 커서 들어가면 경고 메세지 없어진다(공백으로 만들기)

    $('#userId').on('click', function(){
        displayer($('#userId+div.msg')); //제이쿼리 객체 파라미터로 
        //$('#userId+div.msg').html('');
        //$('#userId+div.msg').css('display','none');
    });

    $('#pw').on('click', function(){
        displayer($('#pw+div.msg'));
    });


    $('#repw').on('click', function(){
        displayer($('#repw+div.msg'));
    });

    $('#userName').on('click', function(){
        displayer($('#userName+div.msg'));
    });
    
    
});

// 커서 들어가면 class= msg 공백으로 만드는 메소드
// 파라미터 : 객체 타입
function displayer(obj){
    obj.html('');
    obj.css('display','none');
};

function setList(){
    
}