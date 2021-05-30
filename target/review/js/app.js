function app() {
  $.ajax({
    type: "GET",
    url: "books.json",
    dataType: "json",
    success: function (data) { // xhr_response
        $("#get_data").append(JSON.stringify(data));
      sendToservlet(data);
    },
  });
}

function sendToservlet(data) {
  $.ajax({
    url: "getdata",
    type: "POST",
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify(data),
    success: function (messege) {
      alert("Successfully send to servlet");
    },
  });
}
