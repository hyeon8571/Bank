package shop.mtcoding.bank.config.jwt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.mtcoding.bank.config.auth.LoginUser;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserEnum;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class JwtProcessTest {

    @Test
    public void create_test() throws Exception {
        // given
        User user = User.builder().id(1L).role(UserEnum.CUSTOMER).build();
        LoginUser loginUser = new LoginUser(user);

        // when
        String jwtToken = JwtProcess.create(loginUser);
        System.out.println("테스트 : " + jwtToken);

        // then
        assertTrue(jwtToken.startsWith(JwtVO.TOKEN_PREFIX));
    }

    @Test
    public void verify_test() {
        // given
        String jwtToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYW5rIiwicm9sZSI6IkNVU1RPTUVSIiwiaWQiOjEsImV4cCI6MTY5MjA5NjQ5OX0.hlzAbY2shzmxtdbypKVHgcpWZ12TPW8nBBsXhtMHc9VxsYmqdsNpoVw8u96KqLdC7GrwG_9sPatK_02tq9kNBw";

        // when
        LoginUser loginUser = JwtProcess.verify(jwtToken);
        System.out.println("테스트 : " + loginUser.getUser().getId());
        System.out.println("테스트 : " + loginUser.getUser().getRole().name());

        // then
        assertThat(loginUser.getUser().getId()).isEqualTo(1L);
        assertThat(loginUser.getUser().getRole()).isEqualTo(UserEnum.CUSTOMER);
    }
}
