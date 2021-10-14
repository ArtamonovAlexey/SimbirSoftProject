package ru.artamonov;

import ru.artamonov.dao.StatsWordsDao;
import ru.artamonov.dao.UrlDao;
import ru.artamonov.entity.StatsWords;
import ru.artamonov.entity.Url;
import ru.artamonov.util.HibernateUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // -> https://www.simbirsoft.com <-
        System.out.print("Введите URL-адрес: ");
        String urlName = (new Scanner(System.in)).next();

        String text = "";
        try {
            text = ParserHtml.getText(urlName);
        } catch (Exception e) {
            System.out.println("Ошибка подключения\nПроверьте наличие интернета или убедитесь в корректности адреса");
        }

        if (!text.equals("")) {
            TreeMap<String, Integer> treeMap = CounterWords.getStats(CounterWords.getWords(text));

            StatsWordsDao statsWordsDao = new StatsWordsDao(HibernateUtil.getSessionFactory());

            Url url = new Url();
            url.setUrl(urlName);

            UrlDao urlDao = new UrlDao(HibernateUtil.getSessionFactory());
            url = urlDao.create(url);


            Url finalUrl = url;
            treeMap.forEach((word, count) -> {
                StatsWords statsWords = new StatsWords();

                statsWords.setWord(word);
                statsWords.setCount(count);
                statsWords.setUrlId(finalUrl.getId());
                statsWordsDao.create(statsWords);
            });
        }
    }
}
