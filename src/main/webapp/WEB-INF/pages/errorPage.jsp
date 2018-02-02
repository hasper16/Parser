<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>${errorHead}</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

</head>
<body class="text-center opaque-overlay" style="background-image: url('/images/bg.png');">
<div class="container-fluent py-5 h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-md-12">
            <h1 class="display-3 mb-4">${errorHead}</h1>
            <p class="lead mb-5">${errorMsg}</p>
            <a href="/" class="btn btn-lg btn-primary mx-1">Go to mail page</a>
        </div>
    </div>
</div>
</body>
</html>