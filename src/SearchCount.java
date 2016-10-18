import java.io.*;

/**
 * Created by gbw on 16-10-17.
 */

public class SearchCount
{
    public static void main(String[] args)
    {
        GetName g = new GetName();
        g.GetData();

        try
        {
            FileReader fr = new FileReader("/home/gbw/IdeaProjects/Search/in(中国).txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("/home/gbw/IdeaProjects/Search/baidu.out(中国).txt");
            int Num = 0;
            while(br.ready())
            {
                String keyWord = br.readLine();
                if (keyWord != null)
                {
                    Num = Num + 1;
                    int baiduCount = 0;
                    int start = 0;
                    int end = keyWord.length();
                    int index = keyWord.indexOf("/");
                    while (index != -1 )
                    {
                        String sub = keyWord.substring(start,index);
                        sub = sub.trim();
                        BaiduSearchCount baidu = new BaiduSearchCount();
                        baiduCount = baiduCount + baidu.Search(sub);
                        //System.out.println(sub);
                        start = index+1;
                        index = keyWord.indexOf("/",start);
                    }
                    String sub = keyWord.substring(start,end);
                    sub = sub.trim();
                    BaiduSearchCount baidu = new BaiduSearchCount();
                    baiduCount = baiduCount + baidu.Search(sub);
                    //System.out.println(sub);
                    System.out.println(Num+ " " + keyWord + " " + baiduCount);
                    fw.write(keyWord);
                    fw.write(" / ");
                    fw.write(baiduCount + "\n");
                }
            }
            fr.close();
            br.close();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
