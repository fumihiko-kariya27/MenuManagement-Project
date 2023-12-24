package com.example.domain.cuisine.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.example.domain.cuisine.model.Ingredients;
import com.example.form.CuisineRegistForm;

public interface IngredientsService {
	// 食材一覧の読み込み
	public static Map<String, List<Ingredients>> getIngredients(String file) throws FileNotFoundException
	{
		if(Files.exists(Paths.get(file)) == false)
		{
			throw new FileNotFoundException(file + "が存在してません");
		}
		
		// 読み込み対象CSVの各項目の列位置の設定
		final int NAME = 0;
		final int CATEGORY = 1;
		final int PRICE = 2;
		final int CALORIES = 3;
		
		Map<String, List<Ingredients>> ingredientsMap = new HashMap<>();
		// 食材情報が格納されているCSVの読み込み
		try(Scanner scanner = new Scanner(new File(file)).useDelimiter(System.lineSeparator()))
		{
			// 先頭はヘッダー行であるため読み飛ばす
			scanner.next();
			
			while(scanner.hasNext())
			{
				String line = scanner.next();
				String[] data = line.split(",");
				List<Ingredients> ingredientList = null;
				
				if(ingredientsMap.containsKey(data[CATEGORY]))
				{
					ingredientList = ingredientsMap.get(data[CATEGORY]);
				}
				else
				{
					// カテゴリーがマップに含まれていない場合は新しく追加する
					ingredientList = new ArrayList<>();
					ingredientsMap.put(data[CATEGORY], ingredientList);
				}
				
				Ingredients ingredient = new Ingredients(data[NAME], data[CATEGORY], Integer.valueOf(data[PRICE]), Integer.valueOf(data[CALORIES]));
				ingredientList.add(ingredient);
			}
		} 
		return ingredientsMap;
	}
	
	// フォーム画面から受け取った食材をカンマ区切りの文字列に変換する
	public static String convertIngredients(CuisineRegistForm form)
	{
		StringBuilder sb = new StringBuilder();
		for(String ingredient : form.getIngredientsAry())
		{
			sb.append(ingredient).append(",");
		}
		return sb.substring(0, sb.length() - 1);
	}
}
