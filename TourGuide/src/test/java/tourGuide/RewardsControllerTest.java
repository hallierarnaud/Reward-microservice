package tourGuide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import tourGuide.rewards.service.RewardsService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RewardsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RewardsService rewardsService;

  @Test
  public void getRewards_shouldReturnOk() throws Exception {
    when(rewardsService.getRewardPoints(any(UUID.class), any(UUID.class))).thenReturn(10);
    mockMvc.perform(get("/rewards")
            .contentType(MediaType.APPLICATION_JSON)
            .param("attractionId", "6ba7b810-9dad-11d1-80b4-00c04fd430c8")
            .param("userId", "6ba7b810-9dad-11d1-80b4-00c04fd430c8"))
            .andExpect(status().isOk());
  }

}
