import java.awt.Color;
import java.awt.*; 
// ^---Contains all of the classes for creating user interfaces and for painting graphics and images.
import java.awt.event.*;
import java.awt.event.KeyEvent;
// ^---Provides interfaces and classes for dealing with different types of events fired by AWT components.
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
/**
 * Write a description of class G4me here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Endless_Runner extends JPanel implements ActionListener{
    Enemy e0= new Enemy();
    Enemy e1= new Enemy();
    Enemy e2= new Enemy();
    Enemy e3= new Enemy();
    Blob b1= new Blob();
    Control C=new Control();
public Endless_Runner() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
    }
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
        @Override  /**press*/
        public void keyPressed(KeyEvent e) {
           System.out.println(e.getKeyCode());
           if(e.getKeyCode()==10){//enter
               C.play=1;
            }
            if (e.getKeyCode()==38){
                b1.J=1;
                b1.j=1;
            }
           else if (e.getKeyCode()==40){
                if(b1.duck==0){
                    b1.bigD=1;}
                b1.duck=1;
           }
           if(e.getKeyCode()==32){
               if (C.pause==0){C.pause=1;C.play=0;}
               else{C.pause=0;C.play=1;}
            }
    }
      @Override
        public void keyReleased(KeyEvent e) {
         if (e.getKeyCode()==38){
            /*if(b1.vy<-20){b1.vy=-15;}//Ajustable jump
            else if(b1.vy<-10){
                b1.vy=-10;}*/
                b1.j=0;
               
        }
             if (e.getKeyCode()==40){
            b1.duck=0;
            if(b1.y>=500){
                b1.fa=2;
                b1.vh=0;
            }
        }
    } 
}
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Font font1 = new Font("Verdana", Font.BOLD,40 );
        Font font2 = new Font("Verdana", Font.BOLD,50 );
        this.setBackground(new Color(209, 246, 255));
        g.setColor(new Color(0,0,0));
        //g.drawLine(0,b1.grd,1000,b1.grd);
        g.fillRect(0,500,1000,1000);
        g.setFont(font1);
        C.SCORE="Score:"+C.score;
        C.pSCORE="Score:"+C.pscore;
        g.drawString(C.SCORE,660,90);
        
        g.fillRect(e1.x,500-e1.h,e1.w,e1.h);
        g.fillRect(e2.x,500-e2.h,e2.w,e2.h);
        g.fillRect(e3.x,e3.y-e3.h,e3.w,e3.h);
        g.setColor(new Color(100,200,200));
        g.fillOval(100-b1.w/2, b1.y-b1.h, b1.w, b1.h);
        g.setColor(new Color(0,0,0));
        g.drawOval(100-b1.w/2, b1.y-b1.h, b1.w, b1.h);
        
        if (C.play==0){
          if(C.death==1){
          g.setColor(new Color(255, 51, 51));}
          else{g.setColor(new Color(153, 235, 255));}
          g.fillRect(0,0,1000,500);
          
          g.setFont(font1);
          g.setColor(new Color(0,0,0));
          g.drawString(C.his,660,150);
          g.drawString(C.pSCORE,660,90);
          
          g.setFont(font2);
          g.setColor(Color.WHITE);
          g.drawString("Press ENTER to begin",200,300);
        }
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if (C.play==1){
            C.Play();}
            else if (C.pause==1){C.Pause();}
            else if(C.death==1){C.Die();}
        else{C.Menu();}
    }
    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        // ^---This creates a frame to hold the graphics
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ^---This exits the program when you close the window
        Endless_Runner d = new Endless_Runner();
        Endless_Runner graphics = new Endless_Runner();
        // ^---This creates an object so you can access methods outside of the main method
        f.add(graphics);
        f.setSize(1000,700);
        f.setVisible(true);
        Timer t = new Timer (25, graphics);
        
        t.start();
    }
    {
        // initialise instance variables
        
    }

    class Control{
        int play,death,pause;
        int score,pscore,hs;
        String his="High Score:"+hs;
        String SCORE="Score:"+score;
        String pSCORE="Score:"+pscore;
        void Die(){
            e0= new Enemy();
            e1= new Enemy();
            e2= new Enemy();
            e3= new Enemy();
            b1= new Blob();
            pscore=score;
            score=0; 
            death=0;
        }
        void Menu(){
            if (pscore>hs){hs=pscore;}
            his="High Score:"+hs;
            repaint();
        }
        void Play(){
           if(e1.run==1){
            e1.Run();}
            else{e1.Deploy();}
        if(e2.run==1){
            e2.Run();}
             else{e2.Deploy();}
        if(e3.run==1){
            e3.Run();}
             else{e3.cDeploy();}  
            if (b1.j==1&&b1.y>=b1.grd){b1.Jump();}
        else if(b1.y>=500&&b1.duck==1){b1.Duck();
        b1.bounce=0;}
        else if(b1.fa>0){b1.Squash();}
         if (b1.y<b1.grd){b1.Fall();}
        if (b1.bounce==1){b1.Bounce();}
        e0.Deploy();
        
        repaint();
        int J=b1.J;   
        }
        void Pause(){
            
            
            
            
            
            
        }
    }
     class Enemy{
         double v=15,dist, DV,DV1=30,DT,X;
         int x,h,y, w=100;
         int run,death,cave;
         void Deploy(){
                e0.DT=e0.DT+1;
                if (e0.DT>=e0.DV ){
                    h=(int)(Math.random()*40+80);
                    x=1025;
                    e0.DV=Math.random()*20+e0.DV1;
                    e0.DT=0;
                    y=500;
                    run=1;
                }
            } 
            void cDeploy(){
                e0.DT=e0.DT+1;
                if (e0.DT>=e0.DV ){
                    h=(int)(Math.random()*40+150);
                    x=1025;
                    y=440;
                    e0.DV=Math.random()*30+2*DV1;
                    e0.DT=0;
                    run=1;
                }
            }
         void Run(){
                    x=(int)(x-e0.v);
                    if (x<=100+b1.w/2&&x>=100-w && y-h>=b1.y){b1.grd=y-h;}
                    else if(x<=100+b1.w/2&&x>=100-w && h>y-b1.y && y>b1.y-b1.h){C.death=1;
                    C.play=0;}
                    if ( x<100-w&&x>=100-w-e0.v){b1.grd=500;
                        C.score=C.score+1;
                        e0.v=e0.v+.7;
                        //DV1=DV1+1;
                    }
                    if (x<=-w){run=0;}
                }
    }
    class Blob{
        
        int x,y=500,grd=500, h=100,w=60,bh=90,bhm=12;
        int J,j,fa,bounce=1,duck,bigD=1;
        double vy,Y,c1,sA=1,y2,by,vh;
    void Jump(){
            fa=0;
            bounce=1;
            c1=1.5;
            bh=70;
            bhm=20;
            vy=-25;
            y=y-25;
            J=0;
            }
             void Fall(){
              y=(int)(y+vy);//w=50+60-h/2;
              if(duck==1){
                  if(vy<0){vy=0;}
                  y=y+15;
                }
                
              vy=vy+2;
              
                if (y>=grd){//landing
                y=grd;
                vy=0;
                 if (j==0){
                     J=0;
                     bounce=0;
                     fa=1;}
              }
        }
    void Squash(){
      if (fa==1){
        vh=-7;
        sA=1;
        fa=2;}
        h=(int)(h+vh);
        w=50+60-h/2;
        vh=vh+1;
       if (h<32){//too much squash
              vh=0;
              h=33;}
      if (h>=80&&vh>0){
        h=80;
        w=50+60-h/2;
        fa=0;
        c1=0;
        bh=90;
        bhm=12;
        bounce=1;
        sA=1;
        vy=1;
        
       }
    }
      void Bounce(){
           h=bh+(int)(bhm*Math.sin(c1));
            w=50+60-h/2;
           c1=c1+.25;
            
         }
       
            void Duck(){
            if(h>=50&&bigD==1){
               h=h-17;
               w=50+60-h/2;
               c1=0;
               System.out.println(h);
            }
               
               else{bigD=0;
                    Duck1();}
            }
         void Duck1(){
             h=40-(int)(10*Math.sin(c1));
             w=50+60-h/2;
             System.out.println(h);
             c1=c1+.3;}
    }
}