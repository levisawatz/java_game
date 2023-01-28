import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.*; 
// import javax.swing.ImageIcon;
// import javax.swing.JLabel;
// import java.awt.image.BufferedImage;
// ^---Contains all of the classes for creating user interfaces and for painting graphics and images.
import java.awt.event.*;

// ^---Provides interfaces and classes for dealing with different types of events fired by AWT components.
import javax.swing.*;
/**
 * Write a description of class Shooter
 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shooter extends JPanel implements ActionListener{
    Bullet p1=new Bullet();
    Bullet p2=new Bullet();
    Bullet p3=new Bullet();
    Bullet p4=new Bullet();
    Enemy e0= new Enemy(); Enemy e1= new Enemy(); Enemy e2= new Enemy(); Enemy e3= new Enemy(); Enemy e4= new Enemy(); Enemy e5= new Enemy();
    Token heart=new Token();Token T0=new Token();
    
   
    
    Room r1,r2= new Room();
    Blob b1= new Blob();
    Control C=new Control();
    PointerInfo a = MouseInfo.getPointerInfo();

public Shooter() {
        KeyListener listener = new MyKeyListener();
        MouseListener mlistener = new MyMouseListener();
        addMouseListener(mlistener);
        addKeyListener(listener);
        setFocusable(true);
    }
    public class MyMouseListener implements MouseListener {
     @Override
        public void mouseClicked(MouseEvent e) {

                
        }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if(p1.shoot==0){p1.shoot=1;}
        else if(p2.shoot==0){p2.shoot=1;}
        else if(p4.shoot==0){p4.shoot=1;}
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    }
    public class MyKeyListener implements KeyListener {

        @Override  /**press*/
        public void keyTyped(KeyEvent e){}
        @Override  /**press*/
        public void keyPressed(KeyEvent e) {
           //System.out.println(e.getKeyCode());
           if(e.getKeyCode()==10){//enter
               C.play=1;}
            if(e.getKeyCode()==87){b1.up=1;}
            else if(e.getKeyCode()==83){b1.up=-1;}
            if(e.getKeyCode()==68){b1.R=1;}//right
            else if(e.getKeyCode()==65){b1.R=-1;}
            if(e.getKeyCode()==32){
                if(p1.shoot==0){p1.shoot=1;}
                else if(p2.shoot==0){p2.shoot=1;}
                else if(p4.shoot==0){p4.shoot=1;}
            }
    }
      @Override
        public void keyReleased(KeyEvent e) {
         if (e.getKeyCode()==87){
            b1.up=0;
        }
        if(e.getKeyCode()==65){
                if (b1.R==-1){b1.R=0;}
            }
        if(e.getKeyCode()==68){
                if (b1.R==1){b1.R=0;}
            }
            if(e.getKeyCode()==87){
                if(b1.up==1){b1.up=0;}}
            if(e.getKeyCode()==83){ 
               if(b1.up==-1){b1.up=0;}}
    } 
}
/*private BufferedImage createT0() {
      BufferedImage t0 = new BufferedImage(70, 80, BufferedImage.TYPE_INT_ARGB);int x =(int) (10*Math.sin(e0.a));
      Graphics g = t0.getGraphics();
      g.setColor(Color.RED);
      
      g.dispose();
      return t0;
    }*/
    public void paintComponent(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
       BasicStroke thiccc = new BasicStroke(3f);
        g2d.setStroke(thiccc);
        super.paintComponent(g);
        Font font1 = new Font("Verdana", Font.BOLD,40 );
        Font font2 = new Font("Verdana", Font.BOLD,50 );
        this.setBackground(new Color(209, 246, 255));
        g.setColor(new Color(0,0,0));
        //bullet
        g.fillOval(p1.x-5,p1.y-5,10,10);
        g.fillOval(p2.x-5,p2.y-5,10,10);
        g.fillOval(p4.x-5,p4.y-5,10,10);
        g.setColor(Color.RED);
        g.fillOval(p3.x-7,p3.y-7,14,14);
        //enemies
        g.setColor(new Color(245, e1.color, e1.color));
        g.fillOval(e1.x-e1.w/2,e1.y-e1.h/2,e1.w,e1.h);
        if(e1.spawnT<65&&e1.health>=2){
            g.setColor(new Color(0,0,0));
            g.drawOval(e1.x-e1.w/2,e1.y-e1.h/2,e1.w,e1.h);}
        g.setColor(new Color(245, e2.color, e2.color));
        g.fillOval(e2.x-e2.w/2,e2.y-e2.h/2,e2.w,e2.h);
        if(e2.spawnT<65&&e2.health>=2){
            g.setColor(new Color(0,0,0));
            g.drawOval(e2.x-e2.w/2,e2.y-e2.h/2,e2.w,e2.h);}
        g.setColor(new Color(245, e3.color, e3.color));
        g.fillOval(e3.x-e3.w/2,e3.y-e3.h/2,e3.w,e3.h);
        if(e3.spawnT<65&&e3.health>=2){
            g.setColor(new Color(0,0,0));
            g.drawOval(e3.x-e3.w/2,e3.y-e3.h/2,e3.w,e3.h);}
        //g.setColor(new Color(245, e4.color, e4.color));
        g.setColor(new Color(0,0,0));
        g.fillOval(e4.x-e4.w/2,e4.y-e4.h/2,e4.w,e4.h);
        if(e4.spawnT<65&&e4.health>=2){
            g.setColor(Color.RED);
            g.drawOval(e4.x-e4.w/2,e4.y-e4.h/2,e4.w,e4.h);}
        /*g.fillRect(e3.x,e3.y,e3.w,e3.h);
        g.fillRect(e4.x,e4.y,e4.w,e4.h);
        g.fillRect(e5.x,e5.y,e5.w,e5.h);*/
        //g.drawImage(t0, e1.x, e1.y, this);
        
        BasicStroke thin = new BasicStroke(1f);
        
        g2d.setStroke(thin);
        g.setColor(new Color(0,0,0));
        g.drawRect(0,0,1000,600);
        g.setFont(font1);
        C.SCORE="Score:"+C.score;
        C.pSCORE="Score:"+C.pscore;
        g.drawString(C.SCORE,660,90);
        int healthh=b1.health;
          String healthhh= "health:"+healthh;
          g.drawString(healthhh,660,140);
        
        //g.drawRect(box1.a[1],box1.a[2],box1.a[3], box1.a[4]);
        
        g.setColor(new Color(100,200,200));
        
        g.fillOval(b1.x-b1.w/2, b1.y-b1.h/2, b1.w, b1.h);
        g.setColor(new Color(0,0,0));
        g2d.setStroke(thiccc);
        if(b1.health>=3){g.fillOval(b1.x-7, b1.y-7,14,14);}
        else if(b1.health==1){g2d.setStroke(thin);}
        
        
        g.drawOval(b1.x-b1.w/2, b1.y-b1.h/2, b1.w, b1.h);
        g.setColor(Color.PINK);
        g.fillOval(heart.x-7, heart.y-7,14,14);
        g.setColor(Color.BLACK);
        g2d.setStroke(thin);
        g.drawOval(heart.x-7, heart.y-7,14,14);
        g.drawLine(b1.x,b1.y,C.mx,C.my);
        
        if (C.play==0){
          if(C.death==1){
          g.setColor(new Color(255, 51, 51));}
          else{g.setColor(new Color(153, 235, 255));}
          g.fillRect(0,0,1000,600);
          
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
        Shooter
     d = new Shooter
    ();
        Shooter
     graphics = new Shooter
    ();
        // ^---This creates an object so you can access methods outside of the main method
        f.add(graphics);
        f.setSize(1000,600);
        f.setVisible(true);
         
        Timer t = new Timer (25, graphics);
        
        t.start();
    }
    {
        // initialise instance variables
        
    }

    class Control{
        int play,death,pause;
        int score,pscore,hs,mx,my;
        String his="High Score:"+hs;
        String SCORE="Score:"+score;
        String pSCORE="Score:"+pscore;
        void Die(){
            b1= new Blob();
            pscore=score;
            score=0; 
            death=0;
            e0= new Enemy(); e1= new Enemy(); e2= new Enemy(); e3= new Enemy(); e4= new Enemy(); 
            p1=new Bullet();p2=new Bullet();p3=new Bullet();p4=new Bullet();
        }
        void Menu(){
            if (pscore>hs){hs=pscore;}
            his="High Score:"+hs;
            repaint();
        }
        void Play(){
            a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            mx = (int) b.getX();
            my = (int) b.getY()-50;
            
            //System.out.println(mx);
            //b1.Move();
            
            
            if(b1.R!=0||b1.up!=0){b1.Move();}
            
            
            if (p1.shoot==1){p1.Shoot();}
            if (p1.shoot==2){p1.Zoom();}
            if (p2.shoot==1){p2.Shoot();}
            if (p2.shoot==2){p2.Zoom();}
            if (p4.shoot==1){p4.Shoot();}
            if (p4.shoot==2){p4.Zoom();}
            
            if (e4.e4shoot==1){p3.shoot=1;e4.e4shoot=0;p3.E4shoot();}
            if (p3.shoot==2){p3.Zoom();}
            e0.Deploy();
            if (e1.move>0){e1.eMove();}
            if (e2.move>0){e2.eMove();}
            if (e3.move>0){e3.eMove();}
            if (e4.move>0){e4.eMove();}
            if (e4.move>0){e4.eMove();}
            repaint();
           
        }
        void Pause(){
            
            
            
            
            
            
        }
    }
     class Room{
         int[] a={900,400,300,100};
         void setRoom1(){
             
             
         
            }
    }
    class Token{
        int x,y=-20,w,h;
        double randx,randy,rand;
        int active;
        void tDeploy(){
            rand=Math.random()*100;
            System.out.println("aaa");
            if(rand<10&&active==0){
                randx=Math.random()*900+50;
                randy=Math.random()*500+50;
                x=(int)randx;y=(int)randy;
                active=1;
            }
        }
    }
    class Blob{
        
        int x=300,y=250,w=50,h=50,grd=500,v=15;
        int jump, right, left,dj,room,R,up, health=3;
        double dx,dy,A,X,Y,be1;
        void Move(){
         
             if((R)>=0){
               A = Math.atan((-up)/(R+.01));
            }else{
                A = Math.PI+Math.atan((-up)/(R+.01 ));}
             dx=v* Math.cos(A);
             dy=v* Math.sin(A);  
             x=(int)(x+dx);
             y=(int)(y+dy); 
             if (x<0+w/2){x=w/2;}
             if (x>=1000-w/2){x=1000-w/2;}
             if (y<=h/2){y=h/2;}
             if (y>=600-h){y=600-h;}
             be1=Math.sqrt(Math.pow(heart.x-x,2)+Math.pow(heart.y-(y),2));
             if (be1<30){if(health<5){health=health+1;}
              heart=new Token();
            }
          /*
            if((C.mx-X)>=0){
               A = Math.atan((C.my-Y)/(C.mx-X));
            }else{
                A = Math.PI+Math.atan((C.my-Y)/(C.mx-X));}
             dx=v* Math.cos(A);
             dy=v* Math.sin(A);   
             x=(int)(X+dx);
             y=(int)(Y+dy);
             X=(X+dx);
             Y=(Y+dy);
             */
          }
        
     }
     class Bullet{
         int x=-10,y=-10,v=40;
         double A,dx,dy,X,Y,be4=100;
         int shoot;
         
         void Shoot(){
             X=b1.x;Y=b1.y;
             if((C.mx-X)>=0){
               A = Math.atan((C.my-Y)/(C.mx-X));
            }else{
                A = Math.PI+Math.atan((C.my-Y)/(C.mx-X));}
             dx=v* Math.cos(A);
             dy=v* Math.sin(A);   
             
             shoot=2; }
             void E4shoot(){X=e4.x;Y=e4.y;
                 
             if((b1.x-X)>=0){
               A = Math.atan((b1.y-Y)/(b1.x-X));
            }else{
                A = Math.PI+Math.atan((b1.y-Y)/(b1.x-X));}
                v=20;
             dx=v* Math.cos(A);
             dy=v* Math.sin(A);   
             shoot=2; }
           void Zoom(){
             x=(int)(X+dx);
             y=(int)(Y+dy);
             X=(X+dx);
             Y=(Y+dy); 
             //  kCollision
             if (x<=0||x>=1000||y<=0||y>=600){
                 shoot=0;
                 y=-10;
                 
                } 
                be4=Math.sqrt(Math.pow(p3.x-b1.x,2)+Math.pow(p3.y-(b1.y),2));
                if (be4<=40){b1.health=b1.health-1;
                     p3=new Bullet();
                     if(b1.health==0){
                     C.death=1;
                     C.play=0;}}
            }
         void Collision(){
             
            }
        }
        class Enemy{
         double dist, DV,DT,X,be1,be2,be3,be4,A,dx,dy,c1;
         int x=-100,y=440,v=9, w=70, h=70;
         int form, death,move,type,rand, spawnT, color,health=3,e4shoot;
         
         void Deploy(){
                e0.DT=e0.DT+1;
                if (e0.DT>=e0.DV ){
                    e0.DV=43;
                    e0.DT=0;
                    type=0;
                    
                    rand=(int)(Math.random()*930+35);
                   if (e1.move==0){e1.move=2;}
                   else if (e2.move==0){e2.move=2;}
                   else if (e3.move==0){e3.move=2;}
                    if (C.score>10&&rand>600&&e4.move==0){e4.move=2;}
                    if (C.score>13&&rand<300&&e4.move==0){e5.move=2;}
                   }
                  
            } 
           
         
            void eMove(){
                if(move==2){x=e0.rand;
                    spawnT=155;
                    if(C.score>13){health=3;}
                        else  if( C.score>7){health=2;}
                    else{ health=1;}
                    move=1;
                    A=Math.random()*6.28;
                    dx=v* Math.cos(A);
                    dy=v* Math.sin(A);   
                }
                spawnT=spawnT-3;
                if (spawnT<65){
                      if(spawnT<-100){spawnT=64;c1=c1+1;
                          if(b1.x-x<-200){A=Math.random()*3.14+1.57;
                    dx=v* Math.cos(A);
                    dy=v* Math.sin(A);}
                          else if(b1.x-x>200){A=Math.random()*3.14-1.57;
                    dx=v* Math.cos(A);
                    dy=v* Math.sin(A);}
                    if(c1==2){e4shoot=1;c1=0;}
                    
                }
                    x=x+(int)dx; 
                    y=y+(int)dy;
                    //walls
                if (x<=0+w/2){x=w/2;A=Math.random()*3.14-1.57;
                    dx=v* Math.cos(A);
                    dy=v* Math.sin(A);   }
                if (x>=1000-w/2){x=1000-w/2;A=Math.random()*3.14+1.57;
                    dx=v* Math.cos(A);
                    dy=v* Math.sin(A);}
                if (y<=h/2){y=h/2;dy=-dy;}
                if (y>=600-h/2){y=600-h/2;dy=-dy;}
                
                //if(b1.x-x<-400){v=-10;}
                //if(b1.x-x>400){v=10;}
                //bullet-enemy
                be1=Math.sqrt(Math.pow(p1.x-x,2)+Math.pow(p1.y-(y),2));
                be2=Math.sqrt(Math.pow(p2.x-x,2)+Math.pow(p2.y-(y),2));
                be4=Math.sqrt(Math.pow(p4.x-x,2)+Math.pow(p4.y-(y),2));
                if (be1<=40||be2<=40||be4<=40){
                    health=health-1;
                    A=A+3.14;
                    dx=v* Math.cos(A);
                    dy=v* Math.sin(A); 
                    heart.tDeploy();
                        if (health<=0){
                     x=-100;
                     move=0;
                     C.score=C.score+1;}
                }
                if (be1<=40){p1=new Bullet();}
                    if (be2<=40){p2=new Bullet();}
                     if (be4<=40){p4=new Bullet();}
                //Death
                be3=Math.sqrt(Math.pow(b1.x-x,2)+Math.pow((b1.y+b1.h/2)-(y+h/2),2));
                 if (be3<=60){
                     b1.health=b1.health-1;
                     health=health-1;
                     if (health<=0){
                        x=-100;
                        move=0;}
                     if(b1.health==0){
                     C.death=1;
                     C.play=0;}
                }
                }
                    else{color=spawnT;}
                }
               void be123()    {
                   
                }
                
                /*void e4Move(){
                if(move==2){x=1280-e0.rand;
                    if(e0.rand>600 ){v=-10;}else{v=10;}
                    spawnT=100;
                    if(C.score>17){health=2;}
                       
                    else{ health=1;}
                    move=1 ;
                    y=200;
                    w=30;h=30;
                    
                    p3.shoot=1;
                }
                spawnT=spawnT-3;
                
                if (spawnT<65){
                    if(spawnT<-80){spawnT=64;
                    p3.shoot=1;
                    
                }
                    x=x+v; 
                    //walls
                if (x<=0){x=0;v=10;}
                if (x>=1280-w){x=1280-w;v=-10;}
                
                
                //bullet-enemy
                be1=Math.sqrt(Math.pow(p1.x-x,2)+Math.pow(p1.y-(y),2));
                be2=Math.sqrt(Math.pow(p2.x-x,2)+Math.pow(p2.y-(y),2));
                if (be1<=40){
                    health=health-1;
                    p1.shoot=0; p1.y=-10;
                        if (health<=0){
                    x=-100;
                    move=0;
                    
                    C.score=C.score+1;}
                }
                    if (be2<=40){
                        health=health-1;
                        p2.shoot=0; p2.y=-10;
                        if (health<=0){
                        x=-100;
                    move=0;
                    
                    C.score=C.score+1;}
                }
                
                //Death
                be3=Math.sqrt(Math.pow(b1.x-x,2)+Math.pow((b1.y)-(y),2));
                 if (be3<=60){b1.health=b1.health-1;
                     if(b1.health<=0){
                     C.death=1;
                     C.play=0;}
                }
                }
                    else{color=spawnT;}
                
                }*/
        }

    }
