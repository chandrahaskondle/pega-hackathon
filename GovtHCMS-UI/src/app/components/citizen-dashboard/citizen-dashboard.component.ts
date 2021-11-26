import { Component, OnInit, ViewChild } from '@angular/core';
import {MatAccordion} from '@angular/material/expansion';

@Component({
  selector: 'app-citizen-dashboard',
  templateUrl: './citizen-dashboard.component.html',
  styleUrls: ['./citizen-dashboard.component.scss']
})
export class CitizenDashboardComponent implements OnInit {
  @ViewChild(MatAccordion) accordion: MatAccordion;
  panelOpenState = false;
  constructor() { }

  ngOnInit(): void {
  }

}
