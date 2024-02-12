// 1. Write a function that will receive an array as the first argument, and an object as the second argument.
// The function should return objects corresponding to that key/value.

const students = [
  {
    name: "Mike",
    gender: "male",
    age: 20,
  },
  {
    name: "An",
    gender: "female",
    age: 21,
  },
  {
    name: "Lucy",
    gender: "female",
    age: 20,
  },
  {
    name: "John",
    gender: "male",
    age: 21,
  },
  {
    name: "Tom",
    gender: "male",
    age: 22,
  },
];

function getFilteredArray(arr, obj) {
  let newArr = [];
  for (let val of arr) {
    for (key in obj) {
      if (val[key] === obj[key]) {
        newArr.push(val);
      }
    }
  }
  return newArr;
}
const maleStudents = getFilteredArray(students, { gender: "male" });
const age21 = getFilteredArray(students, { age: 21 });
console.log(maleStudents);
console.log(age21);

// 2. Write a function named transfer, which will receive a string as a parameter and return an object, in which the key will be the character of the string, and the value will be the number of that character in the string.

let transfer = function (string) {
  let stringToArr = string.split("");
  let obj = {};
  for (let val of stringToArr) {
    let count = 0;
    for (let i = 0; i < stringToArr.length; i++) {
      if (val === stringToArr[i]) {
        count++;
      }
    }
    obj[val] = count;
  }
  return obj;
};

const test = transfer("coffee");
console.log(test);

// 3. Write a JavaScript function to convert an object into a list of `[key, value]` pairs.

function convertObj(obj) {
  let arr = [];
  for (key in obj) {
    arr.push([key, obj[key]]);
  }
  return arr;
}

const myObj = { name: "John", age: 30, city: "New York", gender: "male" };
const convertedObj = convertObj(myObj);
console.log(convertedObj);
