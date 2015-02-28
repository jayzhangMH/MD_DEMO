<#macro pagerCommon actionJs="pagerAction"  start=0 max=10  object=pageObj>
    <#if object?exists&&object.totalPage gt 1>
    <script type="text/javascript">
        var everyPage=${object.everyPage?c};
        var evalActionJs='${actionJs?if_exists}';
        seajs.use('utils/page');
    </script>
    <!--分页器begin-->
    <div class="md-oa-page pagenation aligncenter mart30">
        <#assign tp=object.totalPage>
        <#assign cp=object.currentPage>
        <#assign tr=object.totalRecord>
        <#assign ep=object.everyPage>
        <#assign preFlag=false>
        <#assign nextFlag=false>
        <#if cp gt 5>
            <#assign preFlag=true>
        </#if>
        <#if preFlag>
            <a class="page prev marr20" href="javascript:;">上一页</a>
        </#if>
        <#assign mo=(cp%5)?int>
        <#assign divided=(cp/5)?int>
        <#if mo gt 0>
            <#assign divided=(divided+1)?int>
        </#if>
        <#assign endCur=(divided*5)?int>
        <#assign starCur=endCur-4>
        <#if tr gt endCur*ep>
            <#assign nextFlag=true>
        </#if>
        <#list starCur..endCur as p>
            <#if p==object.currentPage>
                <a class="current" href="javascript:;">${p}</a>
            <#elseif p gt object.totalPage>
                <a class="disabled" href="javascript:;">${p}</a>
            <#else >
                <a  href="javascript:;">${p}</a>
            </#if>
        </#list>
        <#if nextFlag>
            <a class="page next marl20" href="javascript:;">下一页</a>
        </#if>
    </div>
    <!--分页器bover-->
    </#if>
</#macro>

