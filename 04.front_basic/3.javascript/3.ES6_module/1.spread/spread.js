/*
... (spread syntax)
하나로 뭉쳐있는 여러 값들의 집합을 펼쳐서(전개, 분산)해서
개별적인 값들의 목록으로 바꿈

스프레드 문법의 사용 가능대상은 Array,String, Map, Set, Dom collection
등으로 한정됨
*/

//1. spread with Arrays
const fruits = ['apple', 'banana']
const otherFruits = ['kiwi', 'grape']

//기본의 배열 연결 방식
const allFruits = fruits.concat(otherFruits);
console.table(allFruits);

//spread로 활용 방식
const myFruits = [...fruits, ...otherFruits];
console.log(myFruits);


//users array에 새로운 user객체를 추가하려면?
const users = [
    {id:1, userName:'76'},
    {id:2, userName: 'Rave'}
];

//기존방식
const newUser = {id:3, userName:'nova'};
users.push(newUser);
console.table(users);

//spread방식
const secondNew = {id:4, userName:'ponzoo'};
console.log(secondNew);
const updateUsers=[...users, secondNew];
console.log(updateUsers);