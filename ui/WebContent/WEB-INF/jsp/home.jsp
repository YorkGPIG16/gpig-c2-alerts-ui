<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Hello React</title>
<script src="https://fb.me/react-15.0.2.js"></script>
<script src="https://fb.me/react-dom-15.0.2.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
<script src="../js/lib/requirejs_2.2.0.js"></script>
<script src="../js/lib/underscorejs_1.8.3.js"></script>
<script src="../js/lib/jquery_2.2.3.js"></script>
</head>
<body>
	<div id="AlertsRoot"></div>
	
	<script type="text/babel">
var alerts = [];

var AlertLi = React.createClass({
  render: function() {
    return (
      <li>
        ALERT: {this.props.alertText}
      </li>
    );
  }
});

var AlertsList = React.createClass({
  render: function() {
    return (
        <ul>
            {this.props.alerts.map(function(alert) {
                return <AlertLi key={alert.id} alertText={alert.text} />;
            })}
        </ul>  
    );
  }
});


function getNewAlerts() {
    $.get("http://localhost:10080/GPIGGroup2UI/app/home/alerts",
        null,
        function(data) {
            alerts = data;
            ReactDOM.render(
    <AlertsList alerts={alerts} />,
    document.getElementById('AlertsRoot')
  );
            setTimeout(getNewAlerts, 1000);
        });
}

getNewAlerts();
    </script>
</body>
</html>