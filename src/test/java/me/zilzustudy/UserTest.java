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


    // https://gist.github.com/Toparvion/26e2baf3b3fb89fa2f957e78fde5ef53  참고하였음
    private final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withInitializer(new ConditionEvaluationReportLoggingListener())
            .withUserConfiguration(UserConfiguration.class);
//            .withUserConfiguration("zilzuUserServiceImpl", "userServiceImpl");

    // 문제있네이거
    @Test
    public void property() {
        runner
                .withPropertyValues("get.user.config=false")
                .run(context -> assertAll(
//                        () -> assertThat(context).hasSingleBean(UserServiceImpl.class)
//                        () -> assertThat(context).hasSingleBean(ZilzuUserServiceImpl.class)
//                        () -> assertThat(context).doesNotHaveBean(ZilzuUserServiceImpl.class)
                        () -> assertThat(context).doesNotHaveBean("zilzuUserServiceImpl")
                ));
    }
}
