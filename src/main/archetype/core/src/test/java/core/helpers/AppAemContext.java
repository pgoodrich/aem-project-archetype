package ${package}.core.helpers;

import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextBuilder;

public class AppAemContext {
  private static final String CONTENT_ROOT = "/content/${appId}";

  public static AemContext newAemContext() {
    return new AemContextBuilder()
        // shared context setup code for all tests
        .<AemContext>afterSetUp(context -> {
          // Load mocked page content
          context.load().json("/content.json", CONTENT_ROOT);

          // Add sling models
          context.addModelsForPackage("${package}.core.models;");

          // Set default current page
          final Page currentPage = context.pageManager().getPage(CONTENT_ROOT);
          context.currentPage(currentPage);
        })
        .build();
  }
}
