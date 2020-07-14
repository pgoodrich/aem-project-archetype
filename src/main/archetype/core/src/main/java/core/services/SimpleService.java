package ${package}.core.services;

import java.util.Optional;

public interface SimpleService {

  /**
   * Gets data for given parameter
   * @param parameter
   * @return Data returned from OSGI configuration
   */
  Optional<String> getData(String parameter);
}
