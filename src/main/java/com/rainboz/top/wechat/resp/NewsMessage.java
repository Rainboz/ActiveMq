package com.rainboz.top.wechat.resp;

import java.util.List;

/**
 * @program: ${CLASS_NAME}
 * @description: 多图文消息
 * @author: LS
 * @create: 2018-09-05 08:53
 */
public class NewsMessage extends BaseMessage{
    // 图文消息个数，限制为 10 条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个 item 为大图
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
