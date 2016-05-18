<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>Alerts</title>
<script type="text/javascript">
var config = {};
config.serverBase = "${pageContext.request.contextPath}/app/";
config.alertsUrl = config.serverBase + "alerts";
config.actionUrl = config.serverBase + "alerts/action";
</script>
<script src="../js/requireConfig.js" type="text/javascript"></script>
<script src="../js/lib/requirejs_2.2.0.js" data-main="../js/main" type="text/javascript"></script>
<link href="../styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="AlertsRoot"></div>
</body>
</html>
