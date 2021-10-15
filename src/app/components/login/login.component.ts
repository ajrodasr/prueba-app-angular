import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuario } from 'src/app/models/login-usuario';
import { AuthService } from 'src/app/services/auth.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  isLogged = false;
  isLoginFail = false;
  loginUsuario: LoginUsuario = new LoginUsuario();
  idUsuario = '';
  password = '';
  roles: string[] = [];
  errorMensaje = '';

  constructor(
    private tokenService: TokenService,
    private authService: AuthService,
    private route: Router
  ) {}

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
      this.isLoginFail = false;
      this.roles = this.tokenService.getAuthorities();
    }
  }

  onLogin(): void {
    this.loginUsuario = new LoginUsuario(this.idUsuario, this.password);
    this.authService.login(this.loginUsuario).subscribe(
      (data) => {
        this.isLogged = true;
        this.isLoginFail = false;
        this.tokenService.setToken(data.token);
        this.tokenService.setUsername(data.idUsuario);
        this.tokenService.setAuthorities(data.authorities);
        this.roles = data.authorities;
        this.route.navigate(['/']);
      },
      (err) => {
        this.isLogged = false;
        this.isLoginFail = true;
        this.errorMensaje = err.error.message;
        console.log(this.errorMensaje);
      }
    );
  }
}
