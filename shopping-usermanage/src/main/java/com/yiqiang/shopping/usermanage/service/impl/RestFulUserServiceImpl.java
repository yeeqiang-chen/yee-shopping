package com.yiqiang.shopping.usermanage.service.impl;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiqiang.shopping.usermanage.bean.EasyUIResult;
import com.yiqiang.shopping.usermanage.mapper.RestFulUserMapper;
import com.yiqiang.shopping.usermanage.pojo.User;
import com.yiqiang.shopping.usermanage.service.RestFulUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/15 0015 1:45
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Service
public class RestFulUserServiceImpl implements RestFulUserService{

    @Autowired
    private RestFulUserMapper restFulUserMapper;

    public EasyUIResult queryUserList(Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);

        // 设置查询条件
        Example example = new Example(User.class);
        example.setOrderByClause("created DESC"); // 设置排序条件
        List<User> users = this.restFulUserMapper.selectByExample(example);

        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public User queryUserById(Long id) {
        return this.restFulUserMapper.selectByPrimaryKey(id);
    }

    /*public void saveUser(User user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        this.newUserMapper.insertSelective(user);
    }


    public void updateUser(User user) {
        this.newUserMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUserById(Long id) {
        this.newUserMapper.deleteByPrimaryKey(id);
    }
    */
    @Override
    public Boolean saveUser(User user) {
        return this.restFulUserMapper.insert(user) == 1;
    }

    @Override
    public Boolean updateUser(User user) {
        return this.restFulUserMapper.updateByPrimaryKeySelective(user) == 1;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return this.restFulUserMapper.deleteByPrimaryKey(id) == 1;
    }
}