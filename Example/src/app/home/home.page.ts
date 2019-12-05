import { Component } from "@angular/core";

declare var cordova: any;

@Component({
  selector: "app-home",
  templateUrl: "home.page.html",
  styleUrls: ["home.page.scss"]
})
export class HomePage {
  constructor() {}

  success = result => {
    alert(JSON.stringify(result, undefined, 2));
  };

  failure = result => {
    alert(JSON.stringify(result, undefined, 2));
  };

  clickToOpenHuggyChat = () => {
    cordova.plugins.huggychat.openHuggyChat(
      "ece94deb-2f6e-4710-8c01-2a4b2d5c3a4a",
      this.success,
      this.failure
    );
  };
}
