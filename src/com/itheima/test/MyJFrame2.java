package com.itheima.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    //创建按钮
    JButton jb1 = new JButton("点我");
    public MyJFrame2(){
        //设置界面大小
        this.setSize(603,680);
        //设置标题
        this.setTitle("拼图小游戏 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认居中方式
        this.setLayout(null);
        //按钮大小
        jb1.setBounds(0,0,100,50);
        //给按钮设置鼠标事件
        jb1.addMouseListener(this);

        this.getContentPane().add(jb1);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
