<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
    게시판 댓글 처리 : reply
    댓글번호   댓글내용    작성자     작성일    부모글번호   부모댓글번호
    1         헬로우염      123abc  20210611    100      1
    4       왜영어로인사...  xyz987  20210611    100      1
    2         방가방가     abc123  20210611    100       2
    3         안녕하세요    xyz987  20210611    100      3

    => 댓글 출력 순서는 부모글번호로 추려낸후 부모댓글번호로 정렬
--%>

<%-- 줄바꿈 기호를 변수로 생성 : br태그 변환 필요! --%>
<c:set var="newChar" value="
" scope="application" />

<div id="main">
   <div>
       <i class="fas fa-comments fa-2x"> 자유 게시판 </i>
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
                    <h2>${bd.title}</h2>
                    </th></tr>
                <tr class="tbbg2">
                    <td style="width: 50%">${bd.userid}</td>
                    <td class="text-right">${bd.regdate} / ${bd.thumbup} / ${bd.views}</td></tr>
                <tr class="tbbg3 bdcsize"><td colspan="2">
                    ${fn:replace(bd.contents, newChar, "<br>")}
                </td></tr>
            </table>
        </div>

       <div class="row">
            <div class="col-5 offset-1">
                <%-- 자신이 작성한 글에 대해 수정/삭제 버튼이 표시되어야 함 --%>
                <c:if test="${not empty UID and UID eq bd.userid}">
                    <button type="button"
                            class="btn btn-warning text-white">
                    <i class="fas fa-edit"></i> 수정하기</button>
                    <button type="button" class="btn btn-danger">
                    <i class="fas fa-trash-alt"></i> 삭제하기</button>
                </c:if>
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
         <c:forEach var="r" items="${rps}">
             <c:if test="${r.rno eq r.rpno}">
             <tr><td><h4>${r.userid}</h4></td>
                 <td><div class="cmtbg1">${r.regdate}
                 <span style="float:right">
                     <c:if test="${not empty UID}">
                         <a href="javascript:addReply('${r.rno}')">[추가]</a></c:if>
                     <c:if test="${UID eq r.userid}">[수정] [삭제]</c:if></span></div>
                     <p>${r.reply}</p></td></tr>
             </c:if><%-- 댓글 --%>

             <c:if test="${r.rno ne r.rpno}">
             <tr><td></td>
                 <td><div class="cmtbg2">
                     <span>${r.userid}</span>
                     <span class="pushright">${r.regdate}</span></div>
                     <p>${r.reply}</p></td></tr>
             </c:if><%-- 대댓글 --%>
         </c:forEach>
      </table>
   </div><!-- 댓글목록 -->

   <div>
       <div class="row">
           <form name="replyfrm" id="replyfrm"
                 class="card card-body bg-light col-10 offset-1">
               <div class="form-group row justify-content-center">
                   <label class="col-form-label col-2 pushdwn" for="reply">${UID}</label>
                   <textarea class="form-control col-7" name="reply" id="reply" rows="5"></textarea>&nbsp;&nbsp;
                   <button class="btn btn-dark form-control col-2 pushdwn" type="button" id="newbrbtn">
                   <i class="fas fa-comment-dots"></i> 댓글쓰기</button>
               </div>
               <input type="hidden" name="userid" value="${UID}" />
               <input type="hidden" name="bdno" value="${param.bdno}" />
           </form>
       </div>
   </div><!-- 댓글쓰기 -->

</div>

<!-- 대댓글 작성을 위한 모달대화상자 -->
<div class="modal hide" id="replyModal" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">대댓글 쓰기</h3></div>

            <div class="modal-body">
                <form name="rpfrm" id="rpfrm" class="well form-inline">
                    <textarea name="reply" id="rreply" rows="8"
                              cols="75" class=""></textarea>
                    <input type="hidden" name="userid" value="${UID}">
                    <input type="hidden" name="bdno" value="${param.bdno}">
                    <input type="hidden" name="rpno" id="rpno">
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" id="newrrpbtn"
                        class="btn btn-warning">대댓글 작성</button>
            </div>
        </div>
    </div>
</div>











