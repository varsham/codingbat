package com.varsha;

import java.util.HashMap;
import java.util.Map;

public class Map2 {

/* word0
Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, always with the value 0. For example the string "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.

word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
*/
public Map<String, Integer> word0(String[] strings) {
          Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])) {
                map.put(strings[i], 0);
            }
        }
        
        return map;
}

/* wordLen
Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.

wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
*/
public Map<String, Integer> wordLen(String[] strings) {
          Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])) {
                map.put(strings[i], strings[i].length());
            }
        }
        
        return map;
}

/* pairs
Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its first character as a key with its last character as the value.

pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
*/
public Map<String, String> pairs(String[] strings) {
          Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(Character.toString(strings[i].charAt(0)))) {
                map.put(Character.toString(strings[i].charAt(0)), Character.toString(strings[i].charAt(strings[i].length() - 1)));
            } else {
                map.put(Character.toString(strings[i].charAt(0)), Character.toString(strings[i].charAt(strings[i].length() - 1)));
            }
        }
        return map;
}

/* firstChar
Given an array of non-empty strings, return a Map<String, String> with a key for every different first character seen, with the value of all the strings starting with that character appended together in the order they appear in the array.

firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
firstChar([]) → {}
*/
public Map<String, String> firstChar(String[] strings) {
          Map<String, String> map = new HashMap<String, String>();
          if (strings.length == 0) return map;
        for (int i = 0; i < strings.length; i++) {
            String f = Character.toString(strings[i].charAt(0));
            if (!map.containsKey(f)) {
                map.put(f, strings[i]);
            } else if (map.containsKey(f)) {
                map.put(f, map.get(f) + strings[i]);
            }
        }
        
        if (!map.containsKey(strings[strings.length - 1].substring(0, 1))) {
            map.put(strings[strings.length - 1].substring(0, 1), strings[strings.length - 1]);
        }
        
        return map;
}

/* wordAppend
Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty string if no string appears a 2nd time.

wordAppend(["a", "b", "a"]) → "a"
wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
wordAppend(["a", "", "a"]) → "a"
*/
public String wordAppend(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  String r = "";
  for (int i = 0; i < strings.length; i++) {
    if (!map.containsKey(strings[i])) map.put(strings[i], 1);
    else map.put(strings[i], map.get(strings[i]) + 1);
    
    if (map.get(strings[i]) % 2 == 0) r += strings[i];
  }
  
  return r;
}

/* wordMultiple
Given an array of strings, return a Map<String, Boolean> where each different string is a key and its value is true if that string appears 2 or more times in the array.

wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
wordMultiple(["c", "c", "c", "c"]) → {"c": true}
*/
public Map<String, Boolean> wordMultiple(String[] strings) {
  Map<String, Boolean> map = new HashMap<String, Boolean>();
  
  for (int i = 0; i < strings.length; i++) {
    if (map.containsKey(strings[i])) {
      map.put(strings[i], true);
    } else {
      map.put(strings[i], false);
    }
  }
  
  return map;
}

/* allSwap
We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. When a position in the array has been swapped, it no longer matches anything. Using a map, this can be solved making just one pass over the array. More difficult than it looks.

allSwap(["ab", "ac"]) → ["ac", "ab"]
allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
*/
public String[] allSwap(String[] strings) {
    String[] result=new String[strings.length];
  Map<Character, Integer> map = new HashMap<Character, Integer>();
  for (int i = 0; i < strings.length; i++) {
    if (map.containsKey(strings[i].charAt(0)))
    {
      int temp = map.get(strings[i].charAt(0));
      map.remove(strings[i].charAt(0));
      result[i]=result[temp];
      result[temp]=strings[i];
    }
    else
    {
      result[i]=strings[i];
      map.put(strings[i].charAt(0),i);
    }
  }
return result;
}

/* firstSwap
We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. A particular first char can only cause 1 swap, so once a char has caused a swap, its later swaps are disabled. Using a map, this can be solved making just one pass over the array. More difficult than it looks.

firstSwap(["ab", "ac"]) → ["ac", "ab"]
firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
*/
public String[] firstSwap(String[] strings) {
  String[] r = new String[strings.length];
  Map<Character, Integer> map = new HashMap<Character, Integer>();
  for (int i = 0; i < strings.length; i++) {
    char c = strings[i].charAt(0);
    if (map.containsKey(c) && map.get(c) != -1) {
      int temp = map.get(c);
      map.put(c, -1);
      
      r[i] = r[temp];
      r[temp] = strings[i];
    } else if (!map.containsKey(c) || map.get(c) == -1) {
      r[i] = strings[i];
      
      if (!map.containsKey(c)) {
        
        map.put(c, i);
      }
      
    }
  }
return r;
}
/*

The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.


wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
wordCount(["c", "c", "c", "c"]) → {"c": 4}

 */

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])) {
                map.put(strings[i], 1);
            } else if (map.containsKey(strings[i])) {
                int n = map.get(strings[i]);
                n++;
                map.put(strings[i], n);
            }
        }

        return map;
    }


}

