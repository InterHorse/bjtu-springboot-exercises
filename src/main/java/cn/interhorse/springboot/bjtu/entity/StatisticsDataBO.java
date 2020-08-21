package cn.interhorse.springboot.bjtu.entity;

import lombok.Data;

/**
 * 用于返回统计信息的实体
 *
 * @author Yuzhe Ma
 * @date 2020/08/20
 */
@Data
public class StatisticsDataBO {
    // 起始值
    private int start;
    // 结束值
    private int end;
    // 人数
    private int num;
}
