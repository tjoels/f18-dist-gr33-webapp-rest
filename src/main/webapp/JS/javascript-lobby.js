function sendMessage(message) {
    $.ajax({
        type: 'POST',
        url: '/Lobby/SendMessage/Message=' + message,
        dataType: 'json',
        data: JSON.stringify(message),
        contentType: 'application/json',
        success: function (response) {
            console.log("Should have worked!", response);
        },
        error: function (error) {
            console.log("Something went wrong: ", error);
        }

    });
}

function Play (username) {
    $.ajax({
        type: 'POST',
        url: '/Lobby/Play',
        dataType: 'json',
        data: JSON.stringify(username),
        contentType: 'application/json',
        success: function (response) {
          console.log("Should have worked!", response)
        },
        error: function () {
            console.log("Something went wrong: ", error)
        }
    });
}