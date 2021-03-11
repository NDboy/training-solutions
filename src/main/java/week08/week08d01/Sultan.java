package week08.week08d01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sultan {

    private List<Cell> cells;

    public Sultan() {
        this.cells = new ArrayList<>();
        IntStream.range(1,101)
                .forEach(a -> cells.add(new Cell(a, DoorStatus.CLOSED)));
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Map<DoorStatus, List<Integer>> mapFreePrisoners () {
        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            IntStream.range(0,100)
                    .filter(a -> a % finalI == 0)
                    .forEach(this::changeDoorStatusByIndex);
        }
        return getCells().stream()
                .collect(Collectors.groupingBy(Cell::getDoorStatus,
                        Collectors.mapping(Cell::getCellNumber, Collectors.toList())));
    }

    private void changeDoorStatusByIndex(int index) {
        getCells().get(index).changeDoorStatus();
    }

}

//    A török szultán elhatározza, hogy a 100 nap múlva lévő születésnapján
//    szabadon enged néhány rabot a börtönéből. A börtönben 100 cella van.
//    Mindegyik cella zárva van.
//    Ha egyet fordítunk a kulcson akkor nyitva lesz,
//    ha még egyet akkor zárva ha hármat akkor ismét nyitva és így tovább.
//    A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet.
//    (Ekkor minden cella nyitva lesz).
//    A második napon minden másodikon fordítsanak egyet,
//    így minden második zárva lesz.
//    A harmadik napon minden harmadikon fordítsanak egyet így a 3. cella zárva ,
//    de a 6. cella például nyitva lesz.
//    A week08d01.Sultan osztályba írj egy metódust openDoors() néven,
//    aminek visszatérési értékéből kiderül, hogy mely ajtók lesznek nyitva a 100. napon!
