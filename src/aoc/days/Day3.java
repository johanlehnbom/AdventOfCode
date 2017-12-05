package aoc.days;

import java.awt.*;
import java.awt.image.DirectColorModel;

import static aoc.days.Day3.DIRECTION.*;

public class Day3 {

    public Day3() {
        //Del1();
        Del2();
    }

    enum DIRECTION {
        RIGHT,
        UP,
        LEFT,
        DOWN
    }

    private void Del1() {

        DIRECTION d = RIGHT;

        Point p = new Point(0,0);

        int i = 1;
        boolean first = true;
        //1	1	2	2	3	3	4	4	5	5
        int move = 1;
        int nrMoves = 1;

        while (i < 265149) {

            System.out.println("i: " + i);

            if (move == 0) {

                //System.out.println("Ny riktning");

                if (d == DIRECTION.RIGHT)
                    d = DIRECTION.UP;
                else if (d == DIRECTION.UP)
                    d = DIRECTION.LEFT;
                else if (d == DIRECTION.LEFT)
                    d = DIRECTION.DOWN;
                else if (d == DIRECTION.DOWN)
                    d = DIRECTION.RIGHT;

                if (!first) {
                    //System.out.println("FALSE");
                    nrMoves++;
                    first = true;
                } else {
                    //System.out.println("TRUE");
                    first = false;
                }
                move = nrMoves;

            }

            switch (d) {

                case RIGHT:
                    System.out.println("RIGHT: ");
                    p = new Point(p.x + 1, p.y);
                    move--;
                    break;

                case UP:
                    System.out.println("UP: ");
                    p = new Point(p.x , p.y + 1);
                    move--;
                    break;

                case LEFT:
                    System.out.println("LEFT: ");
                    p = new Point(p.x - 1, p.y);
                    move--;
                    break;

                case DOWN:
                    System.out.println("DOWN: ");
                    p = new Point(p.x, p.y - 1);
                    move--;
                    break;

                default: break;
            }



            i++;

        }

        System.out.println("Punkt: " + p);

    }

    private void Del2() {

        final int OFFSET = 500;

        int[][] map = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                map[i][j] = 0;
            }
        }

        DIRECTION d = RIGHT;

        Point p = new Point(0,0);

        int i = 1;
        boolean first = true;
        //1	1	2	2	3	3	4	4	5	5
        int move = 1;
        int nrMoves = 1;

        int sum = 0;

        map[p.x + OFFSET][p.y + OFFSET] = 1;

        while (i < 100) {

            if (move == 0) {

                if (d == DIRECTION.RIGHT)
                    d = DIRECTION.UP;
                else if (d == DIRECTION.UP)
                    d = DIRECTION.LEFT;
                else if (d == DIRECTION.LEFT)
                    d = DIRECTION.DOWN;
                else if (d == DIRECTION.DOWN)
                    d = DIRECTION.RIGHT;

                if (!first) {
                    nrMoves++;



                    first = true;
                } else {
                    first = false;
                }
                move = nrMoves;

            }





            switch (d) {

                case RIGHT:
                    p = new Point(p.x + 1, p.y);
                    move--;
                    break;

                case UP:
                    p = new Point(p.x , p.y + 1);
                    move--;
                    break;

                case LEFT:
                    p = new Point(p.x - 1, p.y);
                    move--;
                    break;

                case DOWN:
                    p = new Point(p.x, p.y - 1);
                    move--;
                    break;

                default: break;
            }

            map[p.x + OFFSET][p.y + OFFSET] =
                            map[p.x + OFFSET - 1][p.y + OFFSET - 1] +
                            map[p.x + OFFSET - 1][p.y + OFFSET - 0] +
                            map[p.x + OFFSET - 1][p.y + OFFSET + 1] +
                            map[p.x + OFFSET - 0][p.y + OFFSET + 1] +
                            map[p.x + OFFSET + 1][p.y + OFFSET + 1] +
                            map[p.x + OFFSET + 1][p.y + OFFSET - 0] +
                            map[p.x + OFFSET + 1][p.y + OFFSET - 1] +
                            map[p.x + OFFSET - 0][p.y + OFFSET - 1];


            System.out.println("Sum: " + map[p.x + OFFSET][p.y + OFFSET]);

            if (map[p.x + OFFSET][p.y + OFFSET] > 265149) {
                i = 10000000;
            }

            i++;

        }

        System.out.println("Sum: " + sum);
    }

}
