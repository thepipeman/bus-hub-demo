package io.pipecrafts.bushub.management.admin.trip.schedule

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class TripScheduleControllerTest extends Specification {

  @Autowired
  private MockMvc mockMvc

  def "should expect unauthorized when no authentication is present"() {
    when:
    def results = mockMvc.perform(get("/admin/trips/schedule"))

    then:
    results.andExpect(status().isUnauthorized())
  }

  @WithMockUser(authorities = "SCOPE_mgmt")
  def "should expect Okay when authentication is present"() {
    // Mock RequestPostProcessor can also be used.s
    when:
    def results = mockMvc.perform(get("/admin/trips/schedule"))

    then:
    results.andExpect(status().isOk())
  }
}
