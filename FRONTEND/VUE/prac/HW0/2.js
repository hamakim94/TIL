// 1. Template Literal
let name = "Kim";
let birthday = "2000.01.01";
let job = "Student";

let info = `내 이름은 ${name}이고 ${birthday}에 태어 났습니다. 제 직업은 ${job}입니다`
console.log(info)

// 2. Object Destructuring assignment
let Movie = {
    title : "기생충",
    director : "봉준호",
    genre : "드라마",
    runningTime : 132
}
// key값이랑 변수명이랑 이름 같아야지 됨, 다르더니 안 되더라..
// 순서는 중요하지 않다, 알아서 넣어준다.
let {tite,genre,director,runningTime} = Movie;
console.log(title);
console.log(director);
console.log(genre);
console.log(runningTime);

// 반복문을 통해 영화 배열 출력?
let Movies = ["기생충", "이터널스", "킹스맨", "스파이더맨", "해리포터"];

Movies.forEach(movie => console.log(movie));

// 인자로 숫자 1개 받아, 세제곱을 반환 => 화살표
function triple(a) {
    return a**3;
}

let ans = a => a**3; // 함수처럼 된다?
console.log(ans(3))

// Arrays Helper Methods중 map을 메서드를 사용하여 
// 임의의 정수를 가진 배열의 요소를 2배씩 하여 새로운 배열 생성

let tempArr = [1,4,3,2,6,4];
let timesTwo = tempArr.map(x => x*2);
console.log(timesTwo)