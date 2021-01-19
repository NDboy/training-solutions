package week12.week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private List<Site> sites = new ArrayList<>();

    public void sellSite(Site site) {
        sites.add(site);
    }

    public List<Site> getSites() {
        return new ArrayList<>(sites);
    }

    public int getLastHouseNumber() {
        int counter = 0;
        Site lastSite = getSites().get(sites.size() - 1);
        for (Site site: sites) {
            if (lastSite.getEvenOdd() == site.getEvenOdd()) {
                counter++;
            }
        }
        return lastSite.getEvenOdd() == 0 ? counter * 2 : counter * 2 - 1;
    }

    private int fenceCounter(Fence fence) {
        int counter = 0;
        for (Site site: sites) {
            if (site.getFence() == fence) {
                counter++;
            }
        }
        return counter;
    }

    public List<ReportFence> report() {
        List<ReportFence> report = new ArrayList<>();
        for (Fence fence: Fence.values()) {
            int sum = fenceCounter(fence);
            report.add(new ReportFence(fence, sum));
        }
        return report;
    }
}
