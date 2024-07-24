package lab04$algorithms;

public class Test05TravelDirection {

    private static void goNorthEast(int endX, int endY, int x, int y, String route) {

        if (x == endX && y == endY) {
            System.out.println(route);

        } else if (x <= endX && y <= endY) {
            goNorthEast(endX, endY, x, y + 1, route + " N");
            goNorthEast(endX, endY, x + 1, y, route + " E");
            goNorthEast(endX, endY, x + 1, y + 1, route + " NE");
        }

        //OTHERWISE : DO NOTHING
    }

    public static void goNorthEast(int endX, int endY, int startX, int startY) {
        goNorthEast(endX, endY, startX, startY, "moves:");
    }

    private static void goNorthWest(int endX, int endY, int x, int y, String route) {

        if (x == endX && y == endY) {
            System.out.println(route);

        } else if (x >= endX && y <= endY) {
            goNorthWest(endX, endY, x, y + 1, route + " N");
            goNorthWest(endX, endY, x - 1, y, route + " W");
            goNorthWest(endX, endY, x - 1, y + 1, route + " NW");
        }
    }

    public static void goNorthWest(int endX, int endY, int startX, int startY) {
        goNorthWest(endX, endY, startX, startY, "moves:");
    }


    public static void intro() {
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t T R A V E L    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        System.out.println("Going North-East from (0,0) to (1,2)");
        goNorthEast(1, 2, 0, 0);
        System.out.println();
        System.out.println("Going North-West from (0,0) to (-2,1)");
        goNorthWest(-2, 1, 0, 0);
        System.out.println();
    }
}
