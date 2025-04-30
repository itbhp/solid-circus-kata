export class AcrobatShowPass {
  public name: string;
  public basePrice = 0;
  public taxRate = 0;
  public tax = 0;
  public totalPrice = 0;

  constructor(name: string, basePrice: number, taxRate: number) {
    this.name = name;
    this.basePrice = basePrice;
    this.taxRate = taxRate;
  }

  public printAndArchive(printerId: number): void {
    console.log(`🎟️ Printing on Acrobat Show printer #${printerId}`);
    console.log(`Show: ${this.name}`);

    this.tax = this.basePrice * (this.taxRate / 100);
    this.totalPrice = this.basePrice + this.tax;

    console.log("======================");
    console.log(`Base price: ${this.basePrice.toFixed(2)}€`);
    console.log(`Tax: ${this.tax.toFixed(2)}€`);
    console.log(`TOTAL: ${this.totalPrice.toFixed(2)}€`);

    console.log(
      `🤸 Archiving Acrobat Show pass of ${this.name} in the circus records...`
    );
  }
}
