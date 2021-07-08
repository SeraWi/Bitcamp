

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



