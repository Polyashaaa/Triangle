import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String openFile = args[0];
        String resultFile = args[1];
        Triangle theBiggestTriangle = new Triangle();
        double theBiggestSquare = 0.0;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(openFile), StandardCharsets.UTF_8);
            for (String line : lines) {
                line.trim();
                long countOfSpace = line.chars().filter(num -> num == ' ').count();
                if (countOfSpace == 5) {
                    for (String num : line.split(" ")) {
                        int[] point = new int[6];
                        for (int i = 0; i <= 5; i++) {
                            point[i] = Integer.parseInt(num);
                        }
                        Triangle triangle = new Triangle(point[0], point[1], point[2], point[3], point[4], point[5]);
                        if (triangle.isIsosceles() & triangle.getSquare() >= theBiggestSquare){
                            theBiggestSquare = triangle.square;
                            theBiggestTriangle = triangle;
                        }
                    }
                }
            }
            if (theBiggestSquare == 0.0){
                Files.write(Paths.get(resultFile), Collections.singleton("К сожалению, равнобедренных треугольников не найдено."));
            } else {
                Files.write(Paths.get(resultFile), Collections.singleton(theBiggestTriangle.toString()));
            }

            List<String> linesToOut = Files.readAllLines(Paths.get(resultFile), StandardCharsets.UTF_8);
            for (String line : linesToOut) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
