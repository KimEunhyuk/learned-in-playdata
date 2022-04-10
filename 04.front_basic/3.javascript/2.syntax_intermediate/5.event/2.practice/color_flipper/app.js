const btn = document.querySelector('#btn');
const color = document.querySelector('.color');

//addEventListenr 사용해서 button click 시 button clicked 출력되도록
btn.addEventListener('click', () => {
    //console.log('BUTTON CLICKED!');
    const [r, g, b] = getRandomNumber(0, 255); 
    
    const rgbColor = `rgba(${r}, ${g}, ${b})`;
    document.body.style.backgroundColor=rgbColor;
    color.textContent=rgbColor;
    color.style.color=rgbColor;
});

//rgb숫자값이 랜덤으로 선택되도록 함수 설정
function getRandomNumber(min, max) {
    //반환값은 오직 하나만 가능하기 때문에 배열로 세 숫자를 받아야한
    let randomRGBArray = [];
    for (let i=0; i<3; i++) {
        let randomNumber = 
        Math.floor(Math.random() * (max - min + 1)) + min;
        //console.log(randomNumber);
    
        randomRGBArray.push(randomNumber);
    }
    //console.log(randomRGBArray);
    return randomRGBArray;
}
//getRandomNumber(0, 255);//숫자가 잘 들어가나 확인