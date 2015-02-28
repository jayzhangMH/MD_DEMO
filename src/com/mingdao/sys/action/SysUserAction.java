package com.mingdao.sys.action;

import com.google.inject.Inject;
import com.mingdao.common.UserInfo;
import com.mingdao.common.UserSession;
import com.mingdao.sys.entity.SysUser;
import com.mingdao.sys.service.SysUserService;
import com.mingdao.web.support.ActionSupport;
import org.guiceside.commons.Page;
import org.guiceside.commons.lang.DateFormatUtil;
import org.guiceside.commons.lang.StringUtils;
import org.guiceside.persistence.hibernate.dao.hquery.Selector;
import org.guiceside.web.action.BaseAction;
import org.guiceside.web.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhenjiaWang
 * Date: 12-7-12
 * Time: 下午9:49
 * To change this template use File | Settings | File Templates.
 */
@Action(name = "user", namespace = "/sys")
public class SysUserAction extends ActionSupport<SysUser> {

    @Inject
    private SysUserService sysUserService;

    @ReqGet
    @ModelDriver
    @ReqSet
    private SysUser sysUser;

    @ReqGet
    private Long id;

    @ReqSet
    private List<SysUser> userList;

    @Override
    @PageFlow(result = {@Result(name = "success", path = "/view/index.ftl", type = Dispatcher.FreeMarker)})
    public String execute() throws Exception {
        UserInfo userInfo = UserSession.getUserInfo(getHttpServletRequest());
        if (userInfo != null) {
            return "success";
        }
        return null;
    }




    @PageFlow(result = {@Result(name = "success", path = "/view/reg.ftl", type = Dispatcher.FreeMarker)})
    public String reg() throws Exception {
        if(id!=null){
            sysUser=this.sysUserService.getById(id);
        }
        return "success";
    }


    @Token
    @PageFlow(result = {@Result(name = "success", path = "/sys/user", type = Dispatcher.Redirect)})
    public String save() throws Exception {
        if(sysUser!=null){
            Date currentDate= DateFormatUtil.getCurrentDate(true);
            sysUser.setLoginCount(0);
            sysUser.setUseYn("Y");
            sysUser.setCreatedBy("reg");
            sysUser.setCreated(currentDate);
            this.sysUserService.save(sysUser);
            return "success";
        }
        return null;
    }

    @PageFlow(result = {@Result(name = "success", path = "/sys/user", type = Dispatcher.Redirect)})
    public String test() throws Exception {
        UserInfo userInfo = UserSession.getUserInfo(getHttpServletRequest());
        if (userInfo != null&&id!=null) {
            this.sysUserService.test(id);
            sysUser=this.sysUserService.getById(id);
            userInfo.setSysUser(sysUser);
            return "success";
        }
        return null;
    }

    @PageFlow(result = {@Result(name = "success", path = "/sys/user/reg", type = Dispatcher.Redirect)})
    public String delete() throws Exception {
        if(id!=null){
            sysUserService.deleteById(id);
            return "success";
        }
        return null;
    }

    @PageFlow(result = {@Result(name = "success", path = "/view/list.ftl", type = Dispatcher.FreeMarker)})
    public String list() throws Exception {
        UserInfo userInfo = UserSession.getUserInfo(getHttpServletRequest());
        if (userInfo != null) {
            List<Selector> selectorList=new ArrayList<Selector>();
            //selectorList.add(SelectorUtils.$like("userName","333"));
            if(rows==null){
                rows=3;
            }
            pageObj=this.sysUserService.getPageList(getStart(),rows,selectorList);
            if(pageObj!=null){
                userList=pageObj.getResultList();
                return "success";
            }
        }
        return null;
    }
}
