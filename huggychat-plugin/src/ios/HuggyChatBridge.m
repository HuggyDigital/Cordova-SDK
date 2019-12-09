/********* HelloWorld.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "HuggyChat.h"

@interface HuggyChatBridge : CDVPlugin {
  // Member variables go here.
}

- (void)openHuggyChat:(CDVInvokedUrlCommand*)command;
@end

@implementation HuggyChatBridge

- (void)openHuggyChat:(CDVInvokedUrlCommand*)command
{
    NSString* sdkId = [command.arguments objectAtIndex:0];

    UIStoryboard *storyboard = [UIStoryboard storyboardWithName:@"HuggyChat" bundle:nil];
    HuggyChat *vs = [storyboard instantiateViewControllerWithIdentifier:@"HuggyChat"];
    vs.modalPresentationStyle=UIModalPresentationFullScreen;
    
    vs.sdkId = sdkId;
    [self.viewController presentViewController:vs animated:YES completion:nil];
}

@end
