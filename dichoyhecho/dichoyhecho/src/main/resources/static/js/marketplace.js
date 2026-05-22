// Store Modal Functions
function openStoreModal(element) {
  event.preventDefault();

  const title = element.querySelector(".reddit-card-title").textContent;
  const description = element.querySelector(".reddit-card-text").textContent;
  const zone = element.querySelector(".reddit-card-zone").textContent;
  const phone = element
    .querySelector(".reddit-card-votes")
    .textContent.replace("📞 ", "");
  const email = element
    .querySelector(".reddit-card-comments")
    .textContent.replace("✉ ", "");
  const category = element.querySelector(".post-tag").textContent;
  const imageBg =
    element.querySelector(".reddit-card-thumb").style.backgroundImage;

  document.getElementById("modalTitle").textContent = title;
  document.getElementById("modalDescription").textContent = description;
  document.getElementById("modalZone").textContent = zone.replace("📍 ", "");
  document.getElementById("modalPhone").textContent = phone;
  document.getElementById("modalEmail").textContent = email;
  document.getElementById("modalCategory").textContent = category;
  document.getElementById("modalImage").style.backgroundImage = imageBg;

  document.getElementById("modalCallBtn").href = "tel:" + phone;
  document.getElementById("modalEmailBtn").href = "mailto:" + email;

  document.getElementById("storeModal").classList.add("active");
  document.body.style.overflow = "hidden";
}

function closeStoreModal() {
  document.getElementById("storeModal").classList.remove("active");
  document.body.style.overflow = "";
}

document.getElementById("storeModal").addEventListener("click", function (e) {
  if (e.target === this) {
    closeStoreModal();
  }
});

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape") {
    closeStoreModal();
  }
});

// Search & Filter Functions
function filterStores() {
  const searchText = document.getElementById("storeSearch").value.toLowerCase();
  const cards = document.querySelectorAll(".reddit-card");

  cards.forEach((card) => {
    const name =
      card.dataset.name ||
      card.querySelector(".reddit-card-title").textContent.toLowerCase();
    if (name.includes(searchText)) {
      card.style.display = "";
    } else {
      card.style.display = "none";
    }
  });
}

function filterByCategory(category) {
  const cards = document.querySelectorAll(".reddit-card");

  cards.forEach((card) => {
    const cardCategory = card.dataset.category;
    if (category === "" || cardCategory === category) {
      card.style.display = "";
    } else {
      card.style.display = "none";
    }
  });
}

// Profile Dropdown
const profileTrigger = document.getElementById("profileTrigger");
const profileDropdown = document.getElementById("profileDropdown");

profileTrigger.addEventListener("click", function (e) {
  e.stopPropagation();
  profileDropdown.classList.toggle("show");
});

document.addEventListener("click", function () {
  if (profileDropdown.classList.contains("show")) {
    profileDropdown.classList.remove("show");
  }
});
