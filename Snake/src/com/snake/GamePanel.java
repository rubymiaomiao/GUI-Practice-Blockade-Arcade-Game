package com.snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;//接收键盘按钮
import java.util.Random;
import javax.swing.*;

//初始——构造器——键盘监听——键盘监听带来的变量（程序）—— 画图 —— 动起来（时间）



public class GamePanel extends JPanel implements KeyListener,ActionListener{
//画版 画界面和蛇
	int lenth;//蛇的长度
	int[] snakeX = new int[600];//蛇的坐标
	int[] snakeY = new int[500];
	String fx = "R";//方向
	Timer timer = new Timer(100, this); 
	//定时器：第一个参数是每隔多少秒执行一次（单位：毫秒），100毫秒一次等于一秒十次
	//这里有个接口，actionlistener
	//要在构造器启动
	//食物
	int foodx;
	int foody;
	Random random = new Random();
	boolean isStart = false;//游戏是否结束
	int score;
	//死亡判断
	boolean isFail = false;
	
	//构造器
	public GamePanel() {
		init() ;
		//获取键盘的监听
		this.setFocusable(true);//让键盘的焦点聚集在游戏上面
		this.addKeyListener(this);//实现监听
		timer.start();//动起来！！

	}
	
	
	
	//初始化
	public void init() {
	lenth = 3;
	snakeX[0]= 100;snakeY[0]= 100;//头的坐标
	snakeX[1]= 75;snakeY[1]= 100;//第一个身体
	snakeX[2]= 50;snakeY[2]= 100;//第二个身体
	fx = "R";
	foodx = 25 + 25*random.nextInt(34);//从0到34的范围  int bound
	foody = 75 + 25*random.nextInt(34);//
	
	score = 0; //游戏分数
	
	}
    
	
	
	//Graphics画笔
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);//清屏
		this.setBackground(Color.white);//背景颜色
		
		//绘画头部广告
		Data.header.paintIcon(this, g, 25, 11);//画在指定位置，离x有25距离，离y有11距离
		
	//绘制游戏区域
		g.fillRect(25, 75, 850, 600);//游戏框，前面是离原点多少
		
	
		//绘制蛇
	
		if(fx.equals("R")) {
			Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);}
		else if (fx.equals("L")) {
			Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if (fx.equals("U")) {
			Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if (fx.equals("D")) {
			Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
		}
		
		for (int i = 1;i<lenth;i++) {
			Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);//将长度交给lenth解决
		}
	//画食物
		Data.food.paintIcon(this, g, foodx,foody);
		
		g.setColor(Color.white);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度 " + lenth, 750, 35);
        g.drawString("分数 " + score, 750, 50);
		
		//游戏开始提醒
		if(isStart == false) {
			g.setColor(Color.WHITE);//画笔颜色
			g.setFont(new Font("微软雅黑", Font.BOLD, 40));//设置字体
			g.drawString("按空格开始", 300, 400);//(画什么，坐标）
			
		}
		//FAIL
		if(isFail) {
			g.setColor(Color.red);//画笔颜色
			g.setFont(new Font("微软雅黑", Font.BOLD, 40));//设置字体
			g.drawString("Fall", 200, 300);}//(画什么，坐标）
	}
	


	@Override
	public void keyPressed(KeyEvent e) {// 键盘按下
		 int keyCode = e.getKeyCode(); //获取按下的键盘是哪一个键
		 if (keyCode==KeyEvent.VK_SPACE){ //如果是空格
			 if (isFail){ //如果游戏失败,从头再来！
	                isFail = false;
	                init(); //重新初始化
	            }else { //否则，暂停游戏
	                isStart = !isStart;
	            }
	                repaint();//重新绘制界面
	            }
		 
	        if (keyCode==KeyEvent.VK_LEFT){
	            fx = "L";
	        }else if (keyCode==KeyEvent.VK_RIGHT){
	            fx = "R";
	        }else if (keyCode==KeyEvent.VK_UP){
	            fx = "U";
	        }else if (keyCode==KeyEvent.VK_DOWN){
	            fx = "D";
	        }
	          
	        }//写完这个监听，记得回构造器完成两个步骤

@Override
public void keyReleased(KeyEvent e) {
	//键盘弹起
	
}
@Override
public void keyTyped(KeyEvent e) {
	//键盘按下弹起后
}


@Override
	public void actionPerformed(ActionEvent e) {//执行定时操作
	        //如果游戏处于开始状态，并且没有结束，则小蛇可以移动
	        if (isStart && isFail == false){
	            //身体：即让后一个移到前一个的位置即可 !
	            for (int i = lenth-1; i > 0; i--) { //除了脑袋都往前移：身体移动
	                snakeX[i] = snakeX[i-1]; //即第i节(后一节)的位置变为(i-1：前一节)节的位置！
	                snakeY[i] = snakeY[i-1];
	            }
	           //头 
	            if (fx.equals("R")){
	                snakeX[0] = snakeX[0]+25;
	                if (snakeX[0]>850) snakeX[0] = 25;//边界判断
	            }else if (fx.equals("L")){
	                snakeX[0] = snakeX[0]-25;
	                if (snakeX[0]<25) snakeX[0] = 850;
	            }else if (fx.equals("U")){
	                snakeY[0] = snakeY[0]-25;
	                if (snakeY[0]<75) snakeY[0] = 650;
	            }else if (fx.equals("D")){
	                snakeY[0] = snakeY[0]+25;
	                if (snakeY[0]>650) snakeY[0] = 75;
	            }
	            //如果食物和头重合
	            if(snakeX[0]==foodx && snakeY[0] == foody) {
	            	lenth++;
	            	
	            	score = score + 10;
	            	//c吃完之后再生成
	            	foodx = 25 + 25*random.nextInt(34);//从0到34的范围  int bound
	            	foody = 75 + 25*random.nextInt(24);//
	           
	            }
	            
	            //结束
	            for(int i = 1; i<lenth;i++){
	            if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]) {
	            	isFail=true;
	            }
	            	
	            }
	            repaint(); 
	            
	           
	        }
	        timer.start();//让时间动起来!
	        }



}




