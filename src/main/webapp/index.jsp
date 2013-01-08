<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no, width=device-width">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link rel="shortcut icon" href="favicon.ico">
    <title>Der, Die, Das</title>
    <link rel="stylesheet" href="/css/lib/chui.ios.css">
    <link rel="stylesheet" href="/css/lib/chui.ios.desktop.css">
    <style type="text/css">
        /* Local Styles Here */

    </style>
    <script src="/js/lib/zepto.js" type="text/javascript"></script>
    <script src="/js/lib/iscroll.js" type="text/javascript"></script>
    <script src="/js/lib/chui.ios.js" type="text/javascript"></script>
    <script type="text/javascript">
        /* Local JavaScript Here */
        $(function() {
        	$.ajax({  
                type: "GET",  
                dataType: "json",
            	url: "/rest/word",  
            	beforeSend: function() {
        		},
        		complete: function() {
        		},
            	success: function(data) {
            		if((data != null) && (data.words != null)) {
            			$.each(data.words, function(index, word) { 
            				$("#words").append($('<tablecell>').append($('<celltitle>').text(word.name))); 
           				});
            		} else {
            			$("#words").append('<celltitle>vazia</celltitle>');
            		}
            	}
            });
        });
        
    </script>
</head>
<body>
<app ui-background-style="striped">
<view id="main" ui-background-style="striped" ui-navigation-status="current">
	<navbar>
		<h1>Tableview</h1>
	</navbar>
	<subview ui-associations="withNavBar">
		<scrollpanel>
			<tableview id="words" ui-kind="grouped" >
			</tableview>
		</scrollpanel>
	</subview>
    <toolbar ui-placement="bottom">
    </toolbar>
</view>
</app>
</body>
</html>