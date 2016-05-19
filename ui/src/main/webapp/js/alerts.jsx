define([
	"underscore",
	"jquery",
	"react",
	"reactdom",
    "requirejs-react-jsx!AlertsUi"
],
function (_, $, React, ReactDOM, AlertsUi) {
	
	var alerts = [];
	
	var alertSort = function(alert) {
        switch(alert.priority) {
            case "HIGH":
                return 1;
                break;
            case "MEDIUM":
                return 2;
                break;
            case "LOW":
                return 3;
                break;
        };
    };
	
	function getNewAlerts() {
        $.get(config.alertsUrl,
            null,
            function(data) {
                alerts = _.sortBy(data, alertSort);
                ReactDOM.render(
                   <AlertsUi alerts={alerts} />,
                   document.getElementById('AlertsRoot')
            );
            setTimeout(getNewAlerts, 500);
        });
	}

	return function () {
		getNewAlerts();
	}
});
