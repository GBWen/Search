import java.io.*;

/**
 * Created by gbw on 16-10-17.
 */

public class SaerchCount
{
    public static void main(String[] args)
    {
//        GetName g = new GetName();
//        g.GetData();

        try
        {
            FileReader fr = new FileReader("/home/gbw/IdeaProjects/Search/in.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("/home/gbw/IdeaProjects/Search/out2.txt");
            int Num = 0;
            while(br.ready())
            {
                String keyWord = br.readLine();
                if (keyWord != null)
                {
                    //System.out.print(keyWord);
                    Num = Num + 1;
                    BaiduSearchCount baidu = new BaiduSearchCount();
                    int baiduCount = baidu.Search(keyWord);
                    System.out.println(Num+ " " + keyWord + " " + baiduCount);
                    fw.write(keyWord);
                    fw.write(",");
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
