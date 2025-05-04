package com.therefactorproject.showscheduler;

import com.therefactorproject.show.Show;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.therefactorproject.show.Show.show;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShowSchedulerTest {

    private final Show blindWonderShow = Show.createTightropeShow("The Blind Wonder", 20.0, true);
    private final Show funnyJoeShow = Show.createClownShow("Funny Joe", List.of("joke about Chuck Norris 1", "joke about Chuck Norris 2"));
    private final Show dingoShow = Show.createClownShow("Dingo", List.of("JS developers joke", "backend developers joke", "senior developers joke"));
    private final Show daredevilWalkerShow = Show.createTightropeShow("The Daredevil Walker", 20.0, false);
    private final Show flyingStarsShow = Show.createTrapezeShow("The Flying Stars", 2);
    private final Show threeAmigosShow = Show.createTrapezeShow("The Three Amigos", 3);

    @Test
    void calculatesTotalDurationForClownShow() {
        var scheduler = new ShowScheduler(List.of(dingoShow));

        var totalDuration = scheduler.calculateTotalDuration();

        assertEquals(15, totalDuration);
    }

    @Test
    void calculatesTotalDurationForTightropeShowWithoutBlindfold() {
        var scheduler = new ShowScheduler(List.of(daredevilWalkerShow));

        var totalDuration = scheduler.calculateTotalDuration();

        assertEquals(10, totalDuration);
    }

    @Test
    void calculatesTotalDurationForTightropeShowWithBlindfold() {
        var scheduler = new ShowScheduler(List.of(blindWonderShow));

        var totalDuration = scheduler.calculateTotalDuration();

        assertEquals(15, totalDuration);
    }

    @Test
    void calculatesTotalDurationForTrapezeShow() {
        var scheduler = new ShowScheduler(List.of(threeAmigosShow));

        var totalDuration = scheduler.calculateTotalDuration();

        assertEquals(18, totalDuration);
    }

    @Test
    void calculatesTotalDurationForMultipleShows() {
        var scheduler = new ShowScheduler(List.of(funnyJoeShow, blindWonderShow, flyingStarsShow));

        var totalDuration = scheduler.calculateTotalDuration();

        assertEquals(37, totalDuration);
    }

    @Test
    void calculatesDurationForExistentShowByName() {
        var scheduler = new ShowScheduler(List.of(funnyJoeShow, blindWonderShow, flyingStarsShow));

        var duration = scheduler.getShowDurationByName("Funny Joe");

        assertEquals(10, duration);
    }

    @Test
    void throwsWhenCalculatingDurationForNonExistentShowByName() {
        var scheduler = new ShowScheduler(List.of(funnyJoeShow, blindWonderShow, flyingStarsShow));

        assertThrows(IllegalArgumentException.class, () -> scheduler.getShowDurationByName("The Great FireEater"));
    }

  @Test
  void calculateZeroDurationFoUnknownType() {
    var scheduler = new ShowScheduler(List.of(show("any", "unknown")));

    assertEquals(0, scheduler.calculateTotalDuration());
  }

}
