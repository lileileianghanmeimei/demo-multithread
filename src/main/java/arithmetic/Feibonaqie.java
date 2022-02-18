package arithmetic;

/**
 * 斐波那契数列
 * n=1, 1
 * n=2, 1
 * n>2, f(n)=f(n-2)+f(n-1)
 */
public class Feibonaqie {

    //递归调用
    public int getFeibonaqie(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return getFeibonaqie(n - 2) + getFeibonaqie(n - 1);
    }

    public int getFeibonaqie2 (int n) {
        if(n <= 2) return 1;
        int numberOne, numberTwo, numberThree=1;
        numberOne = 1;
        numberTwo = 1;
        for(int i = 3; i <=n; i++) {
            numberThree = numberOne + numberTwo;
            numberOne = numberTwo;
            numberTwo = numberThree;
        }
        return numberThree;
    }

    public static void main(String[] args) {
        Feibonaqie f = new Feibonaqie();
        int value = f.getFeibonaqie2(6);
        System.out.println(value);
    }
}