package ru.artamonov.entity;

import javax.persistence.*;

@Entity
@Table(name = "Urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private int id;

    @Column(name = "url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
