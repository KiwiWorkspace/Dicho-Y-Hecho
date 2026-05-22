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
    preview.textContent = "📎 " + input.files[0].name;
    preview.style.display = "block";
  }
}

function toggleEditForm(id) {
  const text = document.getElementById("text-" + id);
  const form = document.getElementById("form-" + id);
  if (form.style.display === "none") {
    form.style.display = "block";
    text.style.display = "none";
  } else {
    form.style.display = "none";
    text.style.display = "block";
  }
}