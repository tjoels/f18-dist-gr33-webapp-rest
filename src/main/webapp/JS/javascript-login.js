function Login() {
    document.getElementById("loading").style.display = 'inline';
    data = $('#login').serializeArray();

    var username = data[0]['value'];
    var password = data[1]['value'];

    console.log(username + " : " + password);

    $.ajax({
        type: 'POST',
        url: '/rest/Login/Username=' + username + '&Password=' + password,
        dataType: "json",
        data: JSON.stringify(username, password),
        contentType: "application/json",
        success: function (response) {
            if (response) {
                document.getElementById("loading").style.display = 'none';
                document.getElementById("login").style.display = 'none';
                document.getElementById("game").style.display = 'inline';

                $("#game").load("game.html");

            } else {
                alert("Username or password incorrect !")
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            document.getElementById("login").reset();
            document.getElementById("loading").style.display = 'none';

            alert("Login unsuccessful: " + textStatus);
        }
    });
}