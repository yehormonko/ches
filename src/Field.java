import java.util.ArrayList;

/**
 * Created by Monko on 15.11.2017.
 */
public class Field {
    int size;
    int cheses=0;
    ArrayList<Square> squares = new ArrayList<>();
    public void display(){
        int number=0;
        for(int i=0;i<size;i++){
            System.out.print(i);
            for (int j = 0; j < size; j++) {
                if(!squares.get(number).getActive()) System.out.print("|"+squares.get(number).getFigure()+"    ");
                else System.out.print("|     ");
                number++;
            }
            System.out.print("\n"+" "+"|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|\n");
        }


    }

    public Field(int size){
        this.size=size;
        for(int i=0;i<size;i++){
            for (int j = 0; j < size; j++) {
                squares.add(new Square(i,j));
            }
        }
    }
    public void put(int x, int y){
        for(int i=0;i<squares.size();i++){
            if(squares.get(i).getX()==x&&squares.get(i).getY()==y){
                this.deleteElse(squares.get(i));
                squares.get(i).setFigure('T');
                squares.get(i).delete();
                cheses++;
            }
        }

    }
    public void deleteElse(Square square){
        int x;
        int y;
        int mid = size/2;
        x=square.getX();
        y=square.getY();
        int xmy=x-y;
        int ymx=y-x;
        int xpy=x+y;
        int i=0;
        int n=squares.indexOf(square);
        System.out.println(n);
        for (int p = 0; p <size ;p++) {

           // if(squares.get(i).getX()==x||squares.get(i).getY()==y||(y>x&&x+ymx==y))squares.get(i).delete();
            for (int j = 0; j <size ; j++) {

                if(squares.get(i).getX()==x||squares.get(i).getY()==y||(p-j==xmy)||(j-p==ymx)||(j+p==xpy)){
                    squares.get(i).delete();

                    }

           i++;
            n++;}


        }
    }
    public void deleteField(){
        if(cheses>8) return;
        for(int i=0;i<squares.size();i++){

            if(squares.get(i).getActive()){
                squares.get(i).setFigure('T');
                squares.get(i).delete();
                this.deleteElse(squares.get(i));
                return;

            }
        }
        this.deleteField();


    }
    public void deleteFinal(){
        while (cheses<9){
            this.deleteField();
        }
    }

}
