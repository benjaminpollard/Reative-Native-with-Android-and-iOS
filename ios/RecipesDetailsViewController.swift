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

    detail = RCTRootView(bridge: appDelegate.reactBridge, moduleName: "RecipeDetailPage", initialProperties: ["key1":id])

    self.view.addSubview(detail)
    
    
  }
  override func viewDidLayoutSubviews() {
    super.viewDidLayoutSubviews()
    detail.frame = self.view.bounds
    
  }
}
