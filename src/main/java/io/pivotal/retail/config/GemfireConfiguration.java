package io.pivotal.retail.config;

import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication.Locator;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.config.annotation.EnableSecurity;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@ClientCacheApplication(name="GemFireClient", locators = {
        @Locator(host = "localhost", port = 41111)
})
@EnableGemfireRepositories(basePackages = "io.pivotal.retail.dao" )
@EnableEntityDefinedRegions(basePackages = "io.pivotal.retail.domain")
@EnableSecurity
@EnablePdx
public class GemfireConfiguration {

}