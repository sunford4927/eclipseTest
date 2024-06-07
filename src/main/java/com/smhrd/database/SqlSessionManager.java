package com.smhrd.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	// 데이터 베이스와의 연결과 sql 실행에 대한 기능을 가지고 있는 sqlSession 생성해주는 공장
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		// DB관련 설정 정보 가지고 오는 작업 -> myBatis-config.xml
		String resource = "com/smhrd/database/mybatis-config.xml";
		
		// 위 경로에 있는 파일 읽어오기
		
		try {
			Reader reader= Resources.getResourceAsReader(resource);
			// 읽은 정보를 토대로 DB 관련 기능을 수행할 수 있는 Factory 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 생성된 SqlSessionFactory
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
