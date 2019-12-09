//
//  ChatController.m
//  sdk-demo
//
//  Created by Cássio Santos on 22/05/19.
//  Copyright © 2019 huggy.io. All rights reserved.
//

#import "HuggyChat.h"

@interface HuggyChat ()
{
    //***************
    HuggySdk* huggySdk;
}
@property (weak, nonatomic) IBOutlet UIWebView *HuggyView;

@end

@implementation HuggyChat

- (void)viewDidLoad {
    [super viewDidLoad];
    
    huggySdk = [[HuggySdk alloc] initWith:self.sdkId :_HuggyView];
    huggySdk.delegate = self;
    
    [huggySdk prepare];
    [huggySdk start];
}

-(void)viewWillAppear:(BOOL)animated {
    self.navigationItem.title = @"Huggy Support";
}

-(void)viewWillDisappear:(BOOL)animated{
    [huggySdk stop];
}

-(void)dealloc{
    [huggySdk stop];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

- (IBAction)onSendMessage:(id)sender {
    NSLog(@"sendMessage");
    [huggySdk callApiMethod:@"sendMessage":@"\"Testando SDK\""];
}

- (IBAction)onSetName:(id)sender {
    NSLog(@"setName");
    [huggySdk callApiMethod:@"setName" :@"\"Huggy Client\""];
}

- (IBAction)onCloseModal:(id)sender{
    NSLog(@"closeModal");
    [self dismissViewControllerAnimated:YES completion:nil];
}
@end
