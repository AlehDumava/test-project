package com.example.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;

@ManagedBean
@ViewScoped
public class ParsingURL {

    public static void parsing(String url) throws IOException {

        Document doc = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

        Elements list = doc.select("a[href]");

        for (Element element : list.select("a")) {
            System.out.println(element.text());
        }
    }
}
