function checkPalindrome(string){
	let reversedString = []
	for(let i = 0; i < string.length; i++){
		reversedString.push(string[string.length - 1 - i])
	}
	reversedString = reversedString.join("")
	if(reversedString === string){
		console.log(true)
		return true
	}else{
		console.log(false)
		return false
	}
}

checkPalindrome("madam")


function find(arr, value) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] === value) {
    	console.log(i)
      return i;
    }
  }
  console.log(-1)
  return -1;
}

find([1,2,3,"q", "a", "h"], "a")


// function findMostFrequentNumber(arr){

// 	for(let i =0; i < arr.length; i++){
// 		let num = arr[i]
// 		for(let j =0; i<arr.length; j++){
// 			if(arr[j] === num){

// 			}
// 		}
// 	}
// }

function findMostFrequentNumber(arr) {
  var maxCount = 0;
  var mostFrequentNumber;

  for (var i = 0; i < arr.length; i++) {
    var num = arr[i];
    var count = 0;

    for (var j = 0; j < arr.length; j++) {
      if (arr[j] === num) {
        count++;
      }
    }

    if (count > maxCount) {
      maxCount = count;
      mostFrequentNumber = num;
    }
  }

  return mostFrequentNumber;
}

var numbers = [1, 2, 3, 2, 1, 3, 3, 4, 5, 4, 4, 4];
var mostFrequent = findMostFrequentNumber(numbers);
console.log(mostFrequent)

function isPerfectNumber(number) {
  var sum = 0;

  for (var i = 1; i < number; i++) {
    if (number % i === 0) {
      sum += i;
    }
  }
  console.log(sum === number)
  return sum === number;
}

isPerfectNumber(28)
