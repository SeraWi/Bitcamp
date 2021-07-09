

function Member(id,pw,name){
    this.userId = id;
    this.pw = pw;
    this.username = name;
}


Member.prototype.makeHtml = function(){
    return '[id:' +this.userId+', pw:'+this.pw+',name:'+this.userName+']';
}

var members=[];

window.onload = function(){

    if(localStorage.getItem('members')== null){
        localStorage.setItem('members',JSON.stringify(members));
    }else{
        members=JSON.parse(localStorage.getItem('members'));
        console.log(members);

        setList();
    }

    //setList();

    //input의 아아디 입력의 id값 (HTML ->JS)
    var userid = document.querySelector('#userID');
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var userName = document.querySelector('#userName');


    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function(){

        if(userid.value.trim().length < 1) {
            document.querySelector('#userID+div.msg').innerHTML ='필수 항목입니다.';
            document.querySelector('#userID+div.msg').style.display = 'block';
            return false;
        }

        if(pw.value.trim().length<1){
            document.querySelector('#pw+div.msg').innerHTML ='필수 항목입니다.';
            document.querySelector('#pw+div.msg').style.display = 'block';
            return false;
        }

        if(repw.value.trim().length<1){
            document.querySelector('#repw+div.msg').innerHTML ='필수항목입니다.';
            document.querySelector('#repw+div.msg').style.display = 'block';
            return false;
        }

        if(pw.value.trim() != repw.value.trim()){
            document.querySelector('#repw+div.msg').innerHTML ='비밀번호가 일치하지 않습니다..';
            document.querySelector('#repw+div.msg').style.display = 'block';
            return false; 
        }

        if(userName.value.trim()<1){
            document.querySelector('#userName+div.msg').innerHTML ='필수항목입니다.';
            document.querySelector('#userName+div.msg').style.display = 'block';
            return false;
        }


        console.log(userid.value);
        console.log(pw.value);
        console.log(repw.value);
        console.log(userName.value);

        members.push(new Member(userid.value, pw.value,userName.value));

        alert('등록되었습니다.');
        console.log('회원리스트', members);

        this.reset();
        this.reset();


        //회원리스트 보여주기 함수 호출
        setList();
        


        return false;
    }

    userid.addEventListener('focus',function(){
        document.querySelector('#userID+div.msg').innerHTML ='';
        document.querySelector('#userID+div.msg').style.display = 'none';
    });

    pw.addEventListener('focus',function(){
        document.querySelector('#pw+div.msg').innerHTML ='';
        document.querySelector('#pw+div.msg').style.display = 'none';
    });

    repw.addEventListener('focus',function(){
        document.querySelector('#repw+div.msg').innerHTML ='';
        document.querySelector('#repw+div.msg').style.display = 'none';
    });

    userName.addEventListener('focus', function(){
        document.querySelector('#userName+div.msg').innerHTML ='';
        document.querySelector('#userName+div.msg').style.display = 'none';
    });


}
// function setList(){
//     //배열에 있는 요소들 ->table tr행을 만들어서 추가

//     console.log(members); 

//     //tbody 캐스팅하기
//     var list = document.querySelector('#list');

//     var tbody = '<tr>';
//     tbody += '  <th>순번(index)</th>';
//     tbody += '  <th>아이디</th>';
//     tbody += '  <th>비밀번호</th>';
//     tbody += '  <th>이름</th>';
//     tbody += '  <th>관리</th>';
//     tbody += '</tr>';
    
//     if(members.length <1){
//         tbody +='<tr>';
//         tbody +='<td colspan="5"> 데이터가 존재하지 않습니다.</td>';
//         tbdoy +='</tr>';

//     } else{
//         //데이터 존재
//         for(var i=0; i<members.length; i++){
//                         // <tr>
//             //     <td>0</td>
//             //     <td>cool</td>
//             //     <td>1111</td>
//             //     <td>COOL</td>
//             //     <td>수정 | 삭제</td>
//             // </tr>
//             tbody +='<tr>';
//             tbody +='   <td>'+i+'</td>';//인덱스
//             tbody +='   <td>'+members[i].userId+'</td>';
//             tbody +='   <td>'+members[i].pw+'</td>';
//             tbody +='   <td>'+member[i].userName+'</td>';
//             tbody +='   <td><a href="javascript:editMember('+i+')></a>수정 |<a href="javascript: deleteMember('+i+')> 삭제</a> </td>';
//             tbody +='</tr>';
//         }
//     }
//     list.innerHTML =tbody;
// }

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
            tbody +='   <td>'+members[i].username+'</td>';
            tbody +='   <td><a href="javascript:editMember('+i+')">수정 </a> |<a href="javascript: deleteMember('+i+')"> 삭제</a></td>';
            tbody +='</tr>';
        }
        
    }
    //tbody를 html에 넣기
    list.innerHTML = tbody;


}

function deleteMember(index){
    if(confirm('삭제하시겠습니까?')){
        members.splice(index,1);
        alert('삭제되었습니다.');

        localStorage.setItem('members',JSON.stringify(members));

        setList();
    }
}

function editMember(index){

    document.querySelector('#editFormArea').style.display ='block';
    
    //수정 누르는 순간 index받아서 콘솔에 보여주기
    console.log(index,members[index]);


    var editUserId = document.querySelector('#editId');
    var editPw = document.querySelector('#editPw');
    var editRePw = document.querySelector('#editRePw');
    var editName = document.querySelector('#editName');
    var editIndex = document.querySelector('#index');


    //데이터를 수정폼에 디폴트로 세팅하기
    editUserId.value = members[index].userId;
    editPw.value=members[index].pw;
    editRePw.value =members[index].pw;
    editName.value =members[index].username;
    editIndex.value =index;

    //수정 버튼 눌렀을 때 발생

    document.querySelector('#editForm').onsubmit =function(){
        if(editPw.value != editRePw.value){
            alert('비밀번호가 일치하지 않습니다.');

            return false;
        }

        if(!confirm('수정하시겠습니까>')){
            return false;
        }

        members[editIndex.value].pw = editPw.value;
        members[editIndex.value].username = editName.value;

        alert('수정되었습니다.');
        localStorage.setItem('members',JSON.stringify(members));

        setList();

        return false;

    }

}


function editMemberClose(){
    document.querySelector('#editFormArea').style.display ='none';
}
