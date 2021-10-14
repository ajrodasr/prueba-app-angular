export class NuevoUsuario {
  id: string;
  nombre: string;
  apellido1: string;
  apellido2: string;
  email: string;
  password: string;
  authorities: string[];

  constructor() {
    this.id = '';
    this.nombre = '';
    this.apellido1 = '';
    this.apellido2 = '';
    this.email = '';
    this.password = '';
    this.authorities = [];
  }
}
