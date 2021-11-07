package tourGuide;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import tourGuide.rewards.controller.RewardsController;
import tourGuide.rewards.service.RewardsService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RewardsController.class)
public class RewardsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RewardsService rewardsService;

  @Test
  public void getRewards_shouldReturnOk() throws Exception {
    when(rewardsService.getRewardPoints(any(UUID.class), any(UUID.class))).thenReturn(10);
    mockMvc.perform(get("/rewards")).andExpect(status().isOk());
  }

}
