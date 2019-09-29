/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package OOM;

/**
 * TODO
 *
 * @author wqc
 * @version V1.0
 * @since 2019-06-17 18:03
 */
public class OOMObject {
    private String str ="这是我在2012年任务之前，期间和之后收到的所有有效图书推荐的记录。我为这个项目为每个国家选择了一本书。这些是加下划线的，你可以点击标题或国家名称阅读我对每个选择的想法。\n"
        +"我通过每个月选择一个新的标题作为本月的书籍继续更新列表。这些评论的链接以橙色突出显示。如果您有建议（或者您知道其中一本标有'寻求翻译'的书的英文版），请在底部留言";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
