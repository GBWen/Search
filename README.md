Search
===

已知各个AI公司信息的JSON，对公司的影响力做一个排名。
现在让我做的是基于搜索引擎的那部分，目前做了基于百度搜索的条目数。
我是使用java完成。

1.GetName
---
基于gson 的jar包，解析json文件，找到数组中name的value，打印到in.txt。

2.SearchCount
---
主函数，调用GetName，然后输入in.txt，调用BaiduSearhCount，返回搜索条目数。

3.BaiduSearchCount
---
使用jsoup的jar包，正则表达式匹配到搜索条目数，然后返回结果。

使用jsoup的时候有个怪怪的问题：
Document document = Jsoup.connect(url).get();
Document document = Jsoup.connect(url).timeout(5000).get();
有时设置超时时间连不上返回空指针，有时不设置就怎么也连不上，MDZZ。。。
