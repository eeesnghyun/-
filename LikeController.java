@ResponseBody
  @RequestMapping(value="/liketo/like.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
  public String like(int boardno, HttpSession session){
    //System.out.println("--> like() created");
    int mno = (Integer)session.getAttribute("mno");
    JSONObject obj = new JSONObject();

    ArrayList<String> msgs = new ArrayList<String>();
    HashMap <String, Object> hashMap = new HashMap<String, Object>();
    hashMap.put("boardno", boardno);
    hashMap.put("mno", mno);
    LiketoVO liketoVO = liketoProc.read(hashMap);
    
    BoardVO boardVO = boardProc.read(boardno);
    int like_cnt = boardVO.getLike_cnt();     //게시판의 좋아요 카운트
    int like_check = 0;
    like_check = liketoVO.getLike_check();    //좋아요 체크 값
    
    if(liketoProc.countbyLike(hashMap)==0){
      liketoProc.create(hashMap);
    }
      
    if(like_check == 0) {
      msgs.add("좋아요!");
      liketoProc.like_check(hashMap);
      like_check++;
      like_cnt++;
      boardProc.like_cnt_up(boardno);   //좋아요 갯수 증가
    } else {
      msgs.add("좋아요 취소");
      liketoProc.like_check_cancel(hashMap);
      like_check--;
      like_cnt--;
      boardProc.like_cnt_down(boardno);   //좋아요 갯수 감소
    }
    obj.put("boardno", liketoVO.getBoardno());
    obj.put("like_check", like_check);
    obj.put("like_cnt", like_cnt);
    obj.put("msg", msgs);
    
    return obj.toJSONString();
  }