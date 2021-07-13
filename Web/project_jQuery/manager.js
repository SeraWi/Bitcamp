
// 생성자 함수
function Member(id,pw,name){
    this.userId = id;
    this.pw =pw;
    this.userName = name;
}


//회원정보를 담는 배열 members
var members =[];

//readt -> 등록 submit과 수정 submit 이벤트
$(document).ready(function(){
    
    //localstorage에 저장된 데이터 있는지 확인
    if(localStorage.getItem('members')==null){
        // 배열 members를 json문자열로 변환해서 저장
        localStorage.setItem('members',JSON.stringify(members));
    }else{
        //존재
        //Json문자열 객체로 반환
        members =JSON.parse(localStorage.getItem('members'));

        // 현재 존재하는 회원리스트 보여주기 ->함수 호출
        setList();
    }

    
    //--------------------------------------------------------------------------------
    //등록(submit) 버튼 눌렀을 때 -> 아이디, 비밀번호, 재확인, 이름 체크하고 배열에 저장 
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
        }else{
            //아이디 유효성 검사
            var idRegExp =/^[a-zA-Z0-9]{4,12}$/g;
            if(idRegExp.test(userId)){
                //아이디 패턴 ok 
                console.log('패턴에 맞는 아이디');
            }else{
                console.log('패턴에 맞지 않은 아이디');
                $('#userId+div.msg').html('4~12글자의 영문자 또는 숫자의 조합만 허용');
                $('#userId+div.msg').css('display','block');
                return false;
            }
        }

        
        //비밀번호 입력하지 않았을 때
        if(pw.length<1){
            //경고 메세지
            $('#pw+div.msg').html('필수 항목 입니다.');
            $('#pw+div.msg').css('display','block');
            return false; 
        }else{
            //비밀번호 유효성 검사
            //비밀번호는 영문,숫자,특수문자 조합이고, 6글자 이상 20자 미만, 최소 1개의 숫자 혹은 특수문자 포함
            var pwRegExp =/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/g;
            if(pwRegExp.test(pw)){
                console.log('패턴에 맞는 비밀번호');
            }else{
                console.log('패턴에 맞지 않은 비밀번호');
                $('#pw+div.msg').html('6글자 이상 20미만의 영문 대소문자, 숫자 혹은 특수문자(?=.) 1개 이상만 허용');
                $('#pw+div.msg').css('display','block');
                return false;
            }
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
        }else{
            // 이름 유효성 체크
            // 이름 한글만 허용
            var nameRegExp =/^[가-힣]+$/g;
            if(nameRegExp.test(userName)){
                //아이디 패턴 ok 
                console.log('패턴에 맞는 이름');
            }else{
                console.log('패턴에 맞지 않은 이름');
                $('#userName+div.msg').html('이름은 한글만 허용');
                $('#userName+div.msg').css('display','block');
                return false;
            }
        }
        
        //콘솔에서 확인
        console.log(userId);
        console.log(pw);
        console.log(repw);
        console.log(userName);

        //배열에 저장
        members.push(new Member(userId, pw, userName));

        //localStorage에 저장해주기
        localStorage.setItem('members',JSON.stringify(members));

        //저장 후 알림창
        alert('등록되었습니다.');
        console.log('회원리스트',members);

        //form 초기화
        this.reset();

        //회원 리스트 출력
        setList();
        
        return false;
    });
    //----------------------------------------------------------------------------------------
    //수정(submit) 눌렀을 때
    $('#editForm').submit(function(){
        

        //비밀번호 유효성 검사
        //비밀번호는 영문,숫자,특수문자 조합이고, 6글자 이상 20자 미만, 최소 1개의 숫자 혹은 특수문자 포함
        var pwRegExp =/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/g;
        if(pwRegExp.test($('#editPw').val())){
            console.log('패턴에 맞는 비밀번호');
        }else{
            console.log('패턴에 맞지 않은 비밀번호');
            alert('비밀먼호는 6글자 이상~20자 미만의 영문 대소문자와 숫자 혹은 특수문(?=.) 하나 이상의 조합만 허용');
            return false;
        }
        

        //이름 유효성 검사
        var nameRegExp =/^[가-힣]+$/g;
        if(nameRegExp.test($('#editName').val())){
            //아이디 패턴 ok 
            console.log('패턴에 맞는 이름');
        }else{
            console.log('패턴에 맞지 않은 이름');
            alert('이름은 한글만 허용합니다.');
            return false;
        }

        // 비밀번호와 비번확인 같은지 체크
        if( $('#editPw').val()!= $('#editRePw').val()){
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }

        if(!confirm('수정하시겠습니까?')){ 
            //아니오!
            return false;
        }

        var index =$('#index').val(); // 현재 hidden으로 보이지 않는 인덱스 캐스팅
        console.log(index); 
        
        //변경된 정보 다시 객체에 넣어주기(지정 인덱스에)
        members[index].pw = $('#editPw').val(); 
        members[index].userName=$('#editName').val();

        //localstorge에 수정 후 반영
        localStorage.setItem('members',JSON.stringify(members));
        
        //수정 후 알림창
        alert('수정되었습니다.');

        //리스트 갱신
        setList();
        
        return false;

    });

    //안 쪽 입력창에 커서 들어가면 경고 메세지 없어진다(공백으로 만들기)
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

// 커서 들어가면 class= msg 공백으로 만드는 공통 메서드
// 파라미터 : 객체 타입
function displayer(obj){
    obj.html('');
    obj.css('display','none');
};

//---------------------------------------------------------------------
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

        //삭제 후 localSotrage에 반영
        localStorage.setItem('members',JSON.stringify(members));

        //삭제 후 회원 리스트 갱신
        setList();
    }
};


// 회원리스트에서 수정|삭제 중 수정을 눌렀을 때 
function editMember(index){
    //인덱스 받아오기
    console.log(index, members[index]);

    //수정 폼 화면에 노출되도록 하기
    $('#editFormArea').css('display','block');

    //캐스팅하기 (입력전) ->기존 정보(해당 인덱스 찾아서)를 넣어주기 (수정폼 입력칸에)
    //val() ,setter
    $('#editId').val(members[index].userId);
    $('#editPw').val(members[index].pw);
    $('#editRePw').val(members[index].pw);
    $('#editName').val(members[index].userName);
    $('#index').val(index);// 받아온 인덱스를 세팅해주기(index 는 hidden 임, 보이지 않는다.)
    
};

//수정폼 닫기 눌렀을 때  -> 수정폼 화면에서 보이지 않도록 
function editMemberClose(){
    $('#editFormArea').css('display','none');
}