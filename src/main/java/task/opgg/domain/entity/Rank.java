package task.opgg.domain.entity;

public enum Rank {
    UnRank("언랭"),
    Iron("아이언"),
    Bronze("브론즈"),
    Silver("실버"),
    Gold("골드"),
    Platinum("플레티넘"),
    Dia("다이아"),
    Master("마스터"),
    Grandmaster("그랜드마스터"),
    Challenger("챌린저");

    private String viewName;

    Rank(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

}
