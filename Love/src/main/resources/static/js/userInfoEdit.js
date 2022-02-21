/**
 * <p>userInfoEdit.html页面相关方法</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className userInfoEdit.js
 * @project showLove
 * @package static.js
 * @date 2021/8/31-13:32
 * @email cmrhyq@163.com
 */

/**
 * 更新用户状态
 */
function updateStatic(phone) {
    $.ajax({
        type: "post",
        url: "updateStatic",
        dataType: "json",
        data: {receiverPhone: phone},
        success: function (data) {
            if (data.status === 301) {
                failTips(data.message);
            } else if (data.status === 102 || data.status === 103) {
                successTips(data.message);
            } else {
                infoTips(data.message);
            }
            $(".table tbody").empty();
            loadData();
        }, error: function (data) {
            warnTips(data.status);
        }
    })
}

/**
 * 页面数据的加载
 */
function loadData() {
    $.ajax({
        type: "post",
        url: "queryUserData",
        dataType: "json",
        data: {},
        success: function (data) {
            var receiverStatic;
            var staticBtn;
            $(".table tbody").empty();
            for (var i = 0; i < data.length; i++) {
                if (data[i].receiverStatic === 1) {
                    receiverStatic = "正常";
                    staticBtn = "<input type='button' class='btn-secondary' value='正常' onclick='updateStatic(" + data[i].receiverPhone + ")'>";
                } else {
                    receiverStatic = "禁用";
                    staticBtn = "<input type='button' class='btn-secondary' value='禁用' onclick='updateStatic(" + data[i].receiverPhone + ")'>"
                }
                $(".table tbody").append('<tr>' +
                    '<td>' + data[i].receiverId + '</td>' +
                    '<td>' + data[i].receiverName + '</td>' +
                    '<td>' + data[i].receiverSex + '</td>' +
                    '<td>' + data[i].receiverPhone + '</td>' +
                    '<td>' + receiverStatic + '</td>' +
                    '<td>' + data[i].receiverCity + '</td>' +
                    '<td>' + data[i].receiverSendCount + '</td>' +
                    '<td>' + data[i].receiverSendErrorCount + '</td>' +
                    '<td>' + staticBtn + '</td>' +
                    '</tr>')
            }
        }, error: function (data) {
            console.log(data);
        }
    })
}

/**
 * 重置按钮
 */
function resetSearchInfo(){
    loadData();
    clearSearchInfo()
}

/**
 * 清除搜索信息
 */
function clearSearchInfo(){
    $(".form-control").val("");
}