//callback함수의 기본
function greeting(name) {
    console.log(`hello + ${name}`);
}

//함수의 선언부에 작성하는 값들은 인자값이라고 함
function processUserInput(name, callback) { //인자값(argument)
   callback(name); //파라미터, =greeting('kim')이 됨
}

//함수의 호출부에 작성하는 값들을 parameter라고 함
processUserInput('kim', greeting); //동기(synchronous)콜백




// function give(thing) {
//     console.log(`친구한테 ${thing} 전달완료`);
// }
// function processUserInput(thing, callback) {
//     callback(thing);
//     console.log(`${thing}가 도착했다`);
// }
// processUserInput('사과', give);

function waitCoupang(pkg, callback) {
    console.log(`쿠팡에서 ${pkg}가 도착했다`);
    callback();
}

function bringIt() {
    console.log(`친구한테 전달 완료`);
}
waitCoupang('사과', bringIt);


//버튼 click
const button = document.querySelector('button');

// button.addEventListener('click', function() {
//     console.log('button clicked');
// });

button.addEventListener('click', () => console.log('button clicked'));

