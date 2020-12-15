package com.icis.service;

import com.icis.pojo.UserInfo;

import java.util.List;

//用户service接口
public interface UserInfoService {
    /**
     *
     * @return
     * Select:
     * 方法：List<T> select(T record);
     * 说明：根据实体中的属性值进行查询，查询条件使用等号
     *
     * 方法：T selectByPrimaryKey(Object key);
     * 说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * 方法：List<T> selectAll();
     * 说明：查询全部结果，select(null)方法能达到同样的效果
     *
     * 方法：T selectOne(T record);
     * 说明：根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * 方法：int selectCount(T record);
     * 说明：根据实体中的属性查询总数，查询条件使用等号
     */
    //1.查询所有用户数据
    public List<UserInfo> findAll();
    //根据条件查询
    public List<UserInfo> findByUserInfo(UserInfo userInfo);
    //模糊查询
    public List<UserInfo> findByUserLike(UserInfo userInfo);
    //查询一个用户
    public UserInfo findOneUser(UserInfo userInfo);
    //根据属性查询总数
    public int getCount(UserInfo userInfo);

    /**
     * 保存用户方法
     * 方法：int insert(T record);
     * 说明：保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * 方法：int insertSelective(T record);
     * 说明：保存一个实体，null的属性不会保存，会使用数据库默认值
     */
    public void addUser(UserInfo userInfo);

    //有选择的保存用户
    void addUserSelective(UserInfo userInfo);

    /**
     *
     * @param userInfo
     * update：
     * 方法：int updateByPrimaryKey(T record);
     * 说明：根据主键更新实体全部字段，null值会被更新
     *
     * 方法：int updateByPrimaryKeySelective(T record);
     * 说明：根据主键更新属性不为null的值
     *
     * 方法：int updateByExample(@Param("record") T record, @Param("example") Object example);
     * 说明：根据Example条件更新实体record包含的全部属性，null值会被更新
     *
     * 方法：int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);
     * 说明：根据Example条件更新实体record包含的不是null的属性值
     */
    //根据主键更新实体全部字段，null值会被更新
    void updateUser(UserInfo userInfo);
    //有选择性更新 根据主键更新属性不为null的值
    public void updateUserSelective(UserInfo userInfo);

    //根据名字更新
    void updateUserByName(UserInfo userInfo);


    /**
     * 方法：int delete(T record);
     * 说明：根据实体属性作为条件进行删除，查询条件使用等号
     *
     * 方法：int deleteByPrimaryKey(Object key);
     * 说明：根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * 方法：int deleteByExample(Object example);
     * 说明：根据Example条件删除数据（模糊条件）
     */
    void delUserByPrimaryKey(UserInfo userInfo);

    //根据条件删除数据
    void delUserByName(UserInfo userInfo);
}