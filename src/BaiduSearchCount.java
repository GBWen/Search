import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by gbw on 16-10-17.
 */

public class BaiduSearchCount
{
    public int Search(String keyWord)
    {
        String url = "http://www.baidu.com/s?pn="+0+"&wd=" + keyWord;
        try
        {
            Document document = Jsoup.connect(url).timeout(5000).get();
            String cssQuery = "html body div div div div.nums";
            Element totalElement = document.select(cssQuery).first();
            String totalText = null;
            totalText = totalElement.text();
            String regEx="[^0-9]";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(totalText);
            totalText = matcher.replaceAll("");
            int total = Integer.parseInt(totalText);
            return total;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
}
