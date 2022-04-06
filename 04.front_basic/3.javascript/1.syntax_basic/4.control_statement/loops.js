//기본적인 고전 방식
for (let index = 0; index < 5; index++) {
    console.log(`${index} 번 반복`);
}

const rainbow = 'rainbow';

for (let index = 0; index < rainbow.length; index++) {
    console.log(rainbow[index]);
}

const foods = ['apple', 'orange-cookie', 'avocado', 'plum', 'kiwi'];
let favorite = 'My favorite food is ';

const para = document.querySelector('p');
console.dir(para);

const len = foods.length;
for (let index = 0; index < len; index++) {
    //favorite += foods[index];
    if (index===len-1) {
        favorite += 'and ' + foods[index] + '.';
    } else {
        favorite += foods[index] + ', ';
    }
}
console.log(favorite);
para.textContent = favorite;

//Array.textContext = favorite;
console.log(Array.isArray(foods)); //배열 타입인지 확인하는 것
const fruits = ['apple', 'banana', 'coconut'];
fruits.forEach(fruit => console.log(fruit));

//for in && for of
//let cookie = {} //객체를 생성하는 방식
//console.log(typeof cookie);
let cookie = { //enumerable
    'product_name': 'HERSEY',
    'product_vendor': 'costco',
    'product_id': 'c1'
};

for(const key in cookie) { //객체의 각 key에 대한 임시변수를 셋팅
    console.log(key + ": " + cookie[key]);
}

const scores=[33,22,34,99]; //iterable 들어가야함
// for (const key of cookie) { //cookie is not literable
//     //console.log(`${key} : ${cookie[key]}`);
// }

for (const index of scores) {
    console.log(index);
}


for(const item in scores) {
    console.log(item);
    console.log(`${item} : ${scores[item]}`);
}