package com.icis.mapper;

import com.icis.pojo.UserInfo;
import tk.mybatis.mapper.common.Mapper;

//用户接口，当前业务接口继承自通用mapper提供的接口
public interface UserInfoMapper extends Mapper<UserInfo>{
}