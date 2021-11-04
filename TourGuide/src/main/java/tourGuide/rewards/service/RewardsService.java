package tourGuide.rewards.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

import rewardCentral.RewardCentral;

@Service
public class RewardsService {

  private Logger logger = LoggerFactory.getLogger(RewardsService.class);
  private final RewardCentral rewardCentral;

  public RewardsService(RewardCentral rewardCentral) {
    this.rewardCentral = rewardCentral;
  }

  public int getRewardPoints(UUID attractionId, UUID userId) {
    return rewardCentral.getAttractionRewardPoints(attractionId, userId);
  }

}
