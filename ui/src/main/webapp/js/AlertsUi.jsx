define([
    "underscore",
    "react",
    "requirejs-react-jsx!AlertsList",
    "requirejs-react-jsx!ActionDialog"
],
function (_, React, AlertsList, ActionDialog) {
    
    var AlertsUi = React.createClass({
        getInitialState: function() {
            return {
                showActionDialog: false,
                actionAlert: null
            }
        },
        
        funcs: {
            showActionDialog: function(alert) {
                var uncheckingAlert =
                    !_.isUndefined(this.state.actionAlert) &&
                    !_.isNull(this.state.actionAlert) &&
                    this.state.actionAlert.id == alert.id;
                    
                this.setState({
                    showActionDialog: !uncheckingAlert,
                    actionAlert: uncheckingAlert ? null : alert
                });
            },
            
            hideActionDialog: function() {
                this.setState({
                    showActionDialog: false,
                    actionAlert: null
                });
            }
        },
       
        render: function() {
            this.funcs.showActionDialog = this.funcs.showActionDialog.bind(this);
            this.funcs.hideActionDialog = this.funcs.hideActionDialog.bind(this);
                        
            return (
                <div>
                    {this.state.showActionDialog ?
                        <ActionDialog funcs={this.funcs} actionAlert={this.state.actionAlert} /> :
                        null}
                    <AlertsList funcs={this.funcs} alerts={this.props.alerts} actionAlert={this.state.actionAlert} />
                </div>
            );
        }
    });

    return AlertsUi;
});
