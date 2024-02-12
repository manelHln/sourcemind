const searchBtn = document.querySelector(".search-btn");
const searchBox = document.querySelector(".searchbox");
const cardsContainer = document.querySelector(".cards-container");
const closeModal = document.querySelector(".close-modal");
const modalPopup = document.querySelector(".modal-popup");
const retrievedUser = document.querySelector(".retrieved-username");
const retrievedLogin = document.querySelector(".retrieved-login");
const urlBtn = document.querySelector(".link-to-repo");
const repoCountBtn = document.querySelector(".repo-count-btn");
const userAvatar = document.querySelector(".avatar");
let cards = [];

function get(username) {
  fetch(`https://api.github.com/users/${username}`, {
    method: "GET",
    headers: {
      Accept: "application/vnd.github+json",
      "X-GitHub-Api-Version": "2022-11-28",
      Authorization: "Bearer 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",
    },
  })
    .then((response) => {
      console.log(response);
      if (response.status == 404) {
        cardsContainer.insertAdjacentHTML(
          "beforebegin",
          `<h2 class="heading" style="text-align: center"> No user found for ${username}!!!</h2>`
        );
        return;
      }
      return response.json();
    })
    .then((data) => {
      userAvatar.setAttribute("src", data.avatar_url);
      retrievedLogin.textContent = data.login;
      retrievedUser.textContent = data.name;
      urlBtn.setAttribute("href", data.html_url);
      repoCountBtn.textContent = data.public_repos;
      modalPopup.classList.add("modal-visible");
    })
    .catch((err) => console.log(err));
}

searchBtn.addEventListener("click", () => {
  const toSearch = searchBox.value;
  if (!toSearch || toSearch === "") {
    fetch("https://api.github.com/users?per_page=40", {
      method: "GET",
      headers: {
        Accept: "application/vnd.github+json",
        "X-GitHub-Api-Version": "2022-11-28",
        Authorization: "Bearer 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",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        data?.map((user) => {
          cardsContainer.insertAdjacentHTML(
            "afterbegin",
            `
            <div class="card">
              <img src=${user.avatar_url} alt="avatar" class="avatar" />
              <span class="username">${user.login}</span>
            </div>`
          );
        });
        cards = document.querySelectorAll(".card");
        cards.forEach((card) =>
          card.addEventListener("click", () => {
            const username = card
              .getElementsByClassName("username")
              .item("").textContent;
            get(username);
          })
        );
      })
      .catch((err) => console.log(err));
    return;
  }
  get(toSearch);
});

closeModal.addEventListener("click", () => {
  modalPopup.classList.remove("modal-visible");
});

window.addEventListener("click", (e) => {
  if (modalPopup === e.target) {
    modalPopup.classList.remove("modal-visible");
  }
});
