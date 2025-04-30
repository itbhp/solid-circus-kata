import { Show } from "../Show/Show.js";
import { ShowScheduler } from "./ShowScheduler.js";

const blindWonderShow = new Show("The Blind Wonder", "tightrope");
blindWonderShow.ropeLength = 20;
blindWonderShow.isBlindfolded = true;

const funnyJoeShow = new Show("Funny Joe", "clown");
funnyJoeShow.jokes = ["joke about Chuck Norris 1", "joke about Chuck Norris 2"];

const dingoShow = new Show("Dingo", "clown");
dingoShow.jokes = [
  "JS developers joke",
  "backend developers joke",
  "senior developers joke",
];

const daredevilWalkerShow = new Show("The Daredevil Walker", "tightrope");
daredevilWalkerShow.ropeLength = 20;
daredevilWalkerShow.isBlindfolded = false;

const flyingStarsShow = new Show("The Flying Stars", "trapeze");
flyingStarsShow.performers = 2;

const threeAmigosShow = new Show("The Three Amigos", "trapeze");
threeAmigosShow.performers = 3;

describe("ShowScheduler", () => {
  it("calculates total duration for a clown show", () => {
    const shows = [dingoShow];
    const scheduler = new ShowScheduler(shows);

    const totalDuration = scheduler.calculateTotalDuration();

    expect(totalDuration).toBe(15);
  });

  it("calculates total duration for a tightrope show without blindfold", () => {
    const shows = [daredevilWalkerShow];
    const scheduler = new ShowScheduler(shows);

    const totalDuration = scheduler.calculateTotalDuration();

    expect(totalDuration).toBe(10);
  });

  it("calculates total duration for a tightrope show with blindfold", () => {
    const shows = [blindWonderShow];
    const scheduler = new ShowScheduler(shows);

    const totalDuration = scheduler.calculateTotalDuration();

    expect(totalDuration).toBe(15);
  });

  it("calculates total duration for a trapeze show", () => {
    const shows = [threeAmigosShow];
    const scheduler = new ShowScheduler(shows);

    const totalDuration = scheduler.calculateTotalDuration();

    expect(totalDuration).toBe(18);
  });

  it("calculates total duration for multiple shows", () => {
    const shows = [funnyJoeShow, blindWonderShow, flyingStarsShow];

    const scheduler = new ShowScheduler(shows);

    const totalDuration = scheduler.calculateTotalDuration();

    expect(totalDuration).toBe(37);
  });

  it("calculates duration for an existent show by its name", () => {
    const shows = [funnyJoeShow, blindWonderShow, flyingStarsShow];
    const scheduler = new ShowScheduler(shows);

    const duration = scheduler.getShowDurationByName("Funny Joe");

    expect(duration).toBe(10);
  });

  it("throws when calculating duration for a non existent show by its name", () => {
    const shows = [funnyJoeShow, blindWonderShow, flyingStarsShow];
    const scheduler = new ShowScheduler(shows);

    expect(() => {
      scheduler.getShowDurationByName("The Great FireEater");
    }).toThrow();
  });
});
