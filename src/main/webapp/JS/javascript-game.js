function updateScreenInfo(info){
    document.getElementById(VisibleWord).innerHTML()
    document.getElementById('keyboardoutput').innerText = info;
}

function getScreenInfo() {
    $.ajax({
        type: 'GET',
        url: '/rest/Game',
        success: function (response) {
            updateScreenInfo(response)
        },
        error: function (error) {
            console.log("Something went wrong", error);
        }
    });
}

function GuessLetter(letter) {
    $.ajax({
        type: "POST",
        url: "/rest/Game/Guess=" + letter,
        dataType: "json",
        data: JSON.stringify(letter),
        contentType: "application/json",
        success: function () {
            getScreenInfo();
        },
        error: function (error) {
            console.log("Something went wrong", error);
        }
    });
}

function restart() {
    $.ajax({
        type: "POST",
        url: '/rest/Game/Restart',
        success: function () {
            getScreenInfo();
        },
        error: function (error) {
            console.log("Something went wrong", error);
        }
    });
}