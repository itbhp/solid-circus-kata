export class Show {
  name: string;
  type: string;
  jokes?: string[];
  ropeLength?: number;
  isBlindfolded?: boolean;
  performers?: number;

  constructor(name: string, type: string) {
    this.name = name;
    this.type = type;
  }
}
