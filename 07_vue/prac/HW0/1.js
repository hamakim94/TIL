// 1 소개해보기

// 각 변수에 맞는 키워드를 작성하고 Template Literal을 이용하여 작성해보시오.

// ES6 Template Literal
let vin = "KMHXX00XXXX000000";
let modelName = "소나타";
let color = "Blue";
let mileage = 120000;

let info = `내 자동차는 ${modelName} 이고, 색상은 ${color}입니다. 오늘까지 ${mileage} 주행했습니다.`;

// 2 객체 Shorthand property name를 사용하여 선언하기
let myCar = {
    vin,
    modelName,
    color,
    mileage,
};

console.log(myCar);

// 3 Rest Parameter 를 사용하여 인자로 받은 모든 수를 더해보자.

function sum(...nums) {
  let ans = 0;
  for (let n of nums) {
    ans += n;
  }
  return ans;
}
// 인자가 더 많아질 수도 작아질 수도 있다.
console.log(sum(1, 2, 3, 4, 5));

// 4 String Methods 활용해보자.

let text = "안녕하세요. 저는 해삼 입니다. 잘 부탁드립니다.";
// ssafy라는 내용이 들어있는지를 확인한다.
console.log(text.includes("해삼"));
// 안녕으로 내용이 시작하는지를 확인한다.
console.log(text.startsWith("안녕"));
// .으로 내용이 끝나는지 확인한다.
console.log(text.endsWith("."));

// 5 Array Methods ______ 활용
// 정렬된 나이들 중 처음으로 20살 이상인 나이는 몇살인지 찾으시오.
const ages = [6, 11, 15, 24, 32, 39];

const found = ages.find( (age) => age >= 20);

console.log(found);
