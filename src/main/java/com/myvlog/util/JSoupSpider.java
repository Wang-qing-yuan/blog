package com.myvlog.util;

import com.myvlog.entity.Book;
import com.myvlog.entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mq_xu
 * @ClassName JSoupSpider
 * @Description JSoup实现的一个爬虫工具
 * @Date 9:13 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpider {
    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);

    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(DataUtil.getMobile());
                user.setPassword(DataUtil.getPassword());
                user.setGender(DataUtil.getGender());

                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setNickname(linkChildren.get(1).text());
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(DataUtil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }

    public static List<Book> getBooks() {
        Document document = null;
        List<Book> bookList = new ArrayList<>(100);
        int j = 0;
        for (int i = 0; i <= 180; ) {
            try {
                document = Jsoup.connect("https://book.douban.com/review/best/?start=" + i).get();
            } catch (IOException e) {
                logger.info("连接失败");
            }
            Elements cards = document.getElementsByClass("main review-item");
            cards.forEach(card -> {
                Element img = card.child(0).child(0);
                Element name = card.child(1).child(1);
                Element title = card.child(2).child(0);
                Element content = card.child(2).child(1).child(0);
                Element like = card.child(2).child(3).child(0).child(1);
//                String publishTime =null;
//                Element publishTime = card.child(1).child(2).text();
                int n = card.child(1).children().size()-1;
                Element data = card.child(1).child(n);
                Book book = new Book();
                book.setTitle(title.text());
                book.setContent(content.text());
                book.setCover(img.attr("src"));
                book.setDiamond(new Random().nextInt(100));
                book.setNickname(name.text());
                book.setComments(new Random().nextInt(100));
                book.setLikes(Integer.valueOf(like.text()));
//                book.setPublishTime(Timestamp.valueOf(publishTime).toLocalDateTime());
                bookList.add(book);
            });
            j++;
            i = j * 2 * 10;
        }
        return bookList;
    }


   
}
