<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
      crossorigin="anonymous"
    />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <title>Review</title>
  </head>
  <body>
    <main>
      <section class="py-5 text-center container">
        <div class="row py-lg-5">
          <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">Json Implementation</h1>
            <p class="lead text-muted">Trying to do JSON assignment</p>

            <p>
              <input
                class="btn btn-primary"
                type="button"
                id="button_to_get_json_data"
                value="Click me to get JSON Data"
                name="button_to_get_json_data"
                onclick="app()"
              />
            </p>
            <input
                class="btn btn-secondary"
                type="button"
                id="button_to_get_xml_data"
                value="Click me to get XML Data"
                name="button_to_get_xml_data"
                onclick="script()"
              />
            </p>
            <p id="get_data"></p>
          </div>
        </div>
      </section>
    </main>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>
    <script src="js/app.js"></script>
    <script src="js/script.js"></script>
  </body>
</html>
