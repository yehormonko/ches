import java.util.ArrayList;

/**
 * Created by Monko on 15.11.2017.
 */
public class Field {
    int size;
    int cheses=8;
    ArrayList<Square> squares = new ArrayList<>();
    public void display(){
        int number=0;
        for(int i=0;i<size;i++){
            System.out.print(i);
            for (int j = 0; j < size; j++) {
                if(!squares.get(number).getActive()) System.out.print("|"+squares.get(number).getFigure()+"    ");
                else System.out.print("|0    ");
                number++;
            }
            System.out.print("\n"+" "+"|_____|_____|_____|_____|_____|_____|_____|_____|\n");
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

            }
        }

    }
    public void deleteElse(Square square){
        int x;
        int y;

        x=square.getX();
        y=square.getY();
        int xmy=x-y;
        int ymx=y-x;
        int xpy=x+y;
        int i=0;
        for (int p = 0; p <size ;p++) {


            for (int j = 0; j <size ; j++) {

                if(squares.get(i).getX()==x||squares.get(i).getY()==y||(p-j==xmy)||(j-p==ymx)||(j+p==xpy)){
                    squares.get(i).delete();

                    }

           i++;
            }


        }
    }
    public int countSquares(Square square){
        int x;
        int y;
        int amount=0;
        x=square.getX();
        y=square.getY();
        int xmy=x-y;
        int ymx=y-x;
        int xpy=x+y;
        int i=0;
        for (int p = 0; p <size ;p++) {


            for (int j = 0; j <size ; j++) {

                if((squares.get(i).getX()==x||squares.get(i).getY()==y||(p-j==xmy)||(j-p==ymx)||(j+p==xpy))&&(squares.get(i).getActive())){
                  amount++  ;

                }

                i++;
            }


        }
    return amount;}

    public void deleteField(){
      //  if(cheses>8) return;
        int min=100;
        int ind=-1;
        for(int i=0;i<squares.size();i++) {
            if (squares.get(i).getActive()) {
                int temp = this.countSquares(squares.get(i));
                if (temp < min) {
                    min = temp;
                    ind = i;

                }
            }
        }
     //   for(int i=0;i<squares.size();i++){

//            if(squares.get(i).getActive()){
//                char ch=Integer.toString(i).toCharArray()[0];
//                System.out.println(i+" "+this.countSquares(squares.get(i)));
//                squares.get(i).setFigure(ch);
        System.out.println(squares.get(ind).getX()+" "+squares.get(ind).getY());
        char ch=Integer.toString(9-cheses).toCharArray()[0];
        cheses--;
        squares.get(ind).setFigure(ch);
                squares.get(ind).delete();
                this.deleteElse(squares.get(ind));
//                return;
//
//            }
        }
       // this.deleteField();



    public Square getSquare(int i){
        return squares.get(i);
    }
    public void deleteFinal(){
        while (cheses<9){
            this.deleteField();
        }
    }

}
