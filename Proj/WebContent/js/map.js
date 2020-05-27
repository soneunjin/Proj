var markers = []; 		  // 마커를 담을 배열

var ps;		// 장소 검색 객체	
var map;	// 지도 객체
var placeOverlay;	// 커스텀 오버레이 객체
var contentNode;	// 커스텀 오버레이 내 장소 정보

var currKeywd;		// 현재 선택된 키워드를 가지고 있을 변수
var isItemClick = false;
var searchList = false;
var excRetry = false;
var region;
var town;
var hospitalNm;
var hospitalCd;

var useMapBounds;

var MARKER_WIDTH = 33, // 기본, 클릭 마커의 너비
MARKER_HEIGHT = 36, // 기본, 클릭 마커의 높이
OFFSET_X = 12, // 기본, 클릭 마커의 기준 X좌표
OFFSET_Y = MARKER_HEIGHT, // 기본, 클릭 마커의 기준 Y좌표
OVER_MARKER_WIDTH = 40, // 오버 마커의 너비
OVER_MARKER_HEIGHT = 42, // 오버 마커의 높이
OVER_OFFSET_X = 13, // 오버 마커의 기준 X좌표
OVER_OFFSET_Y = OVER_MARKER_HEIGHT, // 오버 마커의 기준 Y좌표
SPRITE_MARKER_URL = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markers_sprites2.png', // 스프라이트 마커 이미지 URL
SPRITE_WIDTH = 126, // 스프라이트 이미지 너비
SPRITE_HEIGHT = 146, // 스프라이트 이미지 높이
SPRITE_GAP = 10; // 스프라이트 이미지에서 마커간 간격

var markerSize = new kakao.maps.Size(MARKER_WIDTH, MARKER_HEIGHT), // 기본, 클릭 마커의 크기
markerOffset = new kakao.maps.Point(OFFSET_X, OFFSET_Y), // 기본, 클릭 마커의 기준좌표
overMarkerSize = new kakao.maps.Size(OVER_MARKER_WIDTH, OVER_MARKER_HEIGHT), // 오버 마커의 크기
overMarkerOffset = new kakao.maps.Point(OVER_OFFSET_X, OVER_OFFSET_Y), // 오버 마커의 기준 좌표
spriteImageSize = new kakao.maps.Size(SPRITE_WIDTH, SPRITE_HEIGHT); // 스프라이트 이미지의 크기


$(function(){
	setTimeout(mapSideTop, 500);
	mapSideHeight();
	listTgl();
	mapBtnTgl();
	
	region = getParameterByName("region");
	town = getParameterByName("town");
	hospitalNm = checkHospitalNm(getParameterByName("hospitalNm"));
	hospitalCd = getParameterByName("hospitalCd");
	
	if(region == "" || town == "" || hospitalNm == "" ){
		searchList = true;
	} else {
		$(".side_wrap").hide()
	}
	
	var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
	var mapOption = {
	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  
	
	// 지도 생성
	map = new kakao.maps.Map(mapContainer, mapOption);

	// 장소 검색 객체 생성
	ps = new kakao.maps.services.Places(map); 
	
	// 커스텀 오버레이 생성 및 설정
	placeOverlay = new kakao.maps.CustomOverlay({zIndex:1});
	contentNode = document.createElement('div');
	contentNode.className = 'placeinfo_wrap';
	placeOverlay.setContent(contentNode);
	
	if(searchList){
		useMapBounds = true;
		kakao.maps.event.addListener(map, 'idle', keywordSearchUseCurrKeywd);
		useGeolocation();
	}else{
		useMapBounds = false;
		searchPlaces();
	}
});

function checkHospitalNm(hospitalNm){
	hospitalNm = hospitalNm .split('*')[0].trim();

	hospitalListObject = {
			"(Drive-thru)" : "",
			"의료법인성수의료재단인천백병원" : "인천백병원",          
			"의료법인 백송의료재단 굿모닝병원" : "굿모닝병원",        
			"의료법인 박애의료재단 박애병원" : "박애병원",          
			"의료법인정산의료재단효성병원" : "효성병원",            
			"의료법인 대우병원" : "대우병원",                 
			"의료법인이도의료 재단 남해병원" : "남해병원",          
			"고려대학교의과대학부속구로병원" : "고려대학병원",         
			"(학)고려대학교의과대학부속병원(안암병원)" : "안암병원",    
			"충청남도천안의료원(소아청소년과 없음)" : "충청남도천안의료원", 
			"한국보훈복지의료공단중앙보훈병원" : "중앙보훈병원",        
			"학교법인연세대학교의과대학세브란스병원" : "세브란스병원",     
			"학교법인가톨릭학원가톨릭대학교서울성모병원" : "서울성모병원",   
			"동남권원자력의원" : "동남권원자력의학원",             
			"석경의료재단 센트럴병원" : "센트럴병원",             
			"연세대학교 원주세브란스기독병원" : "원주세브란스기독병원",    
			"(의)석천재단고창병원" : "고창종합병원",             
			"청도군보건소(치매안심센터)" : "청도군보건소",          
			"효신의료재단 지샘병원" : "지샘병원",               
			"의료법인승연의료재단 제일병원" : "제일병원",
			"한마음의료재단 하나병원" : "하나병원",
			"연세대학교의과대학강남세브란스병원" : "세브란스병원",
			"이화여자대학교의과대학부속서울병원" : "이대서울병원",
			"세종특별자치시보건소(충남대학교병원세종의원)" : "충남대학교병원세종의원",
			"의료법인 예당의료재단 예산종합병원" : "예산종합병원",
			"대송의료재단 무안병원"	: "무안병원",
			"한림대학교 춘천성심병원" : "춘천성심병원",
			"학교법인동은학원 순천향대학교 부속천안병원" : "순천향대학교",
			"이화여자대학교의과대학부속목동병원" : "이대목동병원",
			"의료법인 인당의료재단 부민병원" : "부민병원",
			"재단법인아산사회복지재단서울아산병원" : "서울아산병원",
			"성애의료재단성애병원" : "성애병원",
			"인제대학교해운대백병원	" : "해운대백병원",
			"의료법인구의료재단 구병원" : "구병원",
			"의)정안의료재단 중앙병원" : "중앙병원",
			"순천의료재단정병원" : "정병원",
			"영문의료재단 다보스병원" : "다보스병원",
			"아가페의료재단 시티병원" : "시티병원",
			"의료법인 양진의료재단 평택성모병원" : "평택성모병원",
			"의료법인 성심의료재단 양구성심병원" : "양구성심병원",
			"(의료법인)정민의료재단 보은한양병원" : "보은한양병원",
			"의료법인 인화재단한국병원" : "청주한국병원",
			"의료법인 인화재단한국병원" : "한국병원",
			"학교법인동은학원 순천향대학교 부속천안병원" : "순천향대학교 부속천안병원",
			"의료법인영서의료재단 천안충무병원" : "천안충무병원",
			"(의)석천재단고창병원" : "고창병원",
			"대송의료재단 무안병원" : "무안병원",
			"성심의료재단강동성심병원" : "강동성심병원",
			"경기도 북부청사 주차장" : "경기도청 북부청사 주차장",
			"화성시보건소(동탄2수질복원센터)" : "동탄2수질복원센터 승차진료소"
			
	}
	
	if(hospitalListObject[hospitalNm] != undefined || hospitalListObject[hospitalNm] != null) {
		hospitalNm = hospitalListObject[hospitalNm];
	}
	
	return hospitalNm;
}

function useGeolocation() {
	//HTML5의 geolocation 사용 가능여부
	if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(function(position) {
	        var lat = position.coords.latitude; // 위도
	        var lon = position.coords.longitude; // 경도
	        var locPosition = new kakao.maps.LatLng(lat, lon); // 좌표 생성
	      
	        // 지도 중짐좌표 및 지도 레벨 설정
	        map.setLevel(3);
	        map.setCenter(locPosition);
	            
	      });
	    
	} else {
		//geolocation 사용 불가능
	    alert("사용자의 위치정보를 가져올 수 없습니다.");
	}
}

// 키워드 검색을 요청하는 함수
function searchPlaces() {
	currKeywd = region + " " + town + " " + hospitalNm;
	keywordSearchUseCurrKeywd();
	$('.side_wrap').addClass('open');
}

//키워드 검색을 요청하는 함수
function keywordSearchUseCurrKeywd(){
	
	if (!currKeywd || isItemClick) {
        return;
    }
	
    // 키워드로 장소검색
	
	var searchKeywd = currKeywd;
	
	if(hospitalCd != "01"){
		excRetry = true;
		searchKeywd = region + " " + town + " 선별진료소 " + hospitalNm;
	}
		
	ps.keywordSearch(searchKeywd, placesSearchCB, {useMapBounds:useMapBounds}); 
}

// 장소검색 콜백함수
function placesSearchCB(data, status, pagination) {
	// 목록 초기화
	initPlacesList();
	if (status === kakao.maps.services.Status.OK) {
    	// 결과 목록, 마커, 커스텀오버레이 컨텐츠 설정
        displayPlaces(data);
        // 페이징
    	displayPagination(pagination);
    	
    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    	if(!searchList && excRetry){
    		ps.keywordSearch(currKeywd, placesSearchCB, {useMapBounds:useMapBounds});
    		excRetry = false;
    	} else {
    		if(map.getLevel() < 15){ map.setLevel(map.getLevel() + 1); }
    	}
        return;
    } else if (status === kakao.maps.services.Status.ERROR) {
        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

//placesList 초기화
function initPlacesList() {
	var listEl = document.getElementById('placesList');
	var paginationEl = document.getElementById('pagination');
	// 커스텀 오버레이 제거
	placeOverlay.setMap(null);

	// 마커 제거
	removeMarker();
	
	// 검색결과 목록의 자식 Element를 제거
    while (listEl.hasChildNodes()) {
    	listEl.removeChild (listEl.lastChild);
    }
	 
	// 기존에 추가된 페이지번호 삭제
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }
}

//결과 목록, 마커, 커스텀오버레이 컨텐츠 설정 함수
function displayPlaces(places) {
    var listEl = document.getElementById('placesList');
    var menuEl = document.getElementById('menu_wrap');
    var fragment = document.createDocumentFragment(); 
    var listStr = '';
    
    for ( var i=0; i<places.length; i++ ) {
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x);
        var marker = addMarker(placePosition, i);	// 마커 설정 
        var itemEl = getListItem(i, places[i]); // 검색 결과 element 생성
        
        // 마커와 검색결과 항목에 click시 해당 장소에 커스텀 오버레이 표시
        (function(marker, places, placePosition) {
            kakao.maps.event.addListener(marker, 'click', function() {
            	displayPlaceInfo(places);
            });
            
            itemEl.onclick =  function (itemEl) {
            	isItemClick = true;
            	map.setLevel(3);
            	map.setCenter(placePosition);
            	//item 클릭 시 클릭한 아티템을 1번으로 설정하고 다른 마커 삭제
//            	initPlacesList();
//            	addMarker(placePosition, 0);
            	
            	displayPlaceInfo(places);	// 커스텀 오버레이 표시
            	listViewResponse();
            	isItemClick = false;
            };
        })(marker, places[i], placePosition);

        fragment.appendChild(itemEl);
        
        if(!searchList){
        	map.setLevel(3);
        	map.setCenter(placePosition);
        	displayPlaceInfo(places[i]);
        	break;
        }
    }
    
    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;
}

// 검색결과 항목을 Element로 반환하는 함수
function getListItem(index, places) {

    var el = document.createElement('li');
    var itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수
function addMarker(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png'; // 마커 이미지 url, 스프라이트 이미지를 씁니다
    var imageSize = new kakao.maps.Size(36, 37);  // 마커 이미지의 크기
    var imgOptions =  {
            //spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            // spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            // offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        };
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions);
    var marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커 표시
    markers.push(marker);  // 배열에 생성된 마커 추가

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거하는 함수
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination');
    var fragment = document.createDocumentFragment();

    for (var i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커에 mouseover 이벤트가 발생했을경우
// 커스텀 오버레이를 표시하는 함수
function displayPlaceInfo(place) {
	var content = '<div class="placeinfo">' +
	    '   <p class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</p>';   
// 	    '   <a class="title" href="https://map.kakao.com/link/to/' + place.place_name + ',' + place.y + ',' + place.x + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';   
	
	if (place.road_address_name) {
	content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
	    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
	}  else {
	content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
	}                
	
	content += '    <span class="tel"><a href="tel:'+place.phone+'">' + place.phone + '</a></span>' + 
	'<a class="btn_close" onclick="placeOverlay.setMap(null)"><span class="hdn">닫기</span></a>'+
	'<a class="btn_roadmap" href="https://map.kakao.com/link/to/' + place.place_name + ',' + place.y + ',' + place.x + '" target="_blank" title="' + place.place_name + '">'+
	'<span>길찾기</span></a></div><div class="after"></div>';

	contentNode.innerHTML = content;
    placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    placeOverlay.setMap(map); 
}
/*
function displayList() {
	if($(".mp_place_list").css("display") == "none") {
		$(".mp_place_list").css("display", "");
		$("#list_btn").text("목록 닫기");
	} else {
		$(".mp_place_list").css("display", "none");
		$("#list_btn").text("목록 열기");
	}
}
*/

function listViewResponse() {
	var status = wCatch();
	var sideDiv = $('.side_wrap');
	var isOpen = sideDiv.hasClass('open');
	if (status === 'm') {
		if (isOpen) {
			sideDiv.removeClass('open');
		} 
	}
}

function listTgl() {
	var btn = $('#list_view_btn');
	var sideDiv = $('.side_wrap');
	btn.click(function(){
		var isOpen = sideDiv.hasClass('open');
		if(!isOpen) {
			sideDiv.addClass('open')
		} else {
			sideDiv.removeClass('open')
		}
	});
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function wCatch() {
	var
		status
	,	wc	= $('.w_catch')
	,	wcP = wc.find('.wc_p').css('display')
	,	wcT = wc.find('.wc_t').css('display')
	,	wcM = wc.find('.wc_m').css('display')
	;

	return "block" === wcP ? status = "p" : "block" === wcT ? status = "t" : "block" === wcM ? status = "m" : void 0

}

function mapSideTop() {

	$('.side_wrap > div').css({
		'padding-top'	:	($('.map_popup_wrap .mp_option').outerHeight()) + 'px'
	});

}

function mapSideHeight() {
	var
		status		=	wCatch()
	,	winH		=	$(window).outerHeight()
	,	sidePadding	=	32
	,	optionH		=	$('.map_popup_wrap .mp_option').outerHeight()
	$('.mp_place_list').css({
		'max-height'	:	(winH - sidePadding - optionH) + 'px'
	});
}

function mapBtnTgl() {
	var btn = $('.mp_option .btn_area > ul > li .btn');
	btn.removeClass('btn_blue');
	btn.addClass('btn_gray');
	
	btn.click(function(){
		btn.removeClass('btn_blue');
		btn.addClass('btn_gray');
	
		$(this).addClass('btn_blue');
		$(this).removeClass('btn_gray');
	});
}

$(window).on('resize', function(){
	mapSideTop();
	mapSideHeight();
	listViewResponse();
});