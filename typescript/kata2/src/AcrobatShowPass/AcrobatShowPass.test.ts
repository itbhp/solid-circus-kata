import { AcrobatShowPass } from "./AcrobatShowPass.js";

describe("AcrobatShowPass", () => {
  beforeEach(() => {
    vi.clearAllMocks();
  });

  it("should print the pass details to the console", () => {
    const pass = new AcrobatShowPass("The Great Aerial Show", 15, 4);
    const logSpy = vi.spyOn(console, "log").mockImplementation(() => {});

    pass.printAndArchive(5);

    const output = logSpy.mock.calls.map((args) => args.join(" ")).join("\n");

    expect(output).toContain("🎟️ Printing on Acrobat Show printer #5");
    expect(output).toContain("Base price: 15.00€");
    expect(output).toContain("Tax: 0.60€");
    expect(output).toContain("TOTAL: 15.60€");

    logSpy.mockRestore();
  });

  it("should log a message indicating the pass was archived", () => {
    const expectedArchiveMessage =
      "🤸 Archiving Acrobat Show pass of Skywalkers in the circus records...";
    const pass = new AcrobatShowPass("Skywalkers", 12, 4);
    const logSpy = vi.spyOn(console, "log").mockImplementation(() => {});

    pass.printAndArchive(1);

    const logMessages = logSpy.mock.calls.map(([msg]) => msg);

    expect(logMessages).toContain(expectedArchiveMessage);

    logSpy.mockRestore();
  });
});
