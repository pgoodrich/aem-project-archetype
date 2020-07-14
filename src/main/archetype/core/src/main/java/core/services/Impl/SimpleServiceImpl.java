package ${package}.core.services.Impl;

import ${package}.core.services.SimpleService;
import ${package}.core.services.configs.SimpleServiceConfiguration;
import java.util.Set;
import java.util.Optional;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;


@Component(service = SimpleService.class,
           immediate = false,
           configurationPolicy = ConfigurationPolicy.OPTIONAL)
@Designate(ocd = SimpleServiceConfiguration.class)
public class SimpleServiceImpl implements SimpleService {

  // Example OSGI wiring
  @Reference
  private SlingSettingsService settings;

  private SimpleServiceConfiguration simpleServiceConfiguration;

  public Optional<String> getData(String parameter) {
    // Example service call for mocking
    final Set<String> runModes = settings.getRunModes();
    if (runModes != null && runModes.contains("prod")) return Optional.empty();

    // Example of using OSGI configuration
    return parameter.equals("url") ? Optional.of(simpleServiceConfiguration.example_url()) : Optional.<String>empty();
  }

  @Activate
  @Modified
  public void activate(SimpleServiceConfiguration configuration) {
    simpleServiceConfiguration = configuration;
  }
}
