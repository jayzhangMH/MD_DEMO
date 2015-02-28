package com.mingdao.common.action;

import com.google.inject.Inject;
import com.mingdao.common.UserInfo;
import com.mingdao.common.UserSession;
import com.mingdao.sys.entity.SysUser;
import com.mingdao.sys.service.SysUserService;
import org.guiceside.commons.lang.StringUtils;
import org.guiceside.web.action.BaseAction;
import org.guiceside.web.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhenjiaWang
 * Date: 12-7-12
 * Time: 下午9:49
 * To change this template use File | Settings | File Templates.
 */
@Action(name = "authorize", namespace = "/common")
public class AuthorizeAction extends BaseAction {

    @Inject
    private SysUserService sysUserService;

    @ReqGet
    private String userAccount;

    @ReqGet
    private String userPassword;


    @ReqSet
    private String errorMessage;


    @Override
    @PageFlow(result = {@Result(name = "success", path = "/view/login.ftl", type = Dispatcher.FreeMarker)})
    public String execute() throws Exception {
        return "success";
    }


    @PageFlow(result = {@Result(name = "success", path = "/sys/user", type = Dispatcher.Redirect),
            @Result(name = "error", path = "/view/error.ftl", type = Dispatcher.FreeMarker)})
    public String login() throws Exception {
        if (StringUtils.isNotBlank(userAccount) && StringUtils.isNotBlank(userPassword)) {
            Integer count = this.sysUserService.getCountByPwd(userAccount, userPassword);
            if (count == null) {
                count = 0;
            }
            if (count.intValue() == 1) {
                UserInfo userInfo = UserSession.create(getHttpServletRequest());
                userInfo.setLoggedIn(true);
                SysUser sysUser = this.sysUserService.getUserByPwd(userAccount, userPassword);
                if (sysUser != null) {
                    if(sysUser.getLoginCount()==null){
                        sysUser.setLoginCount(1);
                    }else{
                        sysUser.setLoginCount(sysUser.getLoginCount()+1);
                    }
                    this.sysUserService.save(sysUser);
                    userInfo.setSysUser(sysUser);
                }
                return "success";
            } else {
                errorMessage = "用户不存在";
                return "error";
            }
        } else {
            errorMessage = "请输入用户名/密码";
            return "error";
        }
    }

    @PageFlow(result = {@Result(name = "success", path = "/sys/user", type = Dispatcher.Redirect)})
    public String logout() throws Exception {
        UserInfo userInfo = UserSession.getUserInfo(getHttpServletRequest());
        if (userInfo != null) {
            UserSession.invalidate(getHttpServletRequest());
        }
        return "success";
    }


}
