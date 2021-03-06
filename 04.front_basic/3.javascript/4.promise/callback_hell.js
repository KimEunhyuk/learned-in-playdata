//비동기 처리를 위한 하나의 패턴 : 콜백 함수 패턴

//전통적인 콜백 패턴

// const xhr=new XMLHttpRequest();
// xhr.open('GET', 'https://jsonplaceholder.typicode.com/todos/1');
// xhr.send();

// xhr.onload=()=>{
//     if (xhr.status===200) {
//         console.log(xhr.response);
//     } else {
//         console.log(xhr.status, xhr.statusText);
//     }
// }

//calllback hell 예시 내가 친건데 왜 에러나지..?
// const get=(url, callback)=> {
//     const xhr=new XMLHttpRequest();
//     xhr.open('GET', url);
//     xhr.send();

//     xhr.onload=()=>{
//         if (xhr.status === 200) {
//             callback(JSON.parse(xhr.response));
//         } else {
//             console.log(xhr.status, xhr.statusText);
//         }
//     }
// }

// const url='https://jsonplaceholder.typicode.com';

// //console.log(typeof get);
// get(`${url}/posts/1`, (userId) => {
//     get(`${url}/users/${userId}`, userInfo => {
//         console.log(userInfo);
//     })
// });

// Callback hell
const get = (url, callback) => {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            console.log(typeof xhr.response);
            callback(JSON.parse(xhr.response));
        } else {
            console.log(xhr.status, xhr.statusText);
        }
    }
}

const url = 'https://jsonplaceholder.typicode.com';

// console.log(typeof get); // function
get(`${url}/posts/1`, (user) => {
    get(`${url}/users/${user.id}`, userInfo => {
        console.log(userInfo);
    })
});