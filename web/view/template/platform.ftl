<#import "/view/template/common.ftl" as common>
<#import "/view/common/core.ftl" as c>
<#macro desktop title>
    <@common.html title=title>
        <#if Session["userSession"]?exists>
            <#assign userInfo=Session["userSession"]?if_exists>
            <#if userInfo?exists>
            <div class="layout" id="platformLayout" pay="${userInfo["pay"]?if_exists}" diffDay="${userInfo["diffDay"]?if_exists}">
                <!--left begin-->
                <div class="layout_left" dir="platform">
                    <div class="oa_logo">
                        <a class="block mart20 marl30" href="javascript:;">
                            <p class="logo_txt"><img src="/img/logo_1.png"></p>
                            <p class="logo_img"><img src="/img/logo_2.png"></p>
                            <#--<p class="p-top10 color-3">${userInfo.company.companyName?if_exists}</p>-->
                        </a>
                    </div>
                    <div class="nav_tools">
                        <ul class="tool_nav font14">
                            <li class="current">
                                <a href="javascript:;" dir="platform"><span class="circle_ico font18"><i class="icon-laptop-chromebook"></i></span><em>工作台</em></a>
                                <span class="title_tip"><i class="toggle_arrow"></i>工作台</span>
                            </li>
                        </ul>
                        <ul class="tool_nav nav_list font14">
                            <li>
                                <a href="javascript:;" dir="req"><span class="circle_ico font18 noborder nobg"><i class="icon-upload2"></i></span><em>申请</em></a>
                                <span class="title_tip"><i class="toggle_arrow"></i>申请</span>
                            </li>
                            <li>
                                <a href="javascript:;" dir="task"><span class="circle_ico font18 noborder nobg"><i class="icon-clipboard"></i></span><em>审批</em></a>
                                <span class="title_tip"><i class="toggle_arrow"></i>审批</span>
                            </li>
                            <li>
                                <a href="javascript:;" dir="manage"><span class="circle_ico font18 noborder nobg"><i class="icon-exit marl5"></i></span><em>经办</em></a>
                                <span class="title_tip"><i class="toggle_arrow"></i>经办</span>
                            </li>
                            <li>
                                <a href="javascript:;" dir="share"><span class="circle_ico font18 noborder nobg"><i class="icon-eye-plus"></i></span><em>传阅</em></a>
                                <span class="title_tip"><i class="toggle_arrow"></i>传阅</span>
                            </li>
                        </ul>
                    </div>
                    <div class="left_bottom">
                        <ul class="tool_nav font14">
                            <li>
                                <a href="javascript:;" dir="create">
                                    <span class="circle_ico font16"><i class="icon-iadd"></i></span>
                                    <em>提交申请</em>
                                </a>
                                <span class="title_tip"><i class="toggle_arrow"></i>提交</span>
                            </li>
                            <li>
                                <a href="javascript:;" dir="search">
                                    <span class="circle_ico font16"><i class="icon-iser"></i></span>
                                    <em>智能搜索</em>
                                </a>
                                <span class="title_tip"><i class="toggle_arrow"></i>搜索</span>
                            </li>
                            <#if userInfo.admin>
                                <li>
                                    <a href="javascript:;" dir="admin">
                                        <span class="circle_ico font16"><i class="icon-iset"></i></span>
                                        <em>管理设置</em>
                                    </a>
                                    <span class="title_tip"><i class="toggle_arrow"></i>管理</span>
                                </li>
                            </#if>
                        </ul>
                        <div class="user_info font14 clearfix">
                            <span class="UserImg floatleft marr10 ie-css3"><img src="${(userInfo.user.avatar)?if_exists}"></span>
                            <p><em>${(userInfo.user.userName)?if_exists}</em></p>
                            <p class="font12"><a href="javascript:;" class="logoutBtn">注销</a></p>
                            <a href="javascript:;" class="font20 color-6 logoutBtn"><i class="icon-input"></i></a>
                            <span class="title_tip"><i class="toggle_arrow"></i>注销</span>
                        </div>
                    </div>
                </div>
                <!--left over-->
                <!--right begin-->
                <div class="layout_right" id="contentMain">
                    <#nested />
                    <#include "/view/template/screen/apply.html">
                    <#if userInfo.admin>
                        <#include "/view/template/screen/admin.html">
                    </#if>
                </div>
                <#include "/view/template/screen/contact.html">
                <#include "/view/template/screen/att.html">
                <#include "/view/template/screen/attView.html">
                <!--right over-->

                <!--右侧滑出的表单详情 附件begin-->

                <!--右侧滑出的表单详情 附件over-->
                <!--附件begin-->

                <!--附件over-->
            </div>
            </#if>
        </#if>
    </@common.html>
</#macro>