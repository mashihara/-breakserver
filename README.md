# voiceAPIWebAPI
## 【1】Voice登録API
### curlサンプル
```
curl -H "Content-type: application/json" -X POST -d '{"voiceContent":"それでは今からブレストを始めたいと思います","tentativeUserId":"005","deviceSerialId":"jfioewgejgkoemkvoe678fe"}'
```

### response header
```properties
"Content-type: application/json"
```
- Content-type : application/json

### response body
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
