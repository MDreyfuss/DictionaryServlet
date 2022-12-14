package dictionary;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class ScrabbleDictionary {

    private HashMap<String, String> words = new HashMap<>();

    public ScrabbleDictionary()
    {
        InputStream dictionary = ScrabbleDictionary.class.getResourceAsStream("dictionary.txt");

        Scanner readFile = new Scanner(dictionary);
        while (readFile.hasNextLine())
        {
            String line = readFile.nextLine();
            String[] entry = line.split(" ", 2);
            if (entry.length == 1)
            {
                words.put(entry[0], "");
            }
            else
            {
                words.put(entry[0], entry[1]);
            }
        }
    }

    public boolean isWord(String lookUpWord)
    {
        return getDefinition(lookUpWord) != null;
    }

    public String getDefinition(String lookUpWord)
    {
        String lookUpWordUpper = lookUpWord.toUpperCase();
        String result = words.get(lookUpWordUpper);
        if (result == null)
        {
            result = "Definition unavailable.";
        }
        return result;
    }
}
