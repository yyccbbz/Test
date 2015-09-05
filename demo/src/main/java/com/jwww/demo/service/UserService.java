package com.jwww.demo.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.jwww.demo.dao.UserEntityMapper;
import com.jwww.demo.domin.UserEntity;
import com.jwww.demo.dto.UserDto;
import com.jwww.support.cache.config.ActionType;
import com.jwww.support.cache.config.CacheAction;
import com.jwww.support.cache.config.CacheKey;
import com.jwww.support.helper.PageHelper;
import com.jwww.support.mybatis.beans.PageObject;
import com.jwww.support.mybatis.beans.PageRequest;
import com.jwww.support.mybatis.query.EntityQuery;
import com.jwww.support.mybatis.query.NativeQuery;


@Named
public class UserService {

	@Inject
	private UserEntityMapper mappder;
	
	/**
	 * 基本操作
	 */
	public void baseTest(){
		//已经默认实现了常用的方法，详见：IGenericEntityDao
		UserEntity entity = mappder.getById(1);
		System.out.println(entity);
		
		mappder.getListByIds(Arrays.asList("1","2"));
		
		mappder.insert(entity);
		
        mappder.deleteById(1);
		
		mappder.deleteByIds(Arrays.asList("1","2"));
		
		//查询所有status = 1的用户
		mappder.findLists(new EntityQuery().addParam("status", 1));
		
		//更新指定字段
		mappder.update(new EntityQuery(1).addParam("username", "zhang3").addParam("lastLoginIp", "127.0.0.1").getParams());
		//按实体更新，仅更新字段username,mobile
		mappder.update(new EntityQuery(1).addParams(entity, true, "username,mobile").getParams());
		//按实体更新，更新除了regIp,regTime以外的字段
		mappder.update(new EntityQuery(1).addParams(entity, false, "regIp,regTime").getParams());
		//自定义主键(默认主键为id，可以通过构造方法指定值)
		mappder.update(new EntityQuery().addParam("id", 1).addParams(entity, false, "regIp,regTime").getParams());
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param queryParams
	 * @return
	 */
	public PageObject<UserDto>  pageTest(PageRequest page,Map<String, String> queryParams){
		//查询逻辑需写在对应的mapper.xml的“query_where”块内
		EntityQuery params = PageHelper.generateQueryParamsMap(page, queryParams, UserEntity.class);
		// 这里可以对查询条件进行处理
		return PageHelper.pageQuery(UserEntityMapper.class, UserDto.class, params);
	}
	
	
	/**
	 * 数据库原生参数查询
	 */
	public void nativeQueryTest(){
		//NativeQuery对应的都是数据库表的column名
		NativeQuery query = new NativeQuery().where("reg_time<? and id IN(?)", new Date(),Arrays.asList(1,2,3)).orderBy("id asc");
		mappder.findListByQuery(query);
		//指定查询字段
		query = new NativeQuery().fields("id,username,reg_time").where("reg_time<? and id IN(?)", new Date(),Arrays.asList(1,2,3));
		mappder.findListByQuery(query);
		
		//统计查询（支持：AVG,COUNT,MIN,MAX,SUM）
		BigDecimal count = mappder.statisticsQuery(new NativeQuery().where("status=1").count("id"));
		BigDecimal total = mappder.statisticsQuery(new NativeQuery().where("status = ?",1).sum("score"));
		
		//还可以按查询条件删除、更新
		mappder.deleteByQuery(new NativeQuery().where("status=?", 0));
		mappder.updateByQuery(new NativeQuery().where("status=?", 0));
	}
	
	/**
	 * 查询（加入缓存）
	 * @param id
	 * @return
	 */
	@CacheAction(group = "User",key = "id:{0}",actionType = ActionType.SELECT)
	public UserEntity get(@CacheKey int id){
		return mappder.getById(1);
	}
	
	@CacheAction(group = "User",key = "id:{0}",actionType = ActionType.DELETE)
	public void delete(@CacheKey int id){
		mappder.deleteById(id);
	}
}
