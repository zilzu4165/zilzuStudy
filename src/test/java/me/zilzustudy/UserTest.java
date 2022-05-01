package me.zilzustudy;

import me.zilzustudy.user.UserConfiguration;
import me.zilzustudy.user.UserService;
import me.zilzustudy.user.UserServiceImpl;
import me.zilzustudy.user.ZilzuUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

// sut = System Under Test

class UserTest {
    @Test
    void user_config가_true이면_UserServiceImpl_bean을_가지고_ZilzuUserServiceImpl은_갖지_않는다() {
        // given
        ApplicationContextRunner sut = runnerWithUserConfig(true);

        sut.run(context -> assertAll(
                () -> assertThat(context).hasSingleBean(UserService.class),
                () -> assertThat(context).hasSingleBean(UserServiceImpl.class),
                () -> assertThat(context).doesNotHaveBean(ZilzuUserServiceImpl.class)
        ));
    }

    // https://gist.github.com/Toparvion/26e2baf3b3fb89fa2f957e78fde5ef53  참고하였음
    private final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withUserConfiguration(UserConfiguration.class);


    // given

    // when

    // then

    @Test
    void config가_false이면_ZilzuUserServiceImple을_가져온다() {
        configPropertyValueIs(false)
                .run(context -> assertAll(
                        () -> assertThat(context).hasSingleBean(ZilzuUserServiceImpl.class),
                        () -> assertThat(context).doesNotHaveBean(UserServiceImpl.class)
                ));
    }

    @Test
    void config가_true이면_UserServiceImple을가져온다() {
        configPropertyValueIs(true)
                .run(context -> assertAll(
                        () -> assertThat(context).hasSingleBean(UserServiceImpl.class),
                        () -> assertThat(context).doesNotHaveBean(ZilzuUserServiceImpl.class)
                ));
    }

    public ApplicationContextRunner configPropertyValueIs(boolean t) {
        if (t) {
            return runner
                    .withPropertyValues("get.user.config=true");
        } else {
            return runner
                    .withPropertyValues("get.user.config=false");
        }
    }
}
