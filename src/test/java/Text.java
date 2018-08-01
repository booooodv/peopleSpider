import analysis.Analysis;
import connection.ConnectionUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    @Test
    public void textGetUrlList(){
        Analysis analysis = new Analysis();
        analysis.getUrlList(ConnectionUtil.Connect("http://jhsjk.people.cn/result/?keywords=&year=0&button=%E6%90%9C%E7%B4%A2"));
    }

    @Test
    public  void textSelect(){
        Document document = ConnectionUtil.Connect("http://jhsjk.people.cn/article/20889675");
        Elements elements = document.select("[class=\"d2txt_con clearfix\"]");
        Elements elements1 = elements.select("p");
        for (Element e:elements
                ) {
            System.out.println(e);
        }
    }

    @Test
    public void regex(){
        String str = "来源：新华网          发布时间：2013-03-17";
        String sourceRegex = "来源.*\\s";
        String timeRegex = "[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
        Pattern p = Pattern.compile(timeRegex);
        Matcher matcher = p.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));
        }
    }
}
