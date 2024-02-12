function whereAmI(coordinate) {
  const { lat, lng } = coordinate;
    fetch(`https://geocode.xyz/${lat},${lng}?geoit=json`)
      .then(response => {
        if(response.status == 403){
            throw new Error("You are allowed to make only 3 requests per second")
        }
        return response.json()
      })
      .then(data => {
        console.log(`You are in ${data?.city}, ${data?.country}`)
      })
      .catch((error) => {
        console.log(error);
      });
}

let coordinate1 = { lat: "52.508", lng: "13.381" };
let coordinate2 = { lat: "19.037", lng: "72.873" };
let coordinate3 = { lat: "-33.933", lng: "18.474" };

whereAmI(coordinate1);
whereAmI(coordinate2);
whereAmI(coordinate3);
