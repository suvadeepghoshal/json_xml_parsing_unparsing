function generate() {
  $.ajax({
    url: "fromdb",
    type: "POST",
    contentType: "application/text",
    dataType: "text",
    data: "Sent",
    success: function (messege) {
      alert("Successfully sent to Servlet");
    },
  });
}
