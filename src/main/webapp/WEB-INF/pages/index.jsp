<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Hello, world!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="/css/theme.css" type="text/css">
</head>
<body>
<div class="p-5 bg-secondary">
    <div class="container-fluid">
        <c:if test="${not empty message}">
            <div class="alert alert-danger" role="alert">
                    ${message}
            </div>
        </c:if>
        <div class="row">
            <div class="p-3 align-self-center col-md-4">
                <div class="card">
                    <div class="card-block p-3">
                        <h1 class="text-center"><span style="font-size: 30px;">Step 1</span></h1>
                        <h3 class="text-center">Page &amp; Group</h3>
                        <hr>
                        <div class="mb-2 mx-2">
                            <form method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/stepOne">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="radioStepOne" id="radioPage"
                                           value="Page" checked>
                                    <label class="form-check-label" for="radioPage">
                                        Page
                                    </label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="radioStepOne" id="radioGroup"
                                           value="Group">
                                    <label class="form-check-label" for="radioGroup">
                                        Group
                                    </label>
                                </div>

                                <div class="custom-file">
                                    <input type="file" accept=".xlsx" class="custom-file-input" name="file"
                                           id="inputStep1">
                                    <label class="custom-file-label" for="inputStep1">Choose file</label>
                                </div>
                                <hr>
                                <input class="btn btn-dark mx-auto" type="submit" value="Get txt for step 1"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="p-3 align-self-center col-md-4">
                <div class="card py-2">
                    <div class="card-block p-3">
                        <h1 class="text-center"><span style="font-size: 30px;">Step 2</span></h1>
                        <h3 class="text-center">Group Members</h3>
                        <hr>
                        <div class="mb-2 mx-2">
                            <form method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/stepTwo">
                                <div class="custom-file">
                                    <input type="file" accept=".xlsx" class="custom-file-input" name="file"
                                           id="inputStep2">
                                    <label class="custom-file-label" for="inputStep2">Choose file</label>
                                </div>
                                <hr>
                                <input class="btn btn-dark mx-auto" type="submit" value="Get txt for step 2"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="p-3 align-self-center col-md-4">
                <div class="card py-2">
                    <div class="card-block p-3">
                        <h1 class="text-center"><span style="font-size: 30px;">Step 3</span></h1>
                        <h3 class="text-center">Posts</h3>
                        <hr>
                        <div class="mb-2 mx-2">
                            <form method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/stepThree">
                                <div class="custom-file">
                                    <input type="file" accept=".xlsx" class="custom-file-input" name="file"
                                           id="inputStep3">
                                    <label class="custom-file-label" for="inputStep3">Choose file</label>
                                </div>
                                <hr>
                                <input class="btn btn-dark mx-auto" type="submit" value="Get txt for step 3"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="p-3 align-self-center col-md-4">
                <div class="card">
                    <div class="card-block p-3">
                        <h1 class="text-center"><span style="font-size: 30px;">Step 4</span></h1>
                        <h3 class="text-center">Post Interaction</h3>
                        <hr>
                        <div class="mb-2 mx-2">
                            <form method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/stepFour">
                                <div class="custom-file">
                                    <input type="file" accept=".xlsx" class="custom-file-input" name="file"
                                           id="inputStep4">
                                    <label class="custom-file-label" for="inputStep4">Choose file</label>
                                </div>
                                <hr>
                                <input class="btn btn-dark mx-auto" type="submit" value="Get txt for step 4"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="p-3 align-self-center col-md-4">
                <div class="card">
                    <div class="card-block p-3">
                        <h1 class="text-center"><span style="font-size: 30px;">Step 5</span></h1>
                        <h3 class="text-center">User Info</h3>
                        <hr>
                        <div class="mb-2 mx-2">
                            <form method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/stepFive">
                                <div class="custom-file">
                                    <input type="file" accept=".xlsx" class="custom-file-input" name="file"
                                           id="inputStep5">
                                    <label class="custom-file-label" for="inputStep5">Choose file</label>
                                </div>
                                <hr>
                                <input class="btn btn-dark mx-auto" type="submit" value="Get txt for step 5"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="p-3 align-self-center col-md-4">
                <div class="card">
                    <div class="card-block p-3">
                        <h1 class="text-center"><span style="font-size: 30px;">Step 6</span></h1>
                        <h3 class="text-center">Get JSON</h3>
                        <hr>
                        <div class="mb-2 mx-2">
                            <form method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/stepSix">
                                <div class="custom-file">
                                    <input type="file" accept=".xlsx" class="custom-file-input" name="file"
                                           id="inputStep6">
                                    <label class="custom-file-label" for="inputStep6">Choose file</label>
                                </div>
                                <hr>
                                <input class="btn btn-warning mx-auto" type="submit" value="Get JSON"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
<script>
    $('.custom-file-input').on('change', function () {
        var fileName = $(this).val().split('\\').slice(-1)[0];
        if (fileName == "") {
            $(this).next('.custom-file-label').html("Choose file");
        } else {
            $(this).next('.custom-file-label').html(fileName);
        }
    })

</script>
</body>
</html>