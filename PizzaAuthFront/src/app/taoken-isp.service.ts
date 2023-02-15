import { HttpInterceptor,HttpEvent,HttpRequest,HttpHandler } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './_services/auth.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TAokenIspService implements HttpInterceptor {


  constructor(private authservice:AuthService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    req = req.clone({
      setHeaders: {
        Authorization:`Bearer ${localStorage.getItem('token')}`
      }
    })
    return next.handle(req);
  }
}
