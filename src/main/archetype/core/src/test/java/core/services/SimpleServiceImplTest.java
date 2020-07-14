package ${package}.core.services.Impl;

import ${package}.core.services.SimpleService;
import ${package}.core.helpers.AppAemContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.settings.SlingSettingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Simple JUnit test verifying the HelloWorldModel
 */
@ExtendWith(AemContextExtension.class)
class SimpleServiceImplTest {

  @Mock
  SlingSettingsService slingSettingsService;

  private SimpleService simpleService;

  private AemContext aemContext = AppAemContext.newAemContext();

  @BeforeEach
  public void setup() throws Exception {
    // Empty
  }

  @Test
  void testGetDataNoConfig() throws Exception {
    // Some very basic junit tests
    final Map<String, Object> properties = new HashMap<>(); // Default properties

    Mockito.when(slingSettingsService.getRunModes()).thenReturn(new HashSet<>(Collections.singletonList("Prod")));
    aemContext.registerService(SlingSettingsService.class, slingSettingsService);
    aemContext.registerInjectActivateService(new SimpleServiceImpl(), properties);

    String response = simpleService.getData("url").orElse("");

    assertTrue(response.equals(""));
  }

  @Test
  void testGetDataWithConfig() throws Exception {
    final Map<String, Object> properties = new HashMap<>();
    properties.put("example.url", "https://github.com/adobe/aem-project-archetype");

    Mockito.when(slingSettingsService.getRunModes()).thenReturn(new HashSet<>(Collections.singletonList("Dev")));
    aemContext.registerService(SlingSettingsService.class, slingSettingsService);
    aemContext.registerInjectActivateService(new SimpleServiceImpl(), properties);

    String response = simpleService.getData("url").orElse("");

    assertTrue(response.equals("https://github.com/adobe/aem-project-archetype"));
  }
}
