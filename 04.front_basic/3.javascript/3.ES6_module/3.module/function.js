/*
modular Programming
코드를 여러 파일로 쪼개서 모듈화시키는 방식
관계있는 기능, 파일들끼리 서로 mdule의 형태로 불러와서 필요한 코드만 사용

ES6(ECMA 2015)에서 모듈화를 할 수 있는 import 및 export 라는 키워드를 사용함
*/

export function sum(x,y) {
    return x+y;
}

export function sub(x,y) {
    return x-y;
}

export function mul(x,y) {
    return x*y;
}

export function div(x,y) {
    return x/y;
}

//Printive value
export const num = 100;
export const str='string';
const obj = {name: 'Homer'};
const array = ['Bart', 'Lisa', 'Maggie'];

export {obj, array};