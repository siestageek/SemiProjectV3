<%@ page pageEncoding="UTF-8"%>

       <div id="main">
           <div>
               <i class="far fa-file-image fa-2x"> 갤러리 </i>
               <hr> 
            </div><!-- 페이지 타이틀 --> 
            
           <div>
                <div class="row">
                    <div class="col-5 offset-1">
                        <button type="button" class="btn btn-light">
                        <i class="fas fa-chevron-left"></i> 이전게시물</button>
                        <button type="button" class="btn btn-light">
                        <i class="fas fa-chevron-right"></i> 다음게시물</button>
                    </div>
                    <div class="col-5 text-right">
                        <button type="button" class="btn btn-light">
                        <i class="fas fa-plus-circle"></i> 새글쓰기</button>
                    </div>
                </div>    
               
                <div class="row">
                    <table class="table col-10 offset-1">
                        <tr class="tbbg1 text-center"><th colspan="2">
                            <h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</h2>
                            </th></tr>
                        <tr class="tbbg2">
                            <td style="width: 50%">zzyzzy</td>
                            <td class="text-right">2021.05.21 11:11:11 / 22 / 33</td></tr>
                        <tr class="tbbg3"><td colspan="2">
                            <div><img src="/img/curly.png" class="img-fluid"></div>
                            <div><img src="/img/Isabelle.png" class="img-fluid"></div>
                            <div><img src="/img/20130125181216_6417.jpg" class="img-fluid"></div>
                        </td></tr><!-- 본문 -->
                        <tr><td colspan="2" class="tbbg4">
                            <i class="fas fa-file-image"></i>
                            homework.jpg (123KB)</td></tr>
                        <tr><td colspan="2" class="tbbg4">
                            <i class="fas fa-file-image"></i>
                            homework.gif (456KB)</td></tr>
                        <tr><td colspan="2" class="tbbg4">
                            <i class="fas fa-file-image"></i>
                            homework.png (789KB)</td></tr>
                    </table>
                </div>    
               
               <div class="row">
                    <div class="col-5 offset-1">
                        <button type="button" 
                                class="btn btn-warning text-white">
                        <i class="fas fa-edit"></i> 수정하기</button>
                        <button type="button" class="btn btn-danger">
                        <i class="fas fa-trash-alt"></i> 삭제하기</button>
                    </div>
                    <div class="col-5 text-right">
                        <button type="button" class="btn btn-light">
                        <i class="fas fa-list"></i> 목록으로</button>
                    </div>
               </div>    
            </div><!-- 본문글 -->    
            
           <div>
              <div class="row">
                  <h3 class="col-10 offset-1">
                      <i class="far fa-comments"></i> 나도 한마디</h3></div>
              
              <table class="table col-10 offset-1">
                 <tr><td><h4>zzyzzy</h4></td>
                     <td><div class="cmtbg1">2021.05.21 10:10:10</div>
                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></td></tr>
                  <tr><td></td>
                     <td><div class="cmtbg2">
                         <span>siestageek</span>
                         <span class="pushright">2021.05.21 10:10:10</span></div>
                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></td></tr>
                  <tr><td><h4>zzyzzy</h4></td>
                     <td><div class="cmtbg1">2021.05.21 10:10:10</div>
                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></td></tr>
                  <tr><td><h4>zzyzzy</h4></td>
                     <td><div class="cmtbg1">2021.05.21 10:10:10</div>
                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></td></tr>
                  <tr><td><h4>zzyzzy</h4></td>
                     <td><div class="cmtbg1">2021.05.21 10:10:10</div>
                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></td></tr>
                  <tr><td><h4>zzyzzy</h4></td>
                     <td><div class="cmtbg1">2021.05.21 10:10:10</div>
                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></td></tr>
                  <tr><td><h4>zzyzzy</h4></td>
                     <td><div class="cmtbg1">2021.05.21 10:10:10</div>
                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></td></tr>
              </table>
           </div><!-- 댓글목록 --> 
            
           <div>
               <div class="row">
                   <form name="replyfrm" id="replyfrm"
                         class="card card-body bg-light col-10 offset-1">
                       <div class="form-group row justify-content-center">
                           <label class="col-form-label col-2 pushdwn" for="reply">작성자</label>
                           <textarea class="form-control col-7" name="reply" id="reply" rows="5"></textarea>&nbsp;&nbsp;
                           <button class="btn btn-dark form-control col-2 pushdwn" type="button">
                           <i class="fas fa-comment-dots"></i> 댓글쓰기</button>
                       </div>
                   </form>
               </div>            
           </div><!-- 댓글쓰기 -->    
            
       </div>
