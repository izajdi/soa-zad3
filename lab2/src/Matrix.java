class Matrix {
    double []data;
    int rows;
    int cols;

    Matrix(int rows_, int cols_){
        this.rows = rows_;
        this.cols = cols_;
        this.data = new double[rows*cols];

    }

    void reserve(double d[][]){
        int counter = 0;
        for(int i=0; i<d.length; i++){
            if(d[i].length > counter){
                counter = d[i].length;
            }
        }
        this.rows = d.length;
        this.cols = counter;

    }

    double [][] reserveforArray(){
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

    double[][] asArray(){
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

    public static void main(String[] arg){
        double [][]new_d = {{1,2,3}, {4,5}, {6}};
        Matrix m = new Matrix(new_d);
        int a = 2; int b = 0;
        double value = 7.5;
        m.set(a, b, value);
        System.out.println( m.get (a, b));
        m.printArray();
    }

}
