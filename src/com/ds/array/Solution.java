package com.ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<Log> wordLogs = new ArrayList<>();
        List<Log> numberLogs = new ArrayList<>();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < logFileSize; i++) {
            String id = logLines.get(i).split(" ")[0];
            String originalLog = logLines.get(i);
            String remainingLog = originalLog.split(" ", 2)[1];
            if (checkAllLowerCaseCharacters(remainingLog.replaceAll("\\s+",""))) {
                Log log = new Log(id, originalLog);
                wordLogs.add(log);
            } else if (checkAllNumbers(remainingLog.replaceAll("\\s+",""))) {
                Log log = new Log(id, originalLog);
                numberLogs.add(log);
            }
        }
        Collections.sort(wordLogs, new LogComparator());
        wordLogs.addAll(numberLogs);
        for (Log log : wordLogs)
            results.add(log.originalLog);
        return results;
    }

    public boolean checkAllLowerCaseCharacters(String text) {
        return text.matches("[a-zA-Z]+");
    }

    public boolean checkAllNumbers(String text) {
        try {
            Integer.parseInt(text);
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

    public static void main(String args[]) {
        List<String> logLines = new ArrayList<>();
        //logLines.add("a1 9 2 3 1");
        logLines.add("b100 off key dog");
        logLines.add("ad200 off key dog");
        //logLines.add("a8 act zoo");
        //logLines.add("g1 act car");
        //logLines.add("z04 4 7");

        Solution solution = new Solution();
        List<String> results = solution.reorderLines(2, logLines);
        for (String result : results)
            System.out.println(result);
    }

}

class Log {
    String id;
    String originalLog;
    String remainingLog;

    public Log(String id, String originalLog) {
        this.id = id;
        this.originalLog = originalLog;
        this.remainingLog = originalLog.split(" ", 2)[1];
    }
}

class LogComparator implements Comparator<Log> {

    Pattern p = Pattern.compile("^([0-9]+)([a-z]?)$");

    int getSortOrder(String s) {
        Matcher m = p.matcher(s);
        if(!m.matches()) return 0;
        int major = Integer.parseInt(m.group(1));
        int minor = m.group(2).isEmpty() ? 0 : m.group(2).charAt(0);
        return (major << 8) | minor;
    }

    @Override
    public int compare(Log log1, Log log2) {
        int result = log1.remainingLog.compareTo(log2.remainingLog);
        if (result == 0)
            return getSortOrder(log1.id) - getSortOrder(log2.id);
        else
            return result;
    }
}
