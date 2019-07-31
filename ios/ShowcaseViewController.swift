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
import React

class ShowcaseViewController : UIViewController {
  var addRatingView: RCTRootView!

  override func viewDidLoad() {
    let appDelegate = UIApplication.shared.delegate as! AppDelegate
//
//    let rootView = RCTRootView(bridge: appDelegate.reactBridge, moduleName: "ActivityDemoComponent", initialProperties: nil )
//    rootView?.backgroundColor = UIColor.init(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)
//    navigationController?.view = rootView
//   // self.view = rootView
    
    addRatingView = RCTRootView(
      bundleURL: URL(string: "http://localhost:8081/index.ios.bundle?platform=ios"),
      moduleName: "ActivityDemoComponent",
      initialProperties: nil,
      launchOptions: nil)
    self.view.addSubview(addRatingView)

    
  }
  override func viewDidLayoutSubviews() {
    super.viewDidLayoutSubviews()
    addRatingView.frame = self.view.bounds

  }
}
