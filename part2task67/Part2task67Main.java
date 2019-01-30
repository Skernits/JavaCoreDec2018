package org.test.epamtasks.part2task67;

public class Part2task67Main {
    public static void main(String[] args) {
        Submarine submarineTest = new Submarine(
                "TEST 1",
                new Submarine.Engine("EngineR Model - test 1", 10),
                new Submarine.Engine("EngineL Model - test 1", 10),
                new Submarine.Hull("Hull Model - test 1")
        );
        submarineTest.moveForward();
        submarineTest.moveLeft();
        submarineTest.moveRight();
        submarineTest.moveReverse();
        submarineTest.stopMaсhine();

    }
}
