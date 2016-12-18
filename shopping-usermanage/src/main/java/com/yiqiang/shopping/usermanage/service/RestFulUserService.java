package com.yiqiang.shopping.usermanage.service;

import com.yiqiang.shopping.usermanage.bean.EasyUIResult;
import com.yiqiang.shopping.usermanage.pojo.User;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/18 0018 23:42
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public interface RestFulUserService {

    /**
     * get user info by page
     * @param page
     * @param rows
     * @return
     */
    EasyUIResult queryUserList(Integer page, Integer rows);

    /**
     * query user info by primary key
     * @param id
     * @return
     */
    User queryUserById(Long id);

    /**
     * save user info
     * @param user
     * @return
     */
    Boolean saveUser(User user);

    /**
     * update user info
     * @param user
     * @return
     */
    Boolean updateUser(User user);

    /**
     * delete user by primary key
     * @param id
     * @return
     */
    Boolean deleteUser(Long id);

}
