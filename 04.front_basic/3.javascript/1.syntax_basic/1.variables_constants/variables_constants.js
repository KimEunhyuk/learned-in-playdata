/*
변수 키워드의 종류
var, let, const
변수, , 상수
    -변수와 상수 Variable & constants

*/

//변수 variable
//변수 hoisting 때문에 error가 아니라 undefiend라고 나옴
console.log(tiger);
var tiger;

//ㅣlet : var의 대체로 사용하는 키워드
//이걸 사용한다
//console.log(rabbit);
//let rabbit; //Error

//자바 스크립트도 자바와 마찬가지로 
//선언(Declaration)과 초기화(initialization) 정의(Definition)필요

//변수 네이밍 컨벤션 Naming convention : Camelcase
let userName='Kim';
console.log(userName);
document.write(userName); //chrome 개발자 도구에서 확인
userName='Lee';
console.log(userName);

//상수 constatnt : 값을 수정할수 없다
const allUsers = 20;
console.log(allUsers);

// allUsers=9; //상수 키워드로 쓴 const 변수에는 재활당 불가능
// console.log(allUsers);