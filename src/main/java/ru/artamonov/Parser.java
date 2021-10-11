package ru.artamonov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Parser {
    public static void main(String[] args) throws IOException {
        String url = "https://www.simbirsoft.com";
        Document doc = Jsoup.connect(url).get();

        String string = doc.text();

        Character[] separators = {',', '.', '!', '?','"', ';', ':', '—', '-', '\'', '«', '»' , '/', '[', ']', '(', ')', '\n', '\r', '\t'};

        {
            String str[] = new String[1];
            str[0] = string;
            Arrays.stream(separators).forEach(sep -> str[0] = str[0].replace(sep, ' '));
            string = str[0];
        }

        String stringArr[] = string.split(" ");
        Arrays.stream(stringArr).forEach(word -> word  = word.toLowerCase());

        List<String> wordsList = Arrays.stream(stringArr).filter(word -> !word.equals("")).collect(Collectors.toList());

        TreeMap<String, Integer> words = new TreeMap<>();

        for (var word : wordsList) {
            /**  Если в слове нет букв, то пропускаем слово, т.е. не учитываем в статистике */

            if (word.toLowerCase().equals(word.toUpperCase())) { continue; }

            String wordLowerCase = word.toLowerCase();

            if (words.containsKey(wordLowerCase)) {
                words.put(wordLowerCase, words.get(wordLowerCase) + 1);
            } else {
                words.put(wordLowerCase, 1);
            }
        }

        words.forEach((key, value) -> System.out.println(key + "\t" + value));
    }
}
