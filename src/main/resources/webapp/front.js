let tg = window.Telegram.WebApp;
let submit_btn = document.getElementById("submit");

submit_btn.addEventListener("click", () => {
    tg.close();
});