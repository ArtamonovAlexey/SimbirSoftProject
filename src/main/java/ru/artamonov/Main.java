package ru.artamonov;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // https://www.simbirsoft.com
        System.out.print("Введите URL-адрес: ");
        String url = (new Scanner(System.in)).next();

        String text = "";
        try {
            text = ParserHtml.getText(url);
        } catch (Exception e) {
            System.out.println("Ошибка подключения\nПроверьте наличие интернета или убедитесь в корректности адреса");
        }

        if (!text.equals("")) {
            TreeMap<String, Integer> treeMap = CounterWords.getStats(CounterWords.getWords(text));

            treeMap.forEach((word, count) -> System.out.println(word + "\t" + count));
        }
    }
}
