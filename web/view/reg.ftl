<#import "/view/template/common.ftl" as common>
<#import "/view/common/core.ftl" as c>
<@common.html title="快捷审批">
<script>
    seajs.use('view/reg');
</script>
<form action="/sys/user/save" method="POST" class="formStyle" name="editForm" id="editForm"
      onsubmit="return false;">
    <@c.joddForm bean="sysUser" scope="request">
        <table style="width: 400px;text-align: center;">
            <tbody>
            <tr>
                <td>用户名</td>
                <td><input type="text" id="sysUser.userName" name="sysUser.userName"></td>
            </tr>
            <tr>
                <td>帐号</td>
                <td><input type="text" id="sysUser.userAccount" name="sysUser.userAccount"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" id="sysUser.userPassword" name="sysUser.userPassword"></td>
            </tr>
            <tr>
                <td><a href="javascript:;" id="saveAction">保存</a></td>
            </tr>
            </tbody>
        </table>
        <input type="hidden" name="sysUser.id" id="sysUser.id">
    </@c.joddForm>
    <@c.token/>
</form>

</@common.html>