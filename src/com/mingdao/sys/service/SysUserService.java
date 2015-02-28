package com.mingdao.sys.service;

import com.google.inject.Singleton;
import com.mingdao.sys.entity.SysUser;
import org.guiceside.commons.Page;
import org.guiceside.persistence.TransactionType;
import org.guiceside.persistence.Transactional;
import org.guiceside.persistence.hibernate.dao.hquery.HQuery;
import org.guiceside.persistence.hibernate.dao.hquery.Selector;

import java.util.List;

/**
 * @author zhenjiaWang
 * @version 1.0 2012-05
 * @since JDK1.5
 */
@Singleton
public class SysUserService extends HQuery {

    /**
     * @param id
     * @return 根据Id获取代码
     */
    @Transactional(type = TransactionType.READ_ONLY)
    public SysUser getById(Long id) {
        return $(id).get(SysUser.class);
    }


    @Transactional(type = TransactionType.READ_ONLY)
    public Integer getCountByPwd(String userAccount,String userPassword) {
        return $($count("id"), $eq("userAccount", userAccount),$eq("userPassword",userPassword)).value(SysUser.class, Integer.class);
    }

    @Transactional(type = TransactionType.READ_ONLY)
    public SysUser getUserByPwd(String userAccount,String userPassword) {
        return $($eq("userAccount", userAccount),$eq("userPassword",userPassword)).get(SysUser.class);
    }

    @Transactional(type = TransactionType.READ_ONLY)
    public List<String> getFirstByCompanyId(Long companyId) {
        return $($eq("companyId.id", companyId), $distinct("userFirst"), $eq("useYn", "Y")).list(SysUser.class, String.class);
    }


    @Transactional(type = TransactionType.READ_ONLY)
    public Page<SysUser> getPageList(int start,
                                     int limit, List<Selector> selectorList) {
        return $(selectorList).page(SysUser.class, start, limit);
    }

    @Transactional(type = TransactionType.READ_ONLY)
    public List<SysUser> getList(List<Selector> selectorList) {
        return $(selectorList).list(SysUser.class);
    }


    /**
     * 保存对象
     */
    @Transactional(type = TransactionType.READ_WRITE)
    public void save(SysUser sysUser) {
        $(sysUser).save();
    }

    @Transactional(type = TransactionType.READ_WRITE)
    public void save(List<SysUser> userList) {
        $(userList).save();
    }

    /**
     * 删除对象
     */
    @Transactional(type = TransactionType.READ_WRITE)
    public void delete(SysUser sysUser) {
        $(sysUser).delete();
    }

    @Transactional(type = TransactionType.READ_WRITE)
    public void delete(List<SysUser> userList) {
        $(userList).delete();
    }

    /**
     * 根据id 删除对象
     *
     * @param id
     */
    @Transactional(type = TransactionType.READ_WRITE)
    public void deleteById(Long id) {
        $(id).delete(SysUser.class);
    }

    @Transactional(type = TransactionType.READ_WRITE)
    public void test(Long id) {
        $(id).attr(SysUser.class,"userName","aaaa");
    }

}
