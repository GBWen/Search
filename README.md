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
不不不，其实是我的问题，后来我打了下log，发现是向百度请求数据过多，要求我输入验证码，这就很尴尬了，而且在浏览器端直接访问不需要输入验证码，后来我想了想，把cookies清了下，ok程序继续。
不不不，不是cookies的问题，刚才应该是正好封ip到时间了。。。可以想到的解决方法：程序sleep随机的秒数，或者使用代理ip，或者识别验证码或手动输入，但这就需要gui的东东了。
