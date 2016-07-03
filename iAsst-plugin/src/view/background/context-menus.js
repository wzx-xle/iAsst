var page = {};

page.feild = {};
page.func = {};
page.event = {};

// 选中时的菜单项
page.feild.selectionMenu = [{
    id: 'search',
    title: '搜索',
    items: [{
        id: 'search_bing',
        title: '必应',
        url: 'https://www.bing.com/search?q=??1??'
    }, {
        id: 'search_baidu',
        title: '百度',
        url: 'https://www.baidu.com/s?wd=??1??'
    }, {
        id: 'search_google',
        title: '谷歌',
        url: 'https://www.google.com/?gws_rd=ssl#q=??1??'
    }]
}, {
    id: 'translate',
    title: '翻译',
    items: [{
        id: 'translate_youdao',
        title: '有道',
        url: 'http://dict.youdao.com/w/??1??/'
    }, {
        id: 'translate_bing',
        title: '必应',
        url: 'http://www.bing.com/translator/?h_text=msn_ctxt&setlang=zh-cn&from=%E8%87%AA%E5%8A%A8%E6%A3%80%E6%B5%8B&to=zh-CHS&text=??1??'
    }, {
        id: 'translate_baidu',
        title: '百度',
        url: 'http://fanyi.baidu.com/translate?aldtype=16047&query=??1??&keyfrom=baidu&smartresult=dict&lang=auto2zh'
    }]
}, {
    id: 'shopping',
    title: '购物',
    items: [{
        id: 'shopping_jd',
        title: '京东',
        url: 'http://search.jd.com/Search?keyword=??1??&enc=utf-8&wq=??1??'
    }, {
        id: 'shopping_tmall',
        title: '天猫',
        url: 'https://list.tmall.com/search_product.htm?q=??1??'
    }, {
        id: 'shopping_amazon',
        title: '亚马逊',
        url: 'https://www.amazon.cn/s/ref=nb_sb_noss_1?__mk_zh_CN=??1??&field-keywords=??1??'
    }, {
        id: 'shopping_taobao',
        title: '淘宝',
        url: 'https://s.taobao.com/search?q=??1??'
    }]
}];

/**
 * 初始化整个整个菜单
 */
page.event.init = function() {
    var idx = 0;
    var menuSize = page.feild.selectionMenu.length;
    for (var menuGroupIdx in page.feild.selectionMenu) {
        var menuGroup = page.feild.selectionMenu[menuGroupIdx];

        // 菜单组
        chrome.contextMenus.create({
            type: 'normal',
            title: menuGroup.title,
            id: menuGroup.id,
            contexts: ['selection']
        });

        // 创建子菜单
        for (var menuItemIdx in menuGroup.items) {
            var menuItem = menuGroup.items[menuItemIdx];
            chrome.contextMenus.create({
                type: 'normal',
                title: menuItem.title,
                id: menuItem.id,
                contexts: ['selection'],
                parentId: menuGroup.id,
                onclick: function (info) {
                    for (var menuGroupIdx in page.feild.selectionMenu) {
                        var menuGroup = page.feild.selectionMenu[menuGroupIdx];
                        if (menuGroup.id == info.parentMenuItemId) {
                            for (var menuItemIdx in menuGroup.items) {
                                var menuItem = menuGroup.items[menuItemIdx];
                                if (menuItem.id == info.menuItemId) {
                                    page.func.openTab(menuItem.url, info.selectionText);
                                }
                            }
                        }
                    }
                }
            });
        }
    }
};

/**
 * 打开一个标签页
 * @param url 新标签页的地址，可以使用??1??，来替换后面给定的参数
 * @param args 参数值
 */
page.func.openTab = function(url, args) {
    console.log(url, args);
    var urlParts = url.split('??1??');
    if (urlParts.length <= 1) {
        return;
    }
    url = '';
    var urlPartsSize = urlParts.length;
    for (var part in urlParts) {
        url += urlParts[part];
        if (part < urlPartsSize - 1) {
            url += args;
        }
    }

    window.open(url, '_blank');
};

//function translate(info, tab) {
//    var url = 'http://www.bing.com/translator/?h_text=msn_ctxt&setlang=zh-cn&from=%E8%87%AA%E5%8A%A8%E6%A3%80%E6%B5%8B&to=zh-CHS&text=' + info.selectionText;
//    window.open(url, '_blank');
//}

function waitRead(info, tab) {
    alert(tab.title + '\n' + tab.url);
}

//chrome.contextMenus.create({
//    type: 'normal',
//    title: '使用Bing翻译',
//    id: 'trans',
//    contexts: ['selection'],
//    onclick: translate
//});

chrome.contextMenus.create({
    type: 'normal',
    title: '稍候阅读',
    id: 'read',
    contexts: ['page'],
    onclick: waitRead
});

(function() {
    page.event.init();
})();
