package cn.interhorse.springboot.bjtu.entity;

import lombok.Data;

/**
 * 数据实体
 *
 * @author Yuzhe Ma
 * @date 2020/7/30
 */
@Data
public class MileageDetails {
    private int id;
    private int gender;
    private int birthYear;
    private int totalMileage;
    private int totalTime;
}
