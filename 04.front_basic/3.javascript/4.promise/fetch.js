//XMLHttpRequest처럼 HTTP요청 전송 기능을 지원하는 web API
//사용법이 간편하고 프로미스를 지원함

//함수 원형이라서 주석처리함
//const promise = fetch(url, [options]);
// https://developer.mozilla.org/en-US/docs/Web/API/fetch

// fetch()는 HTTP 응답을 나타내는 response 객체를 감싼 promise 객체를 반환함.
// fetch() 첫 번쨰 인수로, HTTP 요청을 전송할 URL만 입력(기본 요청은 GET 방식)

const url = 'https://jsonplaceholder.typicode.com/todos/1';

const promise=fetch(url)
    .then(response=>console.log(response))

const promise2=fetch(url)
    .then(response=>response.json())
    //Response.prototype.json(): promise 객체로 변환해줌(역직렬화)
    .then(json=>console.log(json))