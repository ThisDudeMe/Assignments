package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao {
    
    @Override
    public void save(Statistics stat) {
        // Not needed for testing
    }

    @Override
    public List<Statistics> loadAll() {
        // Return unsorted hardcoded list
        List<Statistics> stats = new ArrayList<>();
        stats.add(new Statistics("Anna", 50));
        stats.add(new Statistics("Bengt", 120));
        stats.add(new Statistics("Cecilia", 80));
        stats.add(new Statistics("David", 150));
        stats.add(new Statistics("Eva", 30));
        return stats;
    }
}
