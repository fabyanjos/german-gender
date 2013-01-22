<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no, width=device-width">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link rel="shortcut icon" href="favicon.ico">
    <title>Der, Die, Das</title>
    
    <c:choose>
    	<c:when test="${fn:containsIgnoreCase(header['user-agent'],'Android')}">
    		<link rel="stylesheet" href="/css/lib/chui.android.css">
    	</c:when>
    	<c:otherwise>
    		<link rel="stylesheet" href="/css/lib/chui.ios.css">
    	</c:otherwise>
    </c:choose>
	<link rel="stylesheet" href="/css/lib/chui.ios.desktop.css">
	<style type="text/css" media="only screen and (min-width: 650px)">
        /* Local Styles Here */
	        view {
	        	width: 300px;
	        	height: 380px;
	        	margin-left: 35%;
	        	box-shadow:5px 5px 20px #000;
				-webkit-box-shadow:5px 5px 20px #000;
				border-radius: 20px;
				-webkit-border-radius: 10px;
				border: 2px solid #909cb3;
	        }
    </style>    
    <style type="text/css">
        /* Local Styles Here */
        p {
	        font-size: 20px;
			line-height: 35px;
			text-shadow: 0 -2px 2px white;
			color: #666;
			text-align: center;
        }
        img#image {
        	width: 100px;
        	border-style: solid;
        }
        p#wrong {
        	background-image: -webkit-linear-gradient(top, rgba(255,124,151,0.7), rgba(255,74,89,0.7) 50%, rgba(255,0,4,0.7) 50%, rgba(255,62,27,0.7)); 
        	width: 300px; 
        	color: black;
        	font-size: 15px; 
        	line-height: 25px;
        }
        p#correct {
        	background-image: -webkit-linear-gradient(top, rgba(79,156,74,0.7), rgba(54,127,35,0.7) 50%, rgba(0,113,0,0.7) 50%, rgba(0,150,0,0.7)); 
        	width: 300px; 
        	color: black; 
        	font-size: 15px;
        }
        segmentedcontrol uibutton {
			height: 50px;        	
			font-weight: bold;
        }
        .redButton {
        	background-image: -webkit-linear-gradient(top, rgba(255,124,151,0.7), rgba(255,74,89,0.7) 50%, rgba(255,0,4,0.7) 50%, rgba(255,62,27,0.7));
        }
        .greenButton {
        	background-image: -webkit-linear-gradient(top, rgba(79,156,74,0.7), rgba(54,127,35,0.7) 50%, rgba(0,113,0,0.7) 50%, rgba(0,150,0,0.7));
        }
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
            	url: "/rest/word/random",  
            	beforeSend: function() {
        		},
        		complete: function() {
        		},
            	success: function(data) {
            		if((data != null)) {
            			$("#words").append($('<p>').text(data.name).append($('<br>'))
            					.append($('<image>').attr("id", "image").attr('src', '/images/'+data.image))
            					)
            					.append($('<input>').attr("id", "article").attr("type", "hidden").attr("value", data.article));
            		} else {
            			$("#words").append($('<tablecell>').append($('<celltitle>').text("vazia")));
            		}
            	}
            });
        });
        
        function disableButtons() {
        	$("#articleButton").attr("style", "display: none;");
        	$("#nextButton").attr("style", "display: ;");
        	$("#wrong").attr("style", "display: none;");
    		$("#correct").attr("style", "display:");
        	
        }
        
        function checkArticle(article) {
        	var field = $("#" + article.toLowerCase());
    		if($("#article").val() == article) {
    			//$("#image").attr('style', 'border-width:10px;border-color:green;');
    			disableButtons();
    		} else {
    			field.attr('class', 'redButton');
    			$("#wrong").attr("style", "display:");
    			field.attr('class', 'disabled');
    			field.attr('onclick', '');
    		}
    	}
        
    </script>
</head>
<body>
<app>
<view id="main" ui-background-style="striped" ui-navigation-status="current">
	<navbar>
		<h1>German Gender</h1>
	</navbar>
	<subview ui-associations="withNavBar" id="subview">
		<scrollpanel>
			<div id="words" style="display: block;">
			</div>
			<stack id="articleButton">
				<segmentedcontrol>
					<uibutton id="der" role="button" onclick="checkArticle('Der');">
		    			<label>Der</label>
					</uibutton>
					<uibutton id="die" role="button" onclick="checkArticle('Die');">
		    			<label>Die</label>
					</uibutton>
					<uibutton id="das" role="button" onclick="checkArticle('Das');">
		    			<label>Das</label>
					</uibutton>
				</segmentedcontrol>
			</stack>
			<stack id="nextButton" style="display: none;">
				<segmentedcontrol>
					<uibutton id="next" ui-kind="action" ui-implements="default" role="button" onclick="window.location.reload();">
		    			<label>Next <img src="/images/icons/chevron.svg" width="25px" style="margin-bottom:-7px"></label>
					</uibutton>
				</segmentedcontrol>
			</stack>
			<div id="message" align="center">
				<p id="wrong" style="display: none;"><img src="/images/icons/delete.svg" width="35px" style="margin-bottom:-10px"></img>It's wrong, try again!</p>
				<p id="correct" style="display: none;"><img src="/images/icons/check_mark.svg" width="25px" style="margin-bottom:-5px"></img>It's correct, congratulations!</p>
			</div>
		</scrollpanel>
	</subview>
	
    <!-- toolbar ui-placement="bottom">
    </toolbar-->
</view>
</app>
</body>
</html>