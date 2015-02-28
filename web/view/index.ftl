<#import "/view/template/common.ftl" as common>
<#import "/view/common/core.ftl" as c>
<@common.html title="快捷审批">
<script>
    seajs.use('view/logout');
</script>

    <#if Session["userSession"]?exists>
        <#assign userInfo=Session["userSession"]?if_exists>
        <#if userInfo?exists>
        <span style="color: green">欢迎登录 ${userInfo.sysUser.userName?if_exists} 帐号${userInfo.sysUser.userAccount?if_exists}</span>
        </#if>
    </#if>

<a href="/sys/user/reg?id=${(userInfo.sysUser.id)?c}" style="color: #0066cc" id="editAction">编辑</a>
<a href="/sys/user/delete?id=${(userInfo.sysUser.id)?c}" style="color: darkgoldenrod" >删除</a>
<a href="/sys/user/test?id=${(userInfo.sysUser.id)?c}" style="color: #034c50" >好玩的</a>
<a href="/sys/user/list" style="color: #034c50">列表</a>
<a href="javascript:;" style="color: red" id="logoutAction">注销</a>

</@common.html>