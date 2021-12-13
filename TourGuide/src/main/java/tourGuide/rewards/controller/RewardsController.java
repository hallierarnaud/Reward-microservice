package tourGuide.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import tourGuide.rewards.service.RewardsService;

@Slf4j
@RestController
public class RewardsController {

  @Autowired
  private RewardsService rewardsService;

  /**
   *
   * @param attractionId an id of an attraction
   * @param userId an id of a user
   * @return the number of reward points attributed by the attraction's visit
   */
  @GetMapping("/rewards")
  public int getRewards(@RequestParam UUID attractionId, @RequestParam UUID userId) {
    log.info("call rewards");
    return rewardsService.getRewardPoints(attractionId, userId);
  }

}
