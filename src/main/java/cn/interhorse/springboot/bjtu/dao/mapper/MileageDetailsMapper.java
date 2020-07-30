package cn.interhorse.springboot.bjtu.dao.mapper;

import cn.interhorse.springboot.bjtu.entity.MileageDetails;
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
     * @param endBirthYear 结束年龄
     * @return
     */
    @Select("select * from mileage_details_t where birth_year >= #{start} and birth_year <= #{end}")
    List<MileageDetails> selectByYearsInterval(@Param("start") int startBirthYear, @Param("end") int endBirthYear);

    /**
     * 查询年龄区间
     *
     * @param startBirthYear 起始年龄
     * @param endBirthYear 结束年龄
     * @return
     */
    @Select("select * from mileage_details_t where total_mileage >= #{start} and total_mileage <= #{end}")
    List<MileageDetails> selectByMilesInterval(@Param("start") int startBirthYear, @Param("end") int endBirthYear);

    /**
     * 查询年龄区间
     *
     * @param startBirthYear 起始年龄
     * @param endBirthYear 结束年龄
     * @return
     */
    @Select("select * from mileage_details_t where total_time >= #{start} and total_time <= #{end}")
    List<MileageDetails> selectByTimeInterval(@Param("start") int startBirthYear, @Param("end") int endBirthYear);
}
