/**
 * Created by Monko on 15.11.2017.
 */
public class Square {
    int x;
    int y;
    char figure='1';
    public void setFigure(char character){
        this.figure=character;
    }
    public char getFigure(){
        return figure;
    }
    boolean active;
    public Square(int x,int y){
        this.x=x;
        this.y=y;
        active = true;
    }
    public boolean getActive(){return active;}
    public void delete(){
        active =false;
    }
    public int getX(){return x;}
    public int getY(){return y;}


}
