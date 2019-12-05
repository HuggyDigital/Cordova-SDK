//
//  HuggySdk.h
//
//  Created by Cássio Santos on 13/05/19.
//  Copyright © 2019 Huggy. All rights reserved.
//
#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>

#ifndef HuggySdk_h
#define HuggySdk_h

@protocol HuggyDelegate

// define protocol functions that can be used in any class using this delegate
- (void)onEvent:(NSString *)name
               :(NSString *)data;

@end

@interface HuggySdk : NSObject <UIWebViewDelegate>

@property(nonatomic, assign) id delegate;
@property(strong, nonatomic) UIWebView *webView;
@property(strong, nonatomic) NSString *sdkId;

- (id) initWith:(NSString*)sdkId : (UIWebView *)web;
- (void) prepare;
- (void) start;
- (void) stop;
- (void) execJs:(NSString *)code;
- (void) callApiMethod: (NSString*) methodName : (NSString*)data;

@end

#endif /* HuggySdk_h */
