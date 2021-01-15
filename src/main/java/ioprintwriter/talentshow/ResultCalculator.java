package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void readTalents(Path path) {
        String line;
        int id;
        String name;
        try (BufferedReader br = Files.newBufferedReader(path)){
            while((line = br.readLine()) != null) {
                id = Integer.parseInt(line.split(" ")[0]);
                name = line.split(" ")[1];
                productions.add(new Production(id, name));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void calculateVotes(Path path) {
        String line;
        int vote;
        for (Production production: productions) {
            votes.add(new Vote(production.getId(), 0));
        }
        try (BufferedReader br = Files.newBufferedReader(path)){
            while((line = br.readLine()) != null) {
                vote = Integer.parseInt(line);
                for (Vote vote1 : votes) {
                    if (vote1.getId() == vote) {
                        vote1.incNum();
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private Production winnerProduction() {
        Vote maxVote = votes.get(0);
        Production bestProduction = null;
        for (Vote vote: votes) {
            if (vote.getNumber() > maxVote.getNumber()) {
                maxVote = vote;
            }
        }
        for (Production production: productions) {
            if (production.getId() == maxVote.getId()) {
                bestProduction = production;
            }
        }
        return bestProduction;
    }

    public void writeResultToFile(Path path) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path))){
            for (int i = 0; i < productions.size(); i++) {
                pw.println(String.format("%d %s %d", productions.get(i).getId(), productions.get(i).getName(), votes.get(i).getNumber()));
            }
            pw.print(String.format("Winner: %s", winnerProduction().getName()));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }


}
