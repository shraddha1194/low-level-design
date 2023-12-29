package fundamentals.generics.worksheet_1;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Pair1 idToEmailMapping = Pair1.of("Tetiana", "tetiana@in");
        Pair1 idToBdayMapping = Pair1.of("Tetiana", "09111990");

        List<Pair1> idToEmailMappings = List.of(idToEmailMapping);
        for (Pair1 idToEmail: idToEmailMappings) {
            System.out.println(idToEmail.getLeft() + " " + idToEmail.getRight());
        }
    }
}

//This current implementation supports a pair of only string to string
//Pair of integers =>left and right integers
//Pair of double =>left and right double
//Pair of string =>left and right string
//its all polymorphism - Parametric polymorphism