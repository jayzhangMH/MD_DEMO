<#macro html title="明道OA">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta content="black-translucent" name="apple-mobile-web-app-status-bar-style">
    <title>${title?html}</title>
    <link rel="stylesheet" href="/css/mstyles.css" type="text/css">
    <link rel="stylesheet" href="/css/fontstyles.css" type="text/css">
    <script type="text/javascript" src="http://la-public.b0.upaiyun.com/app/la/js/jquery.js"></script>
    <script type="text/javascript" src="http://la-public.b0.upaiyun.com/app/la/js/iscroll.js"></script>
    <script type="text/javascript" src="http://la-public.b0.upaiyun.com/app/la/js/json2.js"></script>
    <script type="text/javascript" src="http://la-public.b0.upaiyun.com/app/la/js/sea.js"></script>
    <script type="text/javascript" src="http://la-public.b0.upaiyun.com/app/la/js/StringBuilder.js"></script>
    <script type="text/javascript" src="http://la-public.b0.upaiyun.com/app/la/js/support.js"></script>
</head>
<script>
    seajs.config({
        base: "/js/modules/"
    });
</script>
<body>
    <#setting number_format="#">
<div class="view">
    <#nested/>
</div>
</body>
</html>
</#macro>
