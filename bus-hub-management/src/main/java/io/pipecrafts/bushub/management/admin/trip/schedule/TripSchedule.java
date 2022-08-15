package io.pipecrafts.bushub.management.admin.trip.schedule;

import jakarta.validation.constraints.*;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

@Value
@Builder
@Alias("TripSchedule")
public class TripSchedule implements Serializable {

  Long id;

  @NotNull
  @NonNull
  String busType;

  @NotNull
  @NonNull
  LocalTime departureTime;

  @NotBlank
  @NonNull
  String origin;

  @NotBlank
  @NonNull
  String destination;

  @Min(1)
  @NonNull
  BigDecimal amount;
}
