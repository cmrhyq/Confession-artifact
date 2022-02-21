# 工程简介

## API

### 短信

地址：https://itdage.cn/hw/hwSms

参数： name 姓名 phoneNumber 手机号 s1 天气信息 晴、多云 s2 温度区间 1-2° s3 温馨提示 自定义20个字

返回值： 成功：ok 失败：原因

### 天气

地址：https://itdage.cn/hw/weather

参数：city

返回值： {"resp": {
"shidu": "97%",
"zhishus": {"zhishu": [
{
"name": "穿衣指数",
"detail": "天气炎热，建议穿着薄款，透气的衣物。推荐：T恤、裙装、短裤等。",
"value": "清凉夏装"
}, {
"name": "紫外线强度",
"detail": "紫外线较弱，对人体无太大影响，放心出门哦。",
"value": "紫外线最弱"
}, {
"name": "护肤指数",
"detail": "空气湿润度高，可以根据皮肤类型选择相应清爽型扶肤品。",
"value": "清洁护肤"
}, {
"name": "洗车指数",
"detail": "近日可能有降水，很不适合洗车，请等待晴天洗车，保持车子连日洁净。",
"value": "很不适洗车"
}, {
"name": "感冒指数",
"detail": "感冒低发期，天气舒适，请注意多吃蔬菜水果，多喝水哦。",
"value": "少发感冒"
}, {
"name": "晾晒指数",
"detail": "阳光不充足，不适宜晾晒。",
"value": "不适宜晾晒"
}, {
"name": "户外指数",
"detail": "天气还可以，预计白天没有降水，适合参加户外活动，适当锻炼身体。",
"value": "较适宜外出"
}, {
"name": "污染指数",
"detail": "空气质量良好，污染物浓度低，对健康人群无明显影响，可在户外适当活动。",
"value": "轻微污染"
}, {
"name": "钓鱼指数",
"detail": "阴天钓浅不钓深，钓近不钓远。考验您技术的时候到了！",
"value": "较适宜"
}, {
"name": "中暑指数",
"detail": "预计今日天气酷热，极易发生中暑或危急中暑，请做好防暑降温工作。",
"value": "极易中暑"
}, {
"name": "舒适度",
"detail": "天气闷热，舒适度极低，做好散热，补充水分。",
"value": "极不舒适"
}, {
"name": "赏月指数",
"detail": "今晚看不到月亮，不适合赏月",
"value": "不适宜赏月"
}
]},
"fengli": "1级",
"city": "汉川",
"fengxiang": "东南风",
"forecast": {"weather": [
{
"date": "23日星期一",
"high": "高温 31℃",
"low": "低温 25℃",
"night": {
"fengli": "2级",
"fengxiang": "西北风",
"type": "大雨"
},
"day": {
"fengli": "2级",
"fengxiang": "西北风",
"type": "阴"
} }, {
"date": "24日星期二",
"high": "高温 27℃",
"low": "低温 21℃",
"night": {
"fengli": "1级",
"fengxiang": "南风",
"type": "阴"
},
"day": {
"fengli": "1级",
"fengxiang": "南风",
"type": "阴"
} }, {
"date": "25日星期三",
"high": "高温 31℃",
"low": "低温 23℃",
"night": {
"fengli": "2级",
"fengxiang": "南风",
"type": "小雨"
},
"day": {
"fengli": "2级",
"fengxiang": "南风",
"type": "小雨"
} }, {
"date": "26日星期四",
"high": "高温 27℃",
"low": "低温 21℃",
"night": {
"fengli": "2级",
"fengxiang": "北风",
"type": "小雨"
},
"day": {
"fengli": "2级",
"fengxiang": "北风",
"type": "小雨"
} }, {
"date": "27日星期五",
"high": "高温 23℃",
"low": "低温 21℃",
"night": {
"fengli": "2级",
"fengxiang": "北风",
"type": "多云"
},
"day": {
"fengli": "2级",
"fengxiang": "北风",
"type": "小雨"
} }
]},
"wendu": 29,
"sunset_2": "",
"yesterday": {
"low_1": "低温 27℃",
"date_1": "22日星期日",
"day_1": {
"type_1": "小雨",
"fx_1": "东南风",
"fl_1": "2级"
},
"high_1": "高温 34℃",
"night_1": {
"type_1": "阴",
"fx_1": "东南风",
"fl_1": "2级"
} },
"sunset_1": "18:58",
"sunrise_2": "",
"updatetime": "00:16",
"sunrise_1": "05:57"
}}

# 延伸阅读

