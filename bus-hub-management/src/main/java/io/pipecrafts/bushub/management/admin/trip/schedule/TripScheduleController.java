package io.pipecrafts.bushub.management.admin.trip.schedule;

import io.pipecrafts.bushub.management.common.security.tool.AdminEndpoint;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/trips/schedule")
@RestController
@AdminEndpoint
@RequiredArgsConstructor
public class TripScheduleController {

  private final TripScheduleService tripScheduleService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public void createTripSchedule(@RequestBody @Valid TripSchedule tripSchedule) {
    tripScheduleService.create(tripSchedule);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<TripSchedule> readList() {
    return tripScheduleService.readList();
  }
}
