package com.mingdao.sys.service;

import com.mingdao.sys.entity.SysPost;
import org.guiceside.persistence.TransactionType;
import org.guiceside.persistence.Transactional;
import org.guiceside.persistence.hibernate.dao.hquery.HQuery;

/**
 * Created by jay on 2015-03-03.
 */
public class SysPostService extends HQuery {

    @Transactional(type = TransactionType.READ_ONLY)
    public SysPost getById(Long id) {
        return $(id).get(SysPost.class);
    }


    @Transactional(type = TransactionType.READ_WRITE)
    public void save(SysPost sysPost) {
        $(sysPost).save();
    }

}
