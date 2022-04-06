/*
Destructuring
Destructuring assignment(분해할당)은 객체의 property나 배열을
변수로 분해해주는 것을 의미함
-> 코드를 보다 간결하게 해줌

1. objecet destructuring
2. Array Destructuring
*/

//1. Object Destructuring

/*
객체명은 book
id는1,
title은 "The midnight library"
ubDate는 10/04/2021
*/

const book = {
    id:1, 
    title: "The Midnight Library",
    pubDate: "10/04/2021",
}

//기존방식
/* const id=book.id; 
const title=book.title;이런식.. */

//Object Destructuring 방식
/* const {bookId, bookTitle, bookPubDate} = book;
console.log(bookId, bookTitle, bookPubDate); */

//변수는 객체의 property명과 동일한 이름으로 작성해야 함
const {id, title, pubDate} = book;
console.log(id, title, pubDate);

//destructuring은 원본 객체를 수정하지 않음
console.log(book);

//다른 이름으로 지정하고 싶을 경우
//id -> bookId title -> bookTitle pubDate -> bookPubdate
const {id:bookId, title:bookTitle, pubDate:bookPubDate} = book;
console.log(book);

//2. Array Destructuring : 배열의 요소들을 개별 변수들로 분해
const date = ['2021', '12', '01'];

// JS Array는 순서를 보장받아야하기 때문에 인덱싱 활용함
//const year=date[0];
//const month=date[1];
//..

//Array Destructuring방식
const [year, month, day]=date;
console.log(date);