# peopleSpider
人民网-习近平系列重要讲话爬虫，Java简单爬虫，Jsoup爬虫  
这次不太一样的是在于之前一直使用Java基本的实现爬虫，这次用了Jsoup更方便，更简单了。然后输出不再是Txt文档，而是直接写入数据库了。
## 需求  
[http://jhsjk.people.cn/result/](http://jhsjk.people.cn/result/1?keywords=&year=0&button=%E6%90%9C%E7%B4%A2)  
从这个网站获取网站列表  
[![H_N_LTW_7_T_KA8_T_R_S0.png](https://s26.postimg.cc/7fyuj8cbt/H_N_LTW_7_T_KA8_T_R_S0.png)](https://postimg.cc/image/7sq8peulh/)  
再获取目标页面的信息  
[![H57_U_NU_JMO_8_L6_BKJ33_M.png](https://s26.postimg.cc/v6y81ehop/H57_U_NU_JMO_8_L6_BKJ33_M.png)](https://postimg.cc/image/8i911u0at/)  
最后写入数据库  
## 解决思路
思维导图：  
[![OUEY_F2_IC_I1_YWW_CQNG.png](https://s26.postimg.cc/vwh0dui95/OUEY_F2_IC_I1_YWW_CQNG.png)](https://postimg.cc/image/c1uyrq31h/)  
## 结果
数据库结果：  
[![ID_7_RXXR69_3_B_JU7_W_B.png](https://s26.postimg.cc/isby7itrd/ID_7_RXXR69_3_B_JU7_W_B.png)](https://postimg.cc/image/dtofszpyd/)