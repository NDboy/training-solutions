package week08.week08d01;

public class Robot {

    private Position position;

    public Robot(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Position move(String path) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'F') {
                y++;
            } else if (path.charAt(i) == 'L') {
                y--;
            } else if (path.charAt(i) == 'B') {
                x--;
            } else if (path.charAt(i) == 'J') {
                x++;
            } else {
                throw new IllegalArgumentException("Wrong parameter!");
            }
        }
        position = new Position(x, y);
        return getPosition();
    }

}



//    A feladatban egy robot mozgását fogjuk szimulálni.
//    Képzelj el egy koordináta rendszert, ahol a robot az origóban van.
//    A robot négy irányba képes mozogni fel, le, balra és jobbra.
//    A week08d01.Robot osztályban írj egy move() metódust ami egy karaktersorozatot vár.
//
//    pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb.
//    A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója.
//    A feladat szabadon bővíthető osztályokkal és metódusokkal.
//    Bónusz kiegészítés, hogyha más karaktert is tartalmaz a paraméter String
//    nem csak a FLBJ valamelyikét, akkor dobjunk IllegalArgumentExceptiont!
