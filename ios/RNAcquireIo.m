#import "RNAcquireIo.h"
#import <AcquireIO/AcquireIO.h>

@implementation RNAcquireIo

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(init:(NSString *)accountID) {
  
  NSMutableDictionary *_option = [@{} mutableCopy];
  
  _option[@"ShowChatButton"] = @"NO";
  AcquireIOConfig *config = [AcquireIOConfig config];
  [config setDict:_option];

  [[AcquireIO support] setAccount:accountID withOptions:config];

}

RCT_EXPORT_METHOD(setVisitorDetail:(NSString *)name :(NSString *)phone : (NSString *)email)
{
  
  [[AcquireIO support] setVisitor:name phone:phone andEmail:email];

}

RCT_EXPORT_METHOD(setFireBaseToken:(NSString *)token)
{
  
  //TODO need to add method for push notification

}

RCT_EXPORT_METHOD(startSupportChat)
{
  
  UIViewController *controller = [UIApplication sharedApplication].keyWindow.rootViewController;
  [[AcquireIO support] showSupport:controller];

}

RCT_EXPORT_METHOD(logOut)
{
  
  [[AcquireIO support] logoutVisitor];

}

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

@end
