package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class MavenMemberDAO {
	// DAO 객체가 생성이 되면
	// 1. SessionFactory 가져오기
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	// 2. Session 객체 생성 -> DB 관련된 작업 수행해주는 단위 (INSERT, SELECT ..)
	// 1. 회원가입 메서드 
	public int join(MavenMember member) {
		// 1. Session 생성 (insert)
		//true -> auto commit
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		// insert into mavenmember values (?,?,?)
		// 성공시 1 실패시 0 반환
		int res = sqlSession.insert("MemberMapper.join", member);
		
		// session 객체 close (자원 회수)
		sqlSession.close();
		
		return res;
	}
	
	public MavenMember login(MavenMember member)
	{
		System.out.println(member);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		MavenMember result = sqlSession.selectOne("MemberMapper.login", member);
		System.out.println(result);
		sqlSession.close();
		return result;
	}
}
