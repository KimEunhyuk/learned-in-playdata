const btn = document.querySelector('#btn');
const lotto = document.querySelector('.lotto');
console.log(btn);
console.log(lotto);

btn.addEventListener('click', () => {
    //console.log('button clicked!');
    const [a, b, c, d, e, f] = getRandomNumber(1, 45);
    console.log(a); console.log(b); console.log(c); console.log(d); console.log(e); console.log(f);

    const lottoNumber = `(${a}, ${b}, ${c}, ${d}, ${e}, ${f})`;

    lotto.textContent = lottoNumber;
});

function getRandomNumber(min, max){
    let randomLottoArray = [];
    for(let i = 0; i < 6; i++){
        const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
        randomLottoArray.push(randomNumber);
    }
    //console.log(randomNumber);
    return randomLottoArray;
}

