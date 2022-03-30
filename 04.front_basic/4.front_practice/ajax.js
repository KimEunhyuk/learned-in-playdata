// XHLHttpRequest 객체 생성, open() 호출 전
const xhr = new XMLHttpRequest();
console.log(`UNSENT, ${xhr.readyState}`);

// 요청을 보낼 준비
xhr.open("GET", "https://jsonplaceholder.typicode.com/todos/1");
console.log(`OPENED ,${xhr.readyState}`);

// onreadystatechang 이벤트가 발생할 때마다 arrow fn 호출
xhr.onreadystatechange = () =>{
    if (xhr.readyState == 2){
        console.log(`Ready state LOADED ${xhr.readyState}`);
    }

    // 데이터 응답(로딩) 완료와 같음 == onload
    if( xhr.readyState == 4 && xhr.status == 200){ // 데이터가 성공적으로 응답 완료.
        console.log(`DONE, ${xhr.readyState}`);
        console.log(`response data : ${xhr.responseText}`);

    }
}

// 브라우저가 데이터를 받는 동안 주기적으로 발생
xhr.onprogress = () => {
    console.log(`LOADING, ${xhr.readyState}`);
}

// 데이터 응답(로딩) 완료.
xhr.onload = () =>{
    console.log(`DONE, ${xhr.readyState}`);
}

xhr.send(null);