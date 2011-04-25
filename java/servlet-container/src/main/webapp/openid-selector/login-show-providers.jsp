<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>JQuery Simple OpenID Selector Demo</title>
	<!-- Simple OpenID Selector -->
	<link type="text/css" rel="stylesheet" href="openid-selector/css/openid.css" />
	<script type="text/javascript" src="openid-selector/js/jquery-1.2.6.min.js"></script>
	<script type="text/javascript" src="openid-selector/js/openid-jquery.js"></script>
	<script type="text/javascript" src="openid-selector/js/openid-en.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			openid.init('openid_identifier');
			openid.setDemoMode(true); //Stops form submission for client javascript-only test purposes
		});
	</script>
	<!-- /Simple OpenID Selector -->
	<style type="text/css">
		/* Basic page formatting */
		body {
			font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
		}
	</style>
</head>

<body>
	<h2>Login using OpenID</h2>

	<br/>

	<form action="examples/consumer/try_auth.php" method="get" id="openid_form">
		<input type="hidden" name="action" value="verify" />
		<fieldset>
			<legend>Sign-in or Create New Account</legend>
			<div id="openid_choice">
				<p>Please click your account provider:</p>
				<div id="openid_btns"></div>
			</div>
			<div id="openid_input_area">
				<input id="openid_identifier" name="openid_identifier" type="text" value="http://" />
				<input id="openid_submit" type="submit" value="Sign-In"/>
			</div>
			<noscript>
				<p>OpenID is service that allows you to log-on to many different websites using a single indentity.
				Find out <a href="http://openid.net/what/">more about OpenID</a> and <a href="http://openid.net/get/">how to get an OpenID enabled account</a>.</p>
			</noscript>
		</fieldset>
	</form>
</body>