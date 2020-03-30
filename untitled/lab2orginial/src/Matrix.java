import java.util.*;

class Matrix {
    private double []data;
    private int rows;
    private int cols;

    Matrix(int rows_, int cols_){
        this.rows = rows_;
        this.cols = cols_;
        this.data = new double[rows*cols];

    }

    Matrix(int rows_, int cols_, double []data_){
        this.rows = rows_;
        this.cols = cols_;
        this.data = data_;

    }

    private void reserve(double[][] d){
        int counter = 0;
        for(int i=0; i<d.length; i++){
            if(d[i].length > counter){
                counter = d[i].length;
            }
        }
        this.rows = d.length;
        this.cols = counter;

    }

    private double [][] reserveforArray(){
        double [][] tab = new double[rows][];
        for(int i=0; i<rows; i++){
            int counter =0;
            for(int j=0; j<cols; j++){
                if(this.data[(this.rows * i) + j] != 0){
                    counter++;
                }
            }
            tab[i] = new double[counter];
        }
        return tab;
    }

    Matrix(double [][]d){
        reserve(d);
        int counter = 0;
        double []tab = new double[this.rows * this.cols];
        for(int i=0; i<d.length; i++){
            for(int j=0; j<d[i].length; j++){
                tab[counter++] = d[i][j];
            }
            if(d[i].length < cols){
                int counter_2 = cols - d[i].length;
                while(counter_2 != 0){
                    tab[counter++] = 0;
                    counter_2--;
                }
            }
        }
        this.data = tab;
    }

    private double[][] asArray(){
        double [][]tab = reserveforArray();
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++){
                if (this.data[(this.rows * i) + j] != 0){
                    tab[i][j] = this.data[(this.rows * i) + j];
                }
            }
        return tab;
    }

    void printMatrix(){
        for(int i=0; i<rows*cols; i++){
            System.out.println(data[i]);
        }
    }

    void printArray(){
        double [][]tab = asArray();
        for(int i=0; i<tab.length; i++){
            for(int j=0; j<tab[i].length; j++){
                System.out.print( tab[i][j] + " " ) ;
            }
            System.out.println(" ");
        }
    }

    double get(int r, int c){
        return data[(rows * r) + c];
    }

    void set(int r, int c, double value){
        data[(rows * r) + c] = value;
    }

    public String toString(){
        StringBuilder buf = new StringBuilder();
        double [][]tab = this.asArray();
        for(int i=0; i<tab.length; i++){
            buf.append('[');
            for(int j=0; j<tab[i].length; j++){
                buf.append(tab[i][j]);
                buf.append(' ');
            }
            buf.append(']');
        }
        return buf.toString();

    }

    int getRows(){ return this.rows; }
    int getCols(){ return this.cols; }
    double []getData() { return this.data; }

    int choosebiggerRows(Matrix m){
        if(m.getRows() > rows){
            return m.getRows();
        }
        else{
            return rows;
        }
    }

    int choosebiggerCols(Matrix m){
        if(m.getCols() > cols){
            return m.getCols();
        }
        else{
            return cols;
        }
    }


    Matrix addMatrix(Matrix m){
        int new_rows = this.choosebiggerRows(m);
        int new_cols = this.choosebiggerCols(m);
        double []tab = new double[new_rows * new_cols];
        int counter_1 = 0;
        for(int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                tab[counter_1++] = data[(i * rows) + j];
            }
        }
        int counter_2 =0;
        for(int a=0; a<m.getRows(); a++) {
            for (int b = 0; b < m.getCols(); b++) {
                tab[counter_2++] += m.getData()[(a * m.getRows()) + b];
            }
        }
        Matrix new_matrix = new Matrix(new_rows, new_cols, tab);
        return new_matrix;
    }

    public static void main(String[] arg){
        double [][]new_d = {{1,2,3}, {4,5}, {6}};
        double [][]new_d1 = {{9,8,7}, {6,5,10}, {4,4,4}};
        Matrix m1 = new Matrix(new_d);
        Matrix m2 = new Matrix(new_d1);
        Matrix m3= m1.addMatrix(m2);
        m3.printArray();
    }

}