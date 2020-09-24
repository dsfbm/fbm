package com.api.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import javax.swing.*;
import java.util.*;

public class ArticleVote {

    private static final int ONE_WEEK_IN_SECONDS=7*88400;
    private static final int VOTE_SCORE=432;
    private static final int ARICLE_PAGE=20;
    public static void main(String[] args) {
        new ArticleVote().run();
    }

    public void run(){
        //建立本地连接
        Jedis conn=new Jedis("localhost");
        System.out.println("连接成功.....");
        //添加密码 ，如果没有设置密码  可以不用
        //查看服务是否运行
        System.out.println("服务正在运行："+conn.ping());

        //选择存储
        conn.select(2);
        //发布文章

        String articleId=postArticle(conn,"tom","first","http://baidu.com/1");
        System.out.println("发布了一篇文章！ 编号"+articleId);
        Map<String,String> articleData=conn.hgetAll("article"+articleId);
        for (Map.Entry<String,String> entry:articleData.entrySet()){
            System.out.println(" " +entry.getKey()+">>"+entry.getValue());
        }

        System.out.println(" ");
        //其他用户投票
        articleVote(conn, "hanmeimei", "article:" + articleId);
        String votes=conn.hget("artice:"+articleId,"votes");

        System.out.println("完成投票  编号:"+articleId+"当前票数:"+votes);

        assert Integer.parseInt(votes)>1;

        System. out . println("当前最高评分的文章: ");
        List<Map<String, String>> articles = getArticles(conn, 1);
        printArticles(articles);
        assert  articles.size()>=1;
        addGroups(conn, articleId, new String[]{"java" ,"database"});
        System.out.println("增加文章: "+articleId+" 到分组" +Arrays.toString(new String[]{"java", "database"})+"后");
        articles=getGroupArticles(conn,"java",1);
        printArticles(articles);
        assert articles.size()>=1;


    }

    public String postArticle(Jedis conn,String user,String title,String link){

        //文章ID
        String articleId=String .valueOf(conn.incr("article"));
        //对文章投票
        String voted="voted:"+articleId;
        conn.sadd(voted,user);
        conn.expire(voted,ONE_WEEK_IN_SECONDS);

        //保存文章
        long now=System.currentTimeMillis()/1000;
       String article="article"+articleId;
        HashMap<String,String> articleData=new HashMap<String, String>();
        articleData.put("title",title);
        articleData.put("link",link);

        articleData.put("user",user);
        articleData.put("now",String.valueOf(now));
        articleData.put("votes","1");
        conn.hmset(article,articleData);

        //保存文章评分
        conn.zadd("score",now+VOTE_SCORE,article);
        //保存文章时间
        conn.zadd("time",now,article);
        return articleId;


    }
    //文章投票
    public void articleVote(Jedis conn, String user , String article) {
       //获取 当前时间往前推一一周
        long old = (System.currentTimeMillis() / 1000) -ONE_WEEK_IN_SECONDS;

        //增加投票
//        if (conn.zscore("time:", article) > old) {
//            return;
//        }
        String articleId=article.substring(article.indexOf(":")+1);
        if (conn.sadd("voted:"+articleId,user)==1){
            conn.zincrby("score:",VOTE_SCORE,article);
conn.hincrBy(article,"votes",1);
        }
    }


    //获取文章
    public List<Map<String,String>> getArticles(Jedis conn, int page){
        return getArticles(conn, page, "score:");

    }
    public List<Map<String, String>> getArticles(Jedis conn, int page , String order){

        //设定获取范围

        int start=(page-1)*ARICLE_PAGE;
        int end=start+ARICLE_PAGE-1;
        //指定范围内获取文章:由高到底

        Set<String> ids=conn.zrevrange(order,start,end);
        List<Map<String,String>> articles = new ArrayList<Map<String, String>>();
        for (String id:ids){
            Map<String, String> articleData = conn.hgetAll( "article:"+id);
            articleData. put("id",id);
            articles.add(articleData);


        }
            return articles;
    }

    //输出文章
    private void printArticles(List<Map<String, String>> articles) {
        for (Map<String, String> article : articles) {
            System.out.println(" id:" + article.get("id"));
            for (Map.Entry<String, String> entry : article.entrySet()) {
                if (entry.getKey().equals("id")) {
                    continue;
                }
                System.out.println("" + entry.getKey() + ">>" + entry.getValue());
            }
        }


    }
    //增加分组
    public void addGroups(Jedis conn,String articleId,String[] groups){
        String article = "article:" + articleId;
        for(String group:groups){
            conn.sadd( "group:" +group,article);
        }
    }

    //获取分组文章
    public List<Map<String, String>> getGroupArticles(Jedis conn , String group, int page){
return getGroupArticles(conn,group,page,"score:");
    }
    //获取分组文章
    public List<Map<String, String>> getGroupArticles(Jedis conn , String group, int page , String order){
        String key =order+group;
    if (!conn.exists(key)){

        ZParams params=new ZParams().aggregate(ZParams.Aggregate.MAX);
        conn.zinterstore(key,params,"group"+group,order);
        conn.expire(key,60);

    }

    return getArticles(conn,page,key);
    }

}