package com.therefactorproject.show;

import java.util.List;

public sealed interface Show {

  static Show show(String name, String type) {
    return new UnknownShow(name, type);
  }

  static Show createClownShow(String name, List<String> jokes) {
    return new ClownShow(name, jokes);
  }

  static Show createTightropeShow(String name, double ropeLength, boolean isBlindfolded) {
    return new TightRopeSHow(name, ropeLength, isBlindfolded);
  }

  static Show createTrapezeShow(String name, int performers) {
    return new TrapezeShow(name, performers);
  }

  double duration();


  String name();

  record ClownShow(String name, List<String> jokes) implements Show {
    public double duration() {
      return jokes != null ? jokes.size() * 5 : 0;
    }
  }

  record TightRopeSHow(String name, Double ropeLength, boolean isBlindfolded) implements Show {
    public double duration() {
      return (ropeLength != null ? ropeLength / 2.0 : 0.0)
        + (isBlindfolded ? 5.0 : 0.0);
    }
  }

  record TrapezeShow(String name, Integer performers) implements Show {
    public double duration() {
      return performers != null ? performers * 6 : 0;
    }
  }

  record UnknownShow(String name, String type) implements Show {
    public double duration() {
      return 0.0;
    }
  }
}

