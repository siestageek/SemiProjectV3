<%@ page pageEncoding="UTF-8"%>

  <div id="main">
  	
  	<script src="https://www.google.com/recaptcha/api.js"></script>
  	
           <div>
               <i class="fas fa-comments fa-2x"> 자유 게시판 </i>
               <hr> 
            </div><!-- 페이지 타이틀 --> 
            
            <div class="row">
                <div class="col-5 offset-1">
                    <h3><i class="fas fa-plus-circle"> 새글 쓰기</i></h3>
                </div>
                <div class="col-5 text-right">
                    <button type="button" class="btn btn-light">
                        <i class="fas fa-list"></i> 목록으로</button>
                </div>
            </div>
            
            <div class="card card-body bg-light col-10 offset-1">
                <form name="boardfrm" id="boardfrm">
                    <div class="form-group row">
                        <label for="title" 
                               class="col-form-label col-2 text-right text-danger">
                            제목</label>
                        <input type="text" name="title" id="title"
                               class="form-control col-9 border-danger">
                    </div>
                    <div class="form-group row">
                        <label for="userid" 
                               class="col-form-label col-2 text-right text-danger">
                            작성자</label>
                        <input type="text" name="userid" id="userid"
                               class="form-control col-9 border-danger" readonly>
                    </div>
                    <div class="form-group row">
                        <label for="contents" 
                               class="col-form-label col-2 text-right text-danger">
                            본문내용</label>
                        <textarea id="contents" name="contents" rows="15"
                                  class="form-control col-9 border-danger"></textarea>
                    </div>
                    <div class="form-group row">
                        <label class="col-form-label col-2 text-right text-danger">
                            자동가입방지</label>
                        <div class="g-recaptcha"
     						data-sitekey="6LdsIwgbAAAAAJJ4c5e4bSXldI4JJu1rLMGHXie_"></div>
 						<input type="hidden" id="g-recaptcha" name="g-recaptcha"/>
                        
                    </div>                    
                    
                    <div class="form-group row">
                        <hr class="col-10">
                        <div class="col-12 text-center">
                            <button type="button" class="btn btn-primary">
                                <i class="fas fa-check-circle"></i> 입력완료</button>
                            <button type="button" class="btn btn-danger">
                                <i class="fas fa-times-circle"></i> 다시입력</button>
                        </div>
                    </div>
                </form>
            </div>
            
        </div>
