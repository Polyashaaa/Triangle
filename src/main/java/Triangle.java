public class Triangle {
    int point1;
    int point2;
    int point3;
    int point4;
    int point5;
    int point6;

    double lengthOfFirst;
    double lengthOfSecond;
    double lengthOfThird;

    double square;

    boolean isIsosceles(){
       if (lengthOfFirst == lengthOfSecond | lengthOfFirst == lengthOfThird | lengthOfSecond == lengthOfThird){
           return true;
       } else {
           return false;
       }
    }

    double getSquare(){
        double p = (lengthOfFirst + lengthOfSecond + lengthOfThird) / 2;
        square = Math.sqrt((p * (p - lengthOfThird) * (p - lengthOfSecond) * (p - lengthOfFirst)));
        return square;
    }

    public Triangle(int point1, int point2, int point3, int point4, int point5, int point6) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.point5 = point5;
        this.point6 = point6;

        this.lengthOfFirst = Math.abs(Math.sqrt(Math.pow((point1 - point3), 2)) + Math.pow((point2 - point4), 2));
        this.lengthOfSecond = Math.abs(Math.sqrt(Math.pow((point3 - point5), 2)) + Math.pow((point4 - point6), 2));
        this.lengthOfThird = Math.abs(Math.sqrt(Math.pow((point1 - point5), 2)) + Math.pow((point2 - point6), 2));
    }

    public Triangle() {}

    @Override
    public String toString() {
        return point1 + " " + point2 + " " + point3 + " " + point4 + " " + point5 + " " + point6;
    }
}
