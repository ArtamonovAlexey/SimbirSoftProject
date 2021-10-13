package ru.artamonov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ParserHtml {
    public static String getText(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        String string = doc.text();

        return string;
    }

}
