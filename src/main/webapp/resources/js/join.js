// agree
$('#okagree').on('click', function() {
    if (!$('#agree1').is(':checked'))
        alert('이용약관에 동의하세요!');
    else if (!$('#agree2').is(':checked'))
        alert('개인정보 수집에 동의하세요!');
    else
        location.href = '/join/checkme';
}); // 모두 동의함

$('#noagree').on('click', function() {
    location.href = '/';
}); // 동의하지 않음


// checkme
$('#chk2btn').on('click', function () {
    if ($('#name2').val() == '') alert('이름을 입력하세요!');
    else if ($('#jumin1').val() == '' || $('#jumin2').val() == '')
        alert('주민번호를 입력하세요!');
    else if (!$('#chkjumin').is(':checked'))
        alert('주민번호처리에 동의하세요!');
    else {
        const frm = $('#checkfrm2');
        frm.attr('action','/join/joinme');
        frm.attr('method', 'post');
        frm.submit();
    }
});

$('#cancel2btn').on('click', function () {
    location.href = '/';
});


// joinme
$('#joinbtn').on('click', function() {
    if ($('#userid').val() == '') alert('아이디를 입력하세요');
    else if ($('#passwd').val() == '') alert('비밀번호를 입력하세요');
    else if ($('#passwd').val() != $('#repasswd').val())
        alert('비밀번호가 서로 일치하지 않아요!');
    //else if ($('#zip1').val() == '' || $('#zip2').val() == '')
    //    alert('우편번호를 조회하세요');
    else if ($('#addr1').val() == '' || $('#addr2').val() == '')
        alert('기본주소 또는 나머지 주소를 입력하세요');
    else if ($('#email1').val() == '' || $('#email2').val() == '')
       alert('이메일을 입력하세요');
    else if ($('#tel1').val() == '' || $('#tel2').val() == '' ||
        $('#tel3').val() == '') alert('전화번호를 입력하세요');
    else if (grecaptcha.getResponse() == '')
        alert('자동가입 방지 확인 필요!!');
    else {
        $('#jumin').val( $('#jumin1').val() + '-' + $('#jumin2').val() );
        $('#zipcode').val( $('#zip1').val() + '-' + $('#zip2').val() );
        $('#email').val( $('#email1').val() + '@' + $('#email2').val() );
        $('#phone').val(
            $('#tel1').val() + '-' + $('#tel2').val() + '-' + $('#tel3').val());

        const frm = $('#joinfrm');
        frm.attr('action','/join/joinok');
        frm.attr('method','post');
        frm.submit();
    }
});

$('#cancelbtn').on('click', function() { location.href = '/'; });

// show zipcode


// send zipcode
$('#sendzip').on('click', function() {
    let addr = $('#addrlist option:selected').val();

    if (addr == undefined) {
        alert('주소를 선택하세요!!');
        return;
    }

    let addrs = addr.split(' '); // 선택한 주소를 공백으로 나눔

    // 잘라낸 첫번째 뭉치를 -로 다시 나눔
    $('#zip1').val( addrs[0].split('-')[0] );
    $('#zip2').val( addrs[0].split('-')[1] );

    // 잘라낸 나머지 뭉치들을 합쳐서 addr1로 보냄
    $('#addr1').val( addrs[1] + ' ' + addrs[2] + ' ' + addrs[3] );

    // 검색창 닫음
    $('#zipmodal').modal('hide');
});


// send email2
// option:selected => select 요소들 중 선택한 요소의 값 알아냄
$('#email3').on('change', function() {
    let val = $('#email3 option:selected').text();
    if (val == '직접입력하기') {
        $('#email2').attr('readonly', false);  // readonly 속성 해제
        $('#email2').val('');
    } else {
        $('#email2').attr('readonly', true);  // readonly 속성 잠금
        $('#email2').val(val);
    }
});
