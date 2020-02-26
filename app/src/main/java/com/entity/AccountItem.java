package com.entity;

public class AccountItem {
    private int id;
    private String data;
    public AccountItem() {
    }

    public AccountItem(String data) {
        this.data = data;
    }

    public AccountItem(int id,String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AccountItem{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
