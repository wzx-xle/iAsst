function translate(info, tab) {
    var url = 'http://www.bing.com/translator/?h_text=msn_ctxt&setlang=zh-cn&from=%E8%87%AA%E5%8A%A8%E6%A3%80%E6%B5%8B&to=zh-CHS&text=' + info.selectionText;
    window.open(url, '_blank');
}

function waitRead(info, tab) {
    alert(tab.title + '\n' + tab.url);
}

chrome.contextMenus.create({
    type: 'normal',
    title: '使用Bing翻译',
    id: 'trans',
    contexts: ['selection'],
    onclick: translate
});

chrome.contextMenus.create({
    type: 'normal',
    title: '稍候阅读',
    id: 'read',
    contexts: ['page'],
    onclick: waitRead
});