/*
string을 사용하는 방식 : '', "", ``(backtick)
*/

//템플릿 리터럴 방식 tmplete literal
const novel = 'The little prince';
const author = 'Saint-Exupery';

console.log(`My favorite novel is ${novel}`);

const address = 
    'Homer J. Simpson\n' + 
    '742 Evergreen Terrace\n' +
    'Springfield';
console.log(address);

const address2=`Homer J. simpson
742 Evergreen terrace
Springfiled`;
console.log(address2);