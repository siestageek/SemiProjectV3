<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:if test="${param.pno eq 'null' or empty param.pno}">
    <script>alert('보여줄 내용이 없어요!!'); location.href='/pds/list?cp=1'</script>
</c:if>

<%-- 첨부파일 아이콘 선택 --%>
<c:set var="atticon1" value="${p.ftype1}" />
<c:if test="${p.ftype1 ne 'zip' and p.ftype1 ne 'jpg' and p.ftype1 ne 'txt'}">
    <c:set var="atticon1" value="file" />
</c:if>

<c:set var="atticon2" value="${p.ftype2}" />
<c:if test="${p.ftype2 ne 'zip' and p.ftype2 ne 'jpg' and p.ftype2 ne 'txt'}">
    <c:set var="atticon2" value="file" />
</c:if>

<c:set var="atticon3" value="${p.ftype3}" />
<c:if test="${p.ftype3 ne 'zip' and p.ftype3 ne 'jpg' and p.ftype3 ne 'txt'}">
    <c:set var="atticon3" value="file" />
</c:if>

<div id="main">
   <div>
       <i class="fas fa-save fa-2x"> 자료실 </i>
       <hr>
    </div><!-- 페이지 타이틀 -->

   <div>
        <div class="row">
            <div class="col-5 offset-1">
                <button type="button" class="btn btn-light" id="pdprvbtn">
                <i class="fas fa-chevron-left"></i> 이전게시물</button>
                <button type="button" class="btn btn-light" id="pdnxtbtn" >
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
                    <h2>${p.title}</h2>
                    </th></tr>
                <tr class="tbbg2">
                    <td style="width: 50%">${p.userid}</td>
                    <td class="text-right">${p.regdate} / ${p.thumbup} / ${p.views}</td></tr>
                <tr class="tbbg3 bdcsize"><td colspan="2">
                    ${p.contents}
                </td></tr><!-- 본문 -->

                <tr><td colspan="2" class="tbbg4 patxt">첨부1 :
                    <img src="/img/${atticon1}.png" />
                    <a href="/pds/down?pno=${p.pno}&order=1">${p.fname1}</a>
                    (${p.fsize1}KB, ${p.fdown1}회 다운로드함)</td></tr>

                <c:if test="${p.fname2 ne '-'}">
                <tr><td colspan="2" class="tbbg4 patxt">첨부2 :
                    <img src="/img/${atticon2}.png" />
                    <a href="/pds/down?pno=${p.pno}&order=2">${p.fname2}</a>
                    (${p.fsize2}KB, ${p.fdown2}회 다운로드함)</td></tr>
                </c:if>
                <c:if test="${p.fname3 ne '-'}">
                <tr><td colspan="2" class="tbbg4 patxt">첨부3 :
                    <img src="/img/${atticon3}.png" />
                    <a href="/pds/down?pno=${p.pno}&order=3">${p.fname3}</a>
                    (${p.fsize3}KB, ${p.fdown3}회 다운로드함)</td></tr>
                </c:if>
            </table>
        </div>

       <div class="row">
            <div class="col-5 offset-1">
                <button type="button"
                        class="btn btn-warning text-white">
                <i class="fas fa-edit"></i> 수정하기</button>
                <button type="button" class="btn btn-danger" id="pdrmvbtn">
                <i class="fas fa-trash-alt"></i> 삭제하기</button>
            </div>
            <div class="col-5 text-right">
                <button type="button" class="btn btn-success" id="pdthumbtn">
                    <i class="far fa-thumbs-up"></i> 추천하기</button>

                <button type="button" class="btn btn-light">
                <i class="fas fa-list"></i> 목록으로</button>
            </div>
       </div>
       <input type="hidden" id="pno" value="${param.pno}" />

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
