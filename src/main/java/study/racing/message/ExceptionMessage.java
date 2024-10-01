package study.racing.message;

public enum ExceptionMessage {
    INVALID_CAR_COUNT_MESSAGE("2대 이상의 자동차가 필요합니다."),
    INVALID_GAME_COUNT_MESSAGE("1회 이상의 게임이 필요합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
