const container = document.querySelector('.countries');
// rendering country data in HTML
function renderCountry(data, className = ''){
    const html = `
        <article class="country ${className}">
              <img class="country__img" src="${data.flags.png}" />
              <div class="country__data">
                  <h3 class="country__name">${data.name.official}</h3>
                  <h4 class="country__region">${data.region}</h4>
                  <p class="country__row"><span>👫</span>${data.population}</p>
              </div>
            </article>
    `
    container.insertAdjacentHTML('beforeend', html);
    container.style.opacity = 1;
}

// XMLHttpRequest using callback functions
function getCountryData1(countryName) {
    const request = new XMLHttpRequest();
    request.open('GET', 'https://restcountries.com/v3.1/name/' + countryName);
    request.send();
    
    request.addEventListener('load', () => {
            const countryData = JSON.parse(request.response)[0];
            renderCountry(countryData); // Benin information
            
            const code = countryData.borders[0];
            const request2 = new XMLHttpRequest();
            request2.open('GET', 'https://restcountries.com/v3.1/alpha/' + code);
            request2.send();

            request2.addEventListener('load', () => {
                    const neighbourData = JSON.parse(request2.response)[0];
                    renderCountry(neighbourData, 'neighbour')
            })
    })
}

// using Promises
function getCountryData2(countryName) {
    /* 
    //Promise with the problem of callback hell
    fetch(`https://restcountries.com/v3.1/name/${countryName}`)
        .then(data => {
            data.json().then( countryData => {
                renderCountry(countryData[0]);

                const code = countryData[0].borders[0];
                fetch(`https://restcountries.com/v3.1/alpha/${code}`)
                    .then(data => {
                        data.json().then( neighbourData => {
                            renderCountry(neighbourData[0], 'neighbour');
                        });
                    })
            });
    }); 
    */


    fetch(`https://restcountries.com/v3.1/name/${countryName}`)
        .then(data => data.json())
        .then( countryData => {
            renderCountry(countryData[0])
            const code = countryData[0].borders[0];
            return fetch(`https://restcountries.com/v3.1/alpha/${code}`)
        })
        .then(data => data.json())
        .then(neighbourData => renderCountry(neighbourData[0], 'neighbour'))
        .catch(err => console.log(err))
}

getCountryData2('Benin')

/* 
// lottery Promise
let lotteryPromise = new Promise(function(resolve, reject){
    setTimeout(() => {
        const num = Math.trunc(Math.random() * 10) + 1;   // [1...10]
        if(num >= 5) {
            resolve('You win!!!');
        } else {
            reject('You lose')
        }
    }, 2000)
})
lotteryPromise
        .then(data => console.log(data))
        .catch(err => console.log(err)); 
*/





