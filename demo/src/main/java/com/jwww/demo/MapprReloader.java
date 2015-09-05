package com.jwww.demo;

import java.io.IOException;

import com.jwww.support.mybatis.MybatisMapperFormater;

public class MapprReloader {

	public static void main(String[] args) throws IOException {
		String mapperDir = "E:/java/workspace/vakinge@git/demo/src/main/resources/com/jwww/demo/dao";//待格式化的mapping文件夹路径
		String outputDir = mapperDir;//格式化完成文件夹路径
		
		MybatisMapperFormater.doFormat(mapperDir, outputDir); 
	}
}
