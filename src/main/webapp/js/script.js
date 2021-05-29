function script() {
    $.ajax({
        type: "GET",
        url: "books.xml",
        dataType: "xml",
        success: function (xml) {
            console.log(xml);
            $("#get_data").append((new XMLSerializer()).serializeToString(xml));
            send_to_servlet(xml);
        },
      });
}

function send_to_servlet(xml) {
    $.ajax({
        url: "getxmldata",
        type: "POST",
        contentType: "application/xml",
        dataType: "xml",
        data: (new XMLSerializer()).serializeToString(xml),
        success: function (messege) {
         alert("Successfully sent to Servlet");
        },
      });
}