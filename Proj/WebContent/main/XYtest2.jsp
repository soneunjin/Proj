<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>다음지도 - 주소로 위도/경도 좌표값 얻기</title>
</head>
<body>
<div id="map" style="width:100%;height:450px;"></div>

<div id="coordXY"></div>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bfbcb2a9b1a94611a8804b0d71d6315c&libraries=services"></script>
<script>
var mapContainer = document.getElementById("map");
var coordXY   = document.getElementById("coordXY");
var mapOption;
var map;
var x,y = "";

 mapOption = {
  center: new daum.maps.LatLng(33.450701, 126.570667), // 임의의 지도 중심좌표 , 제주도 다음본사로 잡아봤다.
        level: 3            // 지도의 확대 레벨
}

// 지도 생성
map = new daum.maps.Map(mapContainer, mapOption);

 // 주소-좌표 변환 객체를 생성
 // 주소로 좌표를 검색
 var geocoder = new daum.maps.services.Geocoder();

 var positions = [
	    {
	        content: '<div>우리집1</div>', 
	        addr: '디지털로 64'
	    },
	    {
	    	content: '<div>우리집2</div>', 
	        addr: '디지털로 63'
	    },
	    {
	    	content: '<div>우리집3</div>', 
	        addr: '디지털로 62'
	    },
	    {
	    	content: '<div>우리집4</div>', 
	        addr: '디지털로 61'
	    }
	];

   for (var i = 0; i < positions.length; i ++) {
 geocoder.addressSearch(positions[i].addr, function(result, status) {
  
  // 정상적으로 검색이 완료됐으면,
  if (status == daum.maps.services.Status.OK) {
   
   var coords = new daum.maps.LatLng(result[0].y, result[0].x);

   y = result[0].x;
   x = result[0].y;

	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: coords // 마커의 위치
	    });
	    // 마커에 표시할 인포윈도우를 생성합니다 
	    var infowindow = new kakao.maps.InfoWindow({
	        content: positions[i].content // 인포윈도우에 표시할 내용
	    });

	   // 인포윈도우로 장소에 대한 설명표시
	   var infowindow = new kkao.maps.InfoWindow({
	    content: positions[i].content
	   });
	
	   infowindow.open(map,marker);
	    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	}

   
   // 지도 중심을 이동
   map.setCenter(coords);
   console.log(x,y);
  })
 };


</script>
</body>
</html>