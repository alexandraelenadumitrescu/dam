package com.example.test2.domain;

import java.util.Date;

public class Obiect {
    private String string;
    private Date data;
    Enumeratie enumeratie;
    private String bool;

    public Obiect(String string, Date data, Enumeratie enumeratie, String bool) {
        this.string = string;
        this.data = data;
        this.enumeratie = enumeratie;
        this.bool = bool;
    }

    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        return "Obiect{" +
                "string='" + string + '\'' +
                ", data=" + data +
                ", enumeratie=" + enumeratie +
                ", bool=" + bool +
                '}';
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Enumeratie getEnumeratie() {
        return enumeratie;
    }

    public void setEnumeratie(Enumeratie enumeratie) {
        this.enumeratie = enumeratie;
    }

    public String isBool() {
        return bool;
    }

    public void setBool(String bool) {
        this.bool = bool;
    }
}
