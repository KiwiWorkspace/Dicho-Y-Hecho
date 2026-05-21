function changeLanguage(lang) {
    //Capturamos la direccion base actual de la página
    var currentUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
    
    // Redirige al usuario inyectando el nuevo idioma
    window.location.href = currentUrl + "?lang=" + lang;
}