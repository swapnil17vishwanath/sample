<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<script type="text/javascript">
function getAction()
{
  document.form.action="saveEmployee";
  document.form.submit();

}
</script>

</head>
<body>
<form method="get" name="form">
<h1>HOME PAGE</h1>
<input type="submit" value="Save" onclick=" getAction()">
</form>
</body>
</html>