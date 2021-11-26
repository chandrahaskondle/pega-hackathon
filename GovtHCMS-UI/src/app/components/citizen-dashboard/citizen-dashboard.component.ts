import { Component, OnInit, ViewChild } from '@angular/core';
import { MatAccordion } from '@angular/material/expansion';
import { DataService } from 'src/app/data.service';


@Component({
  selector: 'app-citizen-dashboard',
  templateUrl: './citizen-dashboard.component.html',
  styleUrls: ['./citizen-dashboard.component.scss']
})
export class CitizenDashboardComponent implements OnInit {
  @ViewChild(MatAccordion) accordion: MatAccordion;
  vaccinesAvaliable: VaccineSlots[] = [{ quantity: 20, address: "Kukatpally, 500072"}];
  
  constructor(public dataService: DataService) { }

  ngOnInit(): void {
  }

  bookSlot() {
    console.log("helo");
  }

}


interface VaccineSlots {
  quantity: number;
  address: String;
}