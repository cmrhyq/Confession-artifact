/**
 * <p>提示信息</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className tipsInfo.js
 * @project showLove
 * @package static.js
 * @date 2021/8/31-13:58
 * @email cmrhyq@163.com
 */

/**
 * 成功提示
 * @param msg 提示信息
 */
function successTips(msg) {
    $.message({
        message: msg,
        type: 'success'
    });
}

/**
 * 失败提示
 * @param msg 提示信息
 */
function failTips(msg) {
    $.message({
        message: msg,
        type: 'error'
    });
}

/**
 * 警告提示
 * @param msg
 */
function warnTips(msg) {
    $.message({
        message: msg,
        type: 'warning',
        duration: 0,
        showClose: true,
        center: true,
        onClose: function () {
            // alert('知道了')
        }
    });
}

/**
 * 信息提示
 * @param msg 提示信息
 */
function infoTips(msg) {
    $.message({
        message: msg,
        type: 'info'
    });
}

/**
 * 保存成功
 * @param msg 提示信息
 */
function saveSuccess(msg) {
    $.message({
        type: 'success',
        message: '<div style="color:#333;font-weight:bold;font-size:16px;">' + msg + '<div><span style="color:lightgrey;font-size:small;">3秒后自动关闭</span>',
        duration: 3000,
        center: true
    });
}