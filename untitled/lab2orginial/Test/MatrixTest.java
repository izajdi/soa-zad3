import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void printMatrix() {
    }

    @org.junit.jupiter.api.Test
    void printArray() {
    }

    @org.junit.jupiter.api.Test
    void get() {
        Matrix m1 = new Matrix(4,4);
        m1.set(3,3,3);
        double a =3;
        assertEquals(a, m1.get(3,3));
    }

    @org.junit.jupiter.api.Test
    void set() {
        Matrix m1 = new Matrix(4,4);
        m1.set(3,3,3);
        double a=3;
        assertEquals(a, m1.get(3,3));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void getRows() {

    }

    @org.junit.jupiter.api.Test
    void getCols() {
    }

    @org.junit.jupiter.api.Test
    void getData() {
    }

    @org.junit.jupiter.api.Test
    void choosebiggerRows() {
    }

    @org.junit.jupiter.api.Test
    void choosebiggerCols() {
    }

    @org.junit.jupiter.api.Test
    void addMatrix() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void testXXXX(){
        double [][]tab = {{1,2,3},{4,5},{},{6}};
        Matrix m1 = new Matrix(tab);
        double []tab1 = {1,2,3,4,5,0,0,0,0,6,0,0};
        assertArrayEquals(tab1, m1.getData());

    }
}