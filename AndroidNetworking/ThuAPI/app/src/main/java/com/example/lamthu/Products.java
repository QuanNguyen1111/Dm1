package com.example.lamthu;

public class Products {
    private String pid;
    private String name;
    private String price;
    private String created_at;
    private String updated_at;

    public Products(String pid, String name, String price, String created_at, String updated_at) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
