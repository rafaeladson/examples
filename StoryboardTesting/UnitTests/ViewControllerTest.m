//
//  ViewControllerTest.m
//  StoryboardTesting
//
//  Created by Rafael Adson Barbosa Barros on 3/4/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <GHUnitIOS/GHUnit.h> 
#import "ViewController.h"


@interface ViewControllerTest : GHTestCase

@property (strong, nonatomic) ViewController *controller;


@end


@implementation ViewControllerTest

@synthesize controller = _controller;


-(void) setUp {
    UIStoryboard *storyboard = [UIStoryboard storyboardWithName:@"MainStoryboard_iPhone" bundle:nil];
    self.controller = [storyboard instantiateViewControllerWithIdentifier:@"Bob"];
    [self.controller performSelectorOnMainThread:@selector(loadView) withObject:nil waitUntilDone:YES];
    
    
    
}


-(void) testCopyText {
    [self.controller.originalTextField performSelectorOnMainThread:@selector(setText:) withObject:@"foo" waitUntilDone:YES];
    [self.controller copyText:nil];
    GHAssertEqualStrings(@"foo", self.controller.resultTextField.text, nil);
    
}

@end
