/*
배열 메소드의 반환 패턴
1. 원본은 변경하지 않고 새로운 배열을 생성해서 변환 (accessor method)
2. 원본의 직접적인 수정이 이루어짐 (mutator method)
*/

let fish=['pirana', 'hoi', 'nimo', 'clown-fish'];

//fish가 무슨 타입인지 확인하고 싶다면?
console.group('object의 실체 확인');
console.log(typeof fish);
console.log(Array.isArray(fish));
console.groupEnd();

//1. 원본은 직접 수정하는 mutator methods

//1. pop() - 원본배열의 가장 끝 요소 제거, 해당 값 변환하고 추가 parametor는 없음
console.group('pop()');
console.log(`제거된 값 : ${fish.pop()}`);
console.log(fish);
console.groupEnd();

//2. shift() - 원본 배열의 가장 첫 번째(왼쪽 기준, 앞) 요소 제거
console.group('shift()');
console.log(`제거된 값 : ${fish.shift()}`);
// const removeFish = fish.shift();
console.log(fish);
console.groupEnd();

//3. push() - 원본 배열의 가장 끝에 새로운 요소 추가
console.group('push()');
console.log(`추가된 후 배열의 길이 : ${fish.push('whale')}`);
console.log(fish);
console.groupEnd();

//4. unshift() - 원본 배열의 가장 앞에 요소 추가
console.group('unshift()');
console.log(`추가된 후 배열의 길이 : ${fish.unshift('shark')}`);
console.log(fish);
console.groupEnd();

//5. splice() - 정해진 위치에 요소를 추가하거나 제거, 추가와 제거를 동시에 가능
console.group('splice()');
//splice()를 활용한 요소 추가
console.log('splice()를 활용한 요소 추가');
console.log(fish.splice(1, 0, '가자미'));
console.log(fish);
//splice()를 활용한 요소제거
//세번째 파라미터인 가자미를 작ㄷ성하지 않으면 요소의 제거가 가능
console.log(fish.splice(1,2)); //1부터 2개요소 삭제
console.log(fish);

//추가와 제거를 동시에 하는 법
console.log('splice()를 활용한 추가와 제거 동시 진행');
fish=['shark','whale','koi','nimo','가자미'];
console.log(fish);
console.log(fish.splice(2,2,'돌고래','열대어','오리'));
console.log(fish);