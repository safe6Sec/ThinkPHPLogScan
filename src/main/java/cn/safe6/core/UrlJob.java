package cn.safe6.core;

import cn.safe6.tools.HttpTool;
import cn.safe6.tools.Tools;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Callable;



public class UrlJob implements Callable<String> {
    private String url;
    private String header;
    private String method;
    private String postData;

    public UrlJob(String url,String method, String header) {
        this.url = url;
        this.header = header;
        this.method = method;
    }

    public UrlJob(String url,String postData) {
        this.url = url;
        this.postData = postData;
    }

    public UrlJob(String url) {
        this.url = url;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String call() throws Exception {

//        System.out.println("线程:" + this.target + " -> 运行...");

        String res ;
        try {
            if (method.equals(Constants.METHOD_GET)){
                res= HttpTool.getHttpReuest(url,"application/x-www-form-urlencoded","UTF-8");
            }else {
                res = HttpTool.postHttpReuest(url, postData, "UTF-8", "application/x-www-form-urlencoded");
            }

            System.out.println("result ");
            System.out.println(res);

           // boolean flag = result.contains(uuid);


        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

//        System.out.println("线程:" + this.target + " -> 结束.");

        return res;
    }
}
