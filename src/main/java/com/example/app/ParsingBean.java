package com.example.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "name")
@SessionScoped
public class ParsingBean implements Serializable {

    private String name;
    private int counter=0;

    private static ArrayList<Link> link = new ArrayList<Link>();

    public int getCounter() {
        return counter;
    }

    public void parsing(String url) {
        counter = 0;
        link.clear();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements list = doc.select("a[href]");

            for (Element element : list.select("a")) {
                counter++;

                link.add(new Link(counter, element.text(), element.attr("abs:href")));

                System.out.println("Count: " + counter);
                System.out.println("Link: " + element.attr("abs:href"));
                System.out.println("Name: " + element.text());
            }
            System.out.println("Total count: " + counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ParsingBean() {
    }

    public ArrayList<Link> getLink() {
        return link;
    }

    public void setLink(ArrayList<Link> link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
