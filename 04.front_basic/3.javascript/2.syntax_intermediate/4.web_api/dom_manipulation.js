//dom의 조작
//document.querySelector('h1');
console.log(document.querySelector('#main-title'));
console.log(document.getElementById('main-title'));
console.dir(document.getElementById('main-title'));

const h1=document.querySelector('#main-title');
//h1의 텍스트를 바꾸기 위해선 어떤 property를 써야할까?
console.log(h1.innerText);
console.log(typeof h1.innerText);

//여기서부터는 devTool에서 실습
document.getElementsByClassName('list-item');
//CSS select를 통한 조회, 선택자 기호 필수
document.querySelector('#main-title');
document.querySelector('.list-item');

document.querySelectorAll('.list-item'); //NodeList

document.querySelector('ul li');
document.querySelector('ul li:first-of-type'); 
