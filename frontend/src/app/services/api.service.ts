import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class LoginService {
  SERVER_URL = "http://localhost:8080";
  constructor(private http: HttpClient) {}
  createName(name: string) {
    return this.http.post(this.SERVER_URL + "/user", {
      name
    });
  }
}
