//
//  RecipesDetails.swift
//  Activity
//
//  Created by benjamin pollard on 01/08/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation
import React
class RecipesDetailsViewController: UIViewController {
  var detail: RCTRootView!
  var id = "";
  override func viewDidLoad() {
    let appDelegate = UIApplication.shared.delegate as! AppDelegate
    //
    //    let rootView = RCTRootView(bridge: appDelegate.reactBridge, moduleName: "ActivityDemoComponent", initialProperties: nil )
    //    rootView?.backgroundColor = UIColor.init(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)
    //    navigationController?.view = rootView
    //   // self.view = rootView
    detail = RCTRootView(bridge: appDelegate.reactBridge, moduleName: "RecipeDetailPage", initialProperties: ["key1":id])
//    detail = RCTRootView(
//      bundleURL: URL(string: "http://localhost:8081/index.ios.bundle?platform=ios"),
//      moduleName: ,
//      initialProperties: ["key1":id],
//      launchOptions: )
    self.view.addSubview(detail)
    
    
  }
  override func viewDidLayoutSubviews() {
    super.viewDidLayoutSubviews()
    detail.frame = self.view.bounds
    
  }
}
