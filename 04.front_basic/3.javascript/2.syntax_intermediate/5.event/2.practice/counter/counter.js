// function count(type) {
//     const resultElement = document.getElementById('result');
//     let number = resultElement.innerText;
    
//     if (type === 'minus') {
//         number = parseInt(number) -1;
//     } else if(type === 'plus') {
//         number = parseInt(number) +1;
//     } else {
//         number=0;
//     }
//     resultElement.innerText=number;
// }

/* 강사꺼보고 다시 짠 코드
const decrease = document.querySelector('#decrease');
const reset = document.querySelector('#reset');
const increase = document.querySelector('#increase');
const number = document.querySelector('.number');
const countButtons = document.querySelectorAll('btn')

console.log(btn);

let count = 0;
countButtons.forEach((btn) => {
    btn.addEventListener('click', (event) => {
        const curTarget = event.currentTarger;
        console.dir(curTarget);

        const styles = curTarget.classList(1);

        if (styles === 'decrease') {
            --count;
        } else {++count;}
        -----------------삼항 연산자로 바꿈
        count = styles !== 'reset' ? (count = styles === 'decrease' ? --count : ++count) : 0;

        let cvColor = '';
        cvColor = count !== 0 ? (cvColor=count>0 ? 'green' : 'red') : 'grey';

        number.textContent()
    });
});

//숫자 증감에 따른 색 바꾸기
button.addEventListner('click',(event) => {
    const resultColor=count(type);
}) */

//숫자 증감&색바꾸기
function count(type) {
    const countNumber = document.getElementById('result');
    let number = countNumber.innerText;
    // const resultColor = document.number.style.color;
    
    if (type === 'minus') {
        number = parseInt(number) -1;
        result.style.color="red";
    } else if(type === 'plus') {
        number = parseInt(number) +1;
        result.style.color="green";
    } else {
        number=0;
        result.style.color="grey";
    }
    countNumber.innerText=number;
}
