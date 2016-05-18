define([
    "underscore",
    "jquery",
    "react"
],
function (_, $, React) {
    
    var ActionDialog = React.createClass({
        getInitialState: function() {
            return {
                actionText: ""
            };
        },
        
        handleInputChange: function(event) {
            this.setState({
                actionText: event.target.value
            });
        },
        
        handleClick: function() {
            var actionAlert = _.clone(this.props.actionAlert);
            var funcs = this.props.funcs;
            
            actionAlert.actioned = "ACTIONED";
            actionAlert.actionText = this.state.actionText;
            
            jQuery.ajax({
                url: config.actionUrl,
                headers: { 
                    "Content-Type": "application/json" 
                },
                type: "POST",
                data: JSON.stringify(actionAlert),
                dataType: "text",
                success: function() {
                    funcs.hideActionDialog();
                }
            });
        },
        
        render: function() {
            return (
                <div id="AlertsDialog">
                    <div className="inputWrapper">
                        <input type="text" placeholder="Action taken..." onChange={this.handleInputChange} />
                    </div>
                    <div className="buttonWrapper">
                        <button onClick={this.handleClick}>Action</button>
                    </div>
                </div>
            );
        }
    });

    return ActionDialog;
});
