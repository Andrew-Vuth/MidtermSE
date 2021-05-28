<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
      crossorigin="anonymous"
    />
    <title>Feedback form</title>
  </head>
  <body>
    <div class="container">
      <form
        action="http://localhost:8080/midtermEx8/ThankYou.jsp"
        method="POST"
      >
        <div class="form-group">
          <label>Feed back</label>
          <input
            class="form-control"
            placeholder="Your feedbacks"
            name="feedback"
          />
        </div>
        <div class="form-group">
          <label>Example select</label>
          <select class="form-control" name="service">
            <option value="web hosting">Web hosting</option>
            <option value="domain transfer">Domain transfer</option>
            <option value="domain selling">Domain selling</option>
            <option value="ssl">SSL</option>
            <option value="VPS">VPS</option>
          </select>
        </div>
        <input type="submit" value="Submit" />
      </form>
    </div>
  </body>
</html>
