package tourGuide.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import tourGuide.rewards.service.RewardsService;

@RestController
public class RewardsController {

  @Autowired
  private RewardsService rewardsService;

  @GetMapping("/rewards")
  public int getRewards(@RequestParam UUID attractionId, @RequestParam UUID userId) {
    return rewardsService.getRewardPoints(attractionId, userId);
  }

}
