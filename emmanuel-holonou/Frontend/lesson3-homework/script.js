//Write a code, which will take numbers from the prompt window 3 times, and print their arithmetic average in the console.

var numbers = [];
function getNumbers() {
  let i;
  for (i = 0; i < 3; i++) {
    let number = prompt("Enter a random number");
    if (!Number(number)) {
      alert("you should enter a valid number");
      break;
    }
    numbers.push(number);
  }
}

function getAverage() {
  if (numbers.length <= 0 || !numbers) {
    return;
  }
  let average,
    sum = 0;
  for (let i = 0; i < numbers.length; i++) {
    sum += Number(numbers[i]);
  }
  average = sum / numbers.length;
  console.log(
    `The overall average of the numbers you've entered is ${average}`
  );
}
getNumbers();
getAverage();

// Swap 2 numbers without a third variable.

let a = 5;
let b = 10;

console.log("Before swapping: a =", a, "b =", b);

a = a + b;
b = a - b;
a = a - b;

console.log("After swapping: a =", a, "b =", b);


// Write a code to find the largest of three numbers.

function findGreatest(numbers) {
  let greatest;

  for (let i = 0; i < numbers.length; i++) {
    if (!greatest || numbers[i] > greatest) {
      greatest = numbers[i];
    }
  }

  console.log(greatest);
}

findGreatest(numbers);

// Write a code to check triangle type(equilateral, scalene, or isosceles)

function checkTriangleType(side1, side2, side3) {
  if (side1 === side2 && side2 === side3) {
    return "equilateral";
  } else if (side1 === side2 || side2 === side3 || side3 === side1) {
    return "isocele";
  } else {
    return "scalene";
  }
}

console.log(checkTriangleType(54, 67, 98));
console.log(checkTriangleType(10, 20, 10));
console.log(checkTriangleType(15, 15, 15));


/*
What will be the output and why?
	const number = Boolean('true'); Since 'true' is not an empty string this returns true. Short answer is this is not among a falsy value
	const boolean = String(true); String convert anything to a string so this will return 'true'
	const string = Number(true) This will evaluate as 1 because true is 1 and false 0
	const object = Number('true') This will return NaN because 'true' cannot be easily convert to an Int but '45' for example can
	const sum = number + string + object; This will return NaN
	console.log(number, boolean, string, object, sum);


The output will be (true, 'true', 1, NaN, NaN)
*/