package dev.mvc.liketo;

import java.util.HashMap;

public interface LiketoDAOInter {

  /* 게시판의 좋아요 번호가 있는지 카운트 */
  public int countbyLike(HashMap hashMap);
  
  /* 좋아요 번호 등록 */
  public int create(HashMap hashMap);
  
  /**
   * 좋아요 체크 여부 (0 -> 1)
   * @param hashMap
   * @return
   */
  public int like_check(HashMap hashMap);
  
  /**
   * 좋아요 체크 여부 (1 -> 0)
   * @param hashMap
   * @return
   */
  public int like_check_cancel(HashMap hashMap);
  
  /* 조회 */
  public LiketoVO read(HashMap hashMap);
  
  /* 게시판의 좋아요 삭제 */
  public int deletebyBoardno(int boardno);
  
  /* 회원의 좋아요 삭제 */
  public int deletebyMno(int mno);
  
}
