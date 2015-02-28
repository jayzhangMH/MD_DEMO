<#macro html title="明道OA">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Language" content="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9"/>
    <title>${title?html}</title>
    <link rel="shortcut icon" href="/view/favicon.ico"/>
    <script src="/js/jquery.js"></script>
    <script src="/js/sea.js"></script>
    <script src="/js/support.js"></script>
    <script src="/js/StringBuilder.js"></script>
    <script src="/js/jquery.jscrollpane.min.js"></script>
    <script src="/js/jquery.mousewheel.js"></script>
    <script src="/js/My97DatePicker/WdatePicker.js"></script>
    <script src="/js/imgReady.js"></script>
</head>
<script>
    seajs.config({
        base: "/js/modules/"
    });
</script>
<body>
    <#setting number_format="#">
    <#nested/>
</body>
</html>
</#macro>
