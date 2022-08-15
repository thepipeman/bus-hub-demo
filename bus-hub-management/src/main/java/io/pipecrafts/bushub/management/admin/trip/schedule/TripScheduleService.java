package io.pipecrafts.bushub.management.admin.trip.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TripScheduleService {

  private final TripScheduleMapper tripScheduleMapper;

  public void create(TripSchedule tripSchedule) {
    tripScheduleMapper.insert(tripSchedule);
    log.info("Created Trip Schedule");
  }

  @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
  public List<TripSchedule> readList() {
    return tripScheduleMapper.selectCollection();
  }
}
