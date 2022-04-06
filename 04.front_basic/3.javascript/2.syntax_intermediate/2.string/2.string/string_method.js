/*
indexing, spliting, manipulating String
*/

//string을 생성하는 법
const stringPrimitive='A new String';
const stringObject=new String('A new String');

console.log(`${typeof stringPrimitive}, ${typeof stringObject}`);

const aString='How R you?';
console.log(aString);
console.log('01012341234');
console.log(aString[4]);
console.log(aString.charAt(6)); //지정한 인덱스에 해당하는 요소들 조회
//get the char at 5

console.log(aString.indexOf('o'));
console.log(aString.lastIndexOf('o'));
console.log(aString.slice(3,7));
console.log(aString.length);

//Splitting strings
const originalString='How are you';

//Split string by whitespace character(공백을 기준으로 자르기)
const splitString=originalString.split(" ");
console.log(splitString);
console.log(splitString, Array.isArray(splitString));
// Array.isArray()는 static method!
console.log(typeof splitString); //쓰면 배열인지 객체인지 구분이 어려워서 위에껄로 씀

const arr = [1,2,3]; // arr=Array.prototype
arr.forEach

console.log(splitString[2]);

// Replace the first instance of "How" with "where"
const newString = originalString.replace('How', 'Where');
console.log(newString);