package com.yiqiang.shopping.usermanage.mapper;

import com.yiqiang.shopping.usermanage.pojo.User;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/15 0015 1:47
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public interface UserMapper {

    /**
     * 查询用户信息
     *
     * @return
     */
    List<User> queryUserList();

}