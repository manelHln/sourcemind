export function calcAge(birthYear) {
  if (!birthYear) {
    return false;
  }

  const currYear = new Date().getFullYear();
  const age = Number(currYear) - Number(birthYear);
  if (age >= 18) {
    return "adult";
  } else {
    return "kid";
  }
}
