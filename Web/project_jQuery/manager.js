
// 생성자 함수
function Member(id,pw,name){
    this.userId = id;
    this.pw =pw;
    this.userName = name;
}

// 전역변수
var userId = $('#userId').val(); //getter
var pw = $('#pw').val();
var repw =$('#repw').val();
var userName =$('#userName').val();


//회원정보를 담는 배열 members
var members =[];


//ready 메소드 따로 두고
// 나머지 메소드 분리하기


$(document).ready(function(){
    
    //회원 리스트 출력
    setList();

    //사용자가 입력한 값 캐스팅
    // var userId = $('#userId').val(); //getter
    // var pw = $('#pw').val();
    // var repw =$('#repw').val();
    // var userName =$('#userName').val();
    

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

        //회원 리스트 출력
        setList();
        
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



// 회원리스트 출력 

function setList(){
    
    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if(members.length<1){
        //아직 입력된 데이터 없다면

        tbody +='<tr>';
        tbody +='    <td colspan="5">데이터가 존재하지 않습니다.</td>';
        tbody +='</tr>';
    }else{
        //입력된 데이터 존재
        for(var i=0; i<members.length; i++){
            tbody +='<tr>';
            tbody +='   <td>'+i+'</td>'; //인덱스
            tbody +='   <td>'+members[i].userId+'</td>';
            tbody +='   <td>'+members[i].pw+'</td>';
            tbody +='   <td>'+members[i].userName+'</td>';
            tbody +='   <td><a href="javascript:editMember('+i+')">수정 </a> |<a href="javascript: deleteMember('+i+')"> 삭제</a></td>';
            tbody +='</tr>';
        }
        
    }
    // list 캐스팅 후 tbody 넣어주기
    $('#list').html(tbody); 


}


// 회원 삭제
function deleteMember(index){

    if(confirm('삭제하시겠습니까?')){
        members.splice(index,1);
        alert('삭제되었습니다.');

        //삭제 후 회원 리스트 갱신
        setList();
    }
};


// 회원 수정
function editMember(index){
    
    console.log(index, members[index]);

    //캐스팅하기 (입력전) ->기존 정보(해당 인덱스 찾아서)를 넣어주기 
    //val() ,setter
    $('#editId').val(members[index].userId);
    $('#editPw').val(members[index].pw);
    $('#editRePw').val(members[index].pw);
    $('#editName').val(members[index].userName);


    

    //수정(submit) 눌렀을 때
    $('#editForm').submit(function(){
        
        // 비밀번호와 비번확인 같은지 체크
        if( $('#editPw').val()!= $('#editRePw').val()){
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }

        if(!confirm('수정하시겠습니까?')){ // 여기서 부터 에러...// 여기가 왜 반복되지??
            // 여기 버블링되는 거 막기
            //아니오!
            return false;
        }

        //console.log($('#editPw').val());
        
        //변경된 정보 다시 객체에 넣어주기(파라미터로 받아온 인덱스에)
        members[index].pw = $('#editPw').val();
        members[index].userName=$('#editName').val();
        
        alert('수정되었습니다.');

        //리스트 갱신
        setList();
        
        return false;

    });


};