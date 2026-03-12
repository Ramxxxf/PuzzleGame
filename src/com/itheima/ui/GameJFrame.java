package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][]data=new int[4][4];
    //记录空白方块在二维数组中的位置
    int x=0;
    int y=0;
    int [][] win=new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0}
    };

    //定义变量统计步数
    int step=0;
    //创建选项下面的条目
    JMenuItem replayTtem=new JMenuItem("重新游戏");
    JMenuItem reloginTtem=new JMenuItem("重新登陆");
    JMenuItem closeTtem=new JMenuItem("关闭游戏");

    JMenuItem accountTtem=new JMenuItem("微信号");

    public GameJFrame(){

        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenubar();
        //初始化数据(打乱)
        initData();
        //初始化图片
        initImage();

        //可视化
        this.setVisible(true);
    }
    //初始化数据(打乱)
    private void initData() {
        int[]tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //创建二维数组,将打乱后的一维数组存到二维数组中

        for (int i = 0; i < tempArr.length; i++) {
            //得到0图片的位置
            if (tempArr[i]==0) {
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=tempArr[i];


        }

    }

    //初始化图片
    private void initImage() {
        this.getContentPane().removeAll();
        //判断和添加胜利图标
        if(victory()){
            JLabel victory=new JLabel(new ImageIcon("E:\\IDEA\\project\\puzzlegame\\image\\win.png"));
            victory.setBounds(203,283,197,73);
            this.getContentPane().add(victory);
        }
        //添加步数
        JLabel stepcount=new JLabel("步数: "+step);
        stepcount.setBounds(50,30,100,20);
        this.getContentPane().add(stepcount);
        //循环添加
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建图片的imageicon对象
                //创建jlabel对象
                int num = data[i][j];
                JLabel jLabel=new JLabel(new ImageIcon("E:\\IDEA\\project\\puzzlegame\\image\\girl\\girl2\\"+num+".jpg"));
                //指定位置
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(1));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        ImageIcon bg=new ImageIcon("E:\\IDEA\\project\\puzzlegame\\image\\background.png");
        JLabel background=new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);
        //刷新
        this.getContentPane().repaint();


    }

    //初始化菜单
    private void initJMenubar() {
        //创建整个菜单对象
        JMenuBar jMenuBar=new JMenuBar();
        //创建菜单上的两个选项
        JMenu functionJMene=new JMenu("功能");
        JMenu aboutJMene=new JMenu("关于我们");

        //添加条目
        functionJMene.add(replayTtem);
        functionJMene.add(reloginTtem);
        functionJMene.add(closeTtem);

        aboutJMene.add(accountTtem);

        //给条目绑定事件
        replayTtem.addActionListener(this);
        reloginTtem.addActionListener(this);
        closeTtem.addActionListener(this);
        accountTtem.addActionListener(this);

        //添加选项
        jMenuBar.add(functionJMene);
        jMenuBar.add(aboutJMene);

        //给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }
    //初始化界面
    private void initJFrame() {
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
        //添加键盘监听
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }
    //按下不松手会调用这个
    @Override
    public void keyPressed(KeyEvent e) {
        //按住a显示完整图片
        int keyCode = e.getKeyCode();
        if (keyCode==65) {
            //清除所有图片
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel all=new JLabel(new ImageIcon("E:\\IDEA\\project\\puzzlegame\\image\\animal\\animal3\\all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //加载背景图
            ImageIcon bg=new ImageIcon("E:\\IDEA\\project\\puzzlegame\\image\\background.png");
            JLabel background=new JLabel(bg);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
         if(victory()){
             return;
         }
        //上38 下40  左37  右39
        int keyCode = e.getKeyCode();
        if(keyCode==37){    //左
            if(y==3){
                return;
            }
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            step++;
            initImage();
        } else if (keyCode==38) {   //上
            if(x==3){
                return;
            }
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            step++;
            initImage();
        } else if (keyCode==39) {   //右
            if(y==0){
                return;
            }
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            step++;
            initImage();
        } else if (keyCode==40) {   //下
            if(x==0){
                return;
            }
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            step++;
            initImage();
        } else if (keyCode==65) {   //松开a后重新加载
            initImage();
        } else if (keyCode==87) {
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }
    //判断胜利
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==replayTtem){
            //重新打乱数组
            initData();
            //计步器清零
            step=0;
            //重新生成图片
            initImage();

        } else if (source==reloginTtem) {
            //关闭当前界面
            this.setVisible(false);
            //打开登陆界面
            new LoginJFrame();
        } else if (source==closeTtem) {
            //关闭游戏
            System.exit(0);
        } else if (source==accountTtem) {
            //创建弹窗对象
            JDialog jDialog=new JDialog();
            //创建管理图片的容器对象
            JLabel jLabel=new JLabel(new ImageIcon("E:\\IDEA\\project\\puzzlegame\\image\\about.png"));
            //设置图片位置和大小
            jLabel.setBounds(0,0,258,258);
            //添加到弹窗中
            jDialog.getContentPane().add(jLabel);
            //设置弹窗大小
            jDialog.setSize(344,344);
            //置顶弹窗
            jDialog.setAlwaysOnTop(true);
            //弹窗居中
            jDialog.setLocationRelativeTo(null);
            //弹窗不关闭无法操作下面的界面
            jDialog.setModal(true);
            //显示弹窗
            jDialog.setVisible(true);
        }
    }
}
