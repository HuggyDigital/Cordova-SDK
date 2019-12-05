//
//  ChatController.h
//  sdk-demo
//
//  Created by Cássio Santos on 22/05/19.
//  Copyright © 2019 huggy.io. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "HuggySdk.h"

@interface HuggyChat : UIViewController<HuggyDelegate>
  @property(strong, nonatomic) NSString *sdkId;
@end
