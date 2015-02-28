<#import "/view/template/common.ftl" as common>
<#import "/view/common/core.ftl" as c>
<@common.html title="快捷审批">
<script>
</script>

    <#if userList?exists&&userList?size gt 0>
        <#list userList as user>
        ${user_index+1}、姓名${user.userName?if_exists}[${user.userAccount?if_exists}]</br>
        </#list>
    总共几页${userPage.totalPage?c}<br>
    总共条数${userPage.totalRecord?c}
    </#if>

</@common.html>