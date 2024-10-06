package sbs.com.java.board.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
  private int id;
  private String loginId;
  private String password;
  private String name;
}
