package analysis;


import connection.ConnectionUtil;
import file.ToMysql;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analysis {
    /**
     * 通过页面获得网址列表
     * @param document  传入页面
     */
    public List<String> getUrlList(Document document){
        List urlList = new ArrayList();
        Elements elements = document.select("[class=\"list_14 p1_2 clearfix\"]");   //获得ul列表
        Elements liElements = elements.select("a");     //获得所有a标签
        for (Element li: liElements) {
            urlList.add(li.attr("href"));   //全部加入List
        }
        System.out.println(urlList);
        return urlList;
    }

    public void getContent(List<String> urlList){
        String urlHeader = "http://jhsjk.people.cn/";    //地址开头
        for (String url:urlList) {
            url = urlHeader + url;      //组成完全地址
            Document document = ConnectionUtil.Connect(url);    //连接网站获得页面
            Elements elements = document.select("[class=\"d2txt_con clearfix\"]");  //找到文字页面
            Elements content = elements.select("p");
            List<String> contentList = new ArrayList<String>();
            List<String> codeList = new ArrayList<String>();
            for (Element e:content
                 ) {
                contentList.add(e.text());      //所有内容都装入list
            }
            String allContent = contentList.toString();     //完整内容
//            allContent = allContent.substring(1,allContent.length()-1);     //去掉前后[]
            for (Element e:elements
                 ) {
                codeList.add(e.toString());
            }
            String allCode = codeList.toString();       //完整code
            String title = document.select("h1").text();    //得到title
            String timeAndSource = document.select("[class=\"d2txt_1 clearfix\"]").text();
            String source = "";
            String time = "";
            String sourceRegex = "来源.*\\s";     //来源正则
            String timeRegex = "[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
            //找到来源
            Pattern p = Pattern.compile(sourceRegex);
            Matcher matcher = p.matcher(timeAndSource);
            if (matcher.find()) {
                source = matcher.group(0);
                source = source.substring(3,source.length());   //截取掉来源：得到需要的信息
            }
            //找到时间
            p = Pattern.compile(timeRegex);
            matcher = p.matcher(timeAndSource);
            if (matcher.find()) {
                time = matcher.group(0);    //得到时间
            }
            ToMysql.toMysql(title,time,source,allContent,allCode,url);
        }

    }
}
