

// 회원의 정보: 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의

function Member(id,pw,name){
//  받아와서 초기화
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}

// 객체가 가지는 메소드는 공통으로 사용한다 -> prototype을 이용하자!
//화면에 보여주는 메소드
Member.prototype.makeHtml = function(){
    return'[id:'+this.userId+', pw:'+ this.pw+', name:'+this.userName+']';
}
//---------------------------------------------------------------------------

//회원의 정보를 저장하는 배열
var members= []; // new Array()


// 배열을 JSON(문자열)으로 ->loalStorage에 저장
// 저장시
// 수정시
// 삭제시 
// setItem('members',JSON.Stringify(members))으로 저장 해줘야 한다.
// 배열과 localstorage가 싱크가 맞도록한다.





//--------------------------------------------------------------------------
// 사용자가 입력한 정보를 가지고 Member 객체를 생성
// submit 이벤트 연결 -> 캐스팅 필요

    window.onload = function () {

        // localStorage 저장된 데이터가 있는지 확인
        // localStorage.getItem에 저장된 members가 없다면 null 반환
        if(localStorage.getItem('members') == null){
            // 배열 members 를 json문자열로 변환해서 저장
            localStorage.setItem('members', JSON.stringify(members));

        }else{
            // 존재
            // JSON문자열 -> 객체로 변환
            members = JSON.parse(localStorage.getItem('members')); 
            console.log(members);

            //회원리스트 보여주기, 함수 호출
            setList();
        }


        // //회원리스트 보여주기, 함수 호출
        // setList();

        var userid = document.querySelector('#userID');
        var pw = document.querySelector('#pw');
        var repw = document.querySelector('#repw');
        var userName = document.querySelector('#userName');

        // regForm 캐스팅
        var regForm = document.getElementById('regForm');
        regForm.onsubmit = function(){
    
            // 사용자가 입력한 값 캐스팅
            // 사용자가 입력한 정보= value를 가져오기 -> 문자열 반환
            // alert으로 창 띄우기 (방법 1)
            // var userid = document.querySelector('#userID').value;
            // var pw = document.querySelector('#pw').value;
            // var repw = document.querySelector('#repw').value;
            // var userName = document.querySelector('#userName').value;
            


            //-----------------------  div msg로 화면에 보여주기(방법2)
            //value 빼기
            // var userid = document.querySelector('#userID');
            // var pw = document.querySelector('#pw');
            // var repw = document.querySelector('#repw');
            // var userName = document.querySelector('#userName');
            
            //아이디를 입력하지 않았을 때
            if(userid.value.trim().length < 1) {
                //alert('이름을 입력해주세요');
                //-------------------------------------

                // div로 알려주기
                //캐스팅하기
                document.querySelector('#userID+div.msg').innerHTML ='필수 항목입니다.';
                //스타일 설정, 블록으로 만들기
                document.querySelector('#userID+div.msg').style.display = 'block';

                return false;
            }


            //패스워드 압력하지 않았을 때  
            if(pw.value.trim().length<1){
               
                //alert('비밀번호를 입력해주세요');
                //캐스팅하기
                document.querySelector('#pw+div.msg').innerHTML ='필수 항목입니다.';
                //스타일 설정, 블록으로 만들기
                document.querySelector('#pw+div.msg').style.display = 'block';
                return false;
            }

            // 비밀번호 재확인 하지 않았을 때
            if(repw.value.trim().length<1 ){
                //캐스팅하기
                document.querySelector('#repw+div.msg').innerHTML ='필수 항목입니다.';
                //스타일 설정, 블록으로 만들기
                document.querySelector('#repw+div.msg').style.display = 'block';
                return false;
            }
    
            // 비밀번호 비밀번호 확인 일치 여부 체크
            if(pw.value.trim() != repw.value.trim()) {
                //alert('비밀번호와 비밀번화 확인과 일치하지 않습니다.\n다시 확인해주세요.')
                
                //캐스팅하기
                document.querySelector('#repw+div.msg').innerHTML ='비밀번호가 일치하지 않습니다.';
                //스타일 설정, 블록으로 만들기
                document.querySelector('#repw+div.msg').style.display = 'block';
                //repw.value ='';
                return false;
            }

            //사용자 이름 정보
            if(userName.value.trim()<1){
                //alert('이름을 입력해주세요.');

                //캐스팅하기
                document.querySelector('#userName+div.msg').innerHTML ='필수 항목입니다.';
                //스타일 설정, 블록으로 만들기
                document.querySelector('#userName+div.msg').style.display = 'block';
                return false;
            }
    
            //콘솔에서 등록 눌렀을 때 정보 가져왔는지 확인
            console.log(userid.value);
            console.log(pw.value);
            console.log(repw.value);
            console.log(userName.value);

            //객체생성
            //var member = new Member(userid.value, pw.value,  userName.value);
            //객체 확인
            // console.log(typeof member, member.makeHtml());
    
            // //배열에 사용자 정보를 추가
            members.push(new Member(userid.value, pw.value, userName.value));

            //localStorage에 저장해주기
            localStorage.setItem('members', JSON.stringify(members));

            //등록하면 알림창
            alert('등록되었습니다.');
            console.log('회원 리스트', members);

            
    
            // form 초기화
            this.reset();
            
            //회원리스트 보여주기 함수 호출
            setList();
            
            return false;
        }


        // 이벤트 처리하기
        // 안쪽 입력창에 커서 들어갔을 때 이벤트
        // 커서가 들어가면 밑에 메세지 없어진다(공백으로 만들기) 

        // sumit이랑 범위 다르다
        userid.addEventListener('focus', function(){
            //밑에 메세지 나타나지 않게 만듬(블록 없애고 글자도 없애기)
            document.querySelector('#userID+div.msg').style.display = 'none';
            document.querySelector('#userID+div.msg').innerHTML ='';
        
        });

        //비밀번호 
        pw.addEventListener('focus', function(){
            document.querySelector('#pw+div.msg').style.display = 'none';
            document.querySelector('#pw+div.msg').innerHTML ='';
        
        });

        //비밀번호 확인
        repw.addEventListener('focus', function(){
            document.querySelector('#repw+div.msg').style.display = 'none';
            document.querySelector('#repw+div.msg').innerHTML ='';
            repw.value ='';
        });

        //이름
        userName.addEventListener('focus', function(){
           
            document.querySelector('#userName+div.msg').style.display = 'none';
            document.querySelector('#userName+div.msg').innerHTML ='';
        
        });


}

//---------------------------------------------------------------------------

//배열에 있는 요소를 -> table tr행을 만들어서 추가
function setList(){ //함수 호출해야 작동
    
    console.log(members);
   

    //table 의 tbody를 캐스팅한다.
    var list = document.querySelector('#list');

    //이전에 있던 테이블도 가져 오는 문제 해결하기 위해서
    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';
    

    //아직 입력된 회원이 없다면
    if(members.length <1){
        //데이터 존재X

        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존재하지않습니다.</td>';
        tbody += '</tr>';

    }else{
        
        //데이터 존재
        for(var i=0; i<members.length; i++){
            // <tr>
            //     <td>0</td>
            //     <td>cool</td>
            //     <td>1111</td>
            //     <td>COOL</td>
            //     <td>수정 | 삭제</td>
            // </tr>
    
            tbody +='<tr>';
            tbody +='   <td>'+i+'</td>'; //인덱스
            tbody +='   <td>'+members[i].userId+'</td>';
            tbody +='   <td>'+members[i].pw+'</td>';
            tbody +='   <td>'+members[i].userName+'</td>';
            tbody +='   <td><a href="javascript:editMember('+i+')">수정 </a> |<a href="javascript: deleteMember('+i+')"> 삭제</a></td>';
            tbody +='</tr>';
        }
        
    }
    //tbody를 html에 넣기
    list.innerHTML = tbody;


}

//---------------------------------------------------------------------------
// 배열의 요소 삭제 함수
function deleteMember(index){
    //alert(index+'인덱스의 요소를 삭제합니다.');

    //var chk = confirm('삭제하시겠습니까?');

    //배열의 index 요소를 삭제
    // splice(index, count) : index에서 시작해서 count 만큼의 요소를 삭제하고
    // 남은 요소를 반환한다.
    // splice(index , 1)

    if(confirm('삭제하시겠습니까?')){
        members.splice(index,1);
        alert('삭제되었습니다.');
        
        //localStorage에 저장해주기
        localStorage.setItem('members', JSON.stringify(members));

        //테이블의 리스트를 갱신
        setList();
    }
   
}

//---------------------------------------------------------------------------
//배열의 요소 수정 함수
function editMember(index){

    //수정 폼이 화면에 노출되도록 한다
    document.querySelector('#editFormArea').style.display ='block';



    //alert(index +'인덱스의 요소를 수정합니다.');

    //전달받은 index 값으로 members 배열의 객체 하나를 얻을 수 있다!
    //수정 누르는 순간 index받아서 콘솔에 보여주기
    console.log (index,members[index]);

    // editForm의 태그들의 value 값을 세팅
    //캐스팅
    var editUserId = document.querySelector('#editId');
    var editPw = document.querySelector('#editPw');
    var editRePw = document.querySelector('#editRePw');
    var editName = document.querySelector('#editName');
    var editIndex= document.querySelector('#index');

    //데이터 폼(회원리스트)에 세팅하기
    editUserId.value= members[index].userId;
    editPw.value = members[index].pw;
    editRePw.value = members[index].pw;
    editName.value =members[index].userName;
    editIndex.value= index; //인덱스 전달 받기
    

    //수정버튼 눌렀을 때!
    document.querySelector('#editForm').onsubmit= function(){
        
        //수정한 데이터 담는 객체
        //var member= new Member(editUserId.value,editPw.value,editName.value );
        //수정 누르면 콘솔에 인덱스와 정보 보여주기
        //console.log(editIndex.value,member);


        //비밀번호와 비밀번호 확인 같은지 체크
        if(editPw.value !== editRePw.value){
            //다르다!
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');

            return false; //종료: 밑에꺼 실행 안된다.
        }


        if(!confirm('수정하시겠습니까?')){
            //아니오!, 수정안함
            return false;
        }

        //변경된 사항을 다시 객체에 넣어주기(인덱스에 있는 객체를 찾아서!)
        // 수정된다!!
        members[editIndex.value].pw = editPw.value;
        members[editIndex.value].userName =editName.value;

        alert('수정되었습니다.');

        //localStorage에 저장해주기
        localStorage.setItem('members', JSON.stringify(members));
        

        //리스트 갱신해주기
        setList();

        return false;
    };


}


//---------------------------------------------------------------------------
function editMemberClose(){
    // 수정폼을 닫아주기 -> 안보이게 하기
    document.querySelector('#editFormArea').style.display ='none';
}