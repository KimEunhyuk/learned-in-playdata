const countValue = document.querySelector('#value');
const countButtons = document.querySelectorAll('button');

console.log(countButtons);

let count = 0;

// forEach()의 인자값으로 callback fn 지정.
countButtons.forEach((button) => {
    button.addEventListener('click', (event) => {
        const curTarget = event.currentTarget;
        console.dir(curTarget);

        const styles = curTarget.classList[1];
        console.log(styles);

        count = styles !== 'reset' ? (count = styles === 'decrease' ? --count : ++count) : 0;
        console.log(count);

        let countValueColor = '';
        countValueColor = count !== 0 ? (countValueColor = count >0 ? 'green' : 'red') : 'grey';
        console.log(countValueColor);

        countValue.textContent = count;
        countValue.style.color = countValueColor;
        
    });
});
