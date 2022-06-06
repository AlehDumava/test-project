package com.example.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParsingURL {

    public static void parsingURL(String url) throws IOException {

        Document doc = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

        Elements list = doc.select("div#tabnews_newsc.content-tabs__items.content-tabs__items_active_true");

        for (Element element : list.select("a")) {
            System.out.println(element.text());
        }
    }
}
