import { Component, OnInit } from '@angular/core';
import { Pizza } from '../pizza';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content?: string;
  pizzaDetails !: Pizza[];

  constructor(private userService: UserService) { }

  ngOnInit(): void {

    this.pizzaDetails = [{
      "id": 1,
      "name" : "Primavera Gourmet Pizza",
      "desc" : "For the veggie gourmet lovers. Succulent zucchini, fresh red & yellow bellpeppers and grilled mushrooms on a thin crust",
      "imgURL" : "../../assets/img/pizzas/Primavera_1.jpg",
      "price": "699"
      },
      {
        "id": 2,
        "name" : "Smoked Chicken Gourmet Pizza",
        "desc" : "The Italian NV pizza experience. An irresistible combination of our juicy rashers with black olives, red & yellow bell",
        "imgURL" : "../../assets/img/pizzas/SmokedChk_1.jpeg",
        "price": "799"
      },
      {
        "id": 3,
        "name" : "Margherita",
        "desc" : "Classic delight with 100% real mozzarella cheese",
        "imgURL" : "../../assets/img/pizzas/new_margherita_2502.webp",
        "price": "499"
      },
      {
        "id": 4,
        "name" : "Farmhouse",
        "desc" : "Delightful combination of onion, capsicum, tomato & grilled mushroom",
        "imgURL" : "../../assets/img/pizzas/farmhouse.webp",
        "price": "549"
      },
      {
        "id": 5,
        "name" : "Peppy Paneer",
        "desc" : "Flavorful trio of juicy paneer, crisp capsicum with spicy red paprika",
        "imgURL" : "../../assets/img/pizzas/new_peppy_paneer.webp",
        "price": "999"
      },
      {
        "id": 6,
        "name" : "Veg Extravaganza",
        "desc" : "Black olives, capsicum, onion, grilled mushroom, corn, tomato, jalapeno & extra cheese",
        "imgURL" : "../../assets/img/pizzas/new_veg_extravaganza.webp",
        "price": "1099"
      }
    ]
    this.userService.getPublicContent().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.content = res.message;
          } catch {
            this.content = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.content = `Error with status: ${err.status}`;
        }
      }
    });
  }
}
