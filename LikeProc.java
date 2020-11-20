package dev.mvc.liketo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dev.mvc.liketo.LiketoProc")
public class LiketoProc implements LiketoProcInter {

  @Autowired
  @Qualifier("dev.mvc.liketo.LiketoDAO")
  private LiketoDAOInter liketoDAO = null;
  
  public LiketoProc(){
    //System.out.println("--> LiketoProc() created");
  }
  
  @Override
  public int countbyLike(HashMap hashMap){
    int count = liketoDAO.countbyLike(hashMap);
    return count;
  }
  
  @Override
  public int create(HashMap hashMap){
    int count = liketoDAO.create(hashMap);
    return count;
  }
  
  @Override
  public int like_check(HashMap hashMap) {
    int count = liketoDAO.like_check(hashMap);
    return count;
  }

  @Override
  public int like_check_cancel(HashMap hashMap) {
    int count = liketoDAO.like_check_cancel(hashMap);
    return count;
  }
  
  @Override
  public LiketoVO read(HashMap hashMap) {
    LiketoVO liketoVO = liketoDAO.read(hashMap);
    return liketoVO;
  }

  @Override
  public int deletebyBoardno(int boardno) {
    int count = liketoDAO.deletebyBoardno(boardno);
    return count;
  }

  @Override
  public int deletebyMno(int mno) {
    int count = liketoDAO.deletebyMno(mno);
    return count;
  }
}
