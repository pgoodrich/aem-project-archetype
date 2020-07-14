package ${package}.core.services.configs;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Simple Service Configuration")
public @interface SimpleServiceConfiguration {
  @AttributeDefinition(
      name = "Simple service example url",
      description = "Example URL used for demoing osgi configuration",
      type = AttributeType.STRING)
  String example_url() default "";
}
