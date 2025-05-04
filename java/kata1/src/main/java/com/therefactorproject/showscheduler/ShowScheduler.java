package com.therefactorproject.showscheduler;

import com.therefactorproject.show.Show;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class ShowScheduler {
  private final Map<String, Show> showsByName;

  public ShowScheduler(List<Show> shows) {
    this.showsByName = shows.stream()
      .collect(toMap(Show::name, Function.identity()));
  }

  public double calculateTotalDuration() {
    var totalDuration = 0.0;

    for (var show: showsByName.values()) {
      totalDuration += show.duration();
    }

    return totalDuration;
  }

  public double getShowDurationByName(String name) {
    return Optional.ofNullable(showsByName.get(name))
      .map(Show::duration)
      .orElseThrow(() -> new IllegalArgumentException("Show isn't scheduled"));
  }
}
