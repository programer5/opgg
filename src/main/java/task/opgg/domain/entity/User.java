package task.opgg.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private int score;

    @Column
    @Enumerated(EnumType.STRING)
    private Rank rank;

    public User(User user) {
        this.rank = MyRank(user);
    }

    public Rank MyRank(User user) {
        if (user.getScore() > 0 && user.getScore() <= 100) {
            return Rank.Iron;
        } else if (user.getScore() > 100 && user.getScore() <= 200) {
            return Rank.Bronze;
        } else if (user.getScore() > 200 && user.getScore() <= 300) {
            return Rank.Silver;
        } else if (user.getScore() > 300 && user.getScore() <= 400) {
            return Rank.Gold;
        } else if (user.getScore() > 400 && user.getScore() <= 500) {
            return Rank.Platinum;
        } else if (user.getScore() > 500 && user.getScore() <= 600) {
            return Rank.Dia;
        } else if (user.getScore() > 600 && user.getScore() <= 700) {
            return Rank.Master;
        } else if (user.getScore() > 700 && user.getScore() <= 800) {
            return Rank.Grandmaster;
        } else if (user.getScore() > 800 && user.getScore() <= 900) {
            return Rank.Challenger;
        } else {
            return Rank.UnRank;
        }
    }
}
