function Member(userId, pw, name){
    this.userId = userId;
    this.pw = pw;
    this.userName = name;
};

var members =[];


$(document).ready(function(){

    if(localStorage.getItem('members')==null){
        localStorage.setItem('members', JSON.stringify(members));
    }else{
        members = JSON.parse(localStorage.getItem('members'));
        setList();
    }
    
    

    $('#regForm').submit(function(){
       
    //사용자가 입력한 값 캐스팅
    var userId = $('#userId').val(); //getter
    var pw = $('#pw').val();
    var repw =$('#repw').val();
    var userName =$('#userName').val();

    if(userId.length<1){
        $('#userId+div.msg').html('필수 항목 입니다.');
        $('#userId+div.msg').css('display','block');
        return false;
    }
    if(pw.length<1){
        $('#pw+div.msg').html('필수 항목 입니다.');
        $('#pw+div.msg').css('display','block');
        return false;
    }
    if(repw.length<1){
        $('#repw+div.msg').html('필수 항목 입니다.');
        $('#repw+div.msg').css('display','block');
        return false;
    }

    if(pw != repw){
        $('#repw+div.msg').html('비밀번호가 일치 하지 않습니다.');
        $('#repw+div.msg').css('display','block');
        return false;
    }
    if(userName.length<1){
        $('#userName+div.msg').html('필수 항목 입니다.');
        $('#userName+div.msg').css('display','block');
        return false;
    }
    

    //콘솔에 확인
    console.log(userId);
    console.log(pw);
    console.log(repw);
    console.log(userName);

    //배열에 저장
    members.push(new Member(userId, pw, userName));
    
    //저장소 저장
    localStorage.setItem('members', JSON.stringify(members));
    //알림창
    alert('등록되었습니다.');
    console.log('회원리스트',members);
    
    
    //form 초기화
    this.reset();
    setList();
    
    return false;
   
   }); 
    //-------------------------------------------------------------------------
  $('#userId').on('focus', function(){
      displayer($('#userId+div.msg'));
  });

  $('#pw').on('focus', function(){
    displayer($('#pw+div.msg'));
  });

  $('#repw').on('focus', function(){
    displayer($('#repw+div.msg'));
   });

   $('#userName').on('focus', function(){
    displayer($('#userName+div.msg'));
   });
//-------------------------------------------------------------------
   //수정 SUBMIT 눌렀을 때 이벤트
   $('#editForm').submit(function(){
       //사용자 입력시 유효성 검사하기
       // 사용자가 입력한 값을 캐스팅한다
       // 배열에서 찾아서 새로운 정보를 다시 넣어준다.
       // list 갱신시킨다.

       if(!confirm('수정하시겠습니까?')){
           return false;
       }

       var index = $('#index').val();
       members[index].pw = $('#editPw').val();
       members[index].userName =$('#editName').val();

     //저장소 저장
     localStorage.setItem('members', JSON.stringify(members));       

       alert('수정되었습니다.');
       setList();
       return false;
   });

   

});

//공통 메서드
function displayer(obj){
    obj.html('');
    obj.css('display','none');
}

function setList(){
    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if(members.length<1){
        tbody +='<tr>';
        tbody +='    <td colspan="5">데이터가 존재하지 않습니다.</td>';
        tbody +='</tr>';
    }else{
        for(var i =0; i<members.length; i++){
            tbody +='<tr>';
            tbody +='   <td>'+i+'</td>'; //인덱스
            tbody +='   <td>'+members[i].userId+'</td>';
            tbody +='   <td>'+members[i].pw+'</td>';
            tbody +='   <td>'+members[i].userName+'</td>';
            tbody +='   <td><a href="javascript:editMember('+i+')">수정 </a> |<a href="javascript: deleteMember('+i+')"> 삭제</a></td>';
            tbody +='</tr>';
        }
    }

    $('#list').html(tbody);
};

function deleteMember(){
    if(confirm('삭제하시겠습니까?')){
        members.splice(index, 1);
        alert('삭제되었습니다.');
        //저장소 저장
        localStorage.setItem('members', JSON.stringify(members));   
        setList();
    }
};

function editMember(index){
    //인덱스 받아와서 members배열에서 찾기
    console.log(index,members[index]);

    //폼이 화면에 나타난다.
    $('#editFormArea').css('display','block');

    //캐스팅하고 기존 정보 세팅
    $('#editId').val(members[index].userId);
    $('#editPw').val(members[index].pw);
    $('#editRePw').val(members[index].pw);
    $('#editName').val(members[index].userName);
    $('#index').val(index); //index도 캐스팅하기 ->js -> jquery
    


};

function editMemberClose(){
    $('#editFormArea').css('display','none');
}