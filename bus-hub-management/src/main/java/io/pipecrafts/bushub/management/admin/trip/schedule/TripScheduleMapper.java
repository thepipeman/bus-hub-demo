package io.pipecrafts.bushub.management.admin.trip.schedule;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
interface TripScheduleMapper {

  long insert(@Param("entity") TripSchedule tripSchedule);

  List<TripSchedule> selectCollection();
}
