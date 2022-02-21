/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className picture.java
 * @project showLove
 * @package static.js
 * @date 2021/8/28-0:47
 * @email cmrhyq@163.com
 */
function weather(){
    $.ajax({
        type: "post",
        url: "getTemps",
        dataType: "json",
        data: {city: "武汉"},
        success: function (data) {
            linePicture(data.week,data.high,data.low)
        }, error: function (data) {
            console.log(data);
        }
    })
}

function linePicture(week,high,low){
    var line = echarts.init(document.getElementById('line'));
    line.setOption({
        color: ["#fca585", "#07c0e4"],
        title: {
            x: 'left',
            text: '一周温度',
            textStyle: {
                fontSize: '18',
                color: '#4c4c4c',
                fontWeight: 'bolder'
            }
        },
        tooltip: {
            trigger: 'axis'
        },
        toolbox: {
            show: false,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {readOnly: false},
                magicType: {type: ['line', 'bar']}
            }
        },
        legend: {
            x: 'right',
            data: ['最高温度', '最低温度']
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: week,
            axisLabel: {
                interval: 0
            }
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: '最高温度',
                type: 'line',
                data: high,
                markLine: {data: [{type: 'average', name: '平均值'}]}
            }, {
                name: '最低温度',
                type: 'line',
                data: low,
                markLine: {data: [{type: 'average', name: '平均值'}]}
            }
        ]
    });
}