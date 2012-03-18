//
//  NewPersonViewControllerTest.m
//  TDD
//
//  Created by Rafael Adson Barbosa Barros on 3/18/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "NewPersonViewControllerTest.h"
#import "NewPersonViewController.h"
#import "AppDelegate.h"
#import "Person.h"

@interface NewPersonViewControllerTest()

@property (strong, nonatomic) NewPersonViewController *controller;

@end

@implementation NewPersonViewControllerTest

@synthesize controller = _controller;


-(void) setUp {
    
    UIStoryboard *storyboard = [UIStoryboard storyboardWithName:@"MainStoryboard_iPhone" bundle:nil];
    self.controller = [storyboard instantiateViewControllerWithIdentifier:@"NewPersonViewController"];
    
    [self.controller performSelectorOnMainThread:@selector(loadView) withObject:nil waitUntilDone:YES];
}

-(void) testPreConditions {
    STAssertNotNil(self.controller, nil);
    STAssertNotNil(self.controller.nameTextField, nil);
    STAssertNotNil(self.controller.birthdayTextField, nil);
}

-(void) testSaveANewPerson {
    [self.controller.nameTextField performSelectorOnMainThread:@selector(setText:) withObject:@"Mike" waitUntilDone:YES];
    [self.controller.birthdayTextField performSelectorOnMainThread:@selector(setText:) withObject:@"October 10th" waitUntilDone:YES];
    
    [self.controller onSaveAction:nil];
    
    AppDelegate *delegate = [[UIApplication sharedApplication] delegate];
    NSArray *people = delegate.people;
    int peopleCount = [people count];
    STAssertEquals(1, peopleCount, nil);
    
    Person *personInArray = [people objectAtIndex:0];
    STAssertEqualObjects(@"Mike", personInArray.name, nil);
    STAssertEqualObjects(@"October 10th", personInArray.birthday, nil);
    
}


@end
