const arr = ['orange', 'orange', 'orange-cookie'];
console.log(typeof arr, arr);
console.log(arr.length);

console.table(arr);

//요소의 조회(접근)
console.log(`${arr[0]}, ${arr[1]}`);

//요소의 추가, 갱신
arr[3]='new cookie';
arr[2]=5;
console.log(arr);

//요소의 삭제
const numArr=['orange', 'kiwi', 'apple'];
delete numArr[2];

console.log(numArr); //희소배열 empty로 나옴
console.log(`length: ${numArr.length}`);

const nutArr=['walnut', 'almond', 'peanut'];
nutArr.splice(1,1); //Array.prototype.splice (삭제를시작할인덱스, 삭제할요소수)
console.log(nutArr);
console.log(`length: ${nutArr.length}`);