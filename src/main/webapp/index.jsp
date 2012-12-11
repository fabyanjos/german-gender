
<html lang="en" manifest="cache.manifest">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no, width=device-width">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link rel="apple-touch-startup-image" href="startup.png">
    <link rel="apple-touch-icon" href="app-icon.png"/>
    <link rel="shortcut icon" href="favicon.ico">
    <title>Der, Die, Das</title>
    <link rel="stylesheet" href="${request.contextPath}/css/chui.ios.css">
    <style type="text/css">
        /* Local Styles Here */

    </style>
    <script src="${request.contextPath}/js/chocolatechip.js" type="text/javascript"></script>
    <script src="${request.contextPath}/js/chui.ios.js" type="text/javascript"></script>
    <script type="text/javascript">
        /* Local JavaScript Here */
        $(function() {

        });

    </script>
</head>
<body>
    <app>
        <view id="main" ui-background-style="striped" ui-navigation-status="current">
			<toolbar ui-placement="top"></toolbar>
			<toolbar ui-placement="bottom"></toolbar>
        </view>
    </app>
</body>
</html>