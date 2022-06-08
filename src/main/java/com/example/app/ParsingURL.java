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

    public static void parsingURL() {
        try {
            Document document = Jsoup.connect("http://www.yandex.ru").get();

            Elements link = document.select("a[href]");

            for (Element element : link.select("a")) {
                System.out.println("Link: " + element.attr("abs:href"));
                System.out.println("Text: " + element.text());
                System.out.println("--------------- а --------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
