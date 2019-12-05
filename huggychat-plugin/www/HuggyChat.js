var exec = require("cordova/exec");

exports.openHuggyChat = function(sdkId, success, error) {
  exec(success, error, "HuggyChatBridge", "openHuggyChat", [sdkId]);
};

exports.coolMethod = function(sdkId, success, error) {
  exec(success, error, "HuggyChatBridge", "coolMethod", [sdkId]);
};

exports.handleNotification = function(success, error) {
  exec(success, error, "HuggyChatBridge", "handleNotification");
};

exports.notify = function(payload, title, message, success, error) {
  exec(success, error, "HuggyChatBridge", "notify", [payload, title, message]);
};

exports.notifyAppInForeground = function(success, error) {
  exec(success, error, "HuggyChatBridge", "notifyAppInForeground");
};

exports.notNotifyAppInForeground = function(success, error) {
  exec(success, error, "HuggyChatBridge", "notNotifyAppInForeground");
};

exports.testConnection = function(arg0) {
  alert(arg0);
};
