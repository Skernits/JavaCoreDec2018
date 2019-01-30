package org.test.epamtasks.part2task67;

/**
 * Class imitates Submarine, consist of hull and 2 engines.
 * Submarine can move forward, return left or right and reverse.
 *
 * @author Svetlana Kernitskaya
 *
 */

public class Submarine {
    private String name;
    private Engine engineR;
    private Engine engineL;
    private Hull hull;

    /**
     * Engine is necessary part for creation Submarine ad provides any movement for it.
     */
    static class Engine {
        String model;
        int power;
        EngineAction move;

        /**
         * Constructor produces Engine by item model and power. Normally new engine has "STOP" status.
         * @param model engine identification number
         * @param power Power of Engine, kW
         */
        Engine(String model, int power) {
            this.model = model;
            this.power = power;
            this.move = EngineAction.STOP;
        }

        /**
         * Class illustrates possible conditions for Engine.
         */
        enum EngineAction {FORWARD, STOP, REVERSE}

    }

    /**
     * Hull is part of submarine.
     */
    static class Hull {
        String model;

        Hull(String model) {
            this.model = model;
        }
    }

    /**
     * To construct submarine we need 2 engines and hull. Also we need to give her a Name.
     * @param name  submarine name
     * @param engineR right engine @see Submarine#Engine
     * @param engineL left engine @see Submarine#Engine
     * @param hull submarine hull @see Submarine#Hull
     */
     Submarine(String name, Engine engineR, Engine engineL, Hull hull) {
        this.name = name;
        this.engineR = engineR;
        this.engineL = engineL;
        this.hull = hull;
    }

    /**
     * moveForward function changes EngineAction in position "FORWARD" and that means submarine moves forward.
     */
    void moveForward() {
        engineL.move = Engine.EngineAction.FORWARD;
        engineR.move = Engine.EngineAction.FORWARD;
        System.out.println("Left Engine: " + engineL.move);
        System.out.println("Right Engine: " + engineR.move);
        System.out.println("Submarine " + name + " moves forward");
    }

    /**
     * moveLeft function changes EngineAction for Left and Right engines in such positions to provide submarine turns left.
     */
    void moveLeft() {
        engineL.move = Engine.EngineAction.STOP;
        engineR.move = Engine.EngineAction.FORWARD;
        System.out.println("Left Engine: " + engineL.move);
        System.out.println("Right Engine: " + engineR.move);
        System.out.println("Submarine " + name + " moves left");
    }

    /**
     * moveRight function changes EngineAction for Left and Right engines in such positions to provide submarine turns right.
     */
    void moveRight() {
        engineL.move = Engine.EngineAction.FORWARD;
        engineR.move = Engine.EngineAction.STOP;
        System.out.println("Left Engine: " + engineL.move);
        System.out.println("Right Engine: " + engineR.move);
        System.out.println("Submarine " + name + " moves right");
    }

    /**
     * moveReverse function changes EngineAction in position "Reverse".
     */
    void moveReverse() {
        engineL.move = Engine.EngineAction.REVERSE;
        engineR.move = Engine.EngineAction.REVERSE;
        System.out.println("Left Engine: " + engineL.move);
        System.out.println("Right Engine: " + engineR.move);
        System.out.println("Submarine " + name + " moves reverse");
    }
    /**
     * Stop-machine function changes EngineAction status to STOP.
     */
    void stopMaсhine() {
        engineL.move = Engine.EngineAction.STOP;
        engineR.move = Engine.EngineAction.STOP;
        System.out.println("Left Engine: " + engineL.move);
        System.out.println("Right Engine: " + engineR.move);
        System.out.println("Submarine " + name + " stops");
    }

}
