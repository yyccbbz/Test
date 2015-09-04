package org.yyccbbz.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.yyccbbz.mybatis.dao.UserDao;
import org.yyccbbz.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User findUserById(Long id) {
        User user =sqlSession.selectOne("user.findUserById", id);
        return user;
    }

    @Override
    public List<User> findUserList() {
        return this.sqlSession.selectList("user.findUserList");
    }

    @Override
    public void saveUser(User user) {
        this.sqlSession.insert("user.saveUser", user);
    }

    @Override
    public void deleteUserById(Long id) {
        this.sqlSession.delete("user.deleteUserById", id);
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("user.updateUser", user);
    }

}
