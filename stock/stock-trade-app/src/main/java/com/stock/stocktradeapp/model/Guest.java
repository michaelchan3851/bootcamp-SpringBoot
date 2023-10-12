package com.stock.stocktradeapp.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Guest {

  private String userId;

  private String password;

  private String email;

  public boolean isUserIdVaild() {
    return User.userPool.get(this.userId) != null;
  }

  public boolean isPasswordVaild() {
    return true;
  }

  public boolean isEmailVaild() {
    return true;
  }

  public boolean signUp() {
    if (this.userId == null || this.password == null || this.email == null)
      return false;
    if (!this.isPasswordVaild() || !this.isUserIdVaild() || !this.isEmailVaild())
      return false; // TBC. Specific Exception
      //TBC. Put to user Map
    User.userPool.put(this.userId, this.password);
    return true;
  }
}
