<script type="text/babel">
var Guest = React.createClass({
	render : function() {
		return (<div>guest</div>);
	}	
});


var Tables = React.createClass({
	render : function() {
		return (<div>tables</div>);
	}
});

ReactDOM.render(<App />, document.getElementById('root'));
</script>