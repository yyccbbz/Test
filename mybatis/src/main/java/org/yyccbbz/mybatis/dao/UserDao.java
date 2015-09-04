package org.yyccbbz.mybatis.dao;

import java.util.List;

import org.yyccbbz.mybatis.pojo.User;

public interface UserDao {

    /**
     * 根据id 查询用户信息
     * 
     * @param id
     * @return
     */
    public User findUserById(Long id);

    /**
     * 查询所有用户信息
     * 
     * @return
     */
    public List<User> findUserList();

    /**
     * 添加用户
     * 
     * @param user
     */
    public void saveUser(User user);

    /**
     * 根据id 删除用户
     * 
     * @param id
     */
    public void deleteUserById(Long id);

    /**
     * 更新用户
     * 
     * @param user
     */
    public void updateUser(User user);

}
