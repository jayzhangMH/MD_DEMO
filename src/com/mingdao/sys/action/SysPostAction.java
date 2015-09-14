package com.mingdao.sys.action;

import com.google.inject.Inject;
import com.mingdao.sys.entity.SysPost;
import com.mingdao.sys.service.SysPostService;
import com.mingdao.web.support.ActionSupport;
import org.guiceside.web.annotation.Action;
import org.guiceside.web.annotation.ModelDriver;
import org.guiceside.web.annotation.ReqGet;
import org.guiceside.web.annotation.ReqSet;

import java.util.List;

/**
 * Created by jay on 2015-03-03.
 */
@Action(name = "post", namespace = "/sys")
public class SysPostAction extends ActionSupport<SysPost> {

    @Inject
    private SysPostService sysPostService;

    @ReqGet
    @ModelDriver
    @ReqSet
    private SysPost sysPost;

    @ReqGet
    private Long id;

    @ReqSet
    private List<SysPost> postList;

    @Override
    public String execute() throws Exception {
        return null;
    }
}
