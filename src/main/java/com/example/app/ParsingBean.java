package com.example.app;


import javax.faces.bean.ManagedBean;
import javax.faces.context.SessionMap;
import java.io.Serializable;


@ManagedBean(name = "obj")
@SessionMap
public class ParsingBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
