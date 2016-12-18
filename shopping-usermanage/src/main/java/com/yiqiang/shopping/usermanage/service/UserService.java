package com.yiqiang.shopping.usermanage.service;

import com.yiqiang.shopping.usermanage.bean.EasyUIResult;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/18 0018 23:42
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public interface UserService {
    /**
     * get user info by page
     * @param page
     * @param rows
     * @return
     */
    EasyUIResult queryUserList(Integer page, Integer rows);
}
