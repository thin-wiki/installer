package wiki.thin.installer;

import org.springframework.boot.SpringApplication;
import wiki.thin.core.startup.StartupApplicationProvider;

import java.util.Optional;

/**
 * @author beldon
 */
public class InstallStartupApplicationProvider implements StartupApplicationProvider {
    @Override
    public Optional<Class<?>> getStartupApplication() {
        if (InstallManager.isInstalled()) {
            return Optional.empty();
        }
        return Optional.of(InstallApplication.class);
    }

    @Override
    public void beforeRun(SpringApplication app) {
        app.setAdditionalProfiles("install");
    }
}
