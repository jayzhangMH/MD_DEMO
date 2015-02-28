<#import "/view/template/common.ftl" as common>
<#import "/view/common/core.ftl" as c>
<@common.html title="快捷审批">
<script>
    seajs.use('view/login');
</script>
<form action="/common/authorize/login" method="POST" class="formStyle" name="editForm" id="editForm"
      onsubmit="return false;">
<table style="width: 400px;text-align: center;">
    <tbody>
    <tr>
        <td>用户名</td>
        <td><input type="text" id="userAccount" name="userAccount"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="password" id="userPassword" name="userPassword"></td>
    </tr>
    <tr>
        <td><a href="javascript:;" id="loginAction">登录</a></td>
        <td><a href="/sys/user/reg" id="regAction">注册</a></td>
    </tr>
    </tbody>
</table>
    <@c.token/>
    </form>

</@common.html>