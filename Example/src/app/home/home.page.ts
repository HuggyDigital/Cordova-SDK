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
    cordova.plugins.huggychat.handleNotification();

    const data = {
      customer: {
        name: "John Doe",
        mobile: "+557536230001",
        email: "seuemail@email.com",
        custom_fields: {
          passaporte: "0000000"
        }
      }
    };

    cordova.plugins.huggychat.openHuggyChat(
      "ae4c74c3-08c9-4cf6-859b-aee3a1bcb5b0",
      "Huggy Chat",
      this.success,
      this.failure
    );

    cordova.plugins.huggychat.execute(
      "setData",
      data,
      this.success,
      this.failure
    );

    cordova.plugins.huggychat.execute(
      "sendMessage",
      ["Olá", "essa uma é uma nova mensagem"],
      this.success,
      this.failure
    );
  };
}
