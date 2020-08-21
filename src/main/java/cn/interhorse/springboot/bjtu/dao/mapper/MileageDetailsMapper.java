package cn.interhorse.springboot.bjtu.dao.mapper;

import cn.interhorse.springboot.bjtu.entity.MileageDetails;
import cn.interhorse.springboot.bjtu.entity.StatisticsDataBO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Yuzhe Ma
 * @date 2020/7/30
 */
public interface MileageDetailsMapper {
    /**
     * 查询年龄区间
     *
     * @param startBirthYear 起始年龄
     * @param endBirthYear   结束年龄
     * @return
     */
    @Select("select * from mileage_details_t where birth_year >= #{start} and birth_year <= #{end}")
    @Results(id = "mileageDetailMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "birth_year", property = "birthYear"),
            @Result(column = "total_mileage", property = "totalMileage"),
            @Result(column = "total_time", property = "totalTime")
    })
    List<MileageDetails> selectByYearsInterval(@Param("start") int startBirthYear, @Param("end") int endBirthYear);

    /**
     * 查询里程区间
     *
     * @param startMileage 起始里程
     * @param endMileage   结束里程
     * @return
     */
    @Select("select * from mileage_details_t where total_mileage >= #{start} and total_mileage <= #{end}")
    @ResultMap(value = "mileageDetailMap")
    List<MileageDetails> selectByMilesInterval(@Param("start") int startMileage, @Param("end") int endMileage);

    /**
     * 查询时间区间
     *
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @return
     */
    @Select("select * from mileage_details_t where total_time >= #{start} and total_time <= #{end}")
    @ResultMap(value = "mileageDetailMap")
    List<MileageDetails> selectByTimeInterval(@Param("start") int startTime, @Param("end") int endTime);

    /**
     * 查询出生年份范围内的人数
     *
     * @param statisticsDataBO
     * @return
     */
    @Select("select count(*) from mileage_details_t where birth_year >= #{start} and birth_year <= #{end}")
    int countByYearsInterval(StatisticsDataBO statisticsDataBO);

    /**
     * 查询里程数范围内的人数
     *
     * @param statisticsDataBO
     * @return
     */
    @Select("select count(*) from mileage_details_t where total_mileage >= #{start} and total_mileage <= #{end}")
    int countByMilesInterval(StatisticsDataBO statisticsDataBO);

    /**
     * 查询里程时间范围内的人数
     *
     * @param statisticsDataBO
     * @return
     */
    @Select("select count(*) from mileage_details_t where total_time >= #{start} and total_time <= #{end}")
    int countByTimeInterval(StatisticsDataBO statisticsDataBO);
}
