/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className loveTime.java
 * @project showLove
 * @package static.js
 * @date 2021/8/29-23:58
 * @email cmrhyq@163.com
 */
var arr = "2020-11-4 21:00:00".split(/[- :]/);

function timer_start() {
    var start_time = new Date(arr[0], arr[1] - 1, arr[2], arr[3], arr[4], arr[5]);
    var duration = parseInt(new Date() - start_time) / 1000;
    var seconds = parseInt(duration % 60);
    if (seconds < 10)
        seconds = "0" + seconds;
    duration = parseInt(duration / 60);
    var minutes = duration % 60;
    if (minutes < 10)
        minutes = "0" + minutes;
    duration = parseInt(duration / 60);
    var hours = duration % 24;
    if (hours < 10)
        hours = "0" + hours;
    duration = parseInt(duration / 24);
    var days = duration;
    // $(".time").append("已经:<i>"+days+"</i>")
    $('.time').text("已经：" + days + "天" + hours + " 时 " + minutes + " 分 " + seconds + " 秒");
}

window.setInterval(timer_start, 1000);
timer_start();
