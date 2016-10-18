import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * Created by gbw on 16-10-17.
 */

public class GetName
{
    public void GetData()
    {
        try
        {

            JsonParser parser=new JsonParser();  //创建JSON解析器
            //JsonObject object=(JsonObject) parser.parse(new FileReader("/home/gbw/IdeaProjects/Search/世界AI公司.json"));
            //FileWriter fw = new FileWriter("/home/gbw/IdeaProjects/Search/in(全球).txt");
            JsonObject object=(JsonObject) parser.parse(new FileReader("/home/gbw/IdeaProjects/Search/中国AI公司(全称).json"));
            FileWriter fw = new FileWriter("/home/gbw/IdeaProjects/Search/in(中国).txt");
            JsonArray array=object.get("gbw").getAsJsonArray();    //得到为json的数组
            for(int i=0;i<array.size();i++)
            {
                JsonObject subObject=array.get(i).getAsJsonObject();
                fw.write(subObject.get("name").getAsString() + "\n");
            }

        }
        catch (JsonIOException e)
        {
            e.printStackTrace();
        }
        catch (JsonSyntaxException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}