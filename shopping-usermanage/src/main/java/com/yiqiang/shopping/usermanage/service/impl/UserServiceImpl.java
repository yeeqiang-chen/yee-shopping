package com.yiqiang.shopping.usermanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiqiang.shopping.usermanage.bean.EasyUIResult;
import com.yiqiang.shopping.usermanage.mapper.UserMapper;
import com.yiqiang.shopping.usermanage.pojo.User;
import com.yiqiang.shopping.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/15 0015 1:44
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public EasyUIResult queryUserList(Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<User> users = this.userMapper.queryUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

}