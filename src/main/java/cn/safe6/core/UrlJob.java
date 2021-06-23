package cn.safe6.core;

import cn.safe6.Controller;
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
    private String keys;

    public UrlJob(String url, String method, String header, String postData) {
        this.url = url;
        this.header = header;
        this.method = method;
        this.postData = postData;
    }

    public UrlJob(String url, String method, String keys) {
        this.url = url;
        this.keys = keys;
        this.method = method;
    }

    public UrlJob(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
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

        String res=null;
        try {
            System.out.println(url);
            if (method.equals(Constants.METHOD_GET)) {
                res = HttpTool.getHttpReuest(url, "application/x-www-form-urlencoded", "UTF-8");
            } else {
                res = HttpTool.postHttpReuest(url, postData, "UTF-8", "application/x-www-form-urlencoded");
            }

            if (res != null) {
                if (keys != null && !"".equals(keys.trim()) && res.contains(keys)) {
                    Controller.datas.add(new VulInfo(String.valueOf(Controller.datas.size() + 1), url, "存在"));
                }
                Controller.datas.add(new VulInfo(String.valueOf(Controller.datas.size() + 1), url, ""));

            }

            //System.out.println("result ");
            //System.out.println(res);

            // boolean flag = result.contains(uuid);


        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

//        System.out.println("线程:" + this.target + " -> 结束.");

        return res;
    }
}
