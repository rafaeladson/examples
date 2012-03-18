//
//  NewPersonViewController.m
//  TDD
//
//  Created by Rafael Adson Barbosa Barros on 3/18/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "NewPersonViewController.h"
#import "Person.h"
#import "AppDelegate.h"

@interface NewPersonViewController ()

@end

@implementation NewPersonViewController
@synthesize nameTextField;
@synthesize birthdayTextField;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
}

- (void)viewDidUnload
{
    [self setNameTextField:nil];
    [self setBirthdayTextField:nil];
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

- (IBAction)onSaveAction:(id)sender {
    Person *person = [[Person alloc] init];
    person.name = [self.nameTextField text];
    person.birthday = [self.birthdayTextField text];
    
    AppDelegate *delegate = [[UIApplication sharedApplication] delegate];
    [delegate.people addObject:person];
    [self.navigationController popViewControllerAnimated:YES];
}
@end
