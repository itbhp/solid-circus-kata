import { Show } from "../Show/Show.js";

export class ShowScheduler {
  private shows: Show[];

  constructor(shows: Show[]) {
    this.shows = shows;
  }

  public calculateTotalDuration(): number {
    let totalDuration = 0;

    for (const show of this.shows) {
      totalDuration += this.calculateShowDuration(show);
    }

    return totalDuration;
  }

  public getShowDurationByName(name: string): number {
    const show = this.shows.find((show) => show.name === name);

    if (!show) {
      throw new Error("Show isn't scheduled");
    }

    return this.calculateShowDuration(show);
  }

  private calculateShowDuration(show: Show): number {
    let showDuration: number;

    if (show.type === "clown") {
      showDuration = show.jokes!.length * 5;
    } else if (show.type === "tightrope") {
      showDuration = show.ropeLength! / 2 + (show.isBlindfolded ? 5 : 0);
    } else if (show.type === "trapeze") {
      showDuration = show.performers! * 6;
    } else {
      showDuration = 0;
    }

    return showDuration;
  }
}
