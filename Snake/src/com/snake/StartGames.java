package com.snake;
//1.画面版
//2.把素材画在面板上（data.)
//3.坐标控制
//4.时间变换
//5.键盘监听

import javax.swing.JFrame;

public class StartGames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//窗口
JFrame frame = new JFrame("Eating Snake");//标题

frame.setBounds(10, 10, 900, 720);//界面大小
frame.setResizable(false);//不可调整大小
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口设置

frame.add(new GamePanel());//添加面板

frame.setVisible(true);//窗口展示




	}

}
