package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;

	// 등록
	public int insert(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insert()");
		
		return sqlSession.insert("guestbook.insert", guestbookVo);
	}

	// 삭제
	public int delete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.delete()");
		
		return sqlSession.delete("guestbook.delete", guestbookVo);
	}

	// 리스트 가져오기
	public List<GuestbookVo> getList() {
		System.out.println("GuestbookDao.getList()");
		
		List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");		
		return guestList;
	}
}
