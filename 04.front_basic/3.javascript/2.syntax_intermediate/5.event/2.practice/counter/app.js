
const btni = document.querySelector('#btni');
const btnr = document.querySelector('#btnr');
const btnd = document.querySelector('#btnd');
const counting = document.querySelector('.counting');

console.log(btni);
console.log(btnr);
console.log(btnd);
console.log(counting);

j = 0;
btni.addEventListener('click', () => {
    for(i = 0; i<100000000; i++){
        i=j;
        j++
        break;
    }
    counting.textContent = j;
})

btnr.addEventListener('click', () => {
    j = 0;
    counting.textContent = j;
})

btnd.addEventListener('click', () => {
    for(i = 0; 0<i<100000000; i++){
        i=j;
        j--
        break;
    }
    counting.textContent = j;
});