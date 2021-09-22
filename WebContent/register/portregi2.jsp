<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
</head>

<link rel="stylesheet" type="text/css" href="portstyle2.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap"
	rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="portregiscript2.js"></script> <!-- js파일을 분리할 때 jquery의 import문은 반드시 js파일 연결문보다 위에 위치해야 한다. -->
<script type = 'text/javascript'>

/*이벤트가 키업이라서..밑에 콘솔에 보면 키입력된ㄹ때마다..계속 그.. 디비 접속이 불려요... ㅎ 
문제는 아니지만 나중에 이벤트 종류도 조금 고민해보실 필요가 잇지요. 
넵
선생님 근데 이게 사실은 선생님꼐서 가르쳐주신 ajax의 모습은 아닌데 상관은 없는데 그 형태로는 도저히 안돼서요
나중에라도 코드를 썼는데 오류가 나면 그 오류나는 상태로 좀 보고 싶어서요. 
지금은 에이젝스로 안된다고 한 상황이 어디까지인지를 제가 알수가 ㅇ벗어서.. 머라 얘기를 드리기가..... ㅠ 
넵 근데 일단기능 만들어보고 수정 한번해보려구요 선생님이 가르쳐주신대로 넵
알겠습니다 어떤기능을 더 만들어야 될지 고민하고 있었어요 
아이디 비밀번호 찾기도 있고. 아니면 로그인 했을때 내 개인정보가 나오는 페이지도 있고... 아
그 전에 중복을 다르게 해보셔도 되고. 넵 감사합니다. 다해봐야죠 ㅋㅋㅋㅋ*/


	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {

						var addr = '';
						var extraAddr = '';

						if (data.userSelectedType == 'R') {
							addr = data.roadAddress;
						} else {
							addr = data.jibunAddress;
						}

						if (data.userSelectedType == 'R') {

							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}

							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}

							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}

							document.getElementById("sample4_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample4_extraAddress").value = '';
						}

						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = addr;

						document.getElementById("sample4_extraAddress_2")
								.focus();

						/*
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.

						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
						    extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if(data.buildingName !== '' && data.apartment === 'Y'){
						   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if(extraRoadAddr !== ''){
						    extraRoadAddr = ' (' + extraRoadAddr + ')';
						}


						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						document.getElementById("sample4_roadAddress").value = data.jibunAddress;
						
						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if(roadAddr !== ''){
						   document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
						    document.getElementById("sample4_extraAddress").value = '';
						} */
					}
				}).open();
	}
</script>

<body>
	<form method="post" name="my_form" action="regiDbConn.jsp">

		<table align="center" style="padding-top: 50px;">
			<tr>
				<td align="center"><font class="font1"><a href="../main/portmainfinal.jsp">FIT-IN</a></font></td>
			</tr>
			<tr>
				<td align="center"
					style="color: gray; font-weight: bold; font-family: 'Nanum Gothic Coding', monospace;">회원가입</td>
			</tr>

		</table>

		<table align="center" class="table">

			<tr>
				<td><font class="font2">아이디</font></td>
			</tr>
			<tr>
				<td><input type="text" id="idch" name="user_id" maxlength="12"
					class="borderstyle bordersize" placeholder="아이디(4~10자)"></td>
					
			</tr>
			<tr>
				<td id="chtext"><span></span></td>
			</tr>
		
			<tr>
				<td><font class="font2">비밀번호</font></td>
			</tr>
			<tr>
				<td><input type="password" name="user_pw"
					class="borderstyle bordersize" maxlength="12"
					placeholder="비밀번호(4~12자)" onchange="pwchfx()"></td>
			</tr>
			<tr>
				<td><input type="password" name="pwch"
					class="borderstyle bordersize" maxlength="12" placeholder="비밀번호 확인"
					onchange="pwchfx()"></td>
			</tr>
			<tr>
				<td>
					<div id="pwchdp"></div>
				</td>
			</tr>

			<tr>
				<td><font class="font2">이름</font></td>
			</tr>
			<tr>
				<td><input type="text" name="user_name"
					class="bordersize borderstyle"></td>
			</tr>

			<tr>
				<td><font class="font2">이메일</font></td>
			</tr>
			<tr>
				<td><input type="text" name="emailin" class="borderstyle"
					maxlength="50" class="borderstyle"
					style="width: 300px; height: 40px;"> <select
					name="emaildefault"
					style="width: 140px; height: 44px;">
						<option value="@naver.com">@naver.com</option>
						<option value="@google.com">@google.com</option>
						<option value="@daum.net">@daum.net</option>
						<option value="@nate.com">@nate.com</option>
				</select></td>
			</tr>

			<tr>
				<td><font class="font2">생년월일</font></td>
			</tr>
			<tr>
				<td><input type="text" name="year" maxlength="4"
					class="borderstyle" style="width: 165px; height: 40px;"
					placeholder="년도(4자리)"> <select name="month" size="1"
					style="width: 130px; height: 44px;">
						<option value="1">1
						<option value="2">2
						<option value="3">3
						<option value="4">4
						<option value="5">5
						<option value="6">6
						<option value="7">7
						<option value="8">8
						<option value="9">9
						<option value="10">10
						<option value="11">11
						<option value="12">12
				</select> <input type="text" name="day" maxlength="3" class="borderstyle"
					style="width: 125px; height: 40px;"></td>
			</tr>
			<tr>
				<td><font class="font2">휴대전화</font></td>
			</tr>
			<tr>
				<td><input type="text" name="cellnum"
					class="borderstyle bordersize" maxlength="20" placeholder="-제외"></td>
			</tr>

			<tr>
				<td><font class="font2">성별</font></td>
			</tr>

			<tr>
				<td><input type="radio" name="gender" value="남자" checked="on"><font
					style="font-family: 'Nanum Gothic Coding', monospace; font-size: 13px;">남성</font>&emsp;&emsp;&emsp;
					<input type="radio" name="gender" value="여자"><font
					style="font-family: 'Nanum Gothic Coding', monospace; font-size: 13px;">여성</font>&emsp;&emsp;&emsp;
				</td>
			</tr>

			<tr>
				<td><font class="font2">주소</font></td>
			</tr>

			<tr>
				<td><input type="text" name="addnum" id="sample4_postcode"
					class="borderstyle" maxlength="30"
					style="height: 40px; width: 300px;" placeholder="우편번호"> <input
					type="button" name="addbutton" value="우편번호 검색" id="addsearchbtn"
					style="background-color: black; border-style: solid; font-family: 'Nanum Gothic Coding', monospace; font-weight: bold; height: 44px; width: 140px; font-size: 12px; color: white; border-color: black; cursor: pointer;"
					onclick="sample4_execDaumPostcode()"></td>
			</tr>
			<tr>
				<td><input type="text" name="addmain" id="sample4_roadAddress"
					class="bordersize borderstyle" maxlength="50" placeholder="주소입력">
				</td>
			</tr>
			<tr>
				<td><input type="text" name="adddetail"
					id="sample4_extraAddress" class="borderstyle" maxlength="30"
					style="height: 40px; width: 200px;" placeholder="상세주소"> <input
					type="text" name="adddetail_2" id="sample4_extraAddress_2"
					class="borderstyle" style="height: 40px; width: 230px;"
					placeholder="나머지 주소 입력"></td>

			</tr>

			<tr>
				<td align="center"><input type="submit" name="register"
					value="가입"
					style="cursor: pointer; border-style: solid; font-family: 'Nanum Gothic Coding', monospace; background-color: black; font-size: 15px; color: white; font-weight: bold; width: 460px; height: 50px; border-color: black;"
					onclick="return idch2()";></td>
			</tr>

		</table>
		
		<footer>
		<div class="footerwrap">
			<ul>
				<li class="footerlogo">Fit-in</li>
				<li class="footeradd">www.fit-in.com</li>
				<li class="footerinfo"><a href="#">문의사항</a></li>
			</ul>
		</div>
	</footer>
	</form>
</body>
</html>

<!--정확히는 이벤트ㅇㅔ 함수를 여러개 걸어도 되는데. 그렇게 안하죠. 그리고 그게 지금처럼 또 서로 물려있는거면 더더군.... 
근데 그건 그거고 
함수가 이렇게나 많을 이유가 있어요? 그냥 개개 텍스트박스마다 상황설정이 다를것 같아 하나하나 작성했어요
내가 이 작업을 언제 처리할꺼냐는거죠. 
버튼을 누르면 할꺼면 그럼 버튼이 눌러졌을때 일어나는 일은 기본적으로 하나의 묶음.... 
네 알겠습니다

넵 -->
