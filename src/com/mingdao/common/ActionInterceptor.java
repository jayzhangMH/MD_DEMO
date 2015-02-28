package com.mingdao.common;


import com.mingdao.api.entity.AppConfig;
import com.mingdao.api.utils.AppConfigUtil;
import com.mingdao.util.HttpRequestDeviceUtils;
import net.sf.json.JSONObject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.guiceside.commons.collection.RequestData;
import org.guiceside.commons.lang.StringUtils;
import org.guiceside.web.action.ActionContext;
import org.guiceside.web.dispatcher.mapper.ActionMapping;
import org.guiceside.web.interceptor.TokenValidatorException;
import org.guiceside.web.view.freemarker.FreeMarkerResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author zhenjia <a href='mailto:zhenjiaWang@gmail.com'>email</a>
 * @version 1.0 2008-11-6
 * @since JDK1.5
 */
public class ActionInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;

        Object[] args = invocation.getArguments();

        ActionContext actionContext = (ActionContext) args[0];
        ActionMapping actionMapping = (ActionMapping) actionContext
                .getActionContext().get(ActionContext.ACTIONMAPPING);
        HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext.getActionContext().get(ActionContext.HTTPSERVLETREQUEST);
        HttpServletResponse httpServletResponse = (HttpServletResponse) actionContext.getActionContext().get(ActionContext.HTTPSERVLETRESPONSE);
        if(!actionMapping.isError()){
            //我们过滤掉/common/authorize /common/authorize/login  /sys/user/reg /sys/user/save 这几个方法不需要验证session是否存在
            //因为这些动作肯定无SESSION的
            if (actionMapping.getNamespace().equals("/common")) {
                if (actionMapping.getName().equals("authorize")) {
                    if (actionMapping.getMethodName().equals("execute")||actionMapping.getMethodName().equals("login")) {
                        result = invocation.proceed();
                        return result;
                    }
                }
            }
            if (actionMapping.getNamespace().equals("/sys")) {
                if (actionMapping.getName().equals("user")) {
                    if (actionMapping.getMethodName().equals("reg")||actionMapping.getMethodName().equals("save")) {
                        result = invocation.proceed();
                        return result;
                    }
                }
            }
            //其他命名空间 我们需要判断是否有session 即是否登录
            UserInfo userInfo = null;
            try {
                userInfo = UserSession.getUserInfo(httpServletRequest);
                if(userInfo!=null){
                    //如果存在session 则通过action代理机制执行当前方法
                    result = invocation.proceed();
                }
            } catch (UserSessionException e) {
                //如果没session 则跳转到登录页面
                AppConfig appConfig = AppConfigUtil.create();
                if (appConfig != null) {
                    httpServletRequest.setAttribute("authorizeUrl", appConfig.getRedirectUri());
                    httpServletRequest.getRequestDispatcher("/view/common/authorizeGo.jsp").forward(httpServletRequest,
                            httpServletResponse);
                } else {
                    httpServletResponse.sendRedirect("/view/common/urlGoLogin.html");
                }
                return null;
            } catch (TokenValidatorException e) {
                //如果token验证失败则代表 重复提交或者非法提交
                String requestedWith=httpServletRequest.getHeader("x-requested-with");
                if(StringUtils.isBlank(requestedWith)){
                    //正常提交
                    httpServletRequest.setAttribute("errorMsg","您的请求已处理，请勿重复操作");
                    httpServletRequest.setAttribute("errorImg","/img/500.png");
                    boolean mobileDevice = HttpRequestDeviceUtils.isMobileDevice(httpServletRequest);
                    if (mobileDevice) {
                        go("/view/common/errorH5.ftl",actionContext);
                    }else{
                        go("/view/common/error.ftl",actionContext);
                    }
                    return null;
                }else if(requestedWith.equals("XMLHttpRequest")){
                    //ajax提交 我们统一返回json
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("result","-1");
                    jsonObject.put("errorMessage","请勿重复提交");
                    writeByAction(httpServletResponse, jsonObject.toString(),"text/json;charset=UTF-8");
                    return  null;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //url资源路径不存在
            httpServletRequest.setAttribute("errorMsg","您访问的路径不存在");
            httpServletRequest.setAttribute("errorImg","/img/404.png");
            boolean mobileDevice = HttpRequestDeviceUtils.isMobileDevice(httpServletRequest);
            if (mobileDevice) {
                go("/view/common/errorH5.ftl",actionContext);
            }else{
                go("/view/common/error.ftl",actionContext);
            }
            return  null;
        }
        return result;
    }

    private void go(String path,ActionContext actionContext){
        try{
            FreeMarkerResult freeMarkerResult = new FreeMarkerResult();
            freeMarkerResult.doExecute(path, actionContext);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeByAction(HttpServletResponse httpServletResponse,String text, String contentType) {
        httpServletResponse.setContentType(contentType);
        httpServletResponse.setHeader("Pragma", "no-chache");
        httpServletResponse.setHeader("Chache-Control", "no-chache");
        httpServletResponse.setDateHeader("Expires", 0);

        PrintWriter pw = null;
        try {
            pw = httpServletResponse.getWriter();
            pw.write(text);
            pw.close();
        } catch (IOException e) {
        }
    }
}