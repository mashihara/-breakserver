var stompClient = null;
var room;

function connect() {
	//var restUrl = '/api/selectRoom?myAvatarUserName=' + $('.myAvatarName').text(); 
	var restUrl = '/api/selectRoom';
	jQuery.getJSON(restUrl, "",  function (room) {
		//TODO
		this.room = room;
		setRoomId(room);
		var socket = new SockJS('/websocketEndpoint/' + room.roomId); // To connect WebSocket
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function (frame) {
			stompClient.subscribe('/topic/comments', function (voice) { // subscribe (/topic/greetings)
				showComment(voice);
			});
			stompClient.subscribe('/user/queue/errors', function (error) { // subscribe Error Queue(/user/queue/errors)
				alert(JSON.parse(error.body).message);
			});
		});
	});
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    var comment = $('#comment').val();
    var name = "名無しさん";
    stompClient.send("/app/comments", {}, JSON.stringify({'tentativeUserId': name,'voiceContent': comment})); 
}

function setRoomId(room){
	$('#room').append($('<p>').text("ルームナンバー:"+room.roomId));
}
function showComment(voice) {
    // talk-areaを作成
    var main_block = $('<div>').addClass('main_block');
    var main_box_l = $('<div>').addClass('main_box_l');
    var main_box_r = $('<div>').addClass('main_box_r');
    main_box_l.append($('<ul>').append($('<li>').text(JSON.parse(voice.body).tentativeUserId)).append($('<li>').text(JSON.parse(voice.body).tentativeUserId)));
    main_box_r.append($('<p>').text(JSON.parse(voice.body).voiceContent));
    main_block.append(main_box_l).append(main_box_r);
    $('.main_area').append(main_block);
    
    //TODO
    //スクロールを一番下に下げる
};

