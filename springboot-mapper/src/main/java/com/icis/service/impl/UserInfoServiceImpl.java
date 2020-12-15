package com.icis.service.impl;

import com.icis.mapper.UserInfoMapper;
import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
//用户接口实现类
@Service
public class UserInfoServiceImpl implements UserInfoService{
    //注入mapper
    @Autowired
    private UserInfoMapper userInfoMapper;
    //查询所有用户方法
    @Override
    public List<UserInfo> findAll() {
        //查询所有用户数据
        List<UserInfo> userInfoList = this.userInfoMapper.selectAll();
        return userInfoList;
    }
    //根据用户实体查询用户数据
    @Override
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }
    //模糊查询
    @Override
    public List<UserInfo> findByUserLike(UserInfo userInfo) {
        //构建一个Example条件查询对象
        Example example=new Example(UserInfo.class);
        //构建条件 集合
        Example.Criteria criteria = example.createCriteria();
        //条件 具体条件
        criteria.andLike("name","%"+userInfo.getName()+"%");
        List<UserInfo> infoList = userInfoMapper.selectByExample(example);
        return infoList;
    }

    @Override
    public UserInfo findOneUser(UserInfo userInfo) {
        UserInfo one = userInfoMapper.selectOne(userInfo);
        return one;
    }

    @Override
    public int getCount(UserInfo userInfo) {
        int count = userInfoMapper.selectCount(userInfo);
        return count;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        //调用mapper添加用户数据 保存一个实体，null的属性也会保存，不会使用数据库默认值
        this.userInfoMapper.insert(userInfo);
    }

    @Override
    public void addUserSelective(UserInfo userInfo) {
        this.userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        //执行更新  根据主键更新  如果实体类没有主键 不执行任何操作
        this.userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public void updateUserSelective(UserInfo userInfo) {
        //根据主键更新属性不为null的值  如果是null值 不做处理
        this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    //根据名字更新
    @Override
    public void updateUserByName(UserInfo userInfo) {
        Example example=new Example(UserInfo.class);
        //设置条件
        example.createCriteria().andLike("name","%"+userInfo.getName()+"%");
        //根据条件更新数据
        this.userInfoMapper.updateByExample(userInfo,example);
    }

    @Override
    public void delUserByPrimaryKey(UserInfo userInfo) {
        this.userInfoMapper.deleteByPrimaryKey(userInfo);
    }

    @Override
    public void delUserByName(UserInfo userInfo) {
        //根据条件删除  条件是等于   模糊查询是byExample
        this.userInfoMapper.delete(userInfo);
    }
}
