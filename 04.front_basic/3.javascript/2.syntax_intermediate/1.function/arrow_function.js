/*
Arrow function
익명함수 표현식을 작성하는 새로운 방법
python에서는 lambda function과 비슷함
*/

//sum이라는 변수에 덧셈 기능을 제공하는 화살표 함수
const sum=(a,b) => a+b; //sum이라는 함수는 설계도같은거라서 고정
console.log(sum(3, 6));

//화살표 함수의 특징
//1. 암뭊적인 return
//기존의 함수는 {}도 필요하고 return키워드도 썼지만
//화살표 함수는 둘다 쓰지 않음
const anothersum=(a,b) => a+b; 
//만약 함수의 몸체(body)부분이 2줄 이상일 경우 {} 및 return 추가해야함
const sub=(a,b) => {
    console.log("뺄셈입니다");
    return a-b;
}
console.log(sub(3, 1));

//객체를 반환하는 경우
// const div = (a,b) => {
//     const result = {
//         res: a/b
//     };
//     return result;
// }

//객체를 반환하는 경우에는 body를 ()로 감싸주어야 함
//왜냐면 {}를 객체 literal 기호가 아닌 함수 body block으로 인식하기 때문
//그래서 ()를 써주면 {}를 객체 literal 기호로 인식해서 객체가 반환도;ㅁ
const div = (a,b) => ({result: a/b});
console.log(div(10,2));

//파라미터가 1개일 경우
// const square = (x) => x*x;
const square=x => x*x;
console.log(square(10));

//파라미터가 없는 경우 ()는 필수
const great = () => 'hello';
console.log(great());