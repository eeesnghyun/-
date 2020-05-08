/* 좋아요 */
function like_func(){
  var frm_read = $('#frm_read');
  var boardno = $('#boardno', frm_read).val();
  var mno = $('#mno', frm_read).val();
  console.log("boardno, mno : " + boardno +","+ mno);
  
  $.ajax({
    url: "../liketo/like.do",
    type: "GET",
    cache: false,
    dataType: "json",
    data: 'boardno=' +boardno+ '&mno=' +mno,
    success: function(data) {
      var msg = '';
      var like_img = '';
      msg += data.msg;
      alert(msg);
      
      if(data.like_check == 0){
        like_img = "./images/dislike.png";
      } else {
        like_img = "./images/like.png";
      }      
      $('#like_img', frm_read).attr('src', like_img);
      $('#like_cnt').html(data.like_cnt);
      $('#like_check').html(data.like_check);
    },
    error: function(request, status, error){
      alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    }
  });
}


<!-- Modal -->
  <div class="modal fade" id="modal_panel" role="dialog">
    <div class="modal-dialog" style='width: 80%;'>
    
      <!-- Modal content-->
<!--       <div class="modal-content" style='background-color: #FFFFFF;'>
      </div> -->
        <div class="modal-body">  <!--  Modal body -->
          <button type="button" class="close" data-dismiss="modal" id="close_modal" style="display : none;"></button> 
               
           <div style='text-align: center; width: 100%;'>
            <div class="row" style='background-color: #FFFFFF; border-radius: 8px 8px 8px 8px;'>
             <!-- 게시글의 내용 -->
            <form name='frm_read' id='frm_read' method="get">
            <input type="hidden" id='boardno' name="boardno" value=''>
            <input type="hidden" id='categoryno' name="categoryno" value=''>
            <input type="hidden" id='mno' name="mno" value=''>
            
             <div class='col-md-6'  style='margin: 10px 0px 10px 0px;'>
               <span id='content'></span>
             </div>


		 <!--  좋아요  -->
		<div class="div1">
		 <div class="div2">
		   <div class="div3">
		   <c:choose>
		    <c:when test="${mno ne null}">
		     <a href='javascript: like_func();'><img src='./images/dislike.png' id='like_img'></a>
		    </c:when>
		    <c:otherwise>
		     <a href='javascript: login_need();'><img src='./images/dislike.png'></a>
		    </c:otherwise>
		   </c:choose>
		   <a href='#'><img src='./images/chat.png'></a>［<span id='reply_cnt'></span>］
		   <br><span id='like_cnt' style='margin-left: 5px;'></span> Likes
		   </div>
		 </div>
		 <div class="div2">
		   <div class="div3" style='padding-top: 15px;'><img src='./images/tag.png' style='margin-right: 5px;'><span id='word'></span></div>
		 </div>
		</div>
		</div>


	   <!-- Modal -->
              <div class="modal fade" id="login_need" role="dialog">
                <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content" style='position: absolute; left: 20%; top: 50px; width: 60%;'>
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" id="close_modal2" style="display : none;">×</button>
                    </div>
                    <div class="modal-body">
                      <span id='login_content'></span>
                    </div>
                    <div class="modal-footer">
                     <div class="row" style='margin: 0px auto;'>
                      <div class='col-md-6'>
                        <button type="button" class='button_base b09_electric' onclick="location.href='../member/login.do'">로그인</button>
                      </div>
                      <div class='col-md-6' style='text-align: left;'>
                        <button type="button" class='button_base b09_electric' onclick="location.href='../member/create.do'">회원가입</button>
                      </div>
                     </div>
                    </div>
                  </div>              
                </div>
              </div> <!-- Modal END -->