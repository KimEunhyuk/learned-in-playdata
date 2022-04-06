const shoppingDone=false; //쇼핑여부
let childAllowance; //내용돈
//쇼핑을 도와주면 용돈을 더 받을 수 있다
if(shoppingDone === true) {
    childAllowance=10;
} else {
    childAllowance=5;
}

console.log(`내 용돈은 ${childAllowance}달러 주세요`);


const select=document.querySelector('select'); //select tag를 js코드로 가져옴
//console.log(select);
const paragraph=document.querySelector('p');
console.log(paragraph);

function setResult() {
   //console.log('setResult()함수 호출');;
    //console.log(select.value);
    const choice=select.value;

    if (choice === 'tomorrow') {
        paragraph.textContent='내일 두개 먹을 수 있다';
    } else if (choice ==='already') {
        paragraph.textContent='먹어서 행복하다!'
    } else {
        paragraph.textContent='아아앙??이 몸은 쿠키를 먹었다'
    }
} 

//select 태그한테 사용자가 선택박스의 값을 ㄹ수정하는 이벤트가 발생하면
//수정하는 행동(이벤트)하는 것을 확인(listen)하면, setResult()를 호출하도록 약속시킴
select.addEventListener('change', setResult);
