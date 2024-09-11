
import java.util.Scanner;

class Grader {
    private int score;

    public Grader(int score) {
        this.score = score;
    }

    public String letterGrade() {
        if (score >= 90) {
            return "S";
        } else if (score >= 80) {
            return "A++";
        } else if (score >= 70) {
            return "A";
        } else if (score >= 60) {
            return "B";
        } else if (score >= 50) {
             return "C";
        } else {
            return "D";
        }
    }
}
public class MAIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the score card  : ");
        int score = sc.nextInt();
        if (score<0 || score>100){
            System.out.println("Invalid Score. Please enter the score between 0 to 100");
        } else {
            Grader grader = new Grader(score);
            String grade = grader.letterGrade();
            System.out.println("The grade is : " + grade);
        }
        sc.close();
    }
}
