//
//  ShowcaseViewController.swift
//  Activity
//
//  Created by benjamin pollard on 31/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation
import UIKit
import React.RCTRootView

class ShowcaseViewController : UIViewController {
  override func viewDidLoad() {
    let appDelegate = UIApplication.shared.delegate as! AppDelegate
    
    let rootView = RCTRootView(bridge: appDelegate.reactBridge, moduleName: "ActivityDemoComponent", initialProperties: nil )
    rootView?.backgroundColor = UIColor.init(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)
    self.view = rootView

    
  }
}
