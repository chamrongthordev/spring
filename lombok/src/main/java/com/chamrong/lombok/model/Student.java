package com.chamrong.lombok.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"studentId"})
public class Student {
  @Getter @Setter private long studentId;
  @Getter private String studentName;

  @Setter(AccessLevel.PROTECTED)
  private List<String> subjects;
}
