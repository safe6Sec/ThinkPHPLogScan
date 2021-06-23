## ThinkPHPLogScan
支持tp3和tp5日志泄露文件扫描

![img](img/20210624000443.png)


## 说明
这算是Safe6武器库的第二个轮子。这个轮子之前用frame写的，由于比较简陋没放出来。最近心血来潮用javafx改造了一下就直接开源出来了。
我打算后续轮子全部改用javafx进行开发。
1. dirScan
2. ThinkPHPLogScan

造轮子真的很有趣，即能提升渗透效率，又能学习漏洞原理。

## 扫描规则
目前规则还不够全面，需要大家一起完善。

现有日志路径如下：  
```
TP3
/Runtime/Logs/  
/App/Runtime/Logs/
/Application/Runtime/Logs/Admin/
/Application/Runtime/Logs/Home/
/Application/Runtime/Logs/App/
/Application/Runtime/Logs/Ext/
/Application/Runtime/Logs/Api/
/Application/Runtime/Logs/Test/
/Application/Runtime/Logs/Common/
/Application/Runtime/Logs/Service/
/Application/Runtime/Logs/
TP5
/runtime/log/
```
现有日志格式如下：
时间戳前缀的log，开发中
```
tp3
19_01_01.log
1550651608-19_02_20.log
tp5
/runtime/log/201808/07.log
/runtime/log/201808/07_cli.log

```



## 致谢
剑仙大佬demo项目提供ui  
https://github.com/yhy0/ExpDemo-JavaFX


## 0x05 免责声明

本工具仅能在取得足够合法授权的企业安全建设中使用，在使用本工具过程中，您应确保自己所有行为符合当地的法律法规。

如您在使用本工具的过程中存在任何非法行为，您将自行承担所有后果，本工具所有开发者和所有贡献者不承担任何法律及连带责任。

除非您已充分阅读、完全理解并接受本协议所有条款，否则，请您不要安装并使用本工具。

您的使用行为或者您以其他任何明示或者默示方式表示接受本协议的，即视为您已阅读并同意本协议的约束。











