<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>明道OA</title>
    <link rel="stylesheet" href="/css/global.css" type="text/css">
    <link rel="stylesheet" href="/css/appstyle.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="/css/jscrollpane.css" type="text/css">
    <link rel="shortcut icon" href="/view/favicon.ico"/>
</head>
<body>
<div class="home_page">
    <div class="nodata aligncenter">
        <p><img src="${errorImg?if_exists}"></p>
        <p class="font30 color-3 p-top20 p-bt20">${errorMsg?if_exists}</p>
        <p class="color-8 p-top10">服务器内部错误，不能执行请求</p>
        <p><a class="new_btn aligncenter mart20 font14" href="/platform/desktop">返回首页</a></p>
    </div>
</div>
</body>
</html>