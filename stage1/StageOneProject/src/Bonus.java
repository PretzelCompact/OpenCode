public class Bonus {
    //Совершенная дизъюнктивная нормальная форма
    public boolean sdnf(boolean x1, boolean x2, boolean x3, boolean x4){
        return !x1 && !x2 && x3 && x4 ||
                !x1 && x2 && !x3 && x4 ||
                !x1 && x2 && x3 && !x4 ||
                x1 && !x2 && !x3 && x4 ||
                x1 && !x2 && x3 && !x4 ||
                x1 && x2 && !x3 && !x4;
    }
    //Совершенная конъюнктивная нормальная форма
    public boolean sknf(boolean x1, boolean x2, boolean x3, boolean x4){
        return (!x1 || !x2 || !x3 || !x4) &&
                (!x1 || !x2 || !x3 || x4) &&
                (!x1 || !x2 || x3 || !x4) &&
                (!x1 || x2 || !x3 || !x4) &&
                (x1 || !x2 || !x3 || !x4) &&
                (x1 || !x2 || x3 || x4) &&
                (x1 || x2 || !x3 || x4) &&
                (x1 || x2 || x3 || !x4);
    }
    //Полином Жегалкина
    public boolean zhegalkinPolynominal(boolean x1, boolean x2, boolean x3, boolean x4){
        return (x3 && x4) ^
                (x2 && x4) ^
                (x2 && x3) ^
                (x2 && x3 && x4) ^
                (x1 && x4) ^
                (x1 && x3) ^
                (x1 && x3 && x4) ^
                (x1 && x2) ^
                (x1 && x2 && x4) ^
                (x1 && x3 && x4);
    }
    //Решение "в лоб"
    public boolean vLob(boolean x1, boolean x2, boolean x3, boolean x4){
        int counter = 0;
        if(x1)
            counter++;
        if(x2)
            counter++;
        if(x3)
            counter++;
        if(x4)
            counter++;
        return counter == 2;
    }
}
