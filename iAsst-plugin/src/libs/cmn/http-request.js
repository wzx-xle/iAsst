/**
 * 发起 HTTP 请求
 * @param method 请求方法
 * @param url    请求地址
 * @param data   请求参数
 * @param succ   成功时的回调函数
 * @param err    失败时的回调函数
 */
function httpRequest(method, url, data, succ, err) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, url, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var respData = xhr.responseText;
            if (xhr.responseType == 'json') {
                respData = JSON.parse((respData));
            }
            succ(respData);
        }
        else {
            if (null != err) {
                err(xhr.readyState || xhr.status);
            }
        }
    };
    xhr.send(data);
}

/**
 * 发起HTTP GET 请求
 * @param url  请求地址
 * @param data 请求参数，可以是对象，也可以是查询参数
 * @param succ 成功时的回调函数
 * @param err  失败时的回调函数
 */
function httpGet(url, data, succ, err) {
    if (typeof data === 'function') {
        err = succ;
        succ = data;
        data = null;
    }
    var params = '';
    if (data != null) {
        if (typeof data === 'object') {
            // 拼接参数
            for (var prop in data) {
                params += prop + '=' + data[prop] + '&';
            }
        }
        else {
            params += data + '&';
        }

        // 访问时间戳
        params += '_=' + new Date().getTime();
        // 查询分隔符
        if (url.lastIndexOf('?') < 0) {
            params = '?' + params;
        }
        url += params;
    }
    httpRequest('GET', url, null, succ, err);
}

/**
 * 发起HTTP POST 请求
 * @param url  请求地址
 * @param data 请求参数，可以是对象
 * @param succ 成功时的回调函数
 * @param err  失败时的回调函数
 */
function httpPost(url, data, succ, err) {
    if (typeof data === 'function') {
        err = succ;
        succ = data;
        data = null;
    }
    if (data != null && typeof data === 'object') {
        var tmp = '';
        for (var prop in data) {
            tmp += prop + '=' + data[prop] + '&';
        }
        // 访问时间戳
        tmp += '_=' + new Date().getTime();

        data = tmp;
    }
    httpRequest('POST', url, data, succ, err);
}