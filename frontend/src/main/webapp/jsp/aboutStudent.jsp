
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>More information about student</title>

</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<body>
<br>

<div class="container-fluid">
    <div class="col-md-offset-1 col-md-5">
    <div class="panel panel-primary">
        <div class="panel-heading main-color-bg">
            <h3 class="panel-title">User profile</h3>
        </div>
        <div class="panel-body">

            <table class="table table-striped table-hover">
                <tr>
                    <td scope="col">L.Name</td>
                    <td>Zhuk</td>
                </tr>
                <tr>
                    <td scope="col">F.Name</td>
                    <td>Ivan</td>
                </tr>
                <tr>
                    <td>Comments</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading main-color-bg">
            <h3 class="panel-title">Practice</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-hover">
                <thead>
                <th scope="col">Name of company</th>
                <th scope="col">Practic period</th>
                </thead>
                <tr>

                </tr>
            </table>
        </div>
    </div>
    </div>
    <div class="col-md-5">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Group
        </div>
        <div class="panel-body">
            <br>
            <table class="table table-striped table-hover">
                <tr>
                    <td scope="col">Faculty</td>
                </tr>
                <tr>
                    <td scope="col">Specialty</td>
                </tr>
                <tr>
                    <td scope="col">Group</td>
                </tr>
                <tr>
                    <td scope="col">Is budget</td>
                </tr>
                <tr>
                    <td scope="col">Average score</td>
                </tr>
                <tr>
                    <td scope="col">Status</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</div>

<div class="row">
    <div class=" col-md-offset-4 col-md-2 ">
        <button type="button" class="btn btn-primary btn-lg">Assign</button>
    </div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary btn-lg">Realise</button>
    </div>
</div>
</div>
</body>
</html>
