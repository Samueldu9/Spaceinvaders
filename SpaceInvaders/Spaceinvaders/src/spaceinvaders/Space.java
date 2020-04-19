/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 *
 * @author samue
 */
public class Space {
    private int drawLocationX;
    private int drawLocationY;
    private boolean a;
    private boolean escudo;
    
    public Space(int dLocationX, int dLocationY)
    {
        this.drawLocationX = dLocationX;
        this.drawLocationY = dLocationY;
        this.a=true;
        this.escudo=true;
    }
    
    public void setDrawLocationX(int dLocationX)
    {
        this.drawLocationX = dLocationX;
    }
    
    public void setDrawLocationY(int dLocationY)
    {
        this.drawLocationY = dLocationY;
    }
    
    public void seta(boolean a)
    {
        this.a = false;
    }
    
    public void setescudo(boolean escudo)
    {
        this.escudo=false;
    }
    
    public int getDrawLocationX()
    {
        return drawLocationX;
    }
    
    public int getDrawLocationY()
    {
        return drawLocationY;
    }
    
    public boolean geta()
    {
        return a;
    }
    
    public boolean getescudo()
    {
        return escudo;
    }
    
}
