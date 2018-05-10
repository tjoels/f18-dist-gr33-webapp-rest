function PostLetter(letter) {
    $.ajax({
        type: "POST",
        url: "/Game/Guess=" + letter,
        dataType: "json",
        data: JSON.stringify(letter),
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            if (response) {

            } else {
                alert(response)
            }
        },
        error: function (error) {
            console.log("Something went wrong", error);
        }
    });
}

function restart() {

    $.ajax({
        type: "POST",
        url: '/Game/Restart',
        success: function (response) {
            console.log("Restart: " + response);
            document.getElementById(VisibleWord).innerHTML()
        },
        error: function (error) {
            console.log("Something went wrong", error);
        }
    });
}