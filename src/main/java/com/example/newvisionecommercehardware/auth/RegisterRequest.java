package com.example.newvisionecommercehardware.auth;

import com.example.newvisionecommercehardware.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String name;
  private String cpf;
  private Date dateBirth;
  private String telefone;
  private String email;
  private String password;
  private Role role;
}
