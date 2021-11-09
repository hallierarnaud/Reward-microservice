package tourGuide;

import org.junit.Test;

import java.util.UUID;

import rewardCentral.RewardCentral;
import tourGuide.rewards.service.RewardsService;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RewardsServiceTest {

  @Test
  public void getRewardsPoint_shouldReturnOk() {
    // GIVEN
    RewardCentral rewardCentral = new RewardCentral();
    RewardsService rewardsService = new RewardsService(rewardCentral);
    UUID attractionId = UUID.randomUUID();
    UUID userId = UUID.randomUUID();

    // WHEN
    int rewardPoints = rewardsService.getRewardPoints(attractionId, userId);

    // THEN
    assertThat(rewardPoints, is(instanceOf(Integer.class)));
  }

}
