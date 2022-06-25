<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate">
        <title>XSS</title>      
        <link href="/XSS/bootstrap.min.css" rel="stylesheet" type="text/css">        
    </head>
    <body class="container">
        <br>
        <div class="card">
            <h5 class="card-header">
                Create User
                <a class="btn btn-primary float-right" href="/XSS/secure">Users</a>
            </h5>
            <div class="card-body">
                <h5 class="card-title"></h5>
                <form autocomplete="off" action="secureCreate" method="post">
                    <input type="hidden" name="csrfToken" value='<%=session.getAttribute("csrfToken")%>'>	    
                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control" name="fname" autocomplete="off">	    
                    </div>
                    <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" class="form-control" name="lname" autocomplete="off">	    
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" autocomplete="off">	    
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
        <script src="/XSS/jquery-3.3.1.slim.min.js"></script>
        <script src="/XSS/popper.min.js"></script>
        <script src="/XSS/bootstrap.min.js"></script>      
    </body>
</html>