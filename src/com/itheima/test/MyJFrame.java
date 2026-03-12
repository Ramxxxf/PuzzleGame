package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jb2 = new JButton("点我");
    //创建按钮
    JButton jb1 = new JButton("点我");
    public MyJFrame(){
        //设置界面大小
        this.setSize(603, 680);
        //设置标题
        this.setTitle("事件演示");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认居中方式
        this.setLayout(null);



        //设置位置和宽高
        jb1.setBounds(0, 0, 100, 50);
        //添加事件
        jb1.addActionListener(this);


        jb2.setBounds(100, 0, 100, 50);
        jb2.addActionListener(this);

        this.getContentPane().add(jb1);
        this.getContentPane().add(jb2);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被操作的按钮对象
        Object source = e.getSource();
        if (jb1==source) {
            jb1.setSize(200,200);
        } else if (jb2==source) {
            Random r=new Random();
            jb2.setLocation(r.nextInt(500),r.nextInt(500));
            
        }
    }


}
