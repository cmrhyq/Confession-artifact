/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className weatherImg.js
 * @project showLove
 * @package static.js
 * @date 2021/8/30-10:13
 * @email cmrhyq@163.com
 */
var date = new Date;

/**
 * 获取当前今日白天黑夜天气的方法
 */
function todayWeather() {
    $.ajax({
        type: "post",
        url: "getDayNightWeather",
        dataType: "json",
        data: {city: "武汉"},
        success: function (data) {
            $(".weather").text("白天天气 " + data.weatherDay + ",夜晚天气 " + data.weatherNight)
            $(".temp").text(data.tempHigh + "," + data.tempLow);
            $(".wind").text("风向 " + data.wind + ",风力 " + data.windPower);
            $(".tips").text(data.tips);
            showWeatherIcon(data.weatherDay, data.weatherNight, data.wind)
        }, error: function (data) {
            console.log(data);
        }
    })
}

/**
 * 根据当前时间显示不同的图标
 * @param day 白天天气
 * @param night 夜晚天气
 * @param wind 风向
 */
function showWeatherIcon(day, night, wind) {
    var hours = date.getHours();
    if (hours >= 6 && hours <= 18) {
        if (hours === 6) {
            $(".img-main").addClass('sunrise')
        } else if (hours === 18) {
            $(".img-main").addClass('sunset');
        } else {
            $(".img-main").addClass("day");
        }
    } else {
        $(".img-main").addClass("night");
    }
}

window.setInterval(showWeatherIcon, 1000 * 60 * 10);