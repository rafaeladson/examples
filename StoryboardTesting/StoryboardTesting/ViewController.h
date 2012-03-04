//
//  ViewController.h
//  StoryboardTesting
//
//  Created by Rafael Adson Barbosa Barros on 3/4/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
@property (weak, nonatomic) IBOutlet UITextField *originalTextField;
@property (weak, nonatomic) IBOutlet UITextField *resultTextField;
- (IBAction)copyText:(id)sender;

@end
