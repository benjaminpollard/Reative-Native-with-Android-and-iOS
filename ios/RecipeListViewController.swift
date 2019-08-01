//
//  RecipeListViewController.swift
//  Activity
//
//  Created by benjamin pollard on 31/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation
import UIKit
import Alamofire
import SwiftyJSON
import moa

class RecipeListViewController : UITableViewController {
  
  
  var items = [Recipe]();
  override func viewDidLoad() {
    super.viewDidLoad()
    
    getRecipes {[weak self] (pitems) in
      self?.items = pitems;
      self?.tableView.reloadData()
    };
    
  }
  
  func getRecipes(onFinish : @escaping ([Recipe]) -> Void)  {
    
    Alamofire.request("https://www.food2fork.com/api/search?key=5e3af3fd8175a49108c8227793ab0044", method: .get, parameters: nil, encoding: JSONEncoding.default ).responseJSON { response in
      
      switch response.result {
      case .success(let data):
        let json: JSON = JSON(data)
        var items = [Recipe]();
        for i in 0 ..< json["recipes"].count {
          let li = Recipe();

          li.imageUrl = json["recipes"][i]["image_url"].string!
          li.imageUrl = li.imageUrl.replacingOccurrences(of: "http", with: "https")
          print("ben " + li.imageUrl)

          li.recipeId = json["recipes"][i]["recipe_id"].string!
          li.title = json["recipes"][i]["title"].string!
          items.append(li);
        }
       onFinish(items)
        
      case .failure(let error):
        print(error)
        return
      }
    }
  }
  override func numberOfSections(in tableView: UITableView) -> Int {
    return 1
  }
  
  override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
    return items.count
  }
  
  override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
    let cell : RecipeCell = tableView.dequeueReusableCell(withIdentifier: "recipe",for: indexPath) as! RecipeCell
    let item = items[indexPath.row]
    cell.bg.moa.url = item.imageUrl
    cell.name.text = item.title
    cell.id = item.recipeId
    return cell;
  }
  override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
    let item = items[indexPath.row]
    selectedID = item.recipeId
    performSegue(withIdentifier: "toDetail", sender: self)
  }

  var selectedID = ""
  override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
    if(segue.identifier == "toDetail"){
    let vc = segue.destination as! RecipesDetailsViewController
      vc.id = selectedID
    }
  }
}
