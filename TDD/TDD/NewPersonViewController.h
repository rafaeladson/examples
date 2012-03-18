//
//  NewPersonViewController.h
//  TDD
//
//  Created by Rafael Adson Barbosa Barros on 3/18/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface NewPersonViewController : UIViewController

@property (weak, nonatomic) IBOutlet UITextField *nameTextField;
@property (weak, nonatomic) IBOutlet UITextField *birthdayTextField;
- (IBAction)onSaveAction:(id)sender;
@end
