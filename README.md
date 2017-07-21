# voiceAPIWebAPI
## 【1】Voice登録API
音声認識デバイスから送信される会話の内容（テキスト）をサーバーに保存するAPI

### curlサンプル
```
curl -H "Content-type: application/json" -X POST -d '{"voiceContent":"それでは今からブレストを始めたいと思います","tentativeUserId":"005","deviceSerialId":"jfioewgejgkoemkvoe678fe"}' http://52.69.16.168/api/voice
```

### request url
method: POST
url: http://52.69.16.168/api/voice

### request header
```properties
"Content-type: application/json"
```
- Content-type : application/json

### request body
```js
{"voiceContent":"それでは今からブレストを始めたいと思います"
  ,"tentativeUserId":"005"
  ,"deviceSerialId":"jfioewgejgkoemkvoe678fe"}
```
- voiceContent : 音声内容
- tentativeUserId : 発話した人を特定する暫定的なID:反応した音声センサーの真ん中のIDとか
- deviceSerialId : デバイスID：ラズパイのシリアルなど


### response header
```properties
HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
```

### response body
```js
{"voiceId":7
  ,"voiceContent":"それでは今からブレストを始めたいと思います"
  ,"tentativeUserId":"005"
  ,"deviceSerialId":"jfioewgejgkoemkvoe678fe"}
```

- voiceId：一意のシーケンスが設定されている。
