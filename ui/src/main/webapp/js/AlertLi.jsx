define([
    "underscore",
    "react"
],
function (_, React) {
    
    var AlertLi = React.createClass({
        getInitialState: function() {
            return {
                isSelected: false
            }
        },
        
        handleClick: function(event) {
            this.props.funcs.showActionDialog(this.props.alert);
        },
        
        render: function() {
            var classNames = "alert ";
            
            switch (this.props.alert.priority) {
                case "LOW":
                    classNames += "priority-low";
                    break;
                case "MEDIUM":
                    classNames += "priority-medium";
                    break;
                case "HIGH":
                    classNames += "priority-high";
                    break;
            }
            
            classNames += " ";
            
            if (!_.isUndefined(this.props.actionAlert) &&
                !_.isNull(this.props.actionAlert) &&
                this.props.actionAlert.id == this.props.alert.id) {
                classNames += "selected "
            }
            
            return (
                <li className={classNames} onClick={this.handleClick}>
                    {/**{this.props.alert.id}:**/}
                    {this.props.alert.text}
                </li>
            );
        }
    });

    return AlertLi;
});
