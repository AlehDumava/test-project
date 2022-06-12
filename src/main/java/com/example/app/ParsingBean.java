package com.example.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "name")
@RequestScoped
public class ParsingBean implements Serializable {

    private String name;
    private int counter=0;

    private static ArrayList<Link> link = new ArrayList<Link>();

    private Link selectedLink;

    public void parsing(String url) {
        counter = 0;
        link.clear();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements list = doc.select("a[href]");

            Thread.sleep(2000);

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearForm() {
        counter = 0;
        link.clear();
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

    public Link getSelectedLink() {
        System.out.println("Get Selected Link: " + selectedLink);
        return selectedLink;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setSelectedLink(Link selectedLink) {
        System.out.println("Set Selected Link: " + selectedLink);
        this.selectedLink = selectedLink;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "ParsingBean{" +
                "name='" + name + '\'' +
                ", counter=" + counter +
                ", selectedLink=" + selectedLink +
                '}';
    }
}
