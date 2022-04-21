package me.zilzustudy;

import me.zilzustudy.user.UserConfiguration;
import me.zilzustudy.user.UserServiceImpl;
import me.zilzustudy.user.ZilzuUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class UserTest {

    private final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withInitializer(new ConditionEvaluationReportLoggingListener())
            .withUserConfiguration(UserConfiguration.class)
            .withUserConfiguration(ZilzuUserServiceImpl.class, UserServiceImpl.class);

    // 테스트 어렵누;;
    @Test
    public void property() {
        runner
                .withPropertyValues("get.zilzu.config=false")
                .run(context -> assertAll(
//                        () -> assertThat(context).hasSingleBean(UserServiceImpl.class),
                        () -> assertThat(context).hasSingleBean(ZilzuUserServiceImpl.class)
//                        () -> assertThat(context).doesNotHaveBean(ZilzuUserServiceImpl.class)
//                        () -> assertThat(context).doesNotHaveBean(UserServiceImpl.class)
                ));
    }
}
