<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <link type="text/css" href="/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="/resources/js/com-ajax.js"></script>
    <script type="text/javascript" src="/resources/js/com-page.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <div>
        <h2>게시판 목록</h2>
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" id="title"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" id="writer"></td>
            </tr>
            <tr>
                <td><button onclick="getList()">조회</button></td>
                <td><button onclick="resetList()">초기화</button></td>
                <td><button onclick="window.location.href='insert'">등록</button></td>
                <input type="button" class="join_button" href="/memberJoin" value="회원가입">
            </tr>
        </table>
        <input type="hidden" name="page" id="page" value="0"/>
    </div>
    <div>
        <table>
            <colgroup>
                <col width="150px"/>
                <col width="150px"/>
                <col width="150px"/>
                <col width="250px"/>
            </colgroup>
            <thead>
            <tr>
                <th>No.</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성시간</th>
            </tr>
            </thead>
            <!-- 여기에 JSTL로 동적으로 추가 -->
            <tbody id="fieldListBody">
                <c:forEach var="result" items="${response.content}">
                    <tr>
                        <td><p>${PAGE.pageRowNumber(response.number, response.size, result.index, response.totalElements)}</p></td>
                        <td><p><a href="#" onclick="fn_sub(${result.boardId})">${result.title}</a></p></td>
                        <td><p>${result.writer}</p></td>
                        <td><p>${result.regDate}</p></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <ul id="pagingArea" class="pagination"></ul>
    </div>
</div>


    <form id="boardForm" name="boardForm" method="post">
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>날짜</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${list}" var="list">
                    <tr>
                    	<td><c:out value="${list.boardId }"/></td>
<%--                         <td><c:out value="${result.code }"/></td>
                        <td><a href='#' onClick='fn_view(${result.code})'><c:out value="${result.title }"/></a></td>
                        <td><c:out value="${result.writer }"/></td>
                        <td><c:out value="${result.reg_datetime }"/></td> --%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div>            
            <a href='#' onClick='fn_write()'>글쓰기</a>            
        </div>
    </form>


<script>


function fn_view(code){
    
    var form = document.getElementById("boardForm");
    var url = "<c:url value='/board/viewContent.do'/>";
    url = url + "?code=" + code;
    
    form.action = url;    
    form.submit(); 
}

    // 페이지 온로드시 게시글 목록 조회
/*     window.onload = function () {
        getList();
    }

    // 게시글 목록 조회
    function getList(pageNo) {
        pageNo = pageNo || 0;

        const title = document.querySelector("#title").value;
        const writer = document.querySelector("#writer").value;

        const data = "?title=" + title + "&writer=" + writer + "&page=" + pageNo;

        AJAX.ajaxCall("GET", "/boards", data, afterGetList);
    }

    // 조회 후 처리
    function afterGetList(response) {
        PAGE.paging(response.totalPages, response.number, response.totalElements, "getList");
        resultTable(response);
    }

    function fn_sub(boardId){
        const url = '/detailBoards?boardId='+boardId;
        window.location.href = url;
    }

    // 동적으로 테이블 생성
    function resultTable(response) {
        document.querySelector("#fieldListBody").innerHTML = "";

        if (response.size > 0) {
            const content = response.content;

            for (var i = 0; i < content.length; i++) {
                let element = document.querySelector("#fieldListBody");
                let result = content[i];
                let template = `
                    <tr>
                        <td><p>${PAGE.pageRowNumber(response.number, response.size, i, response.totalElements)}</p></td>
                        <td><p><a href="#" onclick="fn_sub(${result.boardId})">${result.title}</a></p></td>
                        <td><p>${result.writer}</p></td>
                        <td><p>${result.regDate}</p></td>
                    </tr>
                `;
                element.insertAdjacentHTML('beforeend', template);
            }
        }
    }

 */    // 초기화
    function resetList() {
        document.querySelector("#title").value = "";
        document.querySelector("#writer").value = "";
        document.querySelector("#fieldListBody").innerHTML = "";
        getList();
    }

    // 게시글 등록
    function insertBoard() {
        const title = document.querySelector("#inputTitle").value;
        const writer = document.querySelector("#inputWriter").value;
        const content = document.querySelector("#inputContent").value;
        const data = "?title=" + title + "&writer=" + writer + "&content=" + content;

        AJAX.ajaxCall("GET", "/insertBoards", data, afterInsertBoard);
    }

    // 등록 후 처리
    function afterInsertBoard(response) {
        alert("게시글이 등록되었습니다.");
        resetForm();
        getList();
    }

    function afterUpdateBoard(){

    }

    // 폼 초기화
    function resetForm() {
        document.querySelector("#inputTitle").value = "";
        document.querySelector("#inputWriter").value = "";
        document.querySelector("#inputContent").value = "";
    }
</script>
<script>
    $(document).ready(function() {
        $(".join_button").click(function() {
            window.location.href = $(this).attr('href');
        });
    });
</script>
</body>
</html>
