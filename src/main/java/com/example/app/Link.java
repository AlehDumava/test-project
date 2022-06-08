package com.example.app;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "link")
public class Link {

    private Integer id;
    private String name;
    private String url;

    public Link(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Link() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
