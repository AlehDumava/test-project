package com.example.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "name")
@RequestScoped
public class ParsingBean implements Serializable {

    private String name;
    private int counter = 0;

    private static ArrayList<Link> link = new ArrayList<Link>();

    private Link selectedLink;
    private String onSelectedLink;

    public void parsing(String url) {
        counter = 0;
        link.clear();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements list = doc.select("a[href]");

            for (Element element : list.select("a")) {
                counter++;
                link.add(new Link(counter, element.text(), element.attr("abs:href")));
            }
            System.out.println("Total count: " + counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearForm() {
        counter = 0;
        link.clear();
        selectedLink = null;
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
        return selectedLink;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setSelectedLink(Link selectedLink) {
        this.selectedLink = selectedLink;
    }

    public int getCounter() {
        return counter;
    }

    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
    }

    public void linkIsAdd() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Link URL was added"));
    }

    public void onRowSelect(SelectEvent<Link> event) {
        FacesMessage msg = new FacesMessage("Link Selected", String.valueOf(event.getObject().getUrl()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        setName(event.getObject().getUrl());
        linkIsAdd();
    }

    public String getOnSelectedLink() {
        if(selectedLink != null) {
            return onSelectedLink = String.valueOf(selectedLink.getUrl());
        } else {
            return "Link not selected";
        }
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
