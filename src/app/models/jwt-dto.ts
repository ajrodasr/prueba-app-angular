export class JwtDTO {
  token: string;
  type: string;
  idUsuario: string;
  authorities: string[];

  constructor() {
    this.token = '';
    this.type = '';
    this.idUsuario = '';
    this.authorities = [];
  }
}
