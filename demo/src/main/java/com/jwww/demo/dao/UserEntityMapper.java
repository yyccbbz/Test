package com.jwww.demo.dao;

import org.springframework.stereotype.Repository;

import com.jwww.demo.domin.UserEntity;
import com.jwww.support.mybatis.IGenericEntityDao;

@Repository
public interface UserEntityMapper extends IGenericEntityDao<UserEntity, Integer>{
	
}