package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {
    private List<State> states;

    public StateRegister() {
        this.states = new ArrayList<>();
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    public void readStatesFromFile(String pathString) {
        String line;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(pathString))){
            while ((line = bufferedReader.readLine()) != null) {
                states.add(new State(line.split("-")[0], line.split("-")[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State state: states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }
}
