define([
	"underscore",
	"jquery",
	"react",
	"reactdom"
],
function (_, $, React, ReactDOM) {
	
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
	    $.get("http://localhost:10080/GPIGGroup2UI/app/alerts",
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
	
	return function () {
		getNewAlerts();
	}
});
