let tg = window.Telegram.WebApp;
let submitBtn = document.getElementById("submit");

submitBtn.addEventListener("click", () => {
    let userId = document.getElementById("user_id_input").value =
    tg.initDataUnsafe.user.username;
    let userPassword = document.getElementById("user_pass_input").value;

    // let data = {
    //     userId: userId,
    //     userPassword: userPassword
    // }

    //tg.sendData(JSON.stringify(data));
    //tg.close();
});