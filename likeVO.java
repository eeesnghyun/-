  /*likeno                      NUMBER(5)    NOT NULL PRIMARY KEY, 
  boardno                         NUMBER(5)    NOT NULL,    
  mno                             NUMBER(6)    NOT NULL,
  like_check                        NUMBER(5)   DEFAULT 0 NULL,
  */
  private int likeno;
  
  private int boardno;
  
  private int mno;
  
  private int like_check;
  
  public int getLikeno() {
    return likeno;
  }
  public void setLikeno(int likeno) {
    this.likeno = likeno;
  }
  public int getBoardno() {
    return boardno;
  }
  public void setBoardno(int boardno) {
    this.boardno = boardno;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getLike_check() {
    return like_check;
  }
  public void setLike_check(int like_check) {
    this.like_check = like_check;
  }
  