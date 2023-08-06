package shop.mtcoding.bank.config.jwt;

/**
 * SECRET은 노출되묜 안된다. (클라우드 AWS - 환경변수, 파일에 있는 것을 읽을 수도 있고)
 * 리플레시 토큰 (지금은 구현 x)
 */
public interface JwtVO {
    public static final String SECRET = "메타코딩"; // HS256(대칭키)

    public static final int EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7; // 일주일
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
}
