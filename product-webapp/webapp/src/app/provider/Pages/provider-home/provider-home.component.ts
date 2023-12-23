import { Component ,OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
@Component({
  selector: 'app-provider-home',
  templateUrl: './provider-home.component.html',
  styleUrls: ['./provider-home.component.css'],
})
export class ProviderHomeComponent implements OnInit {
  open = false;
  isSmallScreen = false;
  constructor(private breakpointObserver: BreakpointObserver) {
    this.breakpointObserver
      .observe([Breakpoints.Small, Breakpoints.XSmall,Breakpoints.TabletPortrait])
      .subscribe((result) => {
        this.isSmallScreen = result.matches;
      });
  }
  ngOnInit(): void {
    if (!this.isSmallScreen) {
      this.open = true;
    } else {
      this.open = false;
    }
  }
  openToggle() {
    this.open=!this.open;
  }
  logout() {
    alert("Logout");
  }
}
