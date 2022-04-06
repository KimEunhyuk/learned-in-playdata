//promise의 상태값에 따라 후속처리 진행
//내가 친 거라서 에러많음,,

/*
후속 메서드 3가지 -> promise 객체를 반환함
1. then()
2. catch()
3. finally()
*/

//1. then()은 2개의 callback function을 인수로 전달받음
new Promise(resolve => resolve('fulfilled'))
    .then(result => console.log(result), error=>console.log(error));

//2. catch()
new Promise((_,reject)=> reject(new Error('rejected')))
    .catch(error=>console.log(error))

//3. finally(), 성공 실패에 관계없이 무조건 호출됨
//공통적으로 수행해야 할 처리 내용이 있을 때 작성
new Promise(()=>{})
    .finally(()=>console.log('finally'))


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
    
// getRequestWithPromise('https://jsonplaceholder.typicode.com/posts/1')
//     .then(result=>console.log(result))
//     .catch(error => console.log(error))
//     .finally(()=>console.log('요정종료'));

//promise chaning
//promise의 then, catch, finally를 활용해서 callback hell을 해결함
//깔끔해짐


// 프로미스 체이닝(Promise chaining) - then(), catch(), finally()는 promise를 반환하므로 연속적으로 호출 가능.
getRequestWithPromise(`${url}/posts/1`)
    .then((user) => getRequestWithPromise(`${url}/users/${user.userId}`))
    .then(userInfo => console.log(userInfo))
    .catch(error => console.log(err));

//이 함수는 비동기적으로 동작한다고 명시하는 것
async function asyncFunc1() {
    const user = await getRequestWithPromise(`${url}/posts/1`)
    const userInfo = await getRequestWithPromise(`${url}/users/${user.userId}`)

}

