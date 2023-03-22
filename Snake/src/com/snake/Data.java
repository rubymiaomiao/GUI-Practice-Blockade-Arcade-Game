package com.snake;

import java.net.URL;

import javax.swing.ImageIcon;

//数据存放
public class Data {
	
	//头部图片   URL :定位图片地址
	
	public static URL headerURL = Data.class.getResource("/statics/header.png");//获取图片
	public static ImageIcon header = new  ImageIcon(headerURL);//将
//获取数据
	public static URL upURL = Data.class.getResource("/statics/up.png");
	public static URL downURL = Data.class.getResource("/statics/down.png");
	public static URL leftURL = Data.class.getResource("/statics/left.png");
	public static URL rightURL = Data.class.getResource("/statics/right.png");
	public static ImageIcon up = new  ImageIcon(upURL);
	public static ImageIcon down = new  ImageIcon(downURL);
	public static ImageIcon left = new  ImageIcon(leftURL);
	public static ImageIcon right = new  ImageIcon(rightURL);
	
	//身体
	public static URL bodyURL = Data.class.getResource("/statics/body.png");
	public static ImageIcon body = new  ImageIcon(bodyURL );
	
	//食物
	public static URL foodURL = Data.class.getResource("/statics/food.png");
	public static ImageIcon food = new  ImageIcon( foodURL );



}
