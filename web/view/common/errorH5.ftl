<#import "/view/template/commonMobile.ftl" as commonMobile>
<@commonMobile.html title="企业理财" >
<div class="view">
    <!--header begin-->
    <header class="header clearfix">
        <div class="TopL"><span class="Icon icon-back"></span></div>
        <div class="TopM aligncenter" id="show_nav"><span class="block font16">出错啦</div>
        <div class="TopR"></div>
    </header>
    <!--header over-->
    <!--content begin-->
    <div class="content">
        <div class="error aligncenter">
            <p><img src="${errorImg?if_exists}"></p>
            <p class="font14 color-8">${errorMsg?if_exists}</p>
        </div>
    </div>
    <!--content over-->
</div>
</@commonMobile.html>