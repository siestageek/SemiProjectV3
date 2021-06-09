<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="row">
    <div class="col"><h1><a href="/"
            style="color:black; text-decoration: none">Lorem Ipsum</a></h1></div>
    <div class="col text-right">
        <c:if test="${empty UID}">
            <h1><button type="button" class="btn btn-danger"
                        data-toggle="modal"
                        data-target="#loginmodal">로그인</button>
            <button type="button"
                    class="btn btn-primary">회원가입</button></h1>
        </c:if>

        <c:if test="${not empty UID}">
            <h1><button type="button" id="logoutbtn"
                        class="btn btn-dark">로그아웃</button></h1>
        </c:if>
    </div>
</header>  

<nav class="navbar navbar-expand navbar-dark bg-dark">
    <ul class="navbar-nav nav-fill w-100">
        <li class="nav-item">
            <a href="/intro" class="nav-link">프로젝트소개</a></li>

        <c:if test="${empty UID}">
            <li class="nav-item">
                <a href="/join/agree" class="nav-link">회원가입</a></li></c:if>

        <c:if test="${not empty UID}">
            <li class="nav-item">
                <a class="nav-link disabled">회원가입</a></li></c:if>

        <li class="nav-item">
            <a href="/board/list" class="nav-link">게시판</a></li>
        <li class="nav-item">
            <a href="/pds/list" class="nav-link">자료실</a></li>
        <li class="nav-item">
            <a href="/gallery/list" class="nav-link">갤러리</a></li>
        <li class="nav-item">
            <a href="/admin" class="nav-link">관리자</a></li>
    </ul>
</nav>

    