package ru.artamonov;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CounterWords {
    public static List<String> getWords(String string) {
        Character[] separators = {
                ',', '.', '!', '?',
                '"', ';', ':', '—',
                '-', '\'', '«', '»',
                '/', '[', ']', '(',
                ')', '\n', '\r', '\t'
        };

        {
            String[] str = new String[1];
            str[0] = string;
            Arrays.stream(separators).forEach(sep -> str[0] = str[0].replace(sep, ' '));
            string = str[0];
        }

        String[] stringArr = string.split(" ");
        Arrays.stream(stringArr).forEach(word -> word  = word.toLowerCase());

        List<String> wordsList = Arrays.stream(stringArr).filter(word -> !word.equals("")).collect(Collectors.toList());

        return wordsList;
    }

    public static TreeMap<String, Integer> getStats(List<String> wordsList) {
        TreeMap<String, Integer> words = new TreeMap<>();

        for (var word : wordsList) {
            /*  Если в слове нет букв, то пропускаем слово, т.е. не учитываем в статистике слов */
            if (word.toLowerCase().equals(word.toUpperCase())) { continue; }

            String wordLowerCase = word.toLowerCase();

            if (words.containsKey(wordLowerCase)) {
                words.put(wordLowerCase, words.get(wordLowerCase) + 1);
            } else {
                words.put(wordLowerCase, 1);
            }
        }

        return words;
    }

}
