<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

</head>
<title>IMS</title>
<h1>Inventory Management System</h1>
<h2>Hello User</h2>
<hr></hr>
<body>

	<form role="form" action="/GradleSpringMVC/inventory/welcome" method="GET">
       <input class="mainInventoryButton" type="submit" name="inventory" value="Add Inventory">
       
	</form>
	<p id="demo"></p>

<script src="<c:url value="/resources/core/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/welcome.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">

</body>
</html>