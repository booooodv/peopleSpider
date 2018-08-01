package main;

import analysis.Analysis;
import connection.ConnectionUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        String urlHeader = "http://jhsjk.people.cn/result/";
        String urlTail = "?keywords=&year=0&button=%E6%90%9C%E7%B4%A2";
        for (int i = 1; i <= 42;i++){
            String url = urlHeader + i + urlTail;   //完整的url
            List<String> urlList = analysis.getUrlList(ConnectionUtil.Connect(url));
            analysis.getContent(urlList);
        }
    }
}
