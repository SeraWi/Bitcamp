

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



//--------------------------------------------------------------------------
// 사용자가 입력한 정보를 가지고 Member 객체를 생성
// submit 이벤트 연결 -> 캐스팅 필요

    window.onload = function () {
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

            //객체 만들기
            var member = new Member(userid.value, pw.value,  userName.value);
    
            console.log(typeof member, member.makeHtml());
    
    
    
            return false;
        }

//--------------------------------------------------------------------
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


