package ru.artamonov.entity;

import javax.persistence.*;

@Entity
@Table(name = "StatsWords")
public class StatsWords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private int id;

    @Column(name = "word")
    private String word;

    @Column(name = "count")
    private int count;

    @Column(name = "url_id")
    private int urlId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    @Override
    public String toString() {
        return "StatsWords{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", count=" + count +
                ", urlId=" + urlId +
                '}';
    }
}
