document.addEventListener("DOMContentLoaded", function () {
  const trigger = document.getElementById("profileTrigger");
  const dropdown = document.getElementById("profileDropdown");

  if (trigger && dropdown) {
    trigger.addEventListener("click", function (e) {
      e.preventDefault();
      e.stopPropagation();
      dropdown.classList.toggle("show");
    });

    document.addEventListener("click", function (e) {
      if (!dropdown.contains(e.target)) {
        dropdown.classList.remove("show");
      }
    });
  }
});

function updateFileName(input) {
  const preview = document.getElementById("filePreview");
  if (input.files.length > 0) {
    preview.textContent = "Archivo seleccionado: " + input.files[0].name;
    preview.style.display = "block";
  }
}

function toggleEditForm(id) {
  const textElement = document.getElementById("text-" + id);
  const formElement = document.getElementById("form-" + id);

  if (formElement.style.display === "none") {
    formElement.style.display = "block";
    textElement.style.display = "none";
  } else {
    formElement.style.display = "none";
    textElement.style.display = "block";
  }
}
