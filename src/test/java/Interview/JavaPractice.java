package Interview;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaPractice {

    public static void main (String[] args) {
//        String input = "Vivek";
//        System.out.println(getCharacterCount(input));

        // Second Largest Number
//        int[] arr = {10,25,5,20,30,15,30,25};
//        secondLargetNumber(arr);

        //Extract Numbers
//        String mixInput = "pran123tes45t";
//        extractNumbers(mixInput);

        //FInd Largest Numbers
//        int[] maxArr = {10,34,23,76,44};
//        findLargetNumber(maxArr);

        //Find word occurance
        String word = "I am learning learning for for for interview interview learning for tomorrow tomorrow I I I";
//        findWordOccurance(word);
//        countCharacters(word);
//        countCharactersAnotherWay(word,"o");
//        removeDuplicateWord(word);

        // check for ANAGRAM
//        String w1 = "FETTER";
//        String w2 = "tetefr";
//        validateAnagram(w1,w2);

        // Find first duplicate character
//        findFirstNonRepetingWord("programming");

        //Reverse a word
//        reverseAString("vivek prasad");

        //Extract String
        extractString("www.google.com");

        // Palindrome check
//        if (isPalindrome("kayak")) {
//            System.out.println("Palindrome");
//        }else {
//            System.out.println("Not Plaindrome");
//        }

        //Reverse each word in a sentence
//        reverseWordsInSentence("This is my world");

        //Find largest and smallest Number
//        findLargestSmallestNumber(new int[] {99,20,21,33,11,4,0,-11,-12,32});

        //Find Missing Number
//        findMissingNumber(new int[] {1,2,3,4,5,6,7,8,9});

        //Duplicate number is an array
//        findDupNumInArray(new int[] {2,3,4,2,3,6,4,7,8,9});

        //Reverse a number
//        reverseANumber(961256);

        //Fibonacci Seq
//        printFibinnaci(10);

        //Factorial
//        findFactorial(5);
//        System.out.println(findFactRecurssion(4));

        //Print Start Pattern
//        printStar(5);
//        printPyramidStart(5);

        //Update Array
//        String[] arr = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday"};
//        updateArr(arr);

        //Check Equals
//        checkEquals();

        //Check Leap year
//        checkLeapYear(2022);

        //ThreadSafe Collection
//        threadSafeCollection();

        //Switch Case
//        caseCheck();

        //String Buffer and Builder
//        checkString();

        //Duplicate values using Stream
//        findDuplicateUsingStream();

        //extract name from json
        extractNameFromJson();
    }


    public static String getCharacterCount(String input) {
        StringBuilder convertedString = new StringBuilder();
        // vivek
        Map<Character,Integer> charMap = new LinkedHashMap<>();

        for (char c : input.toLowerCase().toCharArray()){
            charMap.put(c,charMap.getOrDefault(c,0) +1);
        }

        for (Map.Entry<Character,Integer> entry : charMap.entrySet()){
            convertedString.append(entry.getKey()).append(entry.getValue());
        }
        return convertedString.toString();
    }

    public static void secondLargetNumber(int[] arr) {

        // TreeSet automatically sorts elements and only stores unique ones.
        TreeSet<Integer> unique = new TreeSet<>();
        for (int i : arr){
            unique.add(i);
        }

        int largest = unique.last();
        unique.remove(largest);
        int secondLargest = unique.last();

        System.out.println(secondLargest);

    }

    public static void extractNumbers(String input) {
        String numbers = input.replaceAll("[^0-9]","");
        System.out.println(numbers);
    }

    public static void findLargetNumber(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println(max);
        System.out.println(min);
    }

    public static void findWordOccurance (String word) {
        String[] wordArray = word.split(" ");
        Arrays.sort(wordArray);
        int count = 1;
        String curr = wordArray[0];
        for (int i=1;i<wordArray.length;i++) {
            if (curr.equals(wordArray[i])) {
                count++;
            }else {
                System.out.println(curr + " : " + count );
                curr = wordArray[i];
                count = 1;
            }
        }
        System.out.println(curr + " : " + count );
    }

    public static void countCharacters(String word){
        char[] ch = word.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 1;
        for (char c : ch){
            if (c != ' ') {

                map.put(c, map.getOrDefault(c,0)+1);
//                if (!map.containsKey(c)){
//                    map.put(c,count);
//                } else {
//                    map.put(c, map.get(c)+1);
//                }
            }
        }
        for (char key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    public static void countCharactersAnotherWay(String word, String c){
        int result = word.length() - word.replaceAll(c, "").length();
        System.out.println("Occurance of : "+ c + " is: "+ result);
    }

    public static void removeDuplicateWord (String word) {
        String[] s = word.split(" ");
        Set<String> newString = new LinkedHashSet<>();
        newString.addAll(Arrays.asList(s));
        String newSentence = "";
        for (String ws : newString){
            newSentence = newSentence +" "+ ws;
        }
        System.out.println(newSentence);

        // Another way
        Iterator<String> it = newString.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }

    public static void validateAnagram(String word1, String word2) {
        char[] c1 = word1.toLowerCase().toCharArray();
        char[] c2 = word2.toLowerCase().toCharArray();
        int count = 1;
        Map<Character,Integer> charMap1 = new HashMap<>();
        Map<Character,Integer> charMap2 = new HashMap<>();

        if (c1.length != c2.length) {
            System.out.println("Not an Anagram");
        } else {
            for (char c : c1){
                if (!charMap1.containsKey(c)){
                    charMap1.put(c,count);
                }else {
                    charMap1.put(c, charMap1.get(c)+1);
                    count = 1;
                }
            }
            count = 1;
            for (char c : c2){
                if (!charMap2.containsKey(c)){
                    charMap2.put(c,count);
                }else {
                    charMap2.put(c, charMap2.get(c)+1);
                    count = 1;
                }
            }
        }
        boolean isAnagram = true;
        TreeSet<Character> t1 = new TreeSet<>(charMap1.keySet());
        TreeSet<Character> t2 = new TreeSet<>(charMap2.keySet());
        if (!t1.equals(t2)){
            isAnagram = false;
        }else {
            for (char temp : charMap1.keySet()) {
                if (!charMap1.get(temp).equals(charMap2.get(temp))){
                    isAnagram = false;
                }
            }
        }
        if (isAnagram) {
            System.out.println("Anagram");
        }else {
            System.out.println("Not Anagram");
        }


        //another solution
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (Arrays.equals(c1,c2)) {
            System.out.println("Anagram");
        }else {
            System.out.println("Not an Anagram");
        }
    }

    public static void findFirstNonRepetingWord(String word) {
        char[] c = word.toCharArray();
        int count = 1;
        Map<Character,Integer> m1 = new LinkedHashMap<>();
        for (char ch : c){
            if (!m1.containsKey(ch)) {
                m1.put(ch,count);
            } else {
                m1.put(ch,m1.get(ch)+1);
            }
        }
        for (Character c2 : m1.keySet()) {
            if (m1.get(c2) >1) {
                System.out.println(c2 + " is the first duplicate character");
                break;
            }
        }
        for (Character c2 : m1.keySet()) {
            if (m1.get(c2) == 1) {
                System.out.println(c2 + " is the first non duplicate character");
                break;
            }
        }
    }

    public static void reverseAString(String word) {
        char[] c = word.toCharArray();
        String reversedWord = "";
        for (int i = c.length -1;i >= 0;i--){
            reversedWord = reversedWord + c[i];
        }
        System.out.println(reversedWord);

        // Another approach
        StringBuffer sb = new StringBuffer(word);
        System.out.println(sb.reverse());
    }

    public  static void extractString(String word){
        String firstFour = word.substring(0,4);
        String lastFour = word.substring(word.length()-4);
        String address = word.split("\\.")[1];
        String address1 = word.substring(4,word.length()-4);
        System.out.println(firstFour);
        System.out.println(lastFour);
        System.out.println(address);
        System.out.println(address1);
    }

    public static boolean isPalindrome(String word) { // Use Recursive method
        if (word==null) {
            return false;
        }
        if (word.length()<=1){
            return true;
        }
        String firstWord = word.substring(0,1);
        String lastWord = word.substring(word.length()-1);
        if (!firstWord.equals(lastWord)) {
            return false;
        }else {
            return isPalindrome(word.substring(1,word.length()-1));
        }
    }

    public static void reverseWordsInSentence(String sentence) {
        String[] str = sentence.split("\\s");
        String reversedSentence = "";
        for (String s1 : str) {
            String reversedWord = "";
            char[] c1 = s1.toCharArray();
            for (int i=c1.length-1;i>=0;i--){
                reversedWord = reversedWord + c1[i];
            }
            reversedSentence = reversedSentence + " " + reversedWord;
        }
        System.out.println(reversedSentence);
    }

    public static void findLargestSmallestNumber (int[] arr) {

        int minNumber = arr[0];
        int maxNumber = arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
            }else if (arr[i] < minNumber) {
                minNumber = arr[i];
            }
        }
        System.out.println("Min Number is: " + minNumber);
        System.out.println("Max number is: "+ maxNumber);

        //another approcah
        TreeSet<Integer> s1 = new TreeSet<> ();
        for (int i : arr) {
            s1.add(i);
        }

        Iterator<Integer> it = s1.iterator();
        System.out.println("Smallest: "+ it.next());
        int large=0;
        while (it.hasNext()){
            large = it.next();
        }
        System.out.println("Largest: "+ large);


        // Another approach
/*        Arrays.sort(arr);
        System.out.println("Largest: "+ arr[arr.length-1]);
        System.out.println("Smallest: "+ arr[0]);*/
    }

    public static void findMissingNumber (int[] arr) {
        int startNum = arr[0];
        int endNum = arr[arr.length-1];
        int maxSum = 0;
        for (int i = startNum;i<=endNum;i++){
            maxSum = maxSum + i;
        }
        int actualSum=0;
        for (int ni : arr) {
            actualSum = actualSum + ni;
        }
        if (maxSum-actualSum != 0){
            System.out.println("Missing num is: "+ (maxSum-actualSum));
        } else {
            System.out.println("No Missing Number");
        }
    }

    public static void findDupNumInArray(int[] arr) {
        Map<Integer,Integer> dup = new HashMap<>();
        int count = 1;
        for(int i=0;i<arr.length;i++){
            if (!dup.containsKey(arr[i])){
                dup.put(arr[i],count);
            }else {
                dup.put(arr[i],dup.get(arr[i])+ 1);
            }
        }
        for (int i : dup.keySet()){
            if (dup.get(i) > 1) {
                System.out.println(i);
            }
        }
    }

    public static void reverseANumber(int num) {

        int result = 0; // 1234
        while (num > 0) {
            result = result*10 + num%10;
            num = num / 10;
        }
        System.out.println(result);
    }

    public static void printFibinnaci(int n){ // 0 1 1 2 3 5 8
        int start = 0;
        int second = 1;
        for (int i=0;i<n-1;i++) {
            System.out.print(start + " ");
            int third = start + second;
            start = second;
            second = third;
        }
    }

    public static void findFactorial(int num) { // 5 4 3 2 1
        int fact = 1;
        for (int i=1;i<=num;i++){
            fact = fact * i;
        }
        System.out.println(fact);
    }

    public static int findFactRecurssion(int num) { // 4 3 2 1
        if (num <1){
            return 1;
        }else {
            return num * findFactRecurssion(num-1); // 5 4 3 2
        }
    }

    public static void printStar(int n) {
        for (int i = 1;i <=n ; i++){
            for (int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printPyramidStart(int n){ // 1 3 5 7
        int k = 1;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=k;j++) {
                System.out.print("*");
            }
            k +=2;
            System.out.println();
        }
    }

    public static void updateArr(String[] arr) {
        String[] out = new String[arr.length];
        for (int i=0;i<arr.length;i++) {
            out[i] = arr[i].substring(0,3);
        }
        System.out.println(Arrays.toString(out));
    }

    public static void checkEquals() {
        Integer i = 10;
        Integer j = 10;
        if (i == j) {
            System.out.println("It is equal");
        } else {
            System.out.println("This is not equal");
        }

        //----------
        List<Integer> li = Arrays.asList(15,22,25,43,45,75);
        li.stream().filter(k -> k % 5==0).forEach(System.out::println);
    }

    public static void checkLeapYear(int year) {
        boolean isLeap = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0){
                    isLeap = true;
                }
            }else {
                isLeap = true;
            }
        }

        if (isLeap) {
            System.out.println("is Leap");
        } else {
            System.out.println("Not Leap");
        }
    }

    public static void threadSafeCollection () {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = Collections.synchronizedSet(s1);
        s2.add("as");
        s2.add("ee");

        synchronized (s2) {
            for (String s : s2) {
                System.out.println(s);
            }
        }

        Map<String,String> m1 = new ConcurrentHashMap<>();
        m1.put("sdsd","sdsdwe");
        m1.put("rfrf","rggrg");

        for (String i : m1.keySet()){
            System.out.println(m1.get(i));
        }

        Iterator<String> it = m1.keySet().iterator();
        while(it.hasNext()){
            System.out.println(m1.get(it.next()));
        }
    }

    public static void caseCheck() {
        String s = "Test";
        switch (s) {
            default :
                System.out.println("Default");
                break;
            case "ABC" :
                System.out.println("ABC");
                break;
            case "EWQ" :
                System.out.println("EWQ");
                break;
            case "Test" :
                System.out.println("Test");
                break;

        }
    }

    public static void checkString() {
        StringBuffer sf = new StringBuffer();
        StringBuffer sf1 = new StringBuffer();
        sf.append("Test");
        sf.append("is");
        sf1.append("Test");
        sf1.append("Is");
        System.out.println(sf.toString().compareTo(sf1.toString()));
        System.out.println(sf);
        sf.reverse();
        System.out.println(sf);

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("This");
        sb1.append("is");
        sb.append("This");
        sb.append("Is");
        System.out.println(sb);
        System.out.println(sb.toString().compareTo(sb1.toString()));
    }

    public static void findDuplicateUsingStream() {
        List<String> list = Arrays.asList("Apple","Orange","Apple","Banana","Orange","Mango");

        Map<String,Long> duplicateMap = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Set<String> duplicateKey = duplicateMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println(duplicateKey);

    }

    public static void extractNameFromJson(){ //LTIMindtree Interview
        String json = "[\n" +
                "  {\n" +
                "    \"employeeId\": 1,\n" +
                "    \"name\": \"Alex ore\",\n" +
                "    \"jobTitle\": \"Senior Specialist - Quality Engineering\",\n" +
                "    \"department\": \"Quality Assurance\",\n" +
                "    \"location\": \"Karnataka\",\n" +
                "    \"active\": true\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 2,\n" +
                "    \"name\": \"Anita Desai\",\n" +
                "    \"jobTitle\": \"Software Engineer\",\n" +
                "    \"department\": \"Development\",\n" +
                "    \"location\": \"Hyderabad\",\n" +
                "    \"active\": true\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 3,\n" +
                "    \"name\": \"Ravi Kumar\",\n" +
                "    \"jobTitle\": \"DevOps Engineer\",\n" +
                "    \"department\": \"Infrastructure\",\n" +
                "    \"location\": \"Bangalore\",\n" +
                "    \"active\": false\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 4,\n" +
                "    \"name\": \"Meera Joshi\",\n" +
                "    \"jobTitle\": \"Data Analyst\",\n" +
                "    \"department\": \"Analytics\",\n" +
                "    \"location\": \"Pune\",\n" +
                "    \"active\": true\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 5,\n" +
                "    \"name\": \"Suresh Patil\",\n" +
                "    \"jobTitle\": \"Project Manager\",\n" +
                "    \"department\": \"PMO\",\n" +
                "    \"location\": \"Mumbai\",\n" +
                "    \"active\": true\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 6,\n" +
                "    \"name\": \"Priya Nair\",\n" +
                "    \"jobTitle\": \"UX Designer\",\n" +
                "    \"department\": \"Design\",\n" +
                "    \"location\": \"Chennai\",\n" +
                "    \"active\": false\n" +
                "  }";

        String nameRegex = "\"name\"\\s*:\\s*\"([^\"]*)\"";
        String deptRegex = "\"department\"\\s*:\\s*\"([^\"]*)\"";
        Pattern p = Pattern.compile(nameRegex);
        Matcher m = p.matcher(json);
        Pattern p1 = Pattern.compile(deptRegex);
        Matcher m1 = p1.matcher(json);

        while (m.find() && m1.find()){
            String name = m.group(1);
            String dept = m1.group(1);
            System.out.println(name +" : "+ dept);
        }
    }
}
