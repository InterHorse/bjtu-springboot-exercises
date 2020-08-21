package cn.interhorse.springboot.bjtu.entity;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页实体类
 *
 * @author Yuzhe Ma
 * @date 2019-03-07
 */
@Data
public class PageData<T> {
    private int pageNum;
    private int pageSize;
    private long total;
    private int pages;
    private List<T> list;

    public PageData() {}

    public PageData(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageSize = page.size();
            this.pageNum = page.getPageNum();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
        }
    }
}
