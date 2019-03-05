package org.epamtasks.part4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeyWords {

    public static List<String> keyWordsList() {
        ArrayList<String> keyWords = new ArrayList<>();
        keyWords.add("abstract");
        keyWords.add("assert");
        keyWords.add("boolean");
        keyWords.add("break");
        keyWords.add("byte");
        keyWords.add("case");
        keyWords.add("catch");
        keyWords.add("char");
        keyWords.add("class");
        keyWords.add("const");
        keyWords.add("continue");
        keyWords.add("default");
        keyWords.add("do");
        keyWords.add("double");
        keyWords.add("else");
        keyWords.add("enum");
        keyWords.add("extends");
        keyWords.add("final");
        keyWords.add("finally");
        keyWords.add("float");
        keyWords.add("for");
        keyWords.add("goto");
        keyWords.add("if");
        keyWords.add("implements");
        keyWords.add("import");
        keyWords.add("instanceof");
        keyWords.add("int");
        keyWords.add("interface");
        keyWords.add("long");
        keyWords.add("native");
        keyWords.add("new");
        keyWords.add("package");
        keyWords.add("privat");
        keyWords.add("protected");
        keyWords.add("public");
        keyWords.add("return");
        keyWords.add("short");
        keyWords.add("static");
        keyWords.add("strictfp");
        keyWords.add("super");
        keyWords.add("switch");
        keyWords.add("synchronized");
        keyWords.add("this");
        keyWords.add("throw");
        keyWords.add("throws");
        keyWords.add("transient");
        keyWords.add("try");
        keyWords.add("void");
        keyWords.add("volatile");
        keyWords.add("while");
        return keyWords;
    }

    static HashMap<String, Integer> keyWordsCounter(String str) {
        HashMap<String, Integer> keyWordsCounter = new HashMap<>();

        String[] strWords = str.split("[\\s\\\\;\\\\.\\\\!\\\\@\\\\,\\\\(\\\\)\\\\{\\\\}\\\\+\\\\=\\\\<\\\\>]");

        List<String> keyWords = KeyWords.keyWordsList();
         for (String word : keyWords) {
             int counter = 0;
             for (String strWord : strWords) {
                 if (word.equals(strWord)) {
                     counter++;
                 }
             }
             if (counter > 0) {
                 keyWordsCounter.put(word, counter);
             }
         }
         return keyWordsCounter;
    }

}
