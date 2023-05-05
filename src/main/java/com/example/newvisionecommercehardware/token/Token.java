package com.example.newvisionecommercehardware.token;

import com.example.newvisionecommercehardware.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

  @Id
  @GeneratedValue
  public Integer id;

  @Column(unique = true) //garante que cada token seja exclusivo na tabela do banco de dados.
  public String token;

  @Enumerated(EnumType.STRING)// indico que o atributo TokenType é do tipo enum.
  public TokenType tokenType = TokenType.BEARER;// Defino que os token criados  será do tipo Bearer. O Bearer é uma autenticação http.

  public boolean revoked;// atributo para verificar se o token foi revogado

  public boolean expired;// atributo para verificar se o token foi expirado

  @ManyToOne(fetch = FetchType.LAZY) // Definir o relacionamento de muitos para 1, onde vários token podem estar associados a um único usuário.
  @JoinColumn(name = "user_id")//Ao fazer o realacionamento manytoone, tenho que especificar qual coluna da tabela do banco estou me referenciando.
  public User user;
}
