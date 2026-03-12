package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 {
    static void main(String[] args) {
        JFrame jFrame=new JFrame();
        //设置界面大小
        jFrame.setSize(603,680);
        //设置标题
        jFrame.setTitle("事件演示");
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(3);
        //取消默认居中方式
        jFrame.setLayout(null);


        //创建按钮
        JButton jb=new JButton("点我");
        //设置位置和宽高
        jb.setBounds(0,0,100,50);
        //给按钮添加动作监听(鼠标左键,空ge)
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("别点我");
            }
        });
        //将按钮添加到界面中
        jFrame.getContentPane().add(jb);

        //可视化
        jFrame.setVisible(true);
    }

}
