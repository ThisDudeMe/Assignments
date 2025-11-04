package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockStatisticsServiceTest {
    
    @Mock
    private StatisticsDao mockDao;
    
    private StatisticsService statisticsService;
    
    @BeforeEach
    public void setUp() {
        statisticsService = new StatisticsService(mockDao);
    }
    
    @Test
    public void testGetSortedStatisticsWithMockedDao() {
        // Arrange: Create unsorted list
        List<Statistics> unsortedStats = new ArrayList<>();
        unsortedStats.add(new Statistics("Player1", 45));
        unsortedStats.add(new Statistics("Player2", 200));
        unsortedStats.add(new Statistics("Player3", 100));
        unsortedStats.add(new Statistics("Player4", 75));
        
        // Mock the loadAll method
        when(mockDao.loadAll()).thenReturn(unsortedStats);
        
        // Act
        List<Statistics> sortedStats = statisticsService.getSortedStatistics();
        
        // Assert
        assertNotNull(sortedStats);
        assertEquals(4, sortedStats.size());
        
        // Verify sorting order (highest to lowest)
        assertEquals(200, sortedStats.get(0).getScore());
        assertEquals("Player2", sortedStats.get(0).getPlayerName());
        
        assertEquals(100, sortedStats.get(1).getScore());
        assertEquals("Player3", sortedStats.get(1).getPlayerName());
        
        assertEquals(75, sortedStats.get(2).getScore());
        assertEquals("Player4", sortedStats.get(2).getPlayerName());
        
        assertEquals(45, sortedStats.get(3).getScore());
        assertEquals("Player1", sortedStats.get(3).getPlayerName());
        
        // Verify that loadAll was called exactly once
        verify(mockDao, times(1)).loadAll();
    }
    
    @Test
    public void testGetSortedStatisticsWithEmptyList() {
        // Arrange
        when(mockDao.loadAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<Statistics> sortedStats = statisticsService.getSortedStatistics();
        
        // Assert
        assertNotNull(sortedStats);
        assertTrue(sortedStats.isEmpty());
        verify(mockDao, times(1)).loadAll();
    }
}
