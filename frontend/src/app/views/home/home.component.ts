import { Component } from '@angular/core';
import { HttpErrorResponse } from "@angular/common/http";
import { LoginService } from "src/app/services/api.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent {

  name = "";

  constructor(
    private LoginService: LoginService
  ) {}

  submit() {
    this.LoginService.createName(this.name).subscribe(
      (dados: any) => {
        alert("Successfully registered user: "+dados.user.name);
      },
      (err: HttpErrorResponse) => {
        alert(err);
      }
    );
  }
}
