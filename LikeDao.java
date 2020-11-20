package dev.mvc.liketo;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.liketo.LiketoDAO")
public class LiketoDAO implements LiketoDAOInter {

  @Autowired
  private SqlSessionTemplate mybatis;
  
  public LiketoDAO(){
    //System.out.println("--> LiketoDAO() created");
  }
  
  @Override
  public int countbyLike(HashMap hashMap){
    int count = mybatis.selectOne("liketo.countbyLike", hashMap);
    return count;
  }
  
  @Override
  public int create(HashMap hashMap){
    int count = mybatis.insert("liketo.create", hashMap);
    return count;
  }
  
  @Override
  public int like_check(HashMap hashMap) {
    int count = mybatis.update("liketo.like_check", hashMap);
    return count;
  }

  @Override
  public int like_check_cancel(HashMap hashMap) {
    int count = mybatis.update("liketo.like_check_cancel", hashMap);
    return count;
  }
  
  @Override
  public LiketoVO read(HashMap hashMap) {
    LiketoVO liketoVO = mybatis.selectOne("liketo.read", hashMap);
    return liketoVO;
  }

  @Override
  public int deletebyBoardno(int boardno) {
    int count = mybatis.delete("liketo.deletebyBoardno", boardno);
    return count;
  }
  
  @Override
  public int deletebyMno(int mno) {
    int count = mybatis.delete("liketo.deletebyMno", mno);
    return count;
  }

  

}
