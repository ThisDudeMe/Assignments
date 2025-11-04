package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsServiceTest {
    
    private StatisticsService statisticsService;
    private StatisticsDao dao;
    
    @BeforeEach
    public void setUp() {
        dao = new FakeFileStatisticsDao();
        statisticsService = new StatisticsService(dao);
    }
    
    @Test
    public void testGetSortedStatisticsReturnsListSortedByScoreDescending() {
        List<Statistics> sortedStats = statisticsService.getSortedStatistics();
        
        assertNotNull(sortedStats, "Statistics list should not be null");
        assertEquals(5, sortedStats.size(), "Statistics list should contain 5 entries");
        
        // Verify highest score first
        assertEquals("David", sortedStats.get(0).getPlayerName());
        assertEquals(150, sortedStats.get(0).getScore());
        
        // Verify second highest
        assertEquals("Bengt", sortedStats.get(1).getPlayerName());
        assertEquals(120, sortedStats.get(1).getScore());
        
        // Verify third
        assertEquals("Cecilia", sortedStats.get(2).getPlayerName());
        assertEquals(80, sortedStats.get(2).getScore());
        
        // Verify fourth
        assertEquals("Anna", sortedStats.get(3).getPlayerName());
        assertEquals(50, sortedStats.get(3).getScore());
        
        // Verify lowest score last
        assertEquals("Eva", sortedStats.get(4).getPlayerName());
        assertEquals(30, sortedStats.get(4).getScore());
    }
}
