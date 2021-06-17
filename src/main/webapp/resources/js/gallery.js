// show img
function showimg(gno) {
    location.href = '/gallery/view?gno=' + gno;
}

// new gallery
$('#newgalbtn').on('click', function(){
    location.href = '/gallery/write';
});

// write gallery
$('#newgal').on('click', function(){
    if ($('#title').val() == '') alert('제목을 작성하세요!');
    else if ($('#contents').val() == '') alert('본문을 작성하세요!');
    else if (grecaptcha.getResponse() == '') alert('자동가입방지를 체크하세요!');
    else {
        const frm = $('#galfrm');
        frm.attr('method', 'post');
        frm.attr('action', '/gallery/write');
        frm.attr('enctype', 'multipart/form-data');
        frm.submit();
    }
});

// show attach filename
$('#file1').on('change', function() {
    var fname = $(this).val();
    fname = fname.substring(fname.lastIndexOf("\\") + 1);
    $(this).next('.custom-file-label').html(fname);
});

$('#file2').on('change', function() {
    var fname = $(this).val();
    fname = fname.substring(fname.lastIndexOf("\\") + 1);
    $(this).next('.custom-file-label').html(fname);
});

$('#file3').on('change', function() {
    var fname = $(this).val();
    fname = fname.substring(fname.lastIndexOf("\\") + 1);
    $(this).next('.custom-file-label').html(fname);
});

// modify gallery
$('#modgbtn').on('click', function (){
    location.href = '/gallery/update?gno=' + $('#gno').val();
});

// remove gallery
$('#rmvgbtn').on('click', function (){
    alert('기능 준비중입니다...');
});

// gallery disable/enable upload file
$('#die1').on('change', function(){
    if ($('#die1').is(':checked')) {   // checkbox가 체크되면
        $('#file1').attr('disabled', false);  // disabled 해제
        $('#todie').val("1" + $('#todie').val()); // 첨부파일 수정목록에 1 추가
    } else if (!$('#die1').is(':checked')) {
        $('#file1').attr('disabled', true);
        $('#todie').val($('#todie').val().replace(/1/g, ''));
        // 첨부파일 수정목록에서 1 제거
    }
});

$('#die2').on('change', function(){
    if ($('#die2').is(':checked')) {   // checkbox가 체크되면
        $('#file2').attr('disabled', false);  // disabled 해제
        $('#todie').val($('#todie').val() + "2"); // 첨부파일 수정목록에 2 추가
    } else if (!$('#die2').is(':checked')) {
        $('#file2').attr('disabled', true);
        $('#todie').val($('#todie').val().replace(/2/g, ''));
    }
});

$('#die3').on('change', function(){
    if ($('#die3').is(':checked')) {   // checkbox가 체크되면
        $('#file3').attr('disabled', false);  // disabled 해제
        $('#todie').val($('#todie').val() + "3");
    } else if (!$('#die3').is(':checked')) {
        $('#file3').attr('disabled', true);
        $('#todie').val($('#todie').val().replace(/3/g, ''));
    }
});

// update gallery
$('#modgal').on('click', function() {
    if (grecaptcha.getResponse() == '') alert('자동가입방지 확인하세요!');
    else {
        const frm = $('#modgalfrm');
        frm.attr('method','post');
        frm.attr('enctype','multipart/form-data');
        frm.attr('action','/gallery/update');
        frm.submit();
    }
});




