import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入

        String firstWordList = "";
        String secondWordList = "";
        try (Scanner inputOne = new Scanner(System.in)) {
            firstWordList = inputOne.nextLine();
            secondWordList = inputOne.nextLine();
        }

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行





    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码

        firstWordList = firstWordList.toUpperCase();
        secondWordList= secondWordList.toUpperCase();

        if(!isWordList(firstWordList)||!isWordList(secondWordList)) {
            throw new RuntimeException("input not");
        };

        List<String> list = new ArrayList<String>();
        Set treeSetResult = new TreeSet();
        List<String> result = new ArrayList<>();


        String [] first = null;
        String [] second = null;
        first = firstWordList.split(",");
        second = secondWordList.split(",");

        for(int i = 0; i < second.length; i++){
            for (int j = 0; j < first.length; j++) {
                if(first[j].equals(second[i])){
                    first[j] = first[j].replace("", " ").trim();
                    treeSetResult.add(first[j]);
                }

            }
        }
        System.out.println("treeSetResult:"+treeSetResult);
        result.addAll(treeSetResult);
        System.out.println("Result:"+result);

        return result;
    }

    private static boolean isWordList(String WordList) {
        // 创建一个匹配模式
        Pattern pattern = Pattern.compile("^[A-Z]*([A-Z]+[,])*([A-Z]+)$");
        Matcher matcher = pattern.matcher(WordList);
        return matcher.matches();
    }
}
