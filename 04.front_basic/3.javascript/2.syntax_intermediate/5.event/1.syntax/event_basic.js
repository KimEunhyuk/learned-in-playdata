//2. EventHandler property 방식
//html과 js를 분리한 것
const evPropButton = document.querySelector('#btn-ev-prop');
//console.log(evPropButton);

//js에서 함수는 일급객체이기 때문에 객체는 값이고 값은 property에 할당할 수 있다
evPropButton.onclick=function() { //익명함수 생성 후 onclick property에 할당
    console.log('by event property');
};

//console.dir(evPropButton);
console.log(evPropButton.onclick);

//하나의 event밖에 등록 불가
evPropButton.onclick= () => console.log('new eventhandler');
console.log(evPropButton.onclick);

//3. addEventListner
//eventHandler property(=onclick)에 영향을 미치지 않기 때문에 등록한 모든 이벤트가 호출됨

//on 접두사 생략
const addEvLsnrButton=document.querySelector('#btn-add-ev-lsnr');
console.log(addEvLsnrButton);

// 함수 선언문 방식으로 작성
function buttonHandler() {
    console.log('double clicked');
    console.log('by addEventListener with 함수선언문');
}

//addEvLsnrButton('eventname', callback함수)
addEvLsnrButton.addEventListener('dblclick', buttonHandler); //callback 함수로 등록


//Practice!
//addEventListner에 등록하는데 마우스를 버튼위로 이동했을 때
//발생하는 이벤트는? 화살표 함수로 작성
const buttonHandler2 = document.querySelector('#btn-new');
//console.log(buttonHandler2);

//buttonHandler2.addEventListener = () => console.log('NEW! EVENT!');

/*
function mouseFunction () {
    console.log('mouse is overed');
}
*/

mouse = () => console.log('Mouse is overed!');

//화살표 함수를 callback 함수 parameter에 직접 작성
buttonHandler2.addEventListener ('mouseover', mouse);

/*
const buttonHandler2=() => {
    console.log('mouse is overed);
};
 console.log(buttonHandler2);
addEvLsnrButton.addEventListener('mouseover',buttonHandler2);
여기다가 바로 작성하면
addEvLsnrButton.addEventListener('click',() => {
    console.log('Mouse is overed!');
});
*/

//event Hadnler의 제거
// 1. event Hadnler attribute 방식 - onclick attribute 코드 제거
// 2. event Hadnler property 방식 - 해당 property에 null값 할당
console.log(evPropButton.onclick);
evPropButton.onclick=null;
console.log(evPropButton.onclick);

// 3. addEventListener method방식
addEvLsnrButton.removeEventListener('dblclick', buttonHandler);
//click 이벤트로 등록한 익명함수(화살표함수)는 제거 불가