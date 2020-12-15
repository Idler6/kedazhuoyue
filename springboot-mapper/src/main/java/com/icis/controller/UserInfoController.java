package com.icis.controller;

import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//用户控制器 post form+requestbody form表单的数据封装过来   get 路径的数据
@RestController //Controller+ResponseBody
public class UserInfoController {
    //注入service
    @Autowired
    private UserInfoService userInfoService;
    //查询所有用户数据
    @GetMapping("/findAll")
    public List<UserInfo> findAll(){
        //调用service查询所有用户数据
        List<UserInfo> allUser = this.userInfoService.findAll();
        return allUser;
    }
    //根据用户实体查询用户  等值查询
    @GetMapping("/findByUserInfo")
    public List<UserInfo> findByUserInfo(UserInfo userInfo){
        //调用service查询所有用户数据
        List<UserInfo> allUser = this.userInfoService.findByUserInfo(userInfo);
        return allUser;
    }
    //根据名字模糊查询用户
    @GetMapping("/findUserByName")
    public List<UserInfo> findUserByName(UserInfo userInfo){
        //调用service查询所有用户数据
        List<UserInfo> allUser = this.userInfoService.findByUserLike(userInfo);
        return allUser;
    }
    //查询一个用户
    @GetMapping("/findOne")
    public UserInfo findOne(UserInfo userInfo){
        UserInfo oneUser = this.userInfoService.findOneUser(userInfo);
        return oneUser;
    }
    //根据属性查询总数
    @GetMapping("/getCount")
    public int getCount(UserInfo userInfo){
        int count = userInfoService.getCount(userInfo);
        return count;
    }
    //添加用户数据
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        //调用service保存数据
        this.userInfoService.addUser(userInfo);
        return "ok";
    }
    //添加用户数据 有选择性的添加 null值不添加
    @PostMapping("/addUserSelective")
    public String addUserSelective(@RequestBody UserInfo userInfo){
        //调用service保存数据
        this.userInfoService.addUserSelective(userInfo);
        return "ok";
    }
    //更新用户数据
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody UserInfo userInfo){
        userInfoService.updateUser(userInfo);
        return "ok";
    }
    //有选择性更新
    @PostMapping("/updateUserSelective")
    public String updateUserSelective(@RequestBody UserInfo userInfo){
        userInfoService.updateUserSelective(userInfo);
        return "ok";
    }
    //按照条件更新 更新名字有猪字的  名字也会变为一个  猪
    @PostMapping("/updateUserByName")
    public String updateUserByName(@RequestBody UserInfo userInfo){
        userInfoService.updateUserByName(userInfo);
        return "updates ok";
    }
    //删除数据 根据主键删除
    @GetMapping("/delUserByPrimaryKey")
    public String delUserByPrimaryKey(UserInfo userInfo){
        userInfoService.delUserByPrimaryKey(userInfo);
        return "del ok";
    }
    //根据条件删除数据
    @GetMapping("/delUserByName")
    public String delUserByName(UserInfo userInfo){
        userInfoService.delUserByName(userInfo);
        return "dels ok";
    }
}
