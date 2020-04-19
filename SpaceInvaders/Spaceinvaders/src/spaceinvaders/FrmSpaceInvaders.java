
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class FrmSpaceInvaders extends javax.swing.JFrame implements KeyListener{
    int even = 1;
    int locationX = 20;
    int locationY = 100;
    int escudX = 110; 
    int escudY = 400;
    int sign = 1;
    int movimientox=1;
    int movlider=1;
    int velx=5;
    int vely=10;
    int tanx=300;
    int balay=530;
    int balax;
    int disparo;
    int posbalax;
    int bloquear=32;
    int puntaje1=0;
    int puntaje2=0;
    int puntaje3=0;
    
    //para el cambio de los escudos
    int cambio=0;
    int cambio1=0;
    int cambio2=0;

    int puntajetotal=0;
    int vidas=3;
    
    Space tank = new Space(300,550); 
    Space escudo = new Space(100,360);
    Space escudo2 = new Space(350,360);
    Space escudo3 = new Space(600,360);
    Space lider = new Space (400,60);
    //Clase creada para el proyecto. 

    Space[] invader1 = new Space[10];
    Space[] invader2 = new Space[10];
    Space[] invader3 = new Space[10];
    Space[] invader1b = new Space[10];
    Space[] invader2b = new Space[10];
    Space[] invader3b = new Space[10];
    
    Space bala = new Space(balax,balay);
    
    BufferedImage imgTank=null;
    
    BufferedImage imgInvader1a=null;
    BufferedImage imgInvader1b=null;
    
    BufferedImage imgInvader2a=null;
    BufferedImage imgInvader2b=null;
    
    BufferedImage imgInvader3a=null;
    BufferedImage imgInvader3b=null;
    
    BufferedImage imgEscudo=null;
    BufferedImage imgEscudo2=null;
    BufferedImage imgEscudo3=null;
    
    BufferedImage imgBala=null;
    
    BufferedImage imgLider=null;
    
    public FrmSpaceInvaders() {
        initComponents();
        addKeyListener(this);

        for (int i=0; i<10;i++)
        {
            invader1[i] = new Space(locationX,locationY+200); 
            invader1b[i] = new Space(locationX,locationY+160); 
            invader2[i] = new Space(locationX,locationY+120); 
            invader2b[i] = new Space(locationX,locationY+80); 
            invader3[i] = new Space(locationX,locationY);
            invader3b[i] = new Space(locationX,locationY+40);
            locationX+=55;
        }
                      
      
        try { //Si hago por separado no se donde puede generarse exactamente el problema
            imgTank = ImageIO.read(new File("C:/Spaceinvaders/tank.png"));
            imgInvader1a = ImageIO.read(new File("C:/Spaceinvaders/invaders1a.png"));
            imgInvader1b = ImageIO.read(new File("C:/Spaceinvaders/invaders1b.png"));
            
            imgInvader2a = ImageIO.read(new File("C:/Spaceinvaders/invaders2a.png"));
            imgInvader2b = ImageIO.read(new File("C:/Spaceinvaders/invaders2b.png"));
            
            imgInvader3a = ImageIO.read(new File("C:/Spaceinvaders/invaders3a.png"));
            imgInvader3b = ImageIO.read(new File("C:/Spaceinvaders/invaders3b.png"));
            
            //Escudo completo
            imgEscudo = ImageIO.read(new File("C:/Spaceinvaders/escudo.png"));
            imgEscudo2 = ImageIO.read(new File("C:/Spaceinvaders/escudo1.png"));
            imgEscudo3 = ImageIO.read(new File("C:/Spaceinvaders/escudo2.png"));
            
            imgBala = ImageIO.read(new File("C:/Spaceinvaders/bala.png"));
            
            imgLider = ImageIO.read(new File ("C:/Spaceinvaders/lider.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(FrmSpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            

    }

    @Override
    public void keyTyped(KeyEvent e)
    {     
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==39)
            tank.setDrawLocationX(tank.getDrawLocationX()+10);
        else if(e.getKeyCode()==37)
            tank.setDrawLocationX(tank.getDrawLocationX()-10);  
        if(e.getKeyCode()==bloquear)
        {
            bloquear=1;
            balax = tank.getDrawLocationX()+21;
            disparo=1;
        }           
}
    @Override
    public void keyReleased(KeyEvent e)
    {

    }
    
    
    Timer temporizador=new Timer(100,new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {   
            even*=-1;
//          locationX+=sign*10;

            if (tank.getDrawLocationX()< 20 )
            {
                tank.setDrawLocationX(20);
            }
            if (tank.getDrawLocationX() > 720)
            {
                tank.setDrawLocationX(720);
            }
            
            if (disparo == 1)
            {
                bala.setDrawLocationY(bala.getDrawLocationY()-20);
                
            }
            if (bala.getDrawLocationY()<0)
                {
                    disparo=0;
                    bloquear=32;
                    bala.setDrawLocationY(530);
                }
            
            if (lider.getDrawLocationX() > 720 || lider.getDrawLocationX()<20)
            {
                movlider*=-1;
                lider.setDrawLocationY(lider.getDrawLocationY()+vely);
            }
            
            if (movlider == 1)
            {
                lider.setDrawLocationX(lider.getDrawLocationX()+velx);
            }
            else if (movlider == -1)
            {
                lider.setDrawLocationX(lider.getDrawLocationX()-velx);
            }
            
            
                 
            for (int i=0;i<10;i++)
            {
                if (invader1[i].getDrawLocationX()< 20 ||  invader1[i].getDrawLocationX() > 720 ||
                    invader1b[i].getDrawLocationX()< 20 ||  invader1b[i].getDrawLocationX() > 720 ||
                    invader2[i].getDrawLocationX()< 20 ||  invader2[i].getDrawLocationX() > 720 ||
                    invader2b[i].getDrawLocationX()< 20 ||  invader2b[i].getDrawLocationX() > 720 ||
                    invader3[i].getDrawLocationX()< 20 ||  invader3[i].getDrawLocationX() > 720 ||
                    invader3b[i].getDrawLocationX()< 20 ||  invader3b[i].getDrawLocationX() > 720)     
                {
                    movimientox*=-1;
                    for (int j=0;j<10;j++)
                    {
                        invader1[j].setDrawLocationY(invader1[j].getDrawLocationY()+vely); 
                        invader1b[j].setDrawLocationY(invader1b[j].getDrawLocationY()+vely);
                        invader2[j].setDrawLocationY(invader2[j].getDrawLocationY()+vely);
                        invader2b[j].setDrawLocationY(invader2b[j].getDrawLocationY()+vely);
                        invader3[j].setDrawLocationY(invader3[j].getDrawLocationY()+vely);
                        invader3b[j].setDrawLocationY(invader3b[j].getDrawLocationY()+vely);
                    }
                    
                }
            }
            
            if (movimientox == 1)
            {
                
                for (int i=0;i<10;i++)
                {
                    invader1[i].setDrawLocationX(invader1[i].getDrawLocationX()+velx); 
                    invader1b[i].setDrawLocationX(invader1b[i].getDrawLocationX()+velx);
                    invader2[i].setDrawLocationX(invader2[i].getDrawLocationX()+velx);
                    invader2b[i].setDrawLocationX(invader2b[i].getDrawLocationX()+velx);
                    invader3[i].setDrawLocationX(invader3[i].getDrawLocationX()+velx);
                    invader3b[i].setDrawLocationX(invader3b[i].getDrawLocationX()+velx);
                }
            }
            else if (movimientox == -1)
            {
                for (int i=0;i<10;i++)
                {
                    invader1[i].setDrawLocationX(invader1[i].getDrawLocationX()-velx); 
                    invader1b[i].setDrawLocationX(invader1b[i].getDrawLocationX()-velx);
                    invader2[i].setDrawLocationX(invader2[i].getDrawLocationX()-velx);
                    invader2b[i].setDrawLocationX(invader2b[i].getDrawLocationX()-velx);
                    invader3[i].setDrawLocationX(invader3[i].getDrawLocationX()-velx);
                    invader3b[i].setDrawLocationX(invader3b[i].getDrawLocationX()-velx);
                }
            }
            
            //Reciben las balas cada invader
            for (int h=0;h<10;h++)
            {
                double distancia=Math.sqrt(Math.pow(invader1[h].getDrawLocationX()+20  - balax,2)+Math.pow(invader1[h].getDrawLocationY()+15 - bala.getDrawLocationY(),2));
                if (distancia<=25)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    invader1[h].setDrawLocationY(2000);
                    invader1[h].setDrawLocationX(300);
                    invader1[h].seta(false);
                    puntaje1+=10;
                    
                }
                
                double distancia2=Math.sqrt(Math.pow(invader1b[h].getDrawLocationX()+20 - balax,2)+Math.pow(invader1b[h].getDrawLocationY()+15- bala.getDrawLocationY(),2));
                if (distancia2 <=25)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    invader1b[h].setDrawLocationX(300);
                    invader1b[h].setDrawLocationY(2000);
                    invader1b[h].seta(false);
                    puntaje1+=10;
                }
                
                double distancia3=Math.sqrt(Math.pow(invader2[h].getDrawLocationX()+20 - balax,2)+Math.pow(invader2[h].getDrawLocationY()+15- bala.getDrawLocationY(),2));
                if (distancia3 <=25)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    invader2[h].setDrawLocationX(300);
                    invader2[h].setDrawLocationY(2000);
                    invader2[h].seta(false);
                    puntaje2+=20;
                }
                
                double distancia4=Math.sqrt(Math.pow(invader2b[h].getDrawLocationX()+20 - balax,2)+Math.pow(invader2b[h].getDrawLocationY()+15- bala.getDrawLocationY(),2));
                if (distancia4 <=25)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    invader2b[h].setDrawLocationX(300);
                    invader2b[h].setDrawLocationY(2000);
                    invader2b[h].seta(false);
                    puntaje2+=20;
                }
                
                double distancia5=Math.sqrt(Math.pow(invader3[h].getDrawLocationX()+20 - balax,2)+Math.pow(invader3[h].getDrawLocationY()+15- bala.getDrawLocationY(),2));
                if (distancia5 <=25)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    invader3[h].setDrawLocationX(300);
                    invader3[h].setDrawLocationY(2000);
                    invader3[h].seta(false);
                    puntaje3+=40;
                }
                
                double distancia6=Math.sqrt(Math.pow(invader3b[h].getDrawLocationX()+20 - balax,2)+Math.pow(invader3b[h].getDrawLocationY()+15- bala.getDrawLocationY(),2));
                if (distancia6 <=25)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    invader3b[h].setDrawLocationX(300);
                    invader3b[h].setDrawLocationY(2000);
                    invader3b[h].seta(false);
                    puntaje3+=40;
                }
                
                double descudo=Math.sqrt(Math.pow(escudo.getDrawLocationX()+65 - balax,2)+Math.pow(escudo.getDrawLocationY()+25- bala.getDrawLocationY(),2));
                if (descudo <=30)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    cambio+=1;
                }
                
                double descudo2=Math.sqrt(Math.pow(escudo2.getDrawLocationX()+65 - balax,2)+Math.pow(escudo2.getDrawLocationY()+25- bala.getDrawLocationY(),2));
                if (descudo2 <=30)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    cambio1+=1;
                }
                
                double descudo3=Math.sqrt(Math.pow(escudo3.getDrawLocationX()+65 - balax,2)+Math.pow(escudo3.getDrawLocationY()+25- bala.getDrawLocationY(),2));
                if (descudo3 <=30)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    cambio2+=1;
                }
                
                double dlider=Math.sqrt(Math.pow(lider.getDrawLocationX()+50 - balax,2)+Math.pow(lider.getDrawLocationY()+25- bala.getDrawLocationY(),2));
                if (dlider <=25)
                {
                    bala.setDrawLocationY(530);
                    disparo=0;
                    bloquear=32;
                    lider.setescudo(false);
                    lider.setDrawLocationX(300);
                    lider.setDrawLocationY(2000);
                }
            }
            
            puntajetotal=puntaje1+puntaje2+puntaje3;                     
            repaint(); //llamada del repaint
        }
    });
    
    public void paint(Graphics g)
    {
        super.paint(g); //Primera linea de código
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.ITALIC,20));
        g.drawString("U I D E",360,50);
        g.drawString("Puntaje: ",600,50);
        g.drawString(String.valueOf(puntajetotal), 700, 50);
        g.drawString("Vidas: ",80,50);
        g.drawString(String.valueOf(vidas),150,50);
        
        g.drawImage(imgTank, tank.getDrawLocationX(),tank.getDrawLocationY(),50,50,this);
        //El 50,50 es para escalar la imagen. 
        
        if (escudo.getescudo()==true)
        {
            if (cambio == 0) //Primer Escudo
            {
                g.drawImage(imgEscudo, escudo.getDrawLocationX(),escudo.getDrawLocationY(),135,135,this);
            }
            else if(cambio==1)
            {
                g.drawImage(imgEscudo2, escudo.getDrawLocationX(),escudo.getDrawLocationY(),115,120,this);
            }
            else if (cambio==2)
            {
                g.drawImage(imgEscudo3, escudo.getDrawLocationX(),escudo.getDrawLocationY(),125,120,this);
            }
            else if (cambio>2)
            {
                escudo.setescudo(false);
                escudo.setDrawLocationX(300);
                escudo.setDrawLocationY(2000);
            }   
            
        }
        
        ////////////////////////////////////
        
        if (escudo2.getescudo() == true)
        {
            if (cambio1 == 0) //Segundo escudo
            {
                g.drawImage(imgEscudo, escudo2.getDrawLocationX(),escudo2.getDrawLocationY(),135,135,this);
            }
            else if(cambio1==1)
            {
                g.drawImage(imgEscudo2, escudo2.getDrawLocationX(),escudo2.getDrawLocationY(),115,120,this);
            }
            else if (cambio1==2)
            {
                g.drawImage(imgEscudo3, escudo2.getDrawLocationX(),escudo2.getDrawLocationY(),125,120,this);
            }
            else if (cambio1 > 2)
            {
                escudo2.setescudo(false);
                escudo2.setDrawLocationX(300);
                escudo2.setDrawLocationY(2000);
            }
        }
        /////////////////////////////////////
        
        if (escudo3.getescudo() == true)
        {
            if (cambio2 == 0) //Segundo escudo
            {
                g.drawImage(imgEscudo, escudo3.getDrawLocationX(),escudo3.getDrawLocationY(),135,135,this);
            }
            else if(cambio2==1)
            {
                g.drawImage(imgEscudo2, escudo3.getDrawLocationX(),escudo3.getDrawLocationY(),115,120,this);
            }
            else if (cambio2==2)
            {
                g.drawImage(imgEscudo3, escudo3.getDrawLocationX(),escudo3.getDrawLocationY(),125,120,this);
            }
            else if (cambio2 > 2)
            {
                escudo3.setescudo(false);
                escudo3.setDrawLocationX(300);
                escudo3.setDrawLocationY(2000);
            }
        }
        
        if (lider.getescudo() == true)
        {
            g.drawImage(imgLider, lider.getDrawLocationX(),lider.getDrawLocationY(),40,30,this);
        }
        else if (lider.getescudo() == false)
        {
            g.drawImage(imgLider, lider.getDrawLocationX(),lider.getDrawLocationY(),0,0,this);
        }
        
        //bala
        if (disparo == 1)
        {
            g.drawImage(imgBala,balax,bala.getDrawLocationY(),10,20,this); //2 donde dibujas, 2 cuanto escalas
        }
        
        //Abajo el if (even), variable para alternar entre la iamgen 1 y 2 de cada invasor
        if(even == 1) //Si valen -1, muestra iamgenes b de cada uno
        {
            for (int i=0; i<10;i++)
            {
                //Cada imagen esta escalada igual, imagen para los cambios.
                if (invader1[i].geta() == true)
                {
                    g.drawImage(imgInvader1a, invader1[i].getDrawLocationX(),invader1[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader1a, invader1[i].getDrawLocationX(),invader1[i].getDrawLocationY(),0,0,this);
                }
                if (invader1b[i].geta() == true)
                {
                    g.drawImage(imgInvader1a, invader1b[i].getDrawLocationX(),invader1b[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader1a, invader1b[i].getDrawLocationX(),invader1b[i].getDrawLocationY(),0,0,this);
                }
                if (invader2[i].geta() == true)
                {
                    g.drawImage(imgInvader1a, invader2[i].getDrawLocationX(),invader2[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader1a, invader2[i].getDrawLocationX(),invader2[i].getDrawLocationY(),0,0,this);
                }
                if (invader2b[i].geta() == true)
                {
                    g.drawImage(imgInvader1a, invader2b[i].getDrawLocationX(),invader2b[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader1a, invader2b[i].getDrawLocationX(),invader2b[i].getDrawLocationY(),0,0,this);
                }
                if (invader3[i].geta() == true)
                {
                    g.drawImage(imgInvader3a, invader3[i].getDrawLocationX(),invader3[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader3a, invader3[i].getDrawLocationX(),invader3[i].getDrawLocationY(),0,0,this);
                }
                if (invader3b[i].geta() == true)
                {
                    g.drawImage(imgInvader3a, invader3b[i].getDrawLocationX(),invader3b[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader3a, invader3b[i].getDrawLocationX(),invader3b[i].getDrawLocationY(),0,0,this);
                }
            }
        }
        else
        {
            for (int i=0; i<10;i++)
            {
                if (invader1[i].geta() == true)
                {
                    g.drawImage(imgInvader1b, invader1[i].getDrawLocationX(),invader1[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader1b, invader1[i].getDrawLocationX(),invader1[i].getDrawLocationY(),0,0,this);
                }
                if (invader1b[i].geta() == true)
                {
                    g.drawImage(imgInvader1b, invader1b[i].getDrawLocationX(),invader1b[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader1b, invader1b[i].getDrawLocationX(),invader1b[i].getDrawLocationY(),0,0,this);
                }
                if (invader2[i].geta() == true)
                {
                    g.drawImage(imgInvader2b, invader2[i].getDrawLocationX(),invader2[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader2b, invader2[i].getDrawLocationX(),invader2[i].getDrawLocationY(),0,0,this);
                }
                if (invader2b[i].geta() == true)
                {
                    g.drawImage(imgInvader2b, invader2b[i].getDrawLocationX(),invader2b[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader2b, invader2b[i].getDrawLocationX(),invader2b[i].getDrawLocationY(),0,0,this);
                }
                if (invader3[i].geta() == true)
                {
                    g.drawImage(imgInvader3b, invader3[i].getDrawLocationX(),invader3[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader3b, invader3[i].getDrawLocationX(),invader3[i].getDrawLocationY(),0,0,this);
                }
                if (invader3b[i].geta() == true)
                {
                    g.drawImage(imgInvader3b, invader3b[i].getDrawLocationX(),invader3b[i].getDrawLocationY(),40,30,this);
                }
                else
                {
                    g.drawImage(imgInvader3b, invader3b[i].getDrawLocationX(),invader3b[i].getDrawLocationY(),0,0,this);
                }
            }
        }
        //g.drawImage(img, 250, 30,340,120,90,0,180,90,this);//con llama
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        temporizador.start();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSpaceInvaders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSpaceInvaders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSpaceInvaders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSpaceInvaders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSpaceInvaders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
