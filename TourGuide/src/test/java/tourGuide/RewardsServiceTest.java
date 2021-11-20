package tourGuide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import rewardCentral.RewardCentral;
import tourGuide.rewards.service.RewardsService;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RewardsServiceTest {

  @Test
  public void getRewardsPoint_shouldReturnOk() {
    // GIVEN
    RewardCentral rewardCentral = Mockito.mock(RewardCentral.class);
    RewardsService rewardsService = new RewardsService(rewardCentral);
    UUID attractionId = UUID.randomUUID();
    UUID userId = UUID.randomUUID();
    Mockito.when(rewardCentral.getAttractionRewardPoints(attractionId, userId)).thenReturn(100);

    // WHEN
    int rewardPoints = rewardsService.getRewardPoints(attractionId, userId);

    // THEN
    assertEquals(100, rewardPoints);
  }

}
