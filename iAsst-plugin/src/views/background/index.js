chrome.runtime.onMessage.addListener(function(msg, sender, resp) {
    console.log(msg);
    resp(msg);
    sendMessage();
});

function sendMessage() {
    chrome.tabs.query({active: true, currentWindow: true}, function(tabs) {
        var lastTabId = tabs[0].id;
        chrome.tabs.sendMessage(lastTabId, "Background page started.");
    });
}