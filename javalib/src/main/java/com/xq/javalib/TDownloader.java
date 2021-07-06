package com.xq.javalib;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/07/01 15:00
 */
public class TDownloader extends Thread{
    private String url;//远程路径
    private String name;//储存名字

    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
    }

    public static void main(String[] args) {
        TDownloader td1 = new TDownloader("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fhbimg.huabanimg.com%2F18e5c1f695bf7b30f0275902140c883d77eb05d411e61-DWLRDD_fw658&refer=http%3A%2F%2Fhbimg.huabanimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1627715548&t=dd5a5391612269352f97b26b8ce803fc","luo1");
        TDownloader td2 = new TDownloader("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Ff985f31cff6b5a4fff5e8fa7a7603bbd7041e5f1208ee-BxNr8f_fw658&refer=http%3A%2F%2Fhbimg.b0.upaiyun.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1627715593&t=4fc5a88b26e71a6a3ed877b044eafcfd","luo2");
        TDownloader td3 = new TDownloader("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.doubanio.com%2Fview%2Fgroup_topic%2Fl%2Fpublic%2Fp219635519.jpg&refer=http%3A%2F%2Fimg1.doubanio.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1627715636&t=cea4c5514c95a0a79ab050fa51a82a89","luo3");

        //启动三个线程,没有先后顺序，run方法就有
        td1.start();
        td2.start();
        td3.start();
    }

}
