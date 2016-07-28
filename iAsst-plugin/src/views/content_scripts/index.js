chrome.runtime.onMessage.addListener(function(msg, sender, resp) {
    console.log(msg);
    resp(msg);
});

function init() {
    getAllVideo();
}

function getAllVideo() {
    $('a').each(function (ele) {
        console.log(ele);
    });
}