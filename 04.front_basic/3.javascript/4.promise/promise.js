//ES6, Promise
//비동기 처리상태 및 처리결과를 관리하는 객체
// const isSuccess=false;
// const promise=new Promise((resolve, reject)=>{
//     //비동기 처리는 생성자 함수로 전달받은 콜백함수 내부에서 수행함

//     //비동기 처리가 성공하면 콜백함수의 인자로 전달받은 resolve()가 호출됨
//     //처리 실패하면 reject()가 호출됨
//     if (isSuccess) {
//         resolve('비동기 처리에 따른 응답 결과값을 작성하는 부분')
//     } else {
//         reject('비동기 처리 실패에 대한 예의처리 작성하는 부분')
//     }
// });
//promise 생성자 함수는 인자값으로 콜백 함수를 전달받음

//console.log(promise);

//비동기 처리의 진행상태(결과)를 나타내는 별도의 상태정보(state)를 가짐

//state는 총 세가지 존재
//1. pending : 비동기 처리가 아직 수행되지 않은 상태 프로미스가 생성된 직후 기본 상태
//2. fulfilled : 비동기 처리가 수행된 상태(성공) resolve()호출
//3. rejected : 비동기 처리가 수행된 상태(실패) reject()호출

//promises를 활용한 비동기 요청
const getRequestWithPromice = url => {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.send();
    
        xhr.onload = () => {
            if (xhr.status === 200) {
                resolve(JSON.parse(xhr.response));
            } else {
                reject(new Error(xhr.status));
            }
        }
    });
};

console.log(getRequestWithPromise('https://jsonplaceholder.typicode.com/posts/1'));