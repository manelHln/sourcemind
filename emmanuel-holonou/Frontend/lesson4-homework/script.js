// Write a code to reverse an array (without using arr.reverse() method)

function reverseArray(arr) {
  var start = 0;
  var end = arr.length - 1;

  while (start < end) {
    var temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    start++;
    end--;
  }

  return arr;
}

var myArray = [1, 2, 3, 4, 5];
var reversedArray = reverseArray(myArray);
console.log(reversedArray);

// Write a code to to get the max element of an array

function findMax(arr) {
  var maxElement = arr[0];

  for (var i = 1; i < arr.length; i++) {
    if (arr[i] > maxElement) {
      maxElement = arr[i];
    }
  }

  return maxElement;
}

var myArray = [5, 8, 3, 2, 9];
var maxElement = findMax(myArray);
console.log(maxElement);

// Write a code that will receive a number from the prompt and print asterisks.

function printAsterisks(num) {
  for (var i = 1; i <= num; i++) {
    console.log("*".repeat(i));
  }
}

var number = parseInt(prompt("Enter a number: "));
printAsterisks(number);

// Write a code that will print the most repeated element in an array and its count.

function findMostRepeated(arr) {
  var counts = {};
  var mostRepeatedElement;
  var maxCount = 0;

  for (var i = 0; i < arr.length; i++) {
    var num = arr[i];
    counts[num] = counts[num] ? counts[num] + 1 : 1;

    if (counts[num] > maxCount) {
      mostRepeatedElement = num;
      maxCount = counts[num];
    }
  }

  return { element: mostRepeatedElement, count: maxCount };
}

// Example usage:
var myArray = [1, 2, 3, 2, 4, 2, 5, 2, 2];
var result = findMostRepeated(myArray);
console.log("Most repeated element:", result.element);
console.log("Count:", result.count);
