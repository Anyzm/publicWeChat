package com.anyzm.wechat.dao;

import org.springframework.stereotype.Repository;

/**
 * create by Anyzm on 2018/6/13
 */
@Repository
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    String findAllUser();

}
