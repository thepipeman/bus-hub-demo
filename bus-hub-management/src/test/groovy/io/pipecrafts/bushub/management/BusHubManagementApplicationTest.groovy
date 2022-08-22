package io.pipecrafts.bushub.management

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class BusHubManagementApplicationTest extends Specification {

  @Autowired(required = false)
  ApplicationContext context

  def "context loads"() {
    expect: "Context loads"
    context
  }
}
