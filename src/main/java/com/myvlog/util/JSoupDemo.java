package com.myvlog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * JSoup分析器
 */
public class JSoupDemo {
    public static void main(String[] args) throws Exception {
//        声明文档变量
        Document document;
//        通过JSoup连接目标页面
        document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
//        选取所有class为col-xs-8的元素集合
        Elements divs= document.getElementsByClass("col-xs-8");
//        对divs遍历
        divs.forEach(div->{
//            取出class为wrap的节点
            Element wrapDiv = div.child(0).child(0).child(1);
            System.out.println(wrapDiv.text());
        });

        System.out.println(JSoupSpider.getBooks().size());


    }
}
