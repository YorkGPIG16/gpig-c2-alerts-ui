define([
    "react",
    "jsx!AlertLi",
],
function (React, AlertLi) {
    
    var AlertsList = React.createClass({
        render: function() {
            var props = this.props;
            return (
                <ul id="AlertsList">
                    {this.props.alerts.map(function(alert) {
                        return <AlertLi key={alert.id} funcs={props.funcs} alert={alert} actionAlert={props.actionAlert} />;
                    })}
                </ul>  
            );
        }
    });

    return AlertsList;
});
